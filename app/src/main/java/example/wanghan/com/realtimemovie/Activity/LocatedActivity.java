package example.wanghan.com.realtimemovie.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import java.util.ArrayList;
import java.util.List;

import example.wanghan.com.realtimemovie.MyApplication;
import example.wanghan.com.realtimemovie.R;
import example.wanghan.com.realtimemovie.Utils.MyDatabaseHelper;
import example.wanghan.com.realtimemovie.Utils.sharePreferenceUtils;

/**
 * Created by hs-acer on 2017/12/4.
 */

public class LocatedActivity extends AppCompatActivity {
    private LocationClient mLocationClient;
    private  Button nameButton;
    private Button locatedButton;
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locatedlayout);
        requestPermissions();
        initView();
        initData();
        locatedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLocation();
            }
        });
        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameButton.getText()!=""){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(LocatedActivity.this);
                    dialog.setTitle("这是个对话框");
                    dialog.setMessage("这没什么重要的");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                }
            }
        });


    }

    private void initData() {
        mLocationClient=new LocationClient(MyApplication.getContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }

   private void   initView(){
       locatedButton= (Button) findViewById(R.id.getCityButton);
       nameButton= (Button) findViewById(R.id.nameButton);

   }

    public  class MyLocationListener extends BDAbstractLocationListener{
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            sharePreferenceUtils.setString(MyApplication.getContext(),"yourCityKey",bdLocation.getCity());
            nameButton.setText(bdLocation.getCity());

            dbHelper=new MyDatabaseHelper(MyApplication.getContext(),"BookStore8.db",null,1);
            SQLiteDatabase db=dbHelper.getWritableDatabase();
            Cursor cursor=db.query("Book",null,null,null,null,null,null);//从数据库中查询城市对应的Id.
            if (cursor.moveToFirst()){
                do {
                    //获取到当前城市之后将CityId刷新为当前所在的城市的Id.
                    String myCityName=cursor.getString(cursor.getColumnIndex("name"));
                    int myCityId=  cursor.getInt(cursor.getColumnIndex("cityId"));
                    if (myCityName.equals(bdLocation.getCity().substring(0,2))){
                        sharePreferenceUtils.setInt(MyApplication.getContext(),"yourCityId",myCityId);
                    }
                }while (cursor.moveToNext());
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if(grantResults.length>0){
                    for(int result:grantResults){
                        if(result!= PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this,"需要权限!",Toast.LENGTH_SHORT);
                            finish();
                            return;
                        }
                    }
                } else {
                    finish();
                }
                break;
        }
    }
    private void  requestPermissions(){
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(LocatedActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(LocatedActivity.this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);

        }
        if (ContextCompat.checkSelfPermission(LocatedActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(LocatedActivity.this, permissions, 1);
        }
    }
    private void requestLocation() {
        mLocationClient.start();
    }


}
