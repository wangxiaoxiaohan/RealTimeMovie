package example.wanghan.com.realtimemovie.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import example.wanghan.com.realtimemovie.MyApplication;

import static example.wanghan.com.realtimemovie.MyApplication.context;

/**
 * Created by hs-acer on 2017/12/3.
 */

public class sharePreferenceUtils {
    public static boolean getBoolean(Context context, String key, Boolean defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config", context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defValue);
    }

    public static void setBoolean(Context context, String key, Boolean Value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config", context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key, Value).commit();

    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config", context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defValue);
    }

    public static void setString(Context context, String key, String Value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config", context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key, Value).commit();
    }


    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config", context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defValue);
    }

    public static void setInt(Context context, String key, int Value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config", context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(key, Value).commit();

    }



}

