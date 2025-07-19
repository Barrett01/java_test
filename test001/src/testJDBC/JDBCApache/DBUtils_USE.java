package testJDBC.JDBCApache;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;
import testJDBC.JDBCutilesDruid.JDBCUtilByDruid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_USE {
    public static void main(String[] args) throws SQLException {
        //1.得到链接
        Connection connection = JDBCUtilByDruid.getConnection();
        //2. 使用 DBUtils 类和接口 , 先引入DBUtils 相关的jar , 加入到本Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 就可以执行相关的方法，返回ArrayList 结果集
        String sql = "select * from actor where id >= ?";//先编写sql
        //(1) query 方法就是执行sql 语句，得到resultset ---封装到 --> ArrayList 集合中
        //(2) 返回集合
        //(3) connection: 连接
        //(4) sql : 执行的sql语句
        //(5) new BeanListHandler<>(Actor.class): 在将resultset -> Actor 对象 -> 封装到 ArrayList
        //    底层使用反射机制 去获取Actor 类的属性，然后进行封装
        //(6) 1 就是给 sql 语句中的? 赋值，可以有多个值，因为是可变参数Object... params
        //(7) 底层得到的resultset ,会在query 关闭, 并且关闭PreparedStatment，所以只需要传入connection就可以。
        /**
         * 分析 queryRunner.query方法:
         * public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
         *         PreparedStatement stmt = null;//定义PreparedStatement
         *         ResultSet rs = null;//接收返回的 ResultSet
         *         Object result = null;//返回ArrayList
         *
         *         try {
         *             stmt = this.prepareStatement(conn, sql);//创建PreparedStatement
         *             this.fillStatement(stmt, params);//对sql 进行 ? 赋值
         *             rs = this.wrap(stmt.executeQuery());//执行sql,返回resultset
         *             result = rsh.handle(rs);//返回的resultset --> arrayList[result] [使用到反射，对传入class对象处理]
         *         } catch (SQLException var33) {
         *             this.rethrow(var33, sql, params);
         *         } finally {
         *             try {
         *                 this.close(rs);//关闭resultset
         *             } finally {
         *                 this.close((Statement)stmt);//关闭preparedstatement对象
         *             }
         *         }
         *
         *         return result;
         *     }
         */
        List<Actor> query =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合：");
        for (Actor actor : query){
            System.out.println(actor);
        }
    //释放资源
        JDBCUtilByDruid.close(connection,null,null);
    }

    //演示apche-dbutils +druid完成 返回结果是单行记录（单个对象）
    @Test
    public void testQuerySingle() throws SQLException {
        //链接
        Connection connection = JDBCUtilByDruid.getConnection();
        //创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //sql语句
        String sql = "select * from actor where id >= ?";

        Actor query = queryRunner.query(connection, sql, new BeanHandler<Actor>(Actor.class), 3);
        System.out.println(query);
        JDBCUtilByDruid.close(connection,null,null);
    }
    //演示apache-dbutils + druid 完成查询结果是单行单列 返回是object
    @Test
    public void testScalar() throws SQLException {
        Connection connection = JDBCUtilByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from actor where id >= ?";
        Object oj
                = queryRunner.query(connection, sql, new ScalarHandler(), 3);
        System.out.println(oj);
        JDBCUtilByDruid.close(connection,null,null);
    }
    //演示apache-dbutils + druid 完成 dml (update, insert ,delete)
    @Test
    public void testDML() throws SQLException {
        Connection connection = JDBCUtilByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into actor values(null,?,?,?,?)";
        String sql2 = "update actor set name = ? where id = ?";
        String sql3 = "delete from actor where id = ?";

//        int affectedRow = queryRunner.update(connection, sql, "林青霞", "女", "1996-10-10", "1161983126");
//        int affectedRow = queryRunner.update(connection, sql2, "至尊宝", 7);
        int affectedRow = queryRunner.update(connection, sql3,  7);
        System.out.println(affectedRow > 0 ? "操作成功" : "操作未生效");
        JDBCUtilByDruid.close(connection,null,null);
    }

}
