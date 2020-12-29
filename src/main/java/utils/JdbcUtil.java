package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName JdbcUtil
 * @Description TODO
 * @Author YWT
 * @Date 2020/12/29 8:36
 **/
public class JdbcUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/crm?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=GMT%2B8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static Connection connection = null;
    private static JdbcUtil jdbcUtil = null;

    /**
     * 获得JDBCUtil实例
     *
     * @return JDBCUtil实例
     */
    public static JdbcUtil getInitJdbcUtil() {
        if (jdbcUtil == null) {
            synchronized (JdbcUtil.class) {
                if (jdbcUtil == null) {
                    jdbcUtil = new JdbcUtil();
                }
            }
        }
        return jdbcUtil;
    }
    private JdbcUtil(){

    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    /**
     * 获得连接
     *
     * @return CONNECTION
     */
    public Connection getConnection(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return connection;
    }

    public void closeConnection(){
        if (connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Connection connection = JdbcUtil.getInitJdbcUtil().getConnection();
        if (connection != null){
            System.out.println("连接成功!");
        }
    }
}
