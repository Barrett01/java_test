package testJDBC.jdbc02;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import testJDBC.JDBCutiles.JDBCUtils;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class C3P0_ {
    //传统方式5k次数据库链接
    @Test
    public void testCon() {
        long start = System.currentTimeMillis();
        System.out.println("链接开始");
        for (int i = 0; i < 5000; i++) {
            Connection connection = JDBCUtils.getConnection();
            JDBCUtils.close(null,null,connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("共花费时间："+(end-start)+"ms");//传统方式需要：6429ms
    }

    //C3P0的使用{数据库连接池}
    @Test
    public void testC3P0_1() throws IOException, PropertyVetoException, SQLException {
        //创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //通过配置文件获取相关链接
        Properties properties = new Properties();
        properties.load(new FileInputStream("java_test/test001/src/mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源 comboPooledDataSource 设置相关参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("共花费"+(end-start)+"ms");//使用连接池 c3p0 共花费245ms


    }
    //第二种方式 使用配置文件模板来完成
    @Test
    public void testC3P0_2() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hh_edu");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费"+(end-start)+"ms"); //花费252ms
    }
}
