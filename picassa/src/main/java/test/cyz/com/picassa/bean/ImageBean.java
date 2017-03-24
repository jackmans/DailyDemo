package test.cyz.com.picassa.bean;

/**
 * Created by M on 2017/3/21.
 */
public class ImageBean {

    public ImageBean(String path){
        this.imagePath = path;
    }


    /**
         * 文件夹的第一张图片路径
         */
        private String imagePath;
        /**
         * 文件夹名
         */
        private String folderName;
        /**
         * 文件夹中的图片数
         */
        private int imageCounts;

        public String getImagePath() {
            return imagePath;
        }
        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }
        public String getFolderName() {
            return folderName;
        }
        public void setFolderName(String folderName) {
            this.folderName = folderName;
        }
        public int getImageCounts() {
            return imageCounts;
        }
        public void setImageCounts(int imageCounts) {
            this.imageCounts = imageCounts;
        }


    }
