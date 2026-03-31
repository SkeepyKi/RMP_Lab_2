package com.example.lab_2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity
        implements NameFragment.OnNameEnteredListener,
        TopicFragment.OnTopicSelectedListener {

    private String userName;
    private String selectedTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            loadFragment(new NameFragment());
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null); // добавляем в back stack
        transaction.commit();
    }

    @Override
    public void onNameEntered(String name) {
        userName = name;
        loadFragment(TopicFragment.newInstance(name));
    }

    @Override
    public void onTopicSelected(String topic) {
        selectedTopic = topic;
        loadFragment(ConfirmFragment.newInstance(userName, topic));
    }
}