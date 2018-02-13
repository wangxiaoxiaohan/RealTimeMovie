package example.wanghan.com.realtimemovie.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by hs-acer on 2017/12/3.
 */

public class NetWorkUtils {
    /**
     * 网络是否可用
     * @param context
     * @return
     */
    public  static  boolean IsNetWorkAvailable(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isConnected();
    }

    /**
     * Wifi是否可用
     * @param context
     * @return
     */
    public  static  boolean IsWiFiAvailable(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
        return  networkInfo!=null && networkInfo.getType()==connectivityManager.TYPE_WIFI;
    }

    /**
     * 网络状态是否为移动数据。
     * @param context
     * @return
     */
    public  static  boolean IsMobile(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
        return  networkInfo!=null && networkInfo.getType()==connectivityManager.TYPE_MOBILE;
    }
}
