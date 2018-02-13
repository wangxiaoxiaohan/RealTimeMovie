package example.wanghan.com.realtimemovie.api;

import example.wanghan.com.realtimemovie.bean.MovieCommit.MovieCommitList;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hs-acer on 2017/12/23.
 */

public interface MovieCommit {
    @GET("Movie/HotLongComments.api")
    Observable<MovieCommitList> getMovieCommits(
      @Query("pageIndex") int pageIndex,@Query("movieId") int MovieId);
}
