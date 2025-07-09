package testJDBC.jdbc01;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc01 {
    public static void main(String[] args) throws SQLException {
        //前置工作 ：在项目要下创建一个文件夹libs 加入mysql的jar包
//        注册驱动
        Driver driver = new Driver();//创建driver

        //得到链接
        /*
        //(1) jdbc:mysql:// 规定好表示协议，通过jdbc的方式连接mysql
        //(2) localhost 主机，可以是ip地址
        //(3) 3306 表示mysql监听的端口
        //(4) hsp_db02 连接到mysql dbms 的哪个数据库
        //(5) mysql的连接本质就是前面学过的socket连接
         */
        String url = "jdbc:mysql://localhost:3306/hh_db02";
        //将用户名和密码 放入到properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hh");
        Connection connect = driver.connect(url, properties);//使数据库连接到url


        //执行sql
//        String sql = "insert into actor values(null,'德华','男','1999-12-12','1921679267')";
//        String sql = "update actor set name = '周星驰' where name = '德华'";
        String sql = "delete from actor where id = 1";
        Statement statement = connect.createStatement();//用于执行静态sql语句 并返回结果的对象
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");
        //关闭链接
        statement.close();
        connect.close();


    }
}
