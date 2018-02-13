package example.wanghan.com.realtimemovie.api;

import example.wanghan.com.realtimemovie.bean.ComingMovies.ComingMovie;
import example.wanghan.com.realtimemovie.bean.ComingMovies.ComingMovieList;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hs-acer on 2017/12/5.
 */

public interface MovieComing {
    @GET("Movie/MovieComingNew.api")
    Observable<ComingMovieList>  getMovieComingList(@Query("locationId") int CityId);
}
