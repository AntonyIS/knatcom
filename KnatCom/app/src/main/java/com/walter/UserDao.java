package com.walter;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User x);

    @Query("select * from users")
    List<User> getAllUsers();

    @Delete
    void dleteUser(User x);

    @Query("select count(id) from users")
    int getCount();

    
}
