package frame;

import factory.ServiceFactory;
import utils.ResultEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @ClassName LoginFrame
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 9:29
 **/
public class LoginFrame extends JFrame{
    Color logoPaneColor = new Color(230, 230, 250);
    Color mainPaneColor = new Color(230, 230, 250);
    Color mainFrameColor = new Color(186, 110 ,64);
    Color logoFramColor = new Color(186, 110, 64);
    JLayeredPane layeredPane = new JLayeredPane();
    ImageIcon bgImage = new ImageIcon("C:\\Users\\76108\\Pictures\\bg.jpg");
    ImageIcon lgImage  =new ImageIcon("C:\\Users\\76108\\Pictures\\love.jpg");
    JPanel bgPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JPanel logoPanel  = new JPanel();
    final JLabel type = new  JLabel("用户身份:");
    final JLabel user_name = new JLabel("用户名:");
    final JLabel user_password = new JLabel("密   码:");
    JButton button_ok = new JButton("登陆");
    JButton button_cancel = new JButton("取消");
    JComboBox textType   = null;
    // 登陆用户名
    JTextField text_name = new JTextField();
    // 登陆密码
    JPasswordField text_password = new JPasswordField();

    private static final long serialVersionUID = 1L;
    // 用于处理拖动事件，表示鼠标按下时的坐标，相对于JFrame
    int xOld = 0;
    int yOld = 0;

    class LoginOKAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String account = text_name.getText().trim();
            String password = new String(text_password.getPassword()).trim();
            ResultEntity resultEntity = ServiceFactory.getUserServiceInstance().userLogin(account, password);
            JOptionPane.showMessageDialog(mainPanel, resultEntity.getMessage());

            if (resultEntity.getCode() == 0){
                //关闭登录界面
                setVisible(false);
                if (resultEntity.getType() == 0){
                    new AdminFrame();
                }else if (resultEntity.getType() == 1){
                    new EmployeeFrame();
                }else if (resultEntity.getType() == 2){
                    new CustomerFrame();
                }else {
                    text_name.setText("");
                    text_password.setText("");
                }
            }else {
                text_name.setText("");
                text_password.setText("");
            }
        }

    }

    class LoginCancelAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            System.exit(0);

        }

    }


    public LoginFrame() {
        super();
        initialize();
    }

    public void initialize() {
        this.setLayout(null);
        // 处理拖动事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xOld = e.getX();
                yOld = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xOnScreen = e.getXOnScreen();
                int yOnScreen = e.getYOnScreen();

                int xx = xOnScreen - xOld;
                int yy = yOnScreen - yOld;
                LoginFrame.this.setLocation(xx, yy);
            }
        });



        layeredPane.setBounds(0, 0, 600, 544);
        this.add(layeredPane);

        // 背景Panel
        bgPanel.setBounds(0, 0, 600, 544);
        layeredPane.add(bgPanel, new Integer(Integer.MIN_VALUE));

        // 背景图片，添加到背景Panel里面
        JLabel bgLabel = new JLabel(bgImage);
        bgPanel.add(bgLabel);
        JPanel jp = (JPanel) this.getContentPane();
        jp.setOpaque(false);



        //logo界面， 传播企业文化
        logoPanel.setBounds(50, 150,  150,  170);
        logoPanel.setLayout(null);
        logoPanel.setBackground(Color.WHITE);
        logoPanel.setBorder(BorderFactory.createTitledBorder(""));
        // logoPanel.setBorder(BorderFactory.createLineBorder(logoFramColor));
        layeredPane.add(logoPanel);

        JLabel logo = new JLabel(lgImage);
        logoPanel.add(logo);
        logo.setBounds(new Rectangle(0, 0,  150,  150));


        // 主界面，登陆界面，包含用户类型，用户名，密码等

        mainPanel.setBounds(200, 150, 350, 170);
        mainPanel.setLayout(null);
        mainPanel.setBackground(mainPaneColor);
        mainPanel.setBorder(BorderFactory.createTitledBorder(""));
        //  mainPanel.setBorder(BorderFactory.createLineBorder(mainFrameColor));
        layeredPane.add(mainPanel);

        mainPanel.add(type);
        type.setBounds(new Rectangle(25, 40,  62,  25));
        type.setFont(new java.awt.Font("微软雅黑", 1, 14));


        mainPanel.add(user_name);
        user_name.setBounds(new Rectangle(25, 70, 62, 25));
        user_name.setFont(new java.awt.Font("微软雅黑", 1, 14));


        mainPanel.add(user_password);
        user_password.setBounds(new Rectangle(25, 100, 62, 25));
        user_password.setFont(new java.awt.Font("微软雅黑", 1, 14));


        String[] defaultType={"员工", "管理员", "用户"};
        textType = new JComboBox(defaultType);
        mainPanel.add(textType);

        textType.setBounds(new Rectangle(95, 40, 240 , 25));
        textType.setFont(new java.awt.Font("微软雅黑", 1, 12));
        textType.setEditable(true);


        mainPanel.add(text_name);
        text_name.setBounds(new Rectangle(95, 70, 240, 25));
        text_name.setFont(new java.awt.Font("微软雅黑", 1, 12));

        mainPanel.add(text_password);
        text_password.setBounds(new Rectangle(95, 100, 240, 25));
        // 设置回显字符大小
        text_password.setFont(new Font("", Font.PLAIN, 30));

        mainPanel.add(button_ok);
        button_ok.setBounds(new Rectangle(115, 130,  80, 25));
        // 给按钮加事件监听器
        button_ok.addActionListener(new LoginOKAction());
        button_ok.setFont(new java.awt.Font("微软雅黑", 1, 12));

        mainPanel.add(button_cancel);
        button_cancel.setBounds(new Rectangle(225, 130,  80, 25));
        button_cancel.addActionListener(new LoginCancelAction());
        button_cancel.setFont(new java.awt.Font("微软雅黑", 1, 12));


        this.setBounds(0, 0, 600, 544);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new LoginFrame();

    }


}
