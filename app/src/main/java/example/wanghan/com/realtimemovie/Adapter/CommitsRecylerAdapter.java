package example.wanghan.com.realtimemovie.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;

import example.wanghan.com.realtimemovie.R;
import example.wanghan.com.realtimemovie.bean.MovieCommit.MovieCommit;
import example.wanghan.com.realtimemovie.widget.CircleImageView;
import example.wanghan.com.realtimemovie.widget.LikeView;
import example.wanghan.com.realtimemovie.widget.RatingBar;

/**
 * Created by hs-acer on 2017/12/28.
 */

public class CommitsRecylerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<MovieCommit> commitses=new ArrayList<>();


    class CommitsViewHolder extends RecyclerView.ViewHolder{
        TextView commitContent;
        TextView dateContent;
        TextView consumerId;
        RatingBar ratingBar;
        LikeView likeView;
        CircleImageView icon;

        public CommitsViewHolder(View itemView) {
            super(itemView);
            commitContent= (TextView) itemView.findViewById(R.id.commit_content);
            dateContent= (TextView) itemView.findViewById(R.id.commit_date);
            consumerId= (TextView) itemView.findViewById(R.id.consumer_id);
            ratingBar= (RatingBar) itemView.findViewById(R.id.consumer_score);
            likeView= (LikeView) itemView.findViewById(R.id.consumer_commit_like_count);
            icon= (CircleImageView) itemView.findViewById(R.id.commit_item_icon);
        }
    }

    public CommitsRecylerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.commit_item,parent,false);
        RecyclerView.ViewHolder holder=new CommitsViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mBindViewHolder((CommitsViewHolder) holder,position);

    }
    private  void  mBindViewHolder(final CommitsViewHolder commitsViewHolder, int position){

        SimpleTarget<GlideDrawable>  target=new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                commitsViewHolder.icon.setmDrawable(resource);
            }
        };

        MovieCommit movieCommit=commitses.get(position);
        commitsViewHolder.likeView.setLikeCount(movieCommit.getCommentCount());
        commitsViewHolder.consumerId.setText(movieCommit.getNickname());
        commitsViewHolder.ratingBar.setStarMark((float) movieCommit.getRating());
        Glide.with(mContext)
                .load(movieCommit.getHeadurl())
                .into(target);
        commitsViewHolder.commitContent.setText(movieCommit.getContent());



    }

    @Override
    public int getItemCount() {

        return  commitses.size();
    }
    public  void addItem(ArrayList<MovieCommit> list){
        commitses.addAll(list);
        notifyDataSetChanged();
    }

}
