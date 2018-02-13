package example.wanghan.com.realtimemovie.bean.Ldqu;

import java.util.List;

/**
 * Created by hs-acer on 2017/12/12.
 */

public class Ldqu {

    private List<ImagesBean> images;
    private List<ImageTypesBean> imageTypes;

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public List<ImageTypesBean> getImageTypes() {
        return imageTypes;
    }

    public void setImageTypes(List<ImageTypesBean> imageTypes) {
        this.imageTypes = imageTypes;
    }

    public static class ImagesBean {
        /**
         * id : 7409371
         * image : http://img5.mtime.cn/pi/2017/10/23/101838.89682719_1000X1000.jpg
         * type : 1
         * approveStatus : 1
         * imageSubtype : 101
         * imageSubtypeDes : 正式海报
         */

        private int id;
        private String image;
        private int type;
        private int approveStatus;
        private int imageSubtype;
        private String imageSubtypeDes;

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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getApproveStatus() {
            return approveStatus;
        }

        public void setApproveStatus(int approveStatus) {
            this.approveStatus = approveStatus;
        }

        public int getImageSubtype() {
            return imageSubtype;
        }

        public void setImageSubtype(int imageSubtype) {
            this.imageSubtype = imageSubtype;
        }

        public String getImageSubtypeDes() {
            return imageSubtypeDes;
        }

        public void setImageSubtypeDes(String imageSubtypeDes) {
            this.imageSubtypeDes = imageSubtypeDes;
        }
    }

    public static class ImageTypesBean {
        /**
         * type : -1
         * typeName : 显示所有
         */

        private int type;
        private String typeName;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
    }
}
