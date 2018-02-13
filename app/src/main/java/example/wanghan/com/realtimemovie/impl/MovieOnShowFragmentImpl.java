package example.wanghan.com.realtimemovie.impl;

import example.wanghan.com.realtimemovie.Fragment.MovieOnShowingFragment;

import example.wanghan.com.realtimemovie.api.ApiManager;


import example.wanghan.com.realtimemovie.bean.TodayMovie.TodayMovieList;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by hs-acer on 2017/12/1.
 */

public class MovieOnShowFragmentImpl {
   private MovieOnShowingFragment movieOnShowingFragment;
    public MovieOnShowFragmentImpl(MovieOnShowingFragment movieOnShowingFragment) {
       this.movieOnShowingFragment=movieOnShowingFragment;
    }
    public  void  getMovieOnShowData(int CityId){
         ApiManager.getApiManager().getMovieOnShowService().getMovieOnShow(CityId)
               .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TodayMovieList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TodayMovieList todayMovieList) {

                        movieOnShowingFragment.hideProgress();
                        movieOnShowingFragment.UpListItem(todayMovieList);
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
