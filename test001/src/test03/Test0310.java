package test03;

//枚举的练习
public class Test0310 {
    public static void main(String[] args) {
        //演示枚举值switch的使用
        Color green = Color.GREEN;
        green.show();
        switch (green) {
            case RED:
                System.out.println("匹配到红色");
                break;
            case BLUE:
                System.out.println("匹配到绿色");
                break;
            case GREEN:
                System.out.println("蓝色");
                break;
            default:
                System.out.println("没有匹配到");
                break;
        }
    }
}

interface IMyInterface {
    public void show();
}

enum Color implements IMyInterface {
    RED(255, 0, 0), BLUE(0, 0, 255), GREEN(255, 255, 0), BLACK(0, 0, 0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public void show() {
        System.out.println("属性值：" + redValue + "," + greenValue + "," + blueValue);
    }
}