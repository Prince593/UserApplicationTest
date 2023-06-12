package com.example.userapplication.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.userapplication.UserApplication;
import com.example.userapplication.data.model.User;
import com.example.userapplication.database.AppDatabase;
import com.example.userapplication.database.UserDao;

import java.util.List;

public class UserRepository {

    UserDao userDao;

    public UserRepository() {
        AppDatabase db = Room.databaseBuilder(UserApplication.getApplication(),
                AppDatabase.class, "userdatabase")
                .allowMainThreadQueries()
                .build();
        userDao = db.userDao();
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public LiveData<List<User>> getUsers() {
        return userDao.getUsers();
    }
}
