package example.wanghan.com.realtimemovie.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;


import java.util.ArrayList;

import example.wanghan.com.realtimemovie.Adapter.CommitsRecylerAdapter;
import example.wanghan.com.realtimemovie.Adapter.MovieCommitContainerAdapter;
import example.wanghan.com.realtimemovie.Fragment.MovieCommitFragment;
import example.wanghan.com.realtimemovie.MainActivity;
import example.wanghan.com.realtimemovie.MyApplication;
import example.wanghan.com.realtimemovie.R;
import example.wanghan.com.realtimemovie.Utils.sharePreferenceUtils;
import example.wanghan.com.realtimemovie.bean.MovieCommit.MovieCommitList;
import example.wanghan.com.realtimemovie.bean.moviePerformers.MoviePerformers;
import example.wanghan.com.realtimemovie.widget.CircleImageView;
import example.wanghan.com.realtimemovie.widget.RatingBar;
import example.wanghan.com.realtimemovie.bean.movieDetail.MovieDetail;
import example.wanghan.com.realtimemovie.impl.MovieDetailImpl;
import example.wanghan.com.realtimemovie.widget.expandableTextView;


/**
 * Created by hs-acer on 2017/12/6.
 */

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView posterimageView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private NestedScrollView nestScrollView;
    private CoordinatorLayout coordinatorlayout;
    private LinearLayout linearLayout;
    private AppBarLayout appBarLayout;
    private MovieDetailImpl movieDetailImpl;
    private FrameLayout frameLayout;
    private TextView DetailNameText;
    private TextView DetaisStyleyearText;
    private TextView DetailNameEnText;
    private TextView DetailShowTimeText;
    private TextView DetailMinText;
    private TextView DetailScoreText;
    private RatingBar DetailratingBar;
    private expandableTextView expandableTextView;
    private ProgressBar progressBar;
    private  ImageView detailDirectorImage;
    private LinearLayout actorlinerContent;
    private  TextView directorNametext;
    private CircleImageView circleImageView;
    private ArrayList<Fragment> fragments;
    private  ViewPager MovieCommitContainer;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moviedetail);
        initView();
        initData();

      /**  视图绘制完成之后设置海报周围背景framelayout颜色！！  已经通过Glide 资源监听器 捕获实现
        posterimageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                        int width =posterimageView.getWidth();
                        int height =posterimageView.getHeight();
                        Bitmap bp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bp);
                        posterimageView.draw(canvas);
                        canvas.save();
                        Palette pattle=Palette.from(bp).generate();
                        Palette.Swatch s=pattle.getDominantSwatch();
                        if (s!=null){
                            frameLayout.setBackgroundColor(s.getRgb());
                            toolbar.setBackgroundColor(s.getRgb());
                        }
            }
        });
*/
        }

    private void  initView(){
        posterimageView = (ImageView) findViewById(R.id.detail_image_view);
        toolbar = (Toolbar) findViewById(R.id.title_toolBar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        nestScrollView = (NestedScrollView) findViewById(R.id.nestScrollView);
        coordinatorlayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
        linearLayout = (LinearLayout) findViewById(R.id.nest_inner_linear);
        appBarLayout= (AppBarLayout) findViewById(R.id.appBarLayout);
        frameLayout= (FrameLayout) findViewById(R.id.fr_content);
        DetailNameText= (TextView) findViewById(R.id.detail_name);
        DetaisStyleyearText= (TextView) findViewById(R.id.detail_year_style_text);
        DetailNameEnText= (TextView) findViewById(R.id.detail_name_en);
        DetailShowTimeText= (TextView) findViewById(R.id.detail_show_day);
        DetailMinText= (TextView) findViewById(R.id.detail_min);
        DetailScoreText= (TextView) findViewById(R.id.detail_score_text);
        DetailratingBar= (RatingBar) findViewById(R.id.detail_score_star);
        expandableTextView= (example.wanghan.com.realtimemovie.widget.expandableTextView) findViewById(R.id.introduction_text);
        progressBar= (ProgressBar) findViewById(R.id.progress_detail);
        detailDirectorImage= (ImageView) findViewById(R.id.detail_director_image);
        actorlinerContent= (LinearLayout) findViewById(R.id.actor_linear_content);
        directorNametext= (TextView) findViewById(R.id.detail_director_name);
        MovieCommitContainer= (ViewPager) findViewById(R.id.movie_commit_container);


        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);//返回按钮 android.R.id.home;
        }


    }
    private  void   initData(){

        movieDetailImpl=new MovieDetailImpl(this);
        movieDetailImpl.getMovieDetailData(
            sharePreferenceUtils.getInt(MyApplication.getContext(),"yourCityId",0),getIntent().getIntExtra("movieId",0));
        movieDetailImpl.getMoviePerformersData(getIntent().getIntExtra("movieId",0));
        movieDetailImpl.getMovieLdquData(getIntent().getIntExtra("movieId",0));
        movieDetailImpl.getMovieCommitData(1,getIntent().getIntExtra("movieId",0));




        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float progress=-(float)verticalOffset/(float)(collapsingToolbarLayout.getHeight()-toolbar.getHeight());
                if (progress<1){
                    collapsingToolbarLayout.setTitle("");
                }else {
                    collapsingToolbarLayout.setTitle(sharePreferenceUtils.getString(MyApplication.getContext(),"thisMovieName","电影")
                            +"      "//对齐下策加空格。。。
                    );
                }
                toolbar.getBackground().setAlpha((int)(progress*255));//toolbar 背景透明度 随着上划逐渐出现。

            }
        });

        /**
        commitsRecylerAdapter.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            @override
            fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            }

            @override
            fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    var visiblePosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition()
                    if (visiblePosition == 0) {
                        barLayout.setExpanded(true, true)
                    }
                }
            }
        });*/
        posterimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MovieDetailActivity.this,PostImageActivity.class);
                startActivity(intent);
            }
        });

        fragments=new ArrayList<>();
        MovieCommitFragment movieCommitFragment=new MovieCommitFragment();
        fragments.add(movieCommitFragment);
        MovieCommitContainer.setAdapter(new MovieCommitContainerAdapter(getSupportFragmentManager(),fragments));



    }


    public void  upMovieDetailData(MovieDetail movieDetail){
     Glide.with(this)
             .load(movieDetail.getImage())
             .diskCacheStrategy(DiskCacheStrategy.SOURCE)
             .listener(new RequestListener<String, GlideDrawable>() {
                 @Override
                 public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                     return false;
                 }

                 @Override
                 public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                     Bitmap bitmap=((GlideBitmapDrawable)resource).getBitmap();
                     Palette pattle=Palette.from(bitmap).generate();
                     Palette.Swatch s=pattle.getDominantSwatch();
                     if (s!=null){
                         frameLayout.setBackgroundColor(s.getRgb());
                         toolbar.setBackgroundColor(s.getRgb());
                     }

                     return false;

                 }
             })
             .into(posterimageView);

    sharePreferenceUtils.setString(MyApplication.getContext(),"thisMovieName",movieDetail.getTitleCn());
   // 存储当前电影的名字以便在监听中调用
    DetailNameText.setText(movieDetail.getTitleCn());

    StringBuilder sb=new StringBuilder();
    for(String element:movieDetail.getType())
    {
        sb.append(element+"/");
    }
    DetaisStyleyearText.setText(movieDetail.getYear()+"/"+sb);
    DetailNameEnText.setText("英文名："+movieDetail.getTitleEn());
    DetailShowTimeText.setText("上映时间："+ movieDetail.getRelease().getDate()+"("+movieDetail.getRelease().getLocation()+")");
    DetailMinText.setText("片长："+movieDetail.getRunTime());
    DetailScoreText.setText(movieDetail.getRating());
    DetailratingBar.setStarMark(Float.parseFloat(movieDetail.getRating()));
    expandableTextView.setText(movieDetail.getContent());

}

    public   void  upPerformersData(MoviePerformers MoviePerformers){
        //添加导演数据
                 Glide.with(this)
                .load(MoviePerformers.getTypes().get(0).getPersons().get(0).getImage())
                .centerCrop()
                .into(detailDirectorImage);
                directorNametext.setText("导演："+MoviePerformers.getTypes().get(0).getPersons().get(0).getName());

         //若演员数量大于五个则只显示五个演员
                 int actorCount=MoviePerformers.getTypes().get(1).getPersons().size();
                 int imageCount;
                  if (actorCount>5){
                      imageCount=5;
                  }else {
                      imageCount=actorCount;
                  }

                  //添加演员view 并填充数据
                 for (int i=0;i<imageCount;i++){
                     if (!MoviePerformers.getTypes().get(1).getPersons().get(i).getName().equals("")){
                         LinearLayout linerinner=new LinearLayout(this);
                         linerinner.setPadding(30,0,30,0);
                         linerinner.setOrientation(LinearLayout.VERTICAL);
                         actorlinerContent.addView(linerinner, LinearLayout.LayoutParams.WRAP_CONTENT,500);
                            //演员图片
                            ImageView image=new ImageView(this);
                            linerinner.addView(image,300,380);
                            //演员姓名
                            TextView textactorname=new TextView(this);
                            textactorname.setGravity(Gravity.CENTER_HORIZONTAL);
                            textactorname.setMaxLines(1);
                            textactorname.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
                            textactorname.setEllipsize(TextUtils.TruncateAt.END);
                            linerinner.addView(textactorname,300,LinearLayout.LayoutParams.WRAP_CONTENT);
                         //演员饰演角色名字
                            TextView textpersonname=new TextView(this);
                            textpersonname.setGravity(Gravity.CENTER_HORIZONTAL);
                            textpersonname.setMaxLines(1);
                            textpersonname.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
                            textpersonname.setEllipsize(TextUtils.TruncateAt.END);
                            linerinner.addView(textpersonname,300,LinearLayout.LayoutParams.WRAP_CONTENT);

                            Glide.with(this)
                                   .load(MoviePerformers.getTypes().get(1).getPersons().get(i).getImage())
                                   .centerCrop()
                                   .into(image);
                            textactorname.setText(MoviePerformers.getTypes().get(1).getPersons().get(i).getName());
                            textpersonname.setText("饰："+MoviePerformers.getTypes().get(1).getPersons().get(i).getPersonateCn());
                           }
                 }


   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(MovieDetailActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//刷新
                startActivity(intent);
                break;
            case  R.id.share_button:
                //分享按钮的点击事件。
                break;
         }
        return true;
    }
    public  void hideProgress(){

        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
