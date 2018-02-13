package example.wanghan.com.realtimemovie.bean.movieDetail;

import java.util.List;

/**
 * Created by hs-acer on 2017/12/7.
 */

public class MovieDetail {


    /**
     * image : http://img5.mtime.cn/mt/2017/12/02/172158.15874011_1280X720X2.jpg
     * titleCn : 寻梦环游记
     * titleEn : Coco
     * rating : 9.0
     * scoreCount : 3783
     * year : 2017
     * content : 故事讲述小男孩米格(安东尼·冈萨雷斯 配音)一心梦想成为音乐家，更希望自己能和偶像歌神德拉库斯(本杰明·布拉特 配音)一样，创造出打动人心的音乐，但他的家族却世代禁止族人接触音乐。米格痴迷音乐，无比渴望证明自己的音乐才能，却因为一系列怪事，来到了五彩斑斓又光怪陆离的神秘世界。在那里，米格遇见了魅力十足的落魄乐手埃克托(盖尔·加西亚·贝纳尔 配音)，他们一起踏上了探寻米格家族不为人知往事的奇妙之旅，并开启了一段震撼心灵、感动非凡、永生难忘的旅程。
     * type : ["动画","冒险","喜剧","家庭","奇幻","歌舞","悬疑"]
     * runTime : 109分钟
     * url : http://movie.mtime.com/227434/
     * wapUrl : http://movie.wap.mtime.com/227434/
     * isEggHunt : false
     * commonSpecial : 墨西哥男孩亡灵世界寻父记
     * hotRanking : 14
     * weekBoxOffice :
     * totalBoxOffice :
     * weekBoxOfficeUnit :
     * totalBoxOfficeUnit :
     * director : {"directorId":902534,"directorName":"李·昂克里奇","directorNameEn":"Lee Unkrich","directorImg":"http://img31.mtime.cn/ph/2016/08/08/111121.21158207_1280X720X2.jpg"}
     * actorList : [{"actorId":2246761,"actor":"安东尼·冈萨雷兹","actorEn":"Anthony Gonzalez","actorImg":"http://img5.mtime.cn/ph/2017/03/16/095600.57943994_1280X720X2.jpg","roleName":"米格尔","roleImg":"http://img5.mtime.cn/mg/2017/12/03/175043.19765587_80X80X4.jpg"},{"actorId":927572,"actor":"盖尔·加西亚·贝纳尔","actorEn":"Gael García Bernal","actorImg":"http://img31.mtime.cn/ph/2016/07/05/174713.40385711_1280X720X2.jpg","roleName":"埃克托","roleImg":"http://img5.mtime.cn/mg/2017/12/03/175049.28126148_80X80X4.jpg"}]
     * isTicket : true
     * showCinemaCount : 144
     * showtimeCount : 2125
     * showDay : 1512633600
     * style : {"ifLeadPage":0,"leadUrl":"","leadImag":"http://img2.mtime.cn/mg/.jpg"}
     * is3D : true
     * isIMAX : false
     * isIMAX3D : false
     * isDMAX : true
     * festivals : []
     * awards : []
     * totalWinAward : 0
     * totalNominateAward : 0
     * directors : ["李·昂克里奇"]
     * actors : ["安东尼·冈萨雷兹","盖尔·加西亚·贝纳尔"]
     * release : {"location":"中国","date":"2017-11-24"}
     * imageCount : 55
     * images : ["http://img5.mtime.cn/pi/2017/03/16/105138.36600882_1280X720X2.jpg","http://img5.mtime.cn/pi/2017/09/22/080017.10923319_1280X720X2.jpg","http://img5.mtime.cn/pi/2017/09/22/080019.38171745_1280X720X2.jpg","http://img5.mtime.cn/pi/2017/09/22/080025.84015543_1280X720X2.jpg"]
     * video : http://vfx.mtime.cn/Video/2017/10/23/mp4/171023112305540653.mp4
     * videoId : 68097
     * videoCount : 3
     * videos : [{"url":"http://vfx.mtime.cn/Video/2017/10/23/mp4/171023112305540653.mp4","image":"http://img5.mtime.cn/mg/2017/10/23/112247.65782095.jpg","length":60,"title":"寻梦环游记 定档预告","videoId":68097},{"url":"http://vfx.mtime.cn/Video/2017/11/09/mp4/171109111619156625.mp4","image":"http://img5.mtime.cn/mg/2017/11/09/111546.22368567.jpg","length":93,"title":"寻梦环游记 中国正式预告片（含毛不易推荐视频）","videoId":68337},{"url":"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113170813898424.mp4","image":"http://img5.mtime.cn/mg/2017/11/13/170525.48251103.jpg","length":30,"title":"寻梦环游记 30秒预告片","videoId":68385}]
     * personCount : 85
     */

