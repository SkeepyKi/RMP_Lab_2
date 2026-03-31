package com.example.lab_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ClearTopActivity extends AppCompatActivity {
    private static int instanceCount = 0;
    private int instanceNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        instanceNumber = ++instanceCount;
        TextView title = findViewById(R.id.title);
        title.setText("CLEAR_TOP активность #" + instanceNumber);

        EditText editText = findViewById(R.id.editText);

        Button btnLaunchAgain = findViewById(R.id.btn_launch_again);
        btnLaunchAgain.setOnClickListener(v -> {
            Intent intent = new Intent(this, ClearTopActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());
    }
}