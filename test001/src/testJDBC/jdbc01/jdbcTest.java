package testJDBC.jdbc01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("java_test/test001/src/mysql.properties"));

        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");
        String driver = prop.getProperty("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

        String sql1 = "create table news (id INT PRIMARY KEY ,content VARCHAR(64))";
        String sql2 = "insert into news  values(1,'今天早睡'),(2,'明天早起来'),(3,'算法字段'),(4,'纳税人'),(5,'招投标')";
        String sql3 = "update news set content = '其他维度' where id = 2 ";
        String sql4 = "delete from news where id =3";

        //执行静态语句
        Statement statement = connection.createStatement();
        int row = statement.executeUpdate(sql3);

        System.out.println(
                row > 0 ? "成功" : "失败"
        );

        //关闭链接
        statement.close();
        connection.close();
    }
}
