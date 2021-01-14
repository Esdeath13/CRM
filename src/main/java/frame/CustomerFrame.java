package frame;

import entity.Customer;
import factory.ServiceFactory;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import task.TimeThread;
import vo.ShowCustomerVo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

/**
 * @ClassName CustomerFrame
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 10:28
 **/
public class CustomerFrame extends JFrame{
    private JPanel mainPanel;
    private JPanel showPanel;
    private JPanel bottomPanel;
    private JLabel timeLabel;

    private JTable table;

    public CustomerFrame(String account){
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        init();

        showCustomerTable(ServiceFactory.getCustomerSeriviceInstance().selectByAccount(account));
    }
    public void init(){
        this.setTitle("MainFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }
    public void showCustomerTable(List<Customer> ShowCustomerVoList) {
        showPanel.removeAll();
        //创建表格
        table = new JTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //表头内容
        model.setColumnIdentifiers(new String[]{"编号", "姓名", "电话", "地址", "信用", "商品编号", "消费时间", "商品编号"});
        //遍历List,转成Object数组
        for (Customer ShowCustomer : ShowCustomerVoList) {
            Object[] object = new Object[]{ShowCustomer.getId(), ShowCustomer.getName(), ShowCustomer.getPhone(), ShowCustomer.getAdress(), ShowCustomer.getCredit(), ShowCustomer.getP_id(), ShowCustomer.getC_time(), ShowCustomer.getE_id()};
            model.addRow(object);
        }

        //获得表头
        JTableHeader head = table.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        head.setDefaultRenderer(hr);
        //设置表头大小
        head.setPreferredSize(new Dimension(head.getWidth(), 40));
        //设置表头字体
        head.setFont(new Font("楷体", Font.PLAIN, 16));
        //设置表格行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(223, 241, 234));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        //表格加入滚动面板,水平垂直方向带滚动条
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        showPanel.add(scrollPane);
        showPanel.revalidate();
    }

    public static void main(String[] args) {

        new CustomerFrame("杨文涛");
    }
}

