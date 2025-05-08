package com.example.personalizedlearningapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.personalizedlearningapp.R;

public class TutorActivity extends AppCompatActivity {

    EditText inputQuestion;
    Button btnAsk;
    TextView textResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);

        inputQuestion = findViewById(R.id.editQuestion);
        btnAsk = findViewById(R.id.btnAsk);
        textResponse = findViewById(R.id.textResponse);

        btnAsk.setOnClickListener(v -> {
            String question = inputQuestion.getText().toString().trim().toLowerCase();
            if (question.isEmpty()) {
                Toast.makeText(this, "Please enter a question", Toast.LENGTH_SHORT).show();
                return;
            }

            String response;
            if (question.contains("array")) {
                response = "An array is a data structure that holds elements of the same type in a fixed-size list.";
            } else if (question.contains("linked list")) {
                response = "A linked list is a linear data structure where each element points to the next.";
            } else {
                response = "That’s a great question! I’ll get back to you with more info soon.";
            }

            textResponse.setText(response);
        });
    }
}
