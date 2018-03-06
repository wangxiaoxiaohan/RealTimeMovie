package example.wanghan.com.realtimemovie.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import example.wanghan.com.realtimemovie.Adapter.MovieLocatedAdapter;
import example.wanghan.com.realtimemovie.MyApplication;
import example.wanghan.com.realtimemovie.R;
import example.wanghan.com.realtimemovie.Utils.sharePreferenceUtils;
import example.wanghan.com.realtimemovie.bean.TodayMovie.TodayMovieList;
import example.wanghan.com.realtimemovie.impl.MovieOnShowFragmentImpl;

/**
 * Created by hs-acer on 2017/11/30.
 */

public class MovieOnShowingFragment extends Fragment {
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private MovieOnShowFragmentImpl movieOnShowFragmentImpl;
     private ProgressBar progressBar;
    private MovieLocatedAdapter movieLocatedAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.movie_onshowing_fragment,container,false);
        return  view;
        //RecyclerView 设置
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar= (ProgressBar) view.findViewById(R.id.prograss);
        initData();
        recyclerView= (RecyclerView) view.findViewById(R.id.moview_onshowing_recyclerview);
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.onShowRefresh);

        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setFocusable(false);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        movieLocatedAdapter=new MovieLocatedAdapter(getContext());
        recyclerView.setAdapter(movieLocatedAdapter);



        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getServiceData(785);
                movieLocatedAdapter.notifyDataSetChanged();
                hideRefresh();
            }
        });


    }

    private void  initData(){
        movieOnShowFragmentImpl=new MovieOnShowFragmentImpl(this);

        //暂时默认请求成都市的数据，并将当前城市Id设置为成都市的Id.
        getServiceData(880);
        sharePreferenceUtils.setInt(MyApplication.getContext(),"yourCityId",880);

/**

        dbHelper=new MyDatabaseHelper(MyApplication.getContext(),"BookStore8.db",null,1);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        Cursor cursor=db.query("Book",null,null,null,null,null,null);//从数据库中查询城市对应的Id.
        if (cursor.moveToFirst()){
            do {
                String myCityName=cursor.getString(cursor.getColumnIndex("name"));
                int myCityId=  cursor.getInt(cursor.getColumnIndex("cityId"));
                // 获取sharePreference存储的城市名字。 并请求数据。
                if (myCityName.equals(sharePreferenceUtils.getString(MyApplication.getContext(),"yourCityKey",null).substring(0,2)))
                {
                    movieOnShowFragmentImpl.getMovieOnShowData(myCityId);  //请求正在上映的电影数据。
                    sharePreferenceUtils.setInt(MyApplication.getContext(),"yourCityId",myCityId);//将我的城市Id 存储起来，方便后面的使用。
                }
            }while (cursor.moveToNext());
        }
*/
    }
    public  void UpListItem(TodayMovieList todayMovieList){

      movieLocatedAdapter.addItem(todayMovieList.getMs());
    }

    public  void  hideProgress(){
       progressBar.setVisibility(View.INVISIBLE);
   }

    private void getServiceData( int CityId){
       movieOnShowFragmentImpl.getMovieOnShowData(CityId);

   }
    public  void hideRefresh(){
       swipeRefreshLayout.setRefreshing(false);
   }
}
