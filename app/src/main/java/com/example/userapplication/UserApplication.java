package com.example.userapplication;

import android.app.Application;

public class UserApplication extends Application {

    public static UserApplication userApplication;

    public static UserApplication getApplication() {
        return userApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (userApplication == null)
            userApplication = this;
    }
}
