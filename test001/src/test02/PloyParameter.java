package test02;

public class PloyParameter {
    public static void main(String[] args) {
        Employee e = new Ordinary("张三", 8000,"普通员工");
        Employee e1 = new Manger("张三", 10000,"主管",1000);
//        String annual = e.getAnnual();
//        System.out.println(annual);
        Test test = new Test();
        double v = test.showEmpAnnual(e1);
        System.out.println(v);
        test.testWork(e1);


    }
    
}
class Test{
    public double showEmpAnnual(Employee e){
        return e.getAnnual();
    }

    public void testWork(Employee e){
        if (e instanceof Ordinary ){

            ((Ordinary) e).work();
        }else {

            ((Manger)e).manage();
        }
    }

}

class Employee{
    private String name;//姓名
    private double wages;//工资
//    public String type;

    public Employee(String name, double wages, String type) {
        this.name = name;
        this.wages = wages;
//        this.type = type;
    }



    public double getAnnual(){
        return wages*12;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWages() {
        return wages;
    }

    public void setWages(double wages) {
        this.wages = wages;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
}


//普通的员工
class  Ordinary extends Employee{
    public String type = "普通员工";

    public Ordinary(String name, double wages, String type) {
        super(name, wages, type);

    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }

    public void work(){
        System.out.println("普通员"+ getName()+"工在工作");
    }
}

//经理
class Manger extends Employee{
    private double bonus;//奖金
    public String type = "主管";

    public Manger(String name, double wages, String type, double bonus) {
        super(name, wages, type);
        this.bonus = bonus;

    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void manage(){
        System.out.println("管理者"+getName()+"正在管理员工");
    }
    @Override
    public double getAnnual() {
        return super.getAnnual()+bonus;
    }
}

