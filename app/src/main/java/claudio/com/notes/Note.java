package claudio.com.notes;

import java.io.Serializable;

/**
 * Created by IFSP- on 08/11/2017.
 */

public class Note implements Serializable{
    private String title;
    private String description;
    private int color;


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