    private String image;
    private String titleCn;
    private String titleEn;
    private String rating;
    private String scoreCount;
    private String year;
    private String content;
    private String runTime;
    private String url;
    private String wapUrl;
    private boolean isEggHunt;
    private String commonSpecial;
    private int hotRanking;
    private String weekBoxOffice;
    private String totalBoxOffice;
    private String weekBoxOfficeUnit;
    private String totalBoxOfficeUnit;
    private DirectorBean director;
    private boolean isTicket;
    private int showCinemaCount;
    private int showtimeCount;
    private int showDay;
    private StyleBean style;
    private boolean is3D;
    private boolean isIMAX;
    private boolean isIMAX3D;
    private boolean isDMAX;
    private int totalWinAward;
    private int totalNominateAward;
    private ReleaseBean release;
    private int imageCount;
    private String video;
    private int videoId;
    private int videoCount;
    private int personCount;
    private List<String> type;
    private List<ActorListBean> actorList;
    private List<?> festivals;
    private List<?> awards;
    private List<String> directors;
    private List<String> actors;
    private List<String> images;
    private List<VideosBean> videos;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitleCn() {
        return titleCn;
    }

    public void setTitleCn(String titleCn) {
        this.titleCn = titleCn;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getScoreCount() {
        return scoreCount;
    }

    public void setScoreCount(String scoreCount) {
        this.scoreCount = scoreCount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWapUrl() {
        return wapUrl;
    }

    public void setWapUrl(String wapUrl) {
        this.wapUrl = wapUrl;
    }

    public boolean isIsEggHunt() {
        return isEggHunt;
    }

    public void setIsEggHunt(boolean isEggHunt) {
        this.isEggHunt = isEggHunt;
    }

    public String getCommonSpecial() {
        return commonSpecial;
    }

    public void setCommonSpecial(String commonSpecial) {
        this.commonSpecial = commonSpecial;
    }

    public int getHotRanking() {
        return hotRanking;
    }

    public void setHotRanking(int hotRanking) {
        this.hotRanking = hotRanking;
    }

    public String getWeekBoxOffice() {
        return weekBoxOffice;
    }

    public void setWeekBoxOffice(String weekBoxOffice) {
        this.weekBoxOffice = weekBoxOffice;
    }

    public String getTotalBoxOffice() {
        return totalBoxOffice;
    }

    public void setTotalBoxOffice(String totalBoxOffice) {
        this.totalBoxOffice = totalBoxOffice;
    }

    public String getWeekBoxOfficeUnit() {
        return weekBoxOfficeUnit;
    }

    public void setWeekBoxOfficeUnit(String weekBoxOfficeUnit) {
        this.weekBoxOfficeUnit = weekBoxOfficeUnit;
    }

    public String getTotalBoxOfficeUnit() {
        return totalBoxOfficeUnit;
    }

    public void setTotalBoxOfficeUnit(String totalBoxOfficeUnit) {
        this.totalBoxOfficeUnit = totalBoxOfficeUnit;
    }

    public DirectorBean getDirector() {
        return director;
    }

    public void setDirector(DirectorBean director) {
        this.director = director;
    }

    public boolean isIsTicket() {
        return isTicket;
    }

    public void setIsTicket(boolean isTicket) {
        this.isTicket = isTicket;
    }

    public int getShowCinemaCount() {
        return showCinemaCount;
    }

    public void setShowCinemaCount(int showCinemaCount) {
        this.showCinemaCount = showCinemaCount;
    }

    public int getShowtimeCount() {
        return showtimeCount;
    }

    public void setShowtimeCount(int showtimeCount) {
        this.showtimeCount = showtimeCount;
    }

    public int getShowDay() {
        return showDay;
    }

    public void setShowDay(int showDay) {
        this.showDay = showDay;
    }

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public boolean isIsIMAX() {
        return isIMAX;
    }

    public void setIsIMAX(boolean isIMAX) {
        this.isIMAX = isIMAX;
    }

    public boolean isIsIMAX3D() {
        return isIMAX3D;
    }

    public void setIsIMAX3D(boolean isIMAX3D) {
        this.isIMAX3D = isIMAX3D;
    }

    public boolean isIsDMAX() {
        return isDMAX;
    }

    public void setIsDMAX(boolean isDMAX) {
        this.isDMAX = isDMAX;
    }

    public int getTotalWinAward() {
        return totalWinAward;
    }

    public void setTotalWinAward(int totalWinAward) {
        this.totalWinAward = totalWinAward;
    }

    public int getTotalNominateAward() {
        return totalNominateAward;
    }

    public void setTotalNominateAward(int totalNominateAward) {
        this.totalNominateAward = totalNominateAward;
    }

    public ReleaseBean getRelease() {
        return release;
    }

    public void setRelease(ReleaseBean release) {
        this.release = release;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<ActorListBean> getActorList() {
        return actorList;
    }

    public void setActorList(List<ActorListBean> actorList) {
        this.actorList = actorList;
    }

    public List<?> getFestivals() {
        return festivals;
    }

    public void setFestivals(List<?> festivals) {
        this.festivals = festivals;
    }

    public List<?> getAwards() {
        return awards;
    }

    public void setAwards(List<?> awards) {
        this.awards = awards;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<VideosBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideosBean> videos) {
        this.videos = videos;
    }

    public static class DirectorBean {
        /**
         * directorId : 902534
         * directorName : 李·昂克里奇
         * directorNameEn : Lee Unkrich
         * directorImg : http://img31.mtime.cn/ph/2016/08/08/111121.21158207_1280X720X2.jpg
         */

        private int directorId;
        private String directorName;
        private String directorNameEn;
        private String directorImg;

        public int getDirectorId() {
            return directorId;
        }

        public void setDirectorId(int directorId) {
            this.directorId = directorId;
        }

        public String getDirectorName() {
            return directorName;
        }

        public void setDirectorName(String directorName) {
            this.directorName = directorName;
        }

        public String getDirectorNameEn() {
            return directorNameEn;
        }

        public void setDirectorNameEn(String directorNameEn) {
            this.directorNameEn = directorNameEn;
        }

        public String getDirectorImg() {
            return directorImg;
        }

        public void setDirectorImg(String directorImg) {
            this.directorImg = directorImg;
        }
    }

    public static class StyleBean {
        /**
         * ifLeadPage : 0
         * leadUrl :
         * leadImag : http://img2.mtime.cn/mg/.jpg
         */

        private int ifLeadPage;
        private String leadUrl;
        private String leadImag;

        public int getIfLeadPage() {
            return ifLeadPage;
        }

        public void setIfLeadPage(int ifLeadPage) {
            this.ifLeadPage = ifLeadPage;
        }

        public String getLeadUrl() {
            return leadUrl;
        }

        public void setLeadUrl(String leadUrl) {
            this.leadUrl = leadUrl;
        }

        public String getLeadImag() {
            return leadImag;
        }

        public void setLeadImag(String leadImag) {
            this.leadImag = leadImag;
        }
    }

    public static class ReleaseBean {
        /**
         * location : 中国
         * date : 2017-11-24
         */

        private String location;
        private String date;

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public static class ActorListBean {
        /**
         * actorId : 2246761
         * actor : 安东尼·冈萨雷兹
         * actorEn : Anthony Gonzalez
         * actorImg : http://img5.mtime.cn/ph/2017/03/16/095600.57943994_1280X720X2.jpg
         * roleName : 米格尔
         * roleImg : http://img5.mtime.cn/mg/2017/12/03/175043.19765587_80X80X4.jpg
         */

        private int actorId;
        private String actor;
        private String actorEn;
        private String actorImg;
        private String roleName;
        private String roleImg;

        public int getActorId() {
            return actorId;
        }

        public void setActorId(int actorId) {
            this.actorId = actorId;
        }

        public String getActor() {
            return actor;
        }

        public void setActor(String actor) {
            this.actor = actor;
        }

        public String getActorEn() {
            return actorEn;
        }

        public void setActorEn(String actorEn) {
            this.actorEn = actorEn;
        }

        public String getActorImg() {
            return actorImg;
        }

        public void setActorImg(String actorImg) {
            this.actorImg = actorImg;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleImg() {
            return roleImg;
        }

        public void setRoleImg(String roleImg) {
            this.roleImg = roleImg;
        }
    }

    public static class VideosBean {
        /**
         * url : http://vfx.mtime.cn/Video/2017/10/23/mp4/171023112305540653.mp4
         * image : http://img5.mtime.cn/mg/2017/10/23/112247.65782095.jpg
         * length : 60
         * title : 寻梦环游记 定档预告
         * videoId : 68097
         */

        private String url;
        private String image;
        private int length;
        private String title;
        private int videoId;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }
    }
}
