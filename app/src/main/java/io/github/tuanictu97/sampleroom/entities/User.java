package io.github.tuanictu97.sampleroom.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table", indices = {
        @Index(value = {"userName", "email"}, unique = true)
})
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    private int id;

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "fullName")
    private String fullName;

    public User(String userName, String email, String fullName) {
        this.userName = userName;
        this.email = email;
        this.fullName = fullName;
    }


    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
