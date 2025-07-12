package testJDBC.jdbc01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

//模拟sql注入
public class Statement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String psw = sc.nextLine();

        Properties prop = new Properties();
        prop.load(new FileInputStream("java_test/test001/src/mysql.properties"));

        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();
        String sql = "select * from admin where name =" +"'"+ name+"'" + "and pwd = " + "'" + psw + "'";
        ResultSet resultSet = statement.executeQuery(sql);

    if (resultSet.next()) {
        System.out.println("成功");
    }else {
        System.out.println("失败");
    }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
