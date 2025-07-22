package testJDBC.dao_.test;

import org.junit.jupiter.api.Test;
import testJDBC.dao_.dao.ActorDAO;
import testJDBC.dao_.dao.GoodsDAO;
import testJDBC.dao_.domain.Actor;
import testJDBC.dao_.domain.Goods;

import javax.swing.*;
import java.util.List;

public class testActorDAO {
    @Test
    public void testActorDAO() {
        // 查询
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id > ?", Actor.class, 2);
        System.out.println("查询结果：");
        for (Actor actor : actors) {
            System.out.println(actor);
        }
        System.out.println("================================");

        //2,查询单行记录
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 2);
        System.out.println("查询结果："+actor);
        System.out.println("==================================");
        //3,查询单个
        Object o = actorDAO.queryScalar("select name from actor where id = ?", 2);
        System.out.println("查询结果："+o);
        // 4 dml insert update delete
        int update = actorDAO.update("insert into actor values(null,?,?,?,?)", "张无忌", "男", "2000-11-11", "19936492869");
        System.out.println(update > 0 ? true : false);
    }
    @Test
    public void testGoodsDAO2() {
        GoodsDAO goodsDAO = new GoodsDAO();
        List<Goods> goods = goodsDAO.queryMulti("select * from goods where id > ?", Goods.class, 10);
        System.out.println("商品的全部信息：");
        for (Goods good : goods) {
            System.out.println(good);
        }
    }
}
