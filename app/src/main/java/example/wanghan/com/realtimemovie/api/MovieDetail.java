package example.wanghan.com.realtimemovie.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hs-acer on 2017/12/7.
 */

public interface MovieDetail {
    @GET("movie/detail.api")
    Observable<example.wanghan.com.realtimemovie.bean.movieDetail.MovieDetail> getMovieDetail(
            @Query("locationId") int cityId , @Query("movieId") int movieId);

}
