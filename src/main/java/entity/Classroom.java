package entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Calendar;
import java.util.HashMap;

@Entity
public class Classroom {

    @Id
    private long id;
    private String name;
    private String imageUrl;
    private String description;
    private long createdAt;
    private long updatedAt;
    @Index
    private int status;

    public Classroom() {
        initComponent();
    }

    public Classroom(String name, String description) {
        initComponent();
        this.name = name;
        this.description = description;
    }

    private void initComponent(){
        this.id = Calendar.getInstance().getTimeInMillis();
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();
        this.status = Status.ACTIVE.getValue();
        this.name = "";
        this.description = "";
    }

    public HashMap<String, String> validate() {
        HashMap<String, String> errors = new HashMap<>();
        if (name == null || name.isEmpty()) {
            errors.put("name", "Name is required!");
        }
        if (description == null || description.isEmpty()) {
            errors.put("description", "Description is required!");
        }
        return errors;
    }
    public enum Status {
        ACTIVE(1), DEACTIVE(0);

        int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.getValue();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
