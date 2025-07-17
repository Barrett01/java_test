package testJDBC.JDBCApache;


import java.time.LocalDateTime;

public class Actor {
    private String name;
    private Integer id;
    private String sex;
    private LocalDateTime borndate;
    private String phone;
    public Actor() {//需要一个无参构造器，反射需要
    }

    public Actor(Integer id, String sex, String name, LocalDateTime borndate, String phone) {
        this.id = id;
        this.sex = sex;
        this.name = name;
        this.borndate = borndate;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBorndate() {
        return borndate;
    }

    public void setBorndate(LocalDateTime borndate) {
        this.borndate = borndate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                ", borndate=" + borndate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
