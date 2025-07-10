package testJDBC.jdbc01;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//jdbc链接的五种方式
public class JdbcConn {
    //方式一：
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/hh_db02";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hh");
        Connection conn = driver.connect(url, properties);
        System.out.println("方式1：" + conn);
    }

    //方式2：
    @Test
    public void connect02() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 使用反射加载Driver类  动态加载，更加灵活 减少依赖
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/hh_db02";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hh");
        Connection conn = driver.connect(url, properties);
        System.out.println("方式2：" + conn);

    }

    //方式3：使用DriverManager 替代 Diver 进行统一管理
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/hh_db02";
        String user = "root";
        String password = "hh";
        DriverManager.registerDriver(driver);//注册Driver驱动

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第三种方式：" + connection);

    }

    //第四种方式：{使用最多 推荐使用}
    @Test
    public void connect04() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类
        //在加载Driver类的时候 完成的注册
        /*
        看出底层的加载注册Driver的工作已经完成
        源码：
      static {
        try {
            java.sql.DriverManager.registerDriver(new Driver());
        } catch (SQLException E) {
            throw new RuntimeException("Can't register driver!");
        }
    }


         */
        Class.forName("com.mysql.jdbc.Driver");//把这个去掉也行 因为驱动里面也有注册 但是还是建议写上
        String url = "jdbc:mysql://localhost:3306/hh_db02";
        String user = "root";
        String password = "hh";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第四种方式：" + connection);
    }

    //第五种方式：在方式4的基础上进行简化和改进
    @Test
    public void connect05() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
        // 通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("java_test/test001/src/mysql.properties"));
        //获取相关值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("第五种" + connection);

    }


}
