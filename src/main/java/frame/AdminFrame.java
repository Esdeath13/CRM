package frame;

import com.sun.org.apache.xml.internal.security.Init;

import javax.swing.*;

/**
 * @ClassName AdminFrame
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 10:27
 **/
public class AdminFrame extends JFrame{
    private JPanel mainPanel;
    public AdminFrame(){
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