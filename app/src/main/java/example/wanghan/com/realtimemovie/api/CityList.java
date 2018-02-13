package example.wanghan.com.realtimemovie.api;

import example.wanghan.com.realtimemovie.Utils.Urls;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by hs-acer on 2017/12/1.
 */

public interface CityList  {
   @GET(Urls.CITYLISTURL)
   Observable<example.wanghan.com.realtimemovie.bean.CityList> getCityList();
}
