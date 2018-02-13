package example.wanghan.com.realtimemovie.Utils;

import retrofit2.http.PUT;

/**
 * Created by hs-acer on 2017/12/1.
 */

public class Urls {
    public  final  static  String BASEURL="https://api-m.mtime.cn/";
    public  final  static  String CITYLISTURL="Showtime/HotCitiesByCinema.api";
    public   final  static  String MOVIEONSHOW="Showtime/LocationMovies.api?locationId=";
    public  final static  String MOVIECOMING="Movie/MovieComingNew.api?locationId=";
    public  final  static  String MOVIEWDETAIL="movie/detail.api?";
    public  final  static  String MOVIECREDITS="Movie/MovieCreditsWithTypes.api?movieId=";
    public final  static  String HOTCOMMENT= "movie/hotComment.api?movieId=";

}
