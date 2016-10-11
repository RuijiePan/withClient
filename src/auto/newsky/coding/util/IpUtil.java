package auto.newsky.coding.util;

import javax.servlet.http.HttpServletRequest;
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
            ip= "http://"+addr.getHostAddress()+":8080/with/";//获得本机IP
        } catch (UnknownHostException e) {
            e.printStackTrace();
            ip = "http://"+"127.0.0.1:8080/with/";
        }
        return ip;
        // String address=addr.getHostName();//获得本机名称
    }
    public static String getServerURL(HttpServletRequest request){
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/with/";
    }
    public static String getPicUrl(String url,HttpServletRequest request){
        return getServerURL(request)+url;
    }

    public static String getPicMinUrl(String url,HttpServletRequest request){
        String[] headUrl = url.split("max.");
        return getServerURL(request)+headUrl[0]+"min."+headUrl[1];
    }
}
