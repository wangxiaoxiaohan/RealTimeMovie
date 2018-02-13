package example.wanghan.com.realtimemovie;

import android.app.Application;
import android.content.Context;

/**
 * Created by hs-acer on 2017/12/3.
 */

public class MyApplication extends Application {
    //记得一定要注册。谨记

   public   static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
    public  static Context getContext(){
        return  context;
    }

}
