package com.example.personalizedlearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.personalizedlearningapp.R;

public class ResultsActivity extends AppCompatActivity {

    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        btnContinue = findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(v -> {
            Toast.makeText(this, "Returning to Dashboard...", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(ResultsActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish(); // Optional: remove ResultsActivity from back stack
        });
    }
}

