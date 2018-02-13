package example.wanghan.com.realtimemovie.bean.ComingMovies;

import java.util.List;

/**
 * Created by hs-acer on 2017/12/5.
 */

public class ComingMovie  {

    /**
     * actor1 : 陈柏霖
     * actor2 : 林允
     * director : 王郢
     * id : 246582
     * image : http://img5.mtime.cn/mt/2017/11/30/103502.97070831_1280X720X2.jpg
     * isFilter : false
     * isTicket : true
     * isVideo : true
     * locationName : 中国
     * rDay : 8
     * rMonth : 12
     * rYear : 2017
     * releaseDate : 12月8日上映
     * title : 假如王子睡着了
     * type : 爱情 / 喜剧
     * videoCount : 3
     * videos : [{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/12/04/220211.42837657.jpg","length":81,"title":"假如王子睡着了 终极预告片","url":"http://vfx.mtime.cn/Video/2017/12/04/mp4/171204215729351173.mp4","videoId":68698},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/11/21/221313.44360710.jpg","length":62,"title":"假如王子睡着了 都市灰姑娘版预告","url":"http://vfx.mtime.cn/Video/2017/11/21/mp4/171121221613734934.mp4","videoId":68515},{"hightUrl":"","image":"http://img5.mtime.cn/mg/2017/11/14/211825.31468263.jpg","length":30,"title":"假如王子睡着了 先导预告","url":"http://vfx.mtime.cn/Video/2017/11/14/mp4/171114211757334378.mp4","videoId":68409}]
     * wantedCount : 422
     */

    private String actor1;
    private String actor2;
    private String director;
    private int id;
    private String image;
    private boolean isFilter;
    private boolean isTicket;
    private boolean isVideo;
    private String locationName;
    private int rDay;
    private int rMonth;
    private int rYear;
    private String releaseDate;
    private String title;
    private String type;
    private int videoCount;
    private int wantedCount;
    private List<VideosBean> videos;

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIsFilter() {
        return isFilter;
    }

    public void setIsFilter(boolean isFilter) {
        this.isFilter = isFilter;
    }

    public boolean isIsTicket() {
        return isTicket;
    }

    public void setIsTicket(boolean isTicket) {
        this.isTicket = isTicket;
    }

    public boolean isIsVideo() {
        return isVideo;
    }

    public void setIsVideo(boolean isVideo) {
        this.isVideo = isVideo;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getRDay() {
        return rDay;
    }

    public void setRDay(int rDay) {
        this.rDay = rDay;
    }

    public int getRMonth() {
        return rMonth;
    }

    public void setRMonth(int rMonth) {
        this.rMonth = rMonth;
    }

    public int getRYear() {
        return rYear;
    }

    public void setRYear(int rYear) {
        this.rYear = rYear;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getWantedCount() {
        return wantedCount;
    }

    public void setWantedCount(int wantedCount) {
        this.wantedCount = wantedCount;
    }

    public List<VideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosBean> videos) {
        this.videos = videos;
    }

    public static class VideosBean {
        /**
         * hightUrl :
         * image : http://img5.mtime.cn/mg/2017/12/04/220211.42837657.jpg
         * length : 81
         * title : 假如王子睡着了 终极预告片
         * url : http://vfx.mtime.cn/Video/2017/12/04/mp4/171204215729351173.mp4
         * videoId : 68698
         */

        private String hightUrl;
        private String image;
        private int length;
        private String title;
        private String url;
        private int videoId;

        public String getHightUrl() {
            return hightUrl;
        }

        public void setHightUrl(String hightUrl) {
            this.hightUrl = hightUrl;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }
    }
}
