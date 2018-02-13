package example.wanghan.com.realtimemovie.api;

import example.wanghan.com.realtimemovie.bean.moviePerformers.MoviePerformers;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hs-acer on 2017/12/11.
 */

public interface MoviePerformances {
    @GET("Movie/MovieCreditsWithTypes.api")
    Observable<MoviePerformers> getMoviePerformers(@Query("movieId") int movieId);
}
