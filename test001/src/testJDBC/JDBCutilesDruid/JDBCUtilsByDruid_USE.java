package testJDBC.JDBCutilesDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//使用
public class JDBCUtilsByDruid_USE {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from actor";

        Connection connection = JDBCUtilByDruid.getConnection();
        System.out.println(
                connection.getClass()
        );//运行类型 com.alibaba.druid.pool.DruidPooledConnection
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("name")+"\t"+rs.getString("borndate")
            +"\t"+rs.getString("sex"));
        }
        JDBCUtilByDruid.close(conn, ps, rs);//这个地方 close 不是真的断掉连接 而是把使用的Connection对象放回连接池“因为使用了连接池”
    }
}
