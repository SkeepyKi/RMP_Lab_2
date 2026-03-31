package com.example.lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NewTaskActivity extends AppCompatActivity {
    private static int instanceCount = 0;
    private int instanceNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        instanceNumber = ++instanceCount;
        TextView title = findViewById(R.id.title);
        title.setText("NEW_TASK активность #" + instanceNumber);

        EditText editText = findViewById(R.id.editText);

        Button btnLaunchAgain = findViewById(R.id.btn_launch_again);
        btnLaunchAgain.setOnClickListener(v -> {
            Intent intent = new Intent(this, NewTaskActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());
    }
}