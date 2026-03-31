package com.example.lab_2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new FirstFragment())
                    .commit();
        }
    }

    @Override
    public void onButton1Clicked() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    public void onButton2Clicked() {
        startActivity(new Intent(this, ThirdActivity.class));
    }
}