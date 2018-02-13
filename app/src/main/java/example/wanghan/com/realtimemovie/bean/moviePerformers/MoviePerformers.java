package example.wanghan.com.realtimemovie.bean.moviePerformers;

import java.util.List;

/**
 * Created by hs-acer on 2017/12/11.
 */

public class MoviePerformers {


    private List<TypesBean> types;

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
    }

    public static class TypesBean {
        /**
         * typeName : 导演
         * typeNameEn : Director
         * persons : [{"id":902534,"name":"李·昂克里奇","nameEn":"Lee Unkrich","image":"http://img31.mtime.cn/ph/2016/08/08/111121.21158207_1280X720X2.jpg"},{"id":2246760,"name":"阿德里安·莫里纳","nameEn":"Adrian Molina","image":"http://img5.mtime.cn/ph/2017/09/14/152251.65982838_1280X720X2.jpg"}]
         */

        private String typeName;
        private String typeNameEn;
        private List<PersonsBean> persons;

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeNameEn() {
            return typeNameEn;
        }

        public void setTypeNameEn(String typeNameEn) {
            this.typeNameEn = typeNameEn;
        }

        public List<PersonsBean> getPersons() {
            return persons;
        }

        public void setPersons(List<PersonsBean> persons) {
            this.persons = persons;
        }

        public static class PersonsBean {

            /**
             * id : 1410328
             * name : 韩庚
             * nameEn : Geng Han
             * image : http://img31.mtime.cn/ph/2016/04/14/115937.76192703_1280X720X2.jpg
             * personate : 孟云
             * personateCn : 孟云
             * personateEn :
             */

            private int id;
            private String name;
            private String nameEn;
            private String image;
            private String personate;
            private String personateCn;
            private String personateEn;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNameEn() {
                return nameEn;
            }

            public void setNameEn(String nameEn) {
                this.nameEn = nameEn;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getPersonate() {
                return personate;
            }

            public void setPersonate(String personate) {
                this.personate = personate;
            }

            public String getPersonateCn() {
                return personateCn;
            }

            public void setPersonateCn(String personateCn) {
                this.personateCn = personateCn;
            }

            public String getPersonateEn() {
                return personateEn;
            }

            public void setPersonateEn(String personateEn) {
                this.personateEn = personateEn;
            }
        }
    }
}
