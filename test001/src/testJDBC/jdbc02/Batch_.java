package testJDBC.jdbc02;

import org.junit.jupiter.api.Test;
import testJDBC.JDBCutiles.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch_ {
    //传统方法，添加5000条数据
    @Test
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql1 = "insert into admin2  values (null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        System.out.println("开始执行：");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack"+i);
            preparedStatement.setString(2,"666"+i );
            preparedStatement.executeUpdate();

        }
        long end = System.currentTimeMillis();//结束时间
        System.out.println("耗时："+(end-start));//耗时：3049

        JDBCUtils.close(null, preparedStatement, connection);
    }

    @Test
    public void Batch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql2 = "insert into admin2  values (null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack"+i);
            preparedStatement.setString(2,"666"+i );
            preparedStatement.addBatch();
            //当有1000条记录时，在批量执行
            if ((i+1) % 1000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批处理耗时为："+(end-start));//批处理耗时为：71
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
