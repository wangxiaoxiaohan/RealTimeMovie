package example.wanghan.com.realtimemovie.impl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import example.wanghan.com.realtimemovie.Fragment.MovieOnShowingFragment;
import example.wanghan.com.realtimemovie.MainActivity;
import example.wanghan.com.realtimemovie.MyApplication;
import example.wanghan.com.realtimemovie.Utils.MyDatabaseHelper;
import example.wanghan.com.realtimemovie.Utils.sharePreferenceUtils;
import example.wanghan.com.realtimemovie.api.ApiManager;
import example.wanghan.com.realtimemovie.api.CityList;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



/**
 * Created by hs-acer on 2017/12/1.
 */

public class mainImpl {
    private MainActivity mainActivity;
    private MovieOnShowingFragment movieOnShowingFragment=new MovieOnShowingFragment();
    private MyDatabaseHelper dbHelper;
    public mainImpl(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }
    public void  getCityData(){
          ApiManager.getApiManager().getCityListService().getCityList()
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<example.wanghan.com.realtimemovie.bean.CityList>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(example.wanghan.com.realtimemovie.bean.CityList cityList) {

                         dbHelper=new MyDatabaseHelper(MyApplication.getContext(),"BookStore8.db",null,1);//仅将城市列表写入数据库。
                         SQLiteDatabase db=dbHelper.getWritableDatabase();
                         ContentValues  values =new ContentValues();
                         for(int i=0;i<cityList.getP().size();i++){
                             values.put("name",cityList.getP().get(i).getN());
                             values.put("cityId",cityList.getP().get(i).getId());
                             db.insert("Book",null,values);

                         }

                     }
                     @Override
                     public void onError(Throwable e) {

                     }

                     @Override
                     public void onComplete() {

                     }
                 });

    }
}

