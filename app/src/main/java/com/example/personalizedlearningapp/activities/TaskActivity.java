package com.example.personalizedlearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.personalizedlearningapp.R;

public class TaskActivity extends AppCompatActivity {

    RadioButton answer1, answer2, answer3;
    Switch toggleQ2;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        answer1 = findViewById(R.id.rbAnswer1);
        answer2 = findViewById(R.id.rbAnswer2);
        answer3 = findViewById(R.id.rbAnswer3);
        toggleQ2 = findViewById(R.id.toggleQ2);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            Toast.makeText(this, "Task Submitted!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(TaskActivity.this, ResultsActivity.class));
        });
    }
}
