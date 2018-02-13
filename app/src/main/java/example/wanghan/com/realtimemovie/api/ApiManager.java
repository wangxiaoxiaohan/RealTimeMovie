package example.wanghan.com.realtimemovie.api;

import java.io.File;
import java.io.IOException;

import example.wanghan.com.realtimemovie.MyApplication;
import example.wanghan.com.realtimemovie.Utils.NetWorkUtils;
import example.wanghan.com.realtimemovie.Utils.Urls;
import example.wanghan.com.realtimemovie.bean.ComingMovies.ComingMovie;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hs-acer on 2017/11/28.
 */

public class ApiManager  {
    public   static  ApiManager apiManager;
    private CityList cityList;
    private  MovieOnShow movieOnShow;
    private MovieComing movieComing;
    private  MovieDetail movieDetail;
    private  MoviePerformances moviePerformances;
    private  MovieLdqu movieLdqu;
    private  MovieCommit movieCommit;
    private  Object sync=new Object();


    private   static  final  Interceptor RE_WRITE_CACHE_CONTROL_INTERCEPTOR=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse=chain.proceed(chain.request());
            if (NetWorkUtils.IsNetWorkAvailable(MyApplication.getContext())){
                int maxAge=120;
                return  originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control","public, max-age="+maxAge)
                        .build();
            } else{
                int maxStale=60 * 60 *24 * 28;
                return  originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control","public, only-if-cached, max-age="+maxStale)
                        .build();
            }
        }
    };
    private  static int CacheSize=1024*1024*50;
    private  static   File httpCacheDirectory=new File(MyApplication.getContext().getCacheDir(),"CacheName");
    private  static Cache cache=new Cache(httpCacheDirectory,CacheSize);
    private static    OkHttpClient client=new OkHttpClient.Builder()
            .addNetworkInterceptor(RE_WRITE_CACHE_CONTROL_INTERCEPTOR)
            .addInterceptor(RE_WRITE_CACHE_CONTROL_INTERCEPTOR)
            .cache(cache)
            .build();


    public  static ApiManager getApiManager(){//双重判断，懒汉单例模式，加入同步，实现线程安全。
        if (apiManager==null){
            synchronized (ApiManager.class){
                if (apiManager==null)
                apiManager=new ApiManager();
            }
        }
        return apiManager;
    }
    public CityList getCityListService(){
        if(cityList==null){
            synchronized (sync){
                if(cityList==null){
                    cityList= new Retrofit.Builder()
                            .baseUrl(Urls.BASEURL)
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(CityList.class);

                }
            }
        }
        return  cityList;
    }
    public MovieOnShow getMovieOnShowService(){
        if(movieOnShow==null){
            synchronized (sync){
                if(movieOnShow==null){
                    movieOnShow= new Retrofit.Builder()
                            .baseUrl(Urls.BASEURL)
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(MovieOnShow.class);

                }
            }
        }
        return  movieOnShow;
    }
    public MovieComing getMovieComingService(){
        if (movieComing==null){
            synchronized (sync){
                if (movieComing==null){
                    movieComing=new Retrofit.Builder()
                            .baseUrl(Urls.BASEURL)
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(MovieComing.class);
                }
            }
        }
        return  movieComing;
    }
    public MovieDetail getMovieDetailService(){
        if (movieDetail==null){
            synchronized (sync){
                if (movieDetail==null){
                    movieDetail=new Retrofit.Builder()
                            .baseUrl(Urls.BASEURL)
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(MovieDetail.class);
                }
            }
        }
        return movieDetail;
    }
    public MoviePerformances getMoviePerformerService(){
        if (moviePerformances==null){
            synchronized (sync){
                if (moviePerformances==null){
                    moviePerformances=new Retrofit.Builder()
                            .baseUrl(Urls.BASEURL)
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(MoviePerformances.class);
                }
            }
        }
        return moviePerformances;
    }
    public MovieLdqu getMovieLdquService(){
        if (movieLdqu==null){
            synchronized (sync){
                if (movieLdqu==null){
                    movieLdqu=new Retrofit.Builder()
                            .baseUrl(Urls.BASEURL)
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(MovieLdqu.class);
                }
            }
        }
        return movieLdqu;
    }
    public MovieCommit getMovieCommitService(){
        if (movieCommit==null){
            synchronized (sync){
                if (movieCommit==null){
                    movieCommit=new Retrofit.Builder()
                            .baseUrl(Urls.BASEURL)
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build().create(MovieCommit.class);
                }
            }
        }
        return movieCommit;
    }
}
