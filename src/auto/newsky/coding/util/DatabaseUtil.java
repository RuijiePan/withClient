package auto.newsky.coding.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import auto.newsky.coding.exception.CustomException;

public class DatabaseUtil {

	public static boolean testConnection(String url, String driver,
			String username, String password) throws Exception{
		Connection conn = null;
		try {
			// 加载MySql的驱动类
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username,
					password);
			if(conn!=null)
				return true;
			else
				return false;
		} catch (ClassNotFoundException e) {
			throw new CustomException("找不到驱动程序类 ，加载驱动失败！");
		} catch (SQLException se) {
			throw new CustomException("数据库连接失败！");
		} finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e) {
					throw new CustomException("数据库关闭连接失败！");
				}
			}
		}
	}
	
	public static Connection getConnection(String url, String driver,
			String username, String password) throws Exception{
		Connection conn = null;
		try {
			// 加载MySql的驱动类
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username,
					password);
		} catch (ClassNotFoundException e) {
			throw new CustomException("找不到驱动程序类 ，加载驱动失败！");
		} catch (SQLException se) {
			throw new CustomException("数据库连接失败！");
		} 
		return conn;
	}
	
	public static void release(ResultSet rs, Statement stmt, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
