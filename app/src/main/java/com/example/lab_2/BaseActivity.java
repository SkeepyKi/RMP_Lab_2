package com.example.lab_2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.otto.Bus;

public abstract class BaseActivity extends AppCompatActivity {

    protected Bus bus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = App.getInstance().getBus();
    }

    @Override
    protected void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        bus.unregister(this);
    }
}