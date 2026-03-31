package com.example.lab_2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.squareup.otto.Bus;

public abstract class BaseFragment extends Fragment {

    protected Bus bus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = App.getInstance().getBus();
    }

    @Override
    public void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        bus.unregister(this);
    }
}