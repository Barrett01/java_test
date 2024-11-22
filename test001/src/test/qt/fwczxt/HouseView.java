package test.qt.fwczxt;

/*
相当于页面{视图}
 */
public class HouseView {
    //化繁为简 一步一步实现
    //完成功能 思路分析 代码实现
    private boolean loop = true;
    private char key = ' ';

    private HouseService houseService = new HouseService(2);//设置数组大小为10

    //修改房屋信息{一般来说Id肯定不能修改}
    private void revice() {
        System.out.println("请输入你要修改的房屋信息的id：");
        int Id = Utility.readInt();

        System.out.println(houseService.change(Id));

    }

    //修改房屋信息 在view中完成{”老师思路“}
    private void update() {
        System.out.println("=================修改房屋信息===============");
        System.out.println("请选择待修改的房屋信息的ID（-1表示退出）");
        int updateId = Utility.readInt();
        if (updateId == -1){
            System.out.println("==============你已放弃修改房屋信息=================");
            return;
        }
        //确认要修改
        House house = houseService.fId(updateId);
        if (house == null){
            System.out.println("查无此房");
        }
        //找到该房间对象
        System.out.print("请输入要修改的姓名("+house.getName() +")：");
        String name = Utility.readString(6, "");//如果回车则不修改
        if (!"" .equals(name)){
            house.setName(name);
        }

        System.out.print("请输入要修改的电话("+house.getPhone() +")：");
        String phone = Utility.readString(11, "");
        if (!"".equals(phone)){
            house.setPhone(phone);
        }

        System.out.print("请输入要修改的地址("+house.getAddress() +")：");
        String address = Utility.readString(18, "");
        if (!"".equals(address)){
            house.setAddress(address);
        }
        System.out.print("请输入要修改的月租("+house.getRent() +")：");
        int rent = Utility.readInt(-1);
        if (-1 != rent){
            house.setRent(rent);
        }
        System.out.print("请输入要修改的状态("+house.getState() +")：");
        String state = Utility.readString(3, "");
        if (!"".equals(state)){
            house.setState(state);
        }


    }

    //查找房屋信息根据房屋的id
    private void findId() {
        System.out.println("请输入要查找的房屋id：");
        int Id = Utility.readInt();
        System.out.println(houseService.fId(Id));
    }

    //完成退出确认
    private void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    //编写delHouse（） 接受输入的id，调用Server的del删除方法
    public void delHouse() {
        System.out.println("=====================删除房屋====================");
        System.out.println("请输入待删除房屋的编号（-1退出）：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("================放弃删除房屋信息=============");
            return;
        }
        //该方法本身有循环判断的逻辑，必须输入y/n
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("成功删除");
            } else {
                System.out.println("房屋编号不存在");
            }
        } else {
            System.out.println("================放弃删除房屋信息=============");
        }
    }

    //编写addHouse（）方法；接受输入；创建House对象，调用add方法
    public void addHouse() {
        System.out.println("=====================添加房屋====================");
        System.out.println("姓名：");
        String name = Utility.readString(8);
        System.out.println("电话：");
        String phone = Utility.readString(12);
        System.out.println("地址：");
        String address = Utility.readString(16);
        System.out.println("月租：");
        int rent = Utility.readInt();
        System.out.println("状态：");
        String state = Utility.readString(3);
        House newHouse = new House(0, name, phone, address, rent, state);
        //把对象添加到数组中，使用add方法{service层}
        if (houseService.add(newHouse)) {
            System.out.println("============添加房屋成功============");
        } else {
            System.out.println("=============添加房屋失败============");
        }
    }


    //编写房屋列表的信息
    public void listHouses() {
        System.out.println("=====================房屋列表====================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态{出租/未出租}");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            //雷区一,解决
            if (houses[i] == null) {
                return;
            }
            System.out.println(houses[i]);
        }
        System.out.println("房屋列表显示完毕");

    }

    public void mainMenuHH() {
        do {
            System.out.println("=====================房屋出租系统菜单====================");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 源");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");

            System.out.println("请输入你的选择：");
            key = Utility.readChar();

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findId();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
//                    System.out.println("退      出");
                    //使用工具类“Utility”中的方法，来完成确认
                    exit();
                    break;

            }

        } while (loop);
    }
}
