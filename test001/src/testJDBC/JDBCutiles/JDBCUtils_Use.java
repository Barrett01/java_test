package testJDBC.JDBCutiles;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Scanner;

public class JDBCUtils_Use {
    @Test
    public void testSelect() {
        //得到链接
        Connection conn = null;

        //组织sql
        String sql = "select * from actor where id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        //创建对象并执行
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 2);
            rs = ps.executeQuery();
            //遍历结果
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                Date borndate = rs.getDate("borndate");
                String phone = rs.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭链接
            JDBCUtils.close(rs, ps, conn);
        }


    }

    @Test
    public void testInsert() {
        //数据
//        int id = 5;
//        String name = "华仔";
//        String sex = "男";
//        String borndate = "1999-10-10";
//        String phone = "1888888888";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入id:");
        int id = sc.nextInt();
        /*
        extInt() 只读取整数，不读取行尾的换行符（\n）。
        当用户输入整数后按回车，输入缓冲区中会留下 \n
        后续的nextLine()会立即读取这个残留的 \n，将其视为空字符串，导致看似被"跳过"。
         */
        //方法1
        sc.nextLine();//关键：消耗残留换行符；
        //或者
        //int id = Integer.parseInt(sc.nextline());//转换一下
        System.out.println("请输入sex:");
        String sex = sc.nextLine();
        System.out.println("请输入name:");
        String name = sc.nextLine();
        System.out.println("请输入生日:");
        String borndate = sc.nextLine();
        System.out.println("请输入phone:");
        String phone = sc.nextLine();

        //链接前准备
        Connection conn = null;
        String sql = "insert into actor values(?,?,?,?,?)";
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            //调用接口工具 链接并操作
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.setString(2, name);
            ps.setString(3, sex);
            ps.setString(4,borndate);
            ps.setString(5, phone);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(rs, ps, conn);
        }

    }
}
