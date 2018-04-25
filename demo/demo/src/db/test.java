package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	 // 加载数据库驱动  com.mysql.jdbc.Driver
    private static String dbdriver = "com.mysql.jdbc.Driver";
    // 获取mysql连接地址
    private static String dburl = "jdbc:mysql://127.0.0.1:3306/demo?&useSSL=false&characterEncoding=utf-8";
    // 数据名称
    private static String username = "root";
    // 数据库密码
    private static String userpassword = "123456";
    // 获取一个数据的连接
    public static Connection conn = null;
    // 获取连接的一个状态
    /**
     * 获取数据库连接
     * 
     * @param myProjName
     * @return
     */
    public static Connection getConn(String myProjName) {
        Connection conn = null;
        try {
            Class.forName(dbdriver);            
            String myjdbcUrl = dburl.replace("cmxDatabaseName", myProjName);
            conn = DriverManager.getConnection(myjdbcUrl, username,"");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭数据库连接
     * 
     * @param rs
     * @param ps
     * @param conn
     */
    public static void closeAll(ResultSet rs, PreparedStatement ps,
            Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn == null)
            return;
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
