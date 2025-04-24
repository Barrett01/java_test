package fileIO.proprtties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties_ {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("D:\\githubCount\\test\\java_test\\test001\\src\\mysql.properties"));
        System.out.println(prop.getProperty("user"));
        System.out.println(prop.getProperty("pws"));
        prop.list(System.out);

    }
}
