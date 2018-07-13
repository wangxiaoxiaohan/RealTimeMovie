package example.wanghan.com.realtimemovie.impl;

import android.util.Log;

import example.wanghan.com.realtimemovie.Activity.MovieDetailActivity;
import example.wanghan.com.realtimemovie.Fragment.MovieCommitFragment;
import example.wanghan.com.realtimemovie.api.ApiManager;
import example.wanghan.com.realtimemovie.bean.Ldqu.Ldqu;
import example.wanghan.com.realtimemovie.bean.MovieCommit.MovieCommitList;
import example.wanghan.com.realtimemovie.bean.movieDetail.MovieDetail;
import example.wanghan.com.realtimemovie.bean.moviePerformers.MoviePerformers;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hs-acer on 2017/12/7.
 */

public class MovieDetailImpl {
    private MovieDetailActivity movieDetailActivity;
    private MovieCommitFragment movieCommitFragment;

    public MovieDetailImpl(MovieDetailActivity movieDetailActivity) {
        this.movieDetailActivity=movieDetailActivity;
        movieCommitFragment=new MovieCommitFragment();
    }
    public  void getMovieDetailData(int CityId,int movieId){
        ApiManager.getApiManager().getMovieDetailService().getMovieDetail(CityId,movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieDetail movieDetail) {

                     //   movieDetailActivity.upData(movieDetail);
                        movieDetailActivity.hideProgress();//第一个页面的数据获取完成就可以隐藏进度滚轮。
                        movieDetailActivity.upMovieDetailData(movieDetail);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public  void  getMoviePerformersData(int movieId){
        ApiManager.getApiManager().getMoviePerformerService().getMoviePerformers(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MoviePerformers>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MoviePerformers MoviePerformers) {
                        Log.d("请求演职员数据成功。", "onNext: "+MoviePerformers.getTypes().get(0).getPersons().get(0).getImage());
                      movieDetailActivity.upPerformersData(MoviePerformers);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public  void  getMovieLdquData(int movieId){
          ApiManager.getApiManager().getMovieLdquService().getMovieLdqu(movieId)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Observer<Ldqu>() {
                      @Override
                      public void onSubscribe(Disposable d) {

                      }

                      @Override
                      public void onNext(Ldqu ldqu) {
                          Log.d("请求剧照数据成功", "onNext: ");
                      }

                      @Override
                      public void onError(Throwable e) {

                      }

                      @Override
                      public void onComplete() {


                      }
                  });
    }
    public  void  getMovieCommitData(int pageIndex, int movieId){
        ApiManager.getApiManager().getMovieCommitService().getMovieCommits(pageIndex,movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieCommitList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieCommitList movieCommits) {
                        Log.d("请求评论数据成功了！！！！！！！！！！！", "onNext: ");
                      movieCommitFragment.upCommitsListItem(movieCommits);

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
