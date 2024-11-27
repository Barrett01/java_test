package test03;

public class Test0304 {
    public static void main(String[] args) {
//        System.out.println(Frock.getNextNum());
//        System.out.println(Frock.getNextNum());
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        System.out.println(frock1.getSerialNumber()+"\t"+frock2.getSerialNumber()+"\t"+frock3.getSerialNumber());


    }
}

class Frock {
    private static int currentNum = 100000;
    private int serialNumber;

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getNextNum(){
        currentNum +=100;
        return currentNum;
    }
}
