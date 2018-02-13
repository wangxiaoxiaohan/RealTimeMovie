package example.wanghan.com.realtimemovie.bean.MovieCommit;

/**
 * Created by hs-acer on 2017/12/28.
 */

public class MovieCommit {

    /**
     * commentCount : 83
     * content : 文 | 衡·Isabella 昨天下午看到的是内地删减版本，看完之后我还觉得删完之后还让播也是难得。结果晚上就看到朋友圈里开始传《芳华》被撤档延期。之后，消息坐实。 在都靠娱乐搞怪没正形扯犊子的大背景里，冯小刚拍了一部严肃的、点到即止的历史、战争题材，影片以文工团为主角出发点，脉络为一段段大时代下不同阶层不同人的命运。片子讲的够客观，不扯淡不编梦不画饼。在很多人选择不说话或是只说你喜欢听的话的时候...
     * headurl : http://img5.mtime.cn/up/2017/02/17/184848.82410809_128X128.jpg
     * id : 8018269
     * isWantSee : false
     * location :
     * modifyTime : 1506232740
     * nickname : 衡·Isabella
     * rating : 7.8
     * title : 《芳华》的可贵之处并不在于某些人眼里的那几个亿
     */

    private int commentCount;
    private String content;
    private String headurl;
    private int id;
    private boolean isWantSee;
    private String location;
    private int modifyTime;
    private String nickname;
    private double rating;
    private String title;

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsWantSee() {
        return isWantSee;
    }

    public void setIsWantSee(boolean isWantSee) {
        this.isWantSee = isWantSee;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(int modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
