package example.wanghan.com.realtimemovie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;

import example.wanghan.com.realtimemovie.Activity.MovieDetailActivity;
import example.wanghan.com.realtimemovie.R;
import example.wanghan.com.realtimemovie.widget.RatingBar;
import example.wanghan.com.realtimemovie.bean.TodayMovie.TodayMovie;

/**
 * Created by hs-acer on 2017/11/29.
 */

public class MovieLocatedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<TodayMovie> todayMovies=new ArrayList<>();



    static class MovieLocatedViewHolder extends RecyclerView.ViewHolder{
           TextView directorText;
          TextView actorText;
          TextView movieName;
          ImageView posterImage;
          Button moreButton;
          RatingBar ratingBar;
          TextView scoreText;
          LinearLayout linearLayout;


        public MovieLocatedViewHolder(View itemView) {
            super(itemView);
            directorText= (TextView) itemView.findViewById(R.id.director_text);
            actorText= (TextView) itemView.findViewById(R.id.actor_text);
            movieName= (TextView) itemView.findViewById(R.id.text_MovieName);
            posterImage= (ImageView) itemView.findViewById(R.id.item_poster);
            moreButton= (Button) itemView.findViewById(R.id.item_more_button);
            ratingBar= (RatingBar) itemView.findViewById(R.id.star_view);
            scoreText= (TextView) itemView.findViewById(R.id.score_text);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.item_Linear);
        }
    }

    public MovieLocatedAdapter(Context context) {
        this.mContext=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.recycler_item_onplaying,parent,false);
       RecyclerView.ViewHolder holder= new  MovieLocatedViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
             mbindViewHolder((MovieLocatedViewHolder) holder,position);



    }
    private void mbindViewHolder(final MovieLocatedViewHolder movieLocatedViewHolder, int position){

        final TodayMovie todayMovie=todayMovies.get(position);
        double score=todayMovie.getR();
        if (score>0){
            movieLocatedViewHolder.scoreText.setText(String.valueOf(todayMovie.getR()));
        }else {
            movieLocatedViewHolder.scoreText.setText("暂无评分");
        }

        movieLocatedViewHolder.ratingBar.setStarMark((float)todayMovie.getR());
        movieLocatedViewHolder.movieName.setText(todayMovie.getT());
        movieLocatedViewHolder.directorText.setText("导演："+todayMovie.getDN());
        movieLocatedViewHolder.actorText.setText("主演："+todayMovie.getActors());
        Glide.with(mContext)
                .load(todayMovie.getImg())
              //  .dontAnimate()//禁用加载动画解决刷新变形问题
                .centerCrop()
                .placeholder(R.drawable.preview)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//此处保存原图，详情页面中的第一张大图要用。
                .into(new SimpleTarget<GlideDrawable>() {//这种办法也可解决刷新变形的问题
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        movieLocatedViewHolder.posterImage.setImageDrawable(resource);
                    }
                });

         movieLocatedViewHolder.posterImage.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 goMovieDetailActivity(todayMovie,movieLocatedViewHolder);
             }
         });
        movieLocatedViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMovieDetailActivity(todayMovie,movieLocatedViewHolder);
            }
        });

         }
    @Override
    public int getItemCount() {

        return todayMovies.size();
    }
    public  void  addItem(ArrayList<TodayMovie> list){

       todayMovies.addAll(list);
        notifyDataSetChanged();//

    }
    private void  goMovieDetailActivity(TodayMovie todayMovie,RecyclerView.ViewHolder holder){
        Intent intent=new Intent(mContext, MovieDetailActivity.class);
        intent.putExtra("movieId",todayMovie.getId());

        mContext.startActivity(intent);
    }
  /**  private void runEnterAnimation(View view, int position) {

        if (animationsLocked) return;//animationsLocked是布尔类型变量，一开始为false，确保仅屏幕一开始能够显示的item项才开启动画

        if (position > lastAnimatedPosition) {//lastAnimatedPosition是int类型变量，一开始为-1，这两行代码确保了recycleview滚动式回收利用视图时不会出现不连续的效果
            lastAnimatedPosition = position;
            view.setTranslationY(500);//相对于原始位置下方400
            view.setAlpha(0.f);//完全透明
            //每个item项两个动画，从透明到不透明，从下方移动到原来的位置
            //并且根据item的位置设置延迟的时间，达到一个接着一个的效果
            view.animate()
                    .translationY(0).alpha(1.f)
                    .setStartDelay(delayEnterAnimation ? 20 * (position) : 0)//根据item的位置设置延迟时间，达到依次动画一个接一个进行的效果
                    .setInterpolator(new DecelerateInterpolator(0.5f))//设置动画效果为在动画开始的地方快然后慢
                    .setDuration(700)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            animationsLocked = true;//确保仅屏幕一开始能够显示的item项才开启动画，也就是说屏幕下方还没有显示的item项滑动时是没有动画效果
                        }
                    })
                    .start();
        }
    }*/

}
