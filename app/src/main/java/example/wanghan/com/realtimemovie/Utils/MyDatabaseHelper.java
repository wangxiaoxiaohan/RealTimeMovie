package example.wanghan.com.realtimemovie.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import example.wanghan.com.realtimemovie.MainActivity;
import example.wanghan.com.realtimemovie.MyApplication;

/**
 * Created by hs-acer on 2017/12/4.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public  static  final  String  CREATE_BOOK="create table Book("
            +"id integer primary key autoincrement,"
            +"name text,"
            +"cityId integer)";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
