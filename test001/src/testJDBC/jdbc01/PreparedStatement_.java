package testJDBC.jdbc01;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

//演示PreparedStatement
public class PreparedStatement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
//        //看PreparedStatement类图
////        PreparedStatement
//    }
//    @Test
//    public void test1() throws SQLException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String pwd = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileInputStream("java_test/test001/src/mysql.properties"));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);//注册
        //链接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3得到preparedstatement
        //3.1组织sql，sql中的？相当于占位符
        String sql = "select * from admin where name = ? and pwd = ?";
        //3.2preparedStatement 对象实现了PreparedStatement接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3给?赋值
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);

        //4 执行select需要使用executeQuery
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("恭喜，登录成功");
        } else {
            System.out.println("对不起，登录失败");
        }
        //关闭链接
        resultSet.close();
        preparedStatement.close();
        connection.close();


    }


}

