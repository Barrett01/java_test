package testJDBC.JDBCutiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/*
    这是一个工具类，完成mysql的链接和关闭链接
 */
public class JDBCUtils {
    /*
    定义相关的属性，因为只需要一份 我们做成static
     */
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
    //在static代码快去初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("java_test/test001/src/mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //链接数据库 返回Connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭链接相关资源
    /*
    ResultSet 结果集
    Statement 或者 PreparedStatement
    Connection
    如果需要关闭资源，就传入对象，否则传入null
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
