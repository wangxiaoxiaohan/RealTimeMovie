package example.wanghan.com.realtimemovie.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.wanghan.com.realtimemovie.Adapter.CommitsRecylerAdapter;
import example.wanghan.com.realtimemovie.R;
import example.wanghan.com.realtimemovie.bean.MovieCommit.MovieCommitList;

public class MovieCommitFragment extends Fragment {
    private RecyclerView commitsRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private CommitsRecylerAdapter commitsRecylerAdapter;
    public MovieCommitFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.movie_commit_fragment,container,false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        commitsRecyclerView= (RecyclerView) view.findViewById(R.id.movieDetailCommitRecyclerView);

        linearLayoutManager=new LinearLayoutManager(getContext());
        commitsRecyclerView.setLayoutManager(linearLayoutManager);
        commitsRecyclerView.setNestedScrollingEnabled(false);
        commitsRecylerAdapter=new CommitsRecylerAdapter(getContext());
        commitsRecyclerView.setAdapter(commitsRecylerAdapter);
        commitsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }
        });
    }
    public void upCommitsListItem(MovieCommitList movieCommitList){
        commitsRecylerAdapter.addItem(movieCommitList.getMovieCommits());
    }


}
