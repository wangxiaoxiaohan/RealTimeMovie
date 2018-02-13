package example.wanghan.com.realtimemovie.api;

import example.wanghan.com.realtimemovie.bean.TodayMovie.TodayMovieList;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by hs-acer on 2017/12/1.
 */

public interface MovieOnShow {
    @GET("Showtime/LocationMovies.api")
    Observable<TodayMovieList> getMovieOnShow(@Query("locationId") int CityId);

}
