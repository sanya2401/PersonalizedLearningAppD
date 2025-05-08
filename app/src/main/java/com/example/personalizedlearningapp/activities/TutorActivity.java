package com.example.personalizedlearningapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.personalizedlearningapp.R;

public class TutorActivity extends AppCompatActivity {

    EditText editQuestion;
    Button btnAsk;
    TextView textResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);

        editQuestion = findViewById(R.id.editQuestion);
        btnAsk = findViewById(R.id.btnAsk);
        textResponse = findViewById(R.id.textResponse);

        btnAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = editQuestion.getText().toString().trim();
                if (question.isEmpty()) {
                    textResponse.setText("Please enter a question.");
                } else {
                    textResponse.setText(getDummyLLMResponse(question));
                }
            }
        });
    }

    private String getDummyLLMResponse(String question) {
        question = question.toLowerCase();
        if (question.contains("java")) {
            return "Java is a popular programming language used for Android development and enterprise apps.";
        } else if (question.contains("ai") || question.contains("artificial intelligence")) {
            return "AI stands for Artificial Intelligence — the simulation of human intelligence by machines.";
        } else if (question.contains("math")) {
            return "Math includes topics like Algebra, Geometry, and Calculus. Let me know which one you need help with!";
        } else {
            return "That's a great question! Let's break it down together. (This is a dummy LLM response.)";
        }
    }
}
