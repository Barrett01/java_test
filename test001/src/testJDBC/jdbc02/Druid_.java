package testJDBC.jdbc02;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Druid_ {
    @Test
    public void testDruid() throws Exception {
        //1，加入Druid jar包
        //2，加入配置文件 druid.properties ,将该文件拷贝项目的Src目录
        //3，创建Properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("java_test/test001/src/druid.properties"));

        //4,创建一个指定参数的数据库链接池，druid连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - start));//耗时：239 ||耗时：300{50w的情况下德鲁伊更牛逼 }
    }
}
