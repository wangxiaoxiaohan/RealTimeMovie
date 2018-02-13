package example.wanghan.com.realtimemovie.impl;

import android.util.Log;

import example.wanghan.com.realtimemovie.Fragment.MovieComingFragment;
import example.wanghan.com.realtimemovie.api.ApiManager;
import example.wanghan.com.realtimemovie.bean.ComingMovies.ComingMovieList;
import io.reactivex.Observer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hs-acer on 2017/12/5.
 */

public class MovieComingFragmentImpl {
    private MovieComingFragment movieComingFragment;
    public MovieComingFragmentImpl(MovieComingFragment movieComingFragment) {
        this.movieComingFragment=movieComingFragment;
    }
    public   void getMovieComingData(int CityId){
        ApiManager.getApiManager().getMovieComingService().getMovieComingList(CityId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComingMovieList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ComingMovieList comingMovieList) {

                        movieComingFragment.upListItem(comingMovieList);
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
