package frame;

import javax.swing.*;

/**
 * @ClassName EmployeeFrame
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 10:28
 **/
public class EmployeeFrame extends JFrame {
    private JPanel mainPanel;
    public EmployeeFrame(){
        init();
    }
    public void init(){
        this.setTitle("MainFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }
}
