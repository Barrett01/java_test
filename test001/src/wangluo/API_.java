package wangluo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //1. 获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //2. 根据指定主机名 获取 InetAddress对象
        InetAddress allByName = InetAddress.getByName("LAPTOP-B22B1EE2");
        System.out.println(allByName);
        //3. 根据域名返回 InetAddress对象, 比如 www.baidu.com 对应
        InetAddress allByName1 = InetAddress.getByName("www.baidu.com");
        System.out.println(allByName1);
        //4. 通过 InetAddress 对象，获取对应的地址
        String hostAddress = allByName1.getHostAddress();
        System.out.println(hostAddress);
    }
}
