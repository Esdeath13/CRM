package IO;

import java.io.*;
import java.sql.*;

/**
 * @ClassName JavaToSQLTest
 * @Description TODO
 * @Author YWT
 * @Date 2021/1/11 9:11
 **/
public class JavaToSQLTest {
    private static final String ROOT_PATH = "C:\\Users\\76108\\Desktop\\";
    public static void main(String[] args) throws FileNotFoundException {
        File file  = new File("C:\\Users\\76108\\Desktop\\out.txt");
        PrintWriter pw = new PrintWriter(file);
        FileWriter fw = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/crm?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=GMT%2B8";
        Connection conn = null;
        String id , p_id;
        String c_name, c_phone, c_adress, c_credit, c_time, p_name, p_price;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, "root", "123456");
            PreparedStatement ps = conn.prepareStatement("SELECT c_id, c_name, c_phone, c_adress,c_credit, p_id, c_time, p_name, p_price\n " +
                    "FROM customer NATURAL JOIN product ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                id = rs.getString("c_id");
                p_id = rs.getString("p_id");
                c_name = rs.getString("c_name");
                c_phone = rs.getString("c_phone");
                c_adress = rs.getString("c_adress");
                c_credit = rs.getString("c_credit");
                c_time = rs.getString("c_time");
                p_name = rs.getString("p_name");
                p_price = rs.getString("p_price");
                String filename = ROOT_PATH + id + ".txt";
                File file1 = new File(filename);
                if (!file1.exists()){
                    try {
                        file1.createNewFile();
                        pw.print(id + "\t");
                        pw.print(p_id + "\t");
                        pw.print(c_name + "\t");
                        pw.print(c_phone + "\t");
                        pw.print(c_adress + "\t");
                        pw.print(c_credit + "\t");
                        pw.print(c_time + "\t");
                        pw.print(p_name + "\t");
                        pw.print(p_price + "\t");
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }else {
                    try {
                        fw = new FileWriter(filename, true);
                        fw.write(id + "\t");
                        fw.write(p_id + "\t");
                        fw.write(c_name + "\t");
                        fw.write(c_phone + "\t");
                        fw.write(c_adress + "\t");
                        fw.write(c_credit + "\t");
                        fw.write(c_time + "\t");
                        fw.write(p_name + "\t");
                        fw.write(p_price + "\t");
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载数据库失败");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接错误");
            System.exit(1);
        }finally {
            if (conn != null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (pw != null){
                pw.close();
            }
            if (fw != null){
                try {
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
