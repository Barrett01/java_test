package test.qt.fwczxt;

/*
相当于服务层
 */
public class HouseService {
    private House[] houses;//保存House对象
    private int houseNums = 1;//记录当前有多少房屋信息
    private int idCounter = 1;//记录当前id的增长信息

    public HouseService(int size) {
        houses = new House[size];//创建HouseService对象，指定数组大小
        /*
        测试使用
         */
        houses[0] = new House(1, "jock", "112", "宁海区", 3000, "未出租");


    }

    //change 修改对应的信息，根据id
    public House change(int Id) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            index = i;
        }
        if (index == -1){
            System.out.println("===============查无此房===================");
            return null;
        }
        //如果查到有此房 对该房间的信息进行更改；
        System.out.println("请输入要修改的name"+houses[index].getName() +"：");
        String name = Utility.readString(8);
        System.out.println("请输入要修改的电话"+houses[index].getPhone() +"：");
        String phone = Utility.readString(12);
        System.out.println("请输入要修改的地址"+houses[index]. getAddress()+"：");
        String address = Utility.readString(16);
        System.out.println("请输入要修改的月租"+houses[index].getRent()+"：");
        int rent = Utility.readInt();
        System.out.println("请输入要修改的状态"+houses[index].getState() +"：");
        String state = Utility.readString(3);
        houses[index].setName(name);
        houses[index].setPhone(phone);
        houses[index].setAddress(address);
        houses[index].setRent(rent);
        houses[index].setState(state);
        System.out.println("修改后：");
        return houses[index];
    }

    //fId方法 查找对应房屋的信息 并打印出来
    public House fId(int findId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (findId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("===============查无此房===================");
            return null;
        }
        return houses[index];
    }

    //del方法 删除一个房屋信息对象
    public boolean del(int delId) {
        //先找到房屋信息对应的下标
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) { //要删除房屋的（id），是数值下标为i的元素
                index = i;
            }
        }
        if (index == -1) {//说明delId在数组中不存在
            return false;

        }
        //如果找到房屋信息对应的下标{删除当前，然后让后面以此往前排}
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[houseNums - 1] = null;
        houseNums--;
        return true;

    }


    //add方法 添加新对象 返回boolean
    public boolean add(House newHouse) {
        //加入数组已满还要继续添加{添加数组扩容机制}#数组不能添加，只能创建新的数组，把老的数组放进去#
        if (houseNums == houses.length) {
            //不能再添加了
            System.out.println("数组已满不能再添加了。。。");
            //扩容
            int newCapHouse = houses.length * 2;
            House[] newHouses = new House[newCapHouse];
            //复制旧的数组到新的数组
            System.arraycopy(houses, 0, newHouses, 0, houses.length);//System.arraycopy() 是 Java 中用于数组复制的一个非常高效的方法
            houses = newHouses;
            System.out.println("容量不够进行了扩容，请再次输入");
            return true;
        }
        //吧newHouse对象
        houses[houseNums++] = newHouse;
        //需要设计一个id自增扎长机制，然后更新newHouse的id
        idCounter++;
        newHouse.setId(idCounter);
        return true;
    }

    //list方法 返回houses
    public House[] list() {
        return houses;
    }


}
