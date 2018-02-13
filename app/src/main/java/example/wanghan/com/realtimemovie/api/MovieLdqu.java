package example.wanghan.com.realtimemovie.api;

import example.wanghan.com.realtimemovie.bean.Ldqu.Ldqu;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hs-acer on 2017/12/12.
 */

public interface MovieLdqu {
    @GET("Movie/ImageAll.api")
    Observable<Ldqu> getMovieLdqu(@Query("movieId") int movieId);
}
