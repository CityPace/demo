package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	 // �������ݿ�����  com.mysql.jdbc.Driver
    private static String dbdriver = "com.mysql.jdbc.Driver";
    // ��ȡmysql���ӵ�ַ
    private static String dburl = "jdbc:mysql://127.0.0.1:3306/demo?&useSSL=false&characterEncoding=utf-8";
    // ��������
    private static String username = "root";
    // ���ݿ�����
    private static String userpassword = "123456";
    // ��ȡһ�����ݵ�����
    public static Connection conn = null;
    // ��ȡ���ӵ�һ��״̬
    /**
     * ��ȡ���ݿ�����
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
     * �ر����ݿ�����
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
