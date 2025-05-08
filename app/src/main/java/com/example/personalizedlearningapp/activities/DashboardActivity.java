package com.example.personalizedlearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.personalizedlearningapp.R;

public class DashboardActivity extends AppCompatActivity {

    TextView welcomeText, taskDueText;
    CardView taskCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        welcomeText = findViewById(R.id.textWelcome);
        taskDueText = findViewById(R.id.textTasksDue);
        taskCard = findViewById(R.id.cardTask);


        String username = "Your Name";

        welcomeText.setText("Hello, " + username);
        taskDueText.setText("You have 1 task due");

        taskCard.setOnClickListener(v -> {
            Toast.makeText(this, "Opening Task 1", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(DashboardActivity.this, TaskActivity.class));
        });
    }
}
