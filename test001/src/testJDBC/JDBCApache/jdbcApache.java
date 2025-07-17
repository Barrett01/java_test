package testJDBC.JDBCApache;


import java.sql.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import testJDBC.JDBCutilesDruid.JDBCUtilByDruid;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

//                list.add(new Actor(id,name,sex,borndate,phone));//为了DBUtils 的日期兼容性 这里暂时注销
                //如果要使用，请把Actor里面的LocalDateTime改成date格式
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
