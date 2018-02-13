package example.wanghan.com.realtimemovie.Fragment;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Date;

import example.wanghan.com.realtimemovie.Adapter.MovieComingRecyclerViewAdapter;
import example.wanghan.com.realtimemovie.MyApplication;
import example.wanghan.com.realtimemovie.R;
import example.wanghan.com.realtimemovie.Utils.sharePreferenceUtils;
import example.wanghan.com.realtimemovie.bean.ComingMovies.ComingMovieList;
import example.wanghan.com.realtimemovie.impl.MovieComingFragmentImpl;

/**
 * Created by hs-acer on 2017/11/30.
 */

public class MovieComingFragment extends Fragment{
    private RadioButton radioButtonThisMonth;
    private RadioButton radioButtonNextMonth;
    private RadioButton radioButtonSecondNextMonth;
    private RecyclerView recyclerView;
    private MovieComingFragmentImpl movieComingFragment;
    private MovieComingRecyclerViewAdapter movieComingRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.moview_coming_fragment,container,false);
        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData(view);
        initView();
    }


    private void initData(View view) {
         movieComingFragment=new MovieComingFragmentImpl(this);
         movieComingFragment.getMovieComingData(sharePreferenceUtils.getInt(MyApplication.getContext(),"yourCityId",0));
        radioButtonThisMonth= (RadioButton) view.findViewById(R.id.comingThisMonthRadiobutton);
        radioButtonNextMonth= (RadioButton) view.findViewById(R.id.comingNextMonthRadiobutton);
        radioButtonSecondNextMonth= (RadioButton) view.findViewById(R.id.comingSecondFolingRadiobutton);
        recyclerView= (RecyclerView) view.findViewById(R.id.movie_coming_recyclerView);

        movieComingRecyclerViewAdapter=new MovieComingRecyclerViewAdapter(getContext());
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(movieComingRecyclerViewAdapter);

     }

    private void initView() {
        setRadioButtonDate();
    }
    private  void setRadioButtonDate(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM");
        String currentDate=simpleDateFormat.format(new Date());
        String currentMonth;

        if (currentDate.substring(0,0).equals("0")){
            currentMonth=currentDate.substring(1);
        }else {
            currentMonth=currentDate;
        }
        radioButtonThisMonth.setText(currentMonth+"月");
        int month=Integer.parseInt(currentMonth);
        if (month+1 > 12){
            radioButtonNextMonth.setText((month+1)%12+"月");
        }else {
            radioButtonNextMonth.setText(month+1 + "月");
        }
        if (month+2>12){
            radioButtonSecondNextMonth.setText((month+2)%12 +"月");
        }else {
            radioButtonSecondNextMonth.setText(month+2+ "月" );
        }

    }
    public  void  upListItem(ComingMovieList ComingMovieList){

        movieComingRecyclerViewAdapter.addItem(ComingMovieList.getmoviecomings());
    }

}
