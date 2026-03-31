package com.example.lab_2;

import android.app.Application;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class App extends Application {
    private static App instance;
    private Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        bus = new Bus(ThreadEnforcer.MAIN);
    }

    public static App getInstance() {
        return instance;
    }

    public Bus getBus() {
        return bus;
    }
}