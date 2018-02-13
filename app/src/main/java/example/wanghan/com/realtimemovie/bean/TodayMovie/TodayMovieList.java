package example.wanghan.com.realtimemovie.bean.TodayMovie;

import java.util.ArrayList;


/**
 * Created by hs-acer on 2017/11/28.
 */

public class TodayMovieList {

    /**
     * bImg : http://img5.mtime.cn/mg/2017/01/25/172446.45527982.jpg
     * date : 2017-02-02
     * lid : 20
     * ms : [{"NearestCinemaCount":152,"NearestDay":1486022400,"NearestShowtimeCount":1767,"aN1":"成龙","aN2":"李治廷","cC":152,"commonSpecial":"大哥携\u201c小鲜肉\u201d全球寻宝石","d":"108","dN":"唐季礼","def":0,"id":217896,"img":"http://img5.mtime.cn/mt/2017/01/13/191421.14582165_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":true,"isIMAX":false,"isIMAX3D":false,"isNew":false,"isTicket":true,"m":"","movieType":"动作 / 冒险 / 喜剧","p":["动作冒险喜剧"],"r":6.2,"rc":0,"rd":"20170128","rsC":0,"sC":3003,"t":"功夫瑜伽","tCn":"功夫瑜伽","tEn":"Kung-Fu Yoga","ua":-1,"versions":[],"wantedCount":1132},{"NearestCinemaCount":151,"NearestDay":1486022400,"NearestShowtimeCount":1112,"aN1":"邓超","aN2":"彭于晏","cC":151,"commonSpecial":"邓超彭于晏一起街头热血","d":"102","dN":"韩寒","def":0,"id":237054,"img":"http://img5.mtime.cn/mt/2017/01/12/181512.62044353_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":true,"isIMAX":false,"isIMAX3D":false,"isNew":false,"isTicket":true,"m":"","movieType":"喜剧","p":["喜剧"],"r":6.5,"rc":0,"rd":"20170128","rsC":0,"sC":1928,"t":"乘风破浪","tCn":"乘风破浪","tEn":"Duckweed","ua":-1,"versions":[{"enum":1,"version":"2D"}],"wantedCount":2802}]
     * newActivitiesTime : 0
     * totalComingMovie : 39
     * voucherMsg :
     */

    private String bImg;
    private String date;
    private int lid;
    private int newActivitiesTime;
    private int totalComingMovie;
    private String voucherMsg;
    private ArrayList<TodayMovie> ms;

    public String getBImg() {
        return bImg;
    }

    public void setBImg(String bImg) {
        this.bImg = bImg;
    }

    public String getDate() {
        return date;
    }





    public void setDate(String date) {
        this.date = date;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getNewActivitiesTime() {
        return newActivitiesTime;
    }

    public void setNewActivitiesTime(int newActivitiesTime) {
        this.newActivitiesTime = newActivitiesTime;
    }

    public int getTotalComingMovie() {
        return totalComingMovie;
    }

    public void setTotalComingMovie(int totalComingMovie) {
        this.totalComingMovie = totalComingMovie;
    }

    public String getVoucherMsg() {
        return voucherMsg;
    }

    public void setVoucherMsg(String voucherMsg) {
        this.voucherMsg = voucherMsg;
    }

    public ArrayList<TodayMovie> getMs() {
        return ms;
    }

    public void setMs(ArrayList<TodayMovie> ms) {
        this.ms = ms;
    }

}
