package example.wanghan.com.realtimemovie.bean.ComingMovies;

import java.util.ArrayList;

/**
 * Created by hs-acer on 2017/12/5.
 */

public class ComingMovieList {
    private ArrayList<ComingMovie> attention;
    private ArrayList<ComingMovie> moviecomings;


    public void setAttentions(ArrayList<ComingMovie> attention){
        this.attention=attention;
    }

    public ArrayList<ComingMovie>  getAttentions(){
        return attention;
    }

    public  void setmoviecomings(ArrayList<ComingMovie> moviecomings){
        this.moviecomings=moviecomings;
    }
    public ArrayList<ComingMovie> getmoviecomings(){
        return  moviecomings;
    }



}
