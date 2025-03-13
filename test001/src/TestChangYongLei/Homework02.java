package TestChangYongLei;

public class Homework02 {
    public static void main(String[] args) {
        String name = "jack";
        String pwd = "123456";
        String email = "jack@gmail.com";
        try {
            userRegister(name, pwd, email);
            System.out.println("恭喜 注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userRegister(String name, String pwd, String email) {
        int userLength = name.length();
        if (!(userLength >= 2 && userLength <= 4)) {
            throw new RuntimeException("用户名长度为2~4");
        }
        if (!(pwd.length() == 6 && isDigital(pwd))) {
            throw new RuntimeException("密码格式不正确");
        }
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && j > i)) {
            throw new RuntimeException("邮箱里面需要包含@ 和.");
        }

    }

    //单独写一个方法，判断是否全部为数字字符
    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= '0' && chars[i] >= '9') {
                return false;
            }
        }
        return true;
    }
}
