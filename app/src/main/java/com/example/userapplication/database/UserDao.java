package com.example.userapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.userapplication.data.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    LiveData<List<User>>  getUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);
}
