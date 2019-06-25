package entity;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import util.HashingPass;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
@Entity
public class Account {
    @Id
    private String username;
    private String password;
    private String salt;
    private long createdAt;
    private long updateAt;
    @Index
    private int status;
    Ref<Student> studentRef;

    public Account() {
        generateSalt();
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.updateAt =Calendar.getInstance().getTimeInMillis();
        this.status=1;
    }

    public void generateSalt(){
        this.salt= HashingPass.generateSalt(10);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void passxuli(String password) throws NoSuchAlgorithmException {
        this.password = HashingPass.HashPass(password,salt);
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }



    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Ref<Student> getStudentRef() {
        return studentRef;
    }

    public void setStudentRef(Ref<Student> studentRef) {
        this.studentRef = studentRef;
    }
}
