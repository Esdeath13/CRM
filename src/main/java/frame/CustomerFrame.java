package frame;

import javax.swing.*;

/**
 * @ClassName CustomerFrame
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 10:28
 **/
public class CustomerFrame extends JFrame{
    private JPanel mainPanel;

    public CustomerFrame(){
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
