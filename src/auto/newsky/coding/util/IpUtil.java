package auto.newsky.coding.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2016/10/1.
 */
public class IpUtil {

    static InetAddress addr = null;
    static String ip;

    public static String getServiceIp(){

        if (ip!=null)
            return ip;
        try {
            addr = InetAddress.getLocalHost();
            ip=addr.getHostAddress()+":8080/";//获得本机IP
        } catch (UnknownHostException e) {
            e.printStackTrace();
            ip = "127.0.0.1:8080/";
        }
        return ip;
        // String address=addr.getHostName();//获得本机名称
    }

    public static String getPicUrl(String url){
        return getServiceIp()+url;
    }

    public static String getPicMinUrl(String url){
        String[] headUrl = url.split("max.");
        return getServiceIp()+headUrl[0]+"min."+headUrl[1];
    }
}
