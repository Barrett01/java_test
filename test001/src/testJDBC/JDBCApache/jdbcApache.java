package testJDBC.JDBCApache;


import java.sql.Connection;


import org.junit.jupiter.api.Test;
import testJDBC.JDBCutilesDruid.JDBCUtilByDruid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Date;
import java.util.Scanner;

public class jdbcApache {
    /**
     * @return list
     */
    @Test
    /*
    在 JUnit 测试中（使用 @Test 注解），测试方法必须声明为 public void，不能有返回值。
    这是 JUnit 框架的强制要求，与普通方法不同。
     */
    public void testSelectArrayList(){
    //依旧使用druid方式来完成
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入大于的id：" );
        int cid = scanner.nextInt();


        //组织sql
        String sql = "select * from actor where id >= ?";
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;


        ArrayList<Actor> list = new ArrayList<>();//创建Arraylist对象用于存放actor对象
        //创建对象 -链接
        try {
            conn = JDBCUtilByDruid.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                Date borndate = rs.getDate("borndate");
                String phone = rs.getString("phone");

                list.add(new Actor(id,name,sex,borndate,phone));
            }
            for (Actor actor : list) {
                System.out.println(actor.getId() +"\t"+actor.getName()+"\t"+actor.getSex());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtilByDruid.close(conn,ps,rs);
        }



    }
}
