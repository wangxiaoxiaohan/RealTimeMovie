 package example.wanghan.com.realtimemovie;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

import example.wanghan.com.realtimemovie.Activity.LocatedActivity;
import example.wanghan.com.realtimemovie.Adapter.MovieListViewPagerAdapter;
import example.wanghan.com.realtimemovie.Adapter.SlidePictureViewPagerAdapter;
import example.wanghan.com.realtimemovie.Fragment.MovieOnShowingFragment;
import example.wanghan.com.realtimemovie.Fragment.MovieComingFragment;
import example.wanghan.com.realtimemovie.impl.mainImpl;

 public class MainActivity extends AppCompatActivity  {
     private ArrayList<ImageView> imageViewLists;
     private ViewPager slidePictureViewpager;
     private  ViewPager movieListViewpager;
     private int[] imageResId;
     private  ImageView imageView;
     private LinearLayout linearLayout;
     private  int lastPosition=0;
     private  RadioButton bottomRadioButton1;
     private   RadioButton bottomradioButton2;
     private  RadioButton topRadioButton1;
     private  Drawable topCinema;
     private  Drawable topMe;
     private ArrayList<Fragment> fragments;
     private  boolean Isfirst =true;
     private Integer progressBarLength=0;
     private RelativeLayout.LayoutParams layoutParams;//只能使用RelativeLayout的 layoutparams
     private  Integer progressbarMoveDistance;
     private   ImageView progressbar;
     private  Integer viewpagerWidth=0;
     private RadioGroup topradioGroup;
     private mainImpl mainimpl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainimpl=new mainImpl(this);
        mainimpl.getCityData();


        initView();
        initData();
        initAdapter();





           //电影列表的监听事件。
        movieListViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {//页面变化监听，此处实现进度条跟随逻辑
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                progressbarMoveDistance=
                        (int)((progressBarLength*position)+(((double)positionOffsetPixels/viewpagerWidth)*progressBarLength));
                         //？
                layoutParams.leftMargin=progressbarMoveDistance;
                progressbar.setLayoutParams(layoutParams);
                //实现进度条跟随的核心算法。
            }

            @Override
            public void onPageSelected(int position) {
                  topradioGroup.getChildAt(position).performClick();//模拟点击事件。达到radiobutton跟随viewpager变化地1目的。

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //轮播图的监听事件
           slidePictureViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                int newPosition=position % imageViewLists.size();
                linearLayout.getChildAt(lastPosition).setEnabled(false);
                linearLayout.getChildAt(newPosition).setEnabled(true);
                lastPosition=newPosition;
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //实现点击按钮切换页面。
        topradioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {//此ID不是position！！！
                    if(group.getCheckedRadioButtonId()==R.id.radioButton1){
                        movieListViewpager.setCurrentItem(0);
                    }else {
                        movieListViewpager.setCurrentItem(1);
                    }
              //此处想不到如何处理ID 与Viewpager的position之间的联系，只能使用枚举的方法实现点击按钮切换Viewpager。
            }
        });
        bottomradioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LocatedActivity.class);
                startActivity(intent);
            }
        });
       //轮播图无限轮播逻辑，耗时操作放在子线程中进行。
        new Thread(){

            @Override
            public void run() {
                while (true){
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            slidePictureViewpager.setCurrentItem(slidePictureViewpager.getCurrentItem() + 1);

                        }
                    });
                }
            }
        }.start();
    }
     private void initAdapter() {
         linearLayout.getChildAt(0).setEnabled(true);
         lastPosition=0;
         slidePictureViewpager.setAdapter(new SlidePictureViewPagerAdapter(imageViewLists));
         slidePictureViewpager.setCurrentItem(3000000);

        // if (Build.VERSION.SDK_INT>21){
       //  movieListViewpager.setNestedScrollingEnabled(false);
       //  }

         movieListViewpager.setAdapter(new
                 MovieListViewPagerAdapter(getSupportFragmentManager(),fragments));
     }


     private void initData() {

         View pointView;
         LinearLayout.LayoutParams  params;
         imageResId=new int[]{R.drawable.ic_1,R.drawable.ic_2,R.drawable.ic_3};
         imageViewLists=new ArrayList<>();
         //使用Glide填充顶部轮播图片
         for (int i=0;i<imageResId.length;i++){
             imageView=new ImageView(this);
             Glide.with(this).load(imageResId[i])
                     .centerCrop().into(imageView);
             imageViewLists.add(imageView);

          //小圆点 逻辑
             params=new  LinearLayout.LayoutParams(20,20);
             params.leftMargin=20;
             pointView=new View(this);
             pointView.setBackgroundResource(R.drawable.point_selector);
             pointView.setEnabled(false);
             linearLayout.addView(pointView,params);

         //电影列表Viewpager的Fragment集合添加
             fragments=new ArrayList<>();
             MovieOnShowingFragment movieOnShowingFragment=new MovieOnShowingFragment();
             MovieComingFragment moviewComingFragment=new MovieComingFragment();
             fragments.add(movieOnShowingFragment);
             fragments.add(moviewComingFragment);


         }
     }

     private void initView() {

         linearLayout= (LinearLayout) findViewById(R.id.linear_content);
         bottomRadioButton1= (RadioButton) findViewById(R.id.bottom_radio_group_1);
         bottomradioButton2= (RadioButton) findViewById(R.id.bottom_radio_group_2);
         topRadioButton1= (RadioButton) findViewById(R.id.radioButton1);
         slidePictureViewpager= (ViewPager) findViewById(R.id.sLide_picture_view_pager);
         movieListViewpager= (ViewPager) findViewById(R.id.Movie_list_View_pager);
         progressbar= (ImageView) findViewById(R.id.line_progress_bar);
         layoutParams=(RelativeLayout.LayoutParams)progressbar.getLayoutParams();
         topradioGroup= (RadioGroup) findViewById(R.id.top_radio_group);




      //设置底部RdaioButton的 drawabletop图片并限制它们的大小。
         topCinema=getResources().getDrawable(R.drawable.bottom_cinema_drawable_selector);
         topMe=getResources().getDrawable(R.drawable.bottom_me_drawable_selector);
         topCinema.setBounds(0,0,75,75);
         topMe.setBounds(0,0,75,75);
         bottomRadioButton1.setCompoundDrawables(null,topCinema,null,null);
         bottomradioButton2.setCompoundDrawables(null,topMe,null,null);

     }


     @Override//调用一次 ，利用Button  初始化进度条的宽度。
     public void onWindowFocusChanged(boolean hasFocus) {
         super.onWindowFocusChanged(hasFocus);
         if(Isfirst){
             Isfirst=false;
             int width=topRadioButton1.getWidth();
             progressBarLength=width;
             viewpagerWidth=movieListViewpager.getWidth()+movieListViewpager.getPageMargin();
             layoutParams.width=width;
             progressbar.setLayoutParams(layoutParams);
         }
     }


     @Override
     protected void onResume() {
         super.onResume();
         bottomRadioButton1.setChecked(true);
     }
 }
