package com.example.userapplication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.userapplication.data.model.User;
import com.example.userapplication.repository.UserRepository;

import java.util.List;

public class UserViewModel extends ViewModel {

    UserRepository userRepository;
    public UserViewModel(){
        userRepository = new UserRepository();
    }


    public void addUser(User user){
        userRepository.addUser(user);
    }

    public LiveData<List<User>> getUsers(){
        return userRepository.getUsers();
    }


}
