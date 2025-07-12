package testJDBC.jdbc01;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class PreparedStatementDml {
//    public void test01() throws Exception{
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密码：");
        String pwd = scanner.nextLine();
        System.out.println("请输入修改的名字：");
        String name = scanner.nextLine();

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
        String sql = "update admin set name = ? where pwd = ?";
        //3.2preparedStatement 对象实现了PreparedStatement接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3给?赋值
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);

        //4 执行select需要使用executeQuery
        int resultSet = preparedStatement.executeUpdate();

        //关闭链接

        preparedStatement.close();
        connection.close();

    }
}
