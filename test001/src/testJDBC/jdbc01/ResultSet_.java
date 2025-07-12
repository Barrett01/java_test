package testJDBC.jdbc01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ResultSet_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();//获取配置文件
        properties.load(new FileInputStream("java_test/test001/src/mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);//通过反射完成注册
        Connection connect = DriverManager.getConnection(url, user, password);//链接

        String sql = "select * from news";
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        //循环打印
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1)+"--"+resultSet.getString(2) );
        }
        //关闭链接
        resultSet.close();
        statement.close();
        connect.close();



    }
}
