package mvn.tgBot.tgObjects;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 07/03/16
 * Time: 08:37
 */
public class Photo {
    String file_id;
    Long file_size;
    int width;
    int height;

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public Long getFile_size() {
        return file_size;
    }

    public void setFile_size(Long file_size) {
        this.file_size = file_size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
