package com.example.khabennaki.Design.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User_table")
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "UserId")
    String userId;
    @ColumnInfo(name = "UserType")
    String userType;
    @ColumnInfo(name = "LogInStatus")
    int logInStatus;

    public User() {

    }

    public User(@NonNull String userId, String userType, int logInStatus) {
        this.userId = userId;
        this.userType = userType;
        this.logInStatus = logInStatus;
    }

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getLogInStatus() {
        return logInStatus;
    }

    public void setLogInStatus(int logInStatus) {
        this.logInStatus = logInStatus;
    }

}
