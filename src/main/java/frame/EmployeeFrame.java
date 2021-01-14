package frame;

import entity.Employee;
import factory.ServiceFactory;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import task.TimeThread;
import vo.customerVo;
import vo.employeeVo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

/**
 * @ClassName EmployeeFrame
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 10:28
 **/
public class EmployeeFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel showPanel;
    private JLabel timeLabel;

    private JTable table;

    public EmployeeFrame(String account){
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        init();

        showEmployeeTable(ServiceFactory.getEmployeeSeriviceInstance().selectByAccount(account));
    }
    public void init(){
        this.setTitle("MainFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }
    public void showEmployeeTable(List<Employee> employeeVoList) {
        showPanel.removeAll();
        //创建表格
        table = new JTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //表头内容
        model.setColumnIdentifiers(new String[]{"编号", "姓名", "部门", "产品类型", "任务编号", "工资"});
        //遍历List,转成Object数组
        for (Employee employee : employeeVoList) {
            Object[] object = new Object[]{employee.getId(), employee.getName(), employee.getDepartment(), employee.getType(), employee.getT_id(), employee.getSalary()};
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
        new EmployeeFrame("涛涛");
    }
}
