package com.example.lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NormalActivity extends AppCompatActivity {
    private static int instanceCount = 0;
    private int instanceNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        instanceNumber = ++instanceCount;
        TextView title = findViewById(R.id.title);
        title.setText("Обычная активность #" + instanceNumber);

        EditText editText = findViewById(R.id.editText);

        Button btnLaunchAgain = findViewById(R.id.btn_launch_again);
        btnLaunchAgain.setOnClickListener(v -> {
            startActivity(new Intent(this, NormalActivity.class));
        });

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());
    }
}