package testJDBC.jdbc02;

import org.junit.jupiter.api.Test;
import testJDBC.JDBCutiles.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
演示jdbc中如何使用事务
 */
public class Transaction {
    @Test
    //不使用事务
    public void noTransaction() {
        //链接
        Connection conn = null;

        //sql
        String sql1 = "update account set balance = balance + ? where name = ?";
        String sql2 = "update account set balance = balance - ? where name = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();//链接
            ps = conn.prepareStatement(sql2);
            ps.setDouble(1, 100);
            ps.setString(2, "马云");
            int i = ps.executeUpdate();

            int m = 1 / 0;//人为制造错误，模拟当转账过程中发生了错误
            ps = conn.prepareStatement(sql1);
            ps.setDouble(1, 100);
            ps.setString(2, "马化腾");
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
    }


    @Test
    public void transaction() {
        //链接
        Connection conn = null;

        //sql
        String sql1 = "update account set balance = balance + ? where name = ?";
        String sql2 = "update account set balance = balance - ? where name = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();//链接
            conn.setAutoCommit(false);//开启事务
            ps = conn.prepareStatement(sql2);
            ps.setDouble(1, 100);
            ps.setString(2, "马云");
            int i = ps.executeUpdate();

            int m = 1 / 0;//人为制造错误，模拟当转账过程中发生了错误
            ps = conn.prepareStatement(sql1);
            ps.setDouble(1, 100);
            ps.setString(2, "马化腾");
            ps.executeUpdate();
            conn.commit();//提交事务

        } catch (SQLException e) {
            System.out.println("发生异常 回滚事务");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
    }
}
