package frame;

import com.sun.org.apache.xml.internal.security.Init;
import entity.Customer;
import entity.Employee;
import entity.Information;
import factory.ServiceFactory;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import task.TimeThread;
import vo.customerVo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @ClassName AdminFrame
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 10:27
 **/
public class AdminFrame extends JFrame {
    private JPanel mainPanel;
    private JButton 用户信息Button;
    private JButton 员工信息Button;
    private JPanel centerPanel;
    private JPanel customerPanel;
    private JComboBox customerBox;
    private JComboBox informationBox;
    private JButton 新增Button;
    private JButton 删除Button;
    private JPanel tablePanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel timeLabel;
    private JPanel employeePanel;
    private JPanel tablePanel2;
    private JButton 删除Button1;
    private JButton 新增Button1;
    private JPanel buttonPanel;
    private JButton 退出Button;
    private JTable table;
    private JTable table2;

    /**
     * 自定义变量
     */
    private final CardLayout c;

    public AdminFrame() {
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        init();


        c = new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("1", customerPanel);
        centerPanel.add("2", employeePanel);
        showCustomerTable(ServiceFactory.getCustomerSeriviceInstance().selectAll());
        showEmployeeTable(ServiceFactory.getEmployeeSeriviceInstance().selectAll());

        customerBox.addItem(customerVo.builder().name("请选择姓名").build());
        List<customerVo> customers = ServiceFactory.getCustomerSeriviceInstance().selectAll();
        for (customerVo customer : customers) {
            customerBox.addItem(customer);
        }


        Information tip2 = new Information();
        tip2.setP_id("请选择产品编号");
        informationBox.addItem(tip2);

        List<Information> informationList = ServiceFactory.getInformationServiceInstance().selectAll();;
        for (Information information : informationList) {
            informationBox.addItem(information);
        }
        用户信息Button.addActionListener(e -> {
            c.show(centerPanel, "1");
            showCustomerTable(ServiceFactory.getCustomerSeriviceInstance().selectAll());
        });
        员工信息Button.addActionListener(e -> {
            c.show(centerPanel, "2");
            showEmployeeTable(ServiceFactory.getEmployeeSeriviceInstance().selectAll());
        });

        新增Button.addActionListener(e -> {
            new AddCustomerFrame(AdminFrame.this);
            AdminFrame.this.setEnabled(true);
        });
        删除Button.addActionListener(e -> {
            int a = table.getSelectedRow();
            ServiceFactory.getCustomerSeriviceInstance().deleteById(table.getValueAt(a,0).toString());
            JOptionPane.showMessageDialog(null, "删除成功");
            showCustomerTable(ServiceFactory.getCustomerSeriviceInstance().selectAll());
            table.validate();
        });

        新增Button1.addActionListener(e -> {
            new AddEmployeeFrame(AdminFrame.this);
            AdminFrame.this.setEnabled(true);
        });
        删除Button1.addActionListener(e -> {
            int a = table2.getSelectedRow();
            ServiceFactory.getEmployeeSeriviceInstance().deleteById(table2.getValueAt(a,0).toString());
            JOptionPane.showMessageDialog(null, "删除成功");
            showEmployeeTable(ServiceFactory.getEmployeeSeriviceInstance().selectAll());
            table2.validate();
        });
        退出Button.addActionListener(e -> {
            new LoginFrame();
            this.dispose();
        });
    }

    public void init() {
        this.setTitle("AdminFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setVisible(true);
    }

    public void showCustomerTable(List<customerVo> customerList) {
        tablePanel.removeAll();
        //创建表格
        table = new JTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //表头内容
        model.setColumnIdentifiers(new String[]{"编号", "姓名", "电话", "地址", "信用度", "商品编号", "消费时间", "联系人编号"});
        //遍历List,转成Object数组
        for (customerVo customer : customerList) {
            Object[] object = new Object[]{customer.getId(), customer.getName(), customer.getPhone(), customer.getAdress(), customer.getCredit(), customer.getP_id(), customer.getTime(), customer.getE_id()};
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
        tablePanel.add(scrollPane);
        tablePanel.revalidate();
    }


    public void showEmployeeTable(List<Employee> employeeList) {
        tablePanel2.removeAll();
        //创建表格
        table2 = new JTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel();
        table2.setModel(model);
        //表头内容
        model.setColumnIdentifiers(new String[]{"编号", "姓名", "部门", "产品类型", "任务编号", "工资"});
        //遍历List,转成Object数组
        for (Employee employee : employeeList) {
            Object[] object = new Object[]{employee.getId(), employee.getName(), employee.getDepartment(),employee.getType(), employee.getT_id(), employee.getSalary()};
            model.addRow(object);
        }

        //获得表头
        JTableHeader head = table2.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        head.setDefaultRenderer(hr);
        //设置表头大小
        head.setPreferredSize(new Dimension(head.getWidth(), 40));
        //设置表头字体
        head.setFont(new Font("楷体", Font.PLAIN, 16));
        //设置表格行高
        table2.setRowHeight(35);
        //表格背景色
        table2.setBackground(new Color(223, 241, 234));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table2.setDefaultRenderer(Object.class, r);
        //表格加入滚动面板,水平垂直方向带滚动条
        JScrollPane scrollPane = new JScrollPane(table2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel2.add(scrollPane);
        tablePanel2.revalidate();
    }

    public static void main(String[] args) {
        new AdminFrame();
    }
}
