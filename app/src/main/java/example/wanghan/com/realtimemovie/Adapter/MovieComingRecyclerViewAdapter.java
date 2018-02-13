package example.wanghan.com.realtimemovie.Adapter;

import  android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.ArrayList;
import example.wanghan.com.realtimemovie.Activity.MovieDetailActivity;
import example.wanghan.com.realtimemovie.R;
import example.wanghan.com.realtimemovie.bean.ComingMovies.ComingMovie;

/**
 * Created by hs-acer on 2017/12/5.
 */

public class MovieComingRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<ComingMovie> comingMovies=new ArrayList<>();
    class  MovieComingViewHolder extends  RecyclerView.ViewHolder{
        TextView directorText;
        TextView actorText;
        TextView movieName;
        ImageView posterImage;
        RelativeLayout relativeLayout;
        Button moreButton;


        public MovieComingViewHolder(View itemView) {
            super(itemView);
            directorText= (TextView) itemView.findViewById(R.id.director_coming__text);
            actorText= (TextView) itemView.findViewById(R.id.actor_coming_text);
            movieName= (TextView) itemView.findViewById(R.id.text_coming_MovieName);
            posterImage= (ImageView) itemView.findViewById(R.id.item_coming_poster);
            moreButton= (Button) itemView.findViewById(R.id.item_more_coming_button);
           relativeLayout= (RelativeLayout) itemView.findViewById(R.id.item_coming_movie);


        }
    }



    public MovieComingRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.recycler_item_coming,parent,false);
        RecyclerView.ViewHolder holder=new MovieComingViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
           mbindViewHolder((MovieComingViewHolder)holder,position);
    }

    private void  mbindViewHolder(MovieComingViewHolder movieComingViewHolder,int position){
          final ComingMovie comingMovie=comingMovies.get(position);
           movieComingViewHolder.movieName.setText(comingMovie.getTitle());
           movieComingViewHolder.directorText.setText("导演:"+comingMovie.getDirector());
           movieComingViewHolder.actorText.setText("主演:"+comingMovie.getActor1() +"/"+ comingMovie.getActor2());
        Glide.with(mContext)
                .load(comingMovie.getImage())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(movieComingViewHolder.posterImage);
          movieComingViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  goDetailActivity(comingMovie);
              }
          });

    }
    @Override
    public int getItemCount() {
        return comingMovies.size();
    }
    public  void  addItem(ArrayList<ComingMovie> list){
        comingMovies.addAll(list);
        notifyDataSetChanged();

    }
    private  void  goDetailActivity(ComingMovie comingMovie){
        Intent intent =new Intent(mContext, MovieDetailActivity.class);
        intent.putExtra("movieId",comingMovie.getId());

        mContext.startActivity(intent);

    }
}
