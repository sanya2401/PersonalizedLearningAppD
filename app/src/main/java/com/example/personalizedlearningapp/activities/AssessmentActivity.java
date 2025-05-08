package com.example.personalizedlearningapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.personalizedlearningapp.R;

public class AssessmentActivity extends AppCompatActivity {

    TextView textQuestion, textProgress;
    RadioGroup radioGroup;
    RadioButton optionA, optionB, optionC, optionD;
    Button btnNext;

    int currentIndex = 0;
    int score = 0;

    String[] questions = {
            "What is 5 + 3?",
            "Which language is used for Android development?",
            "What does AI stand for?",
            "Who is the author of 'Harry Potter'?"
    };

    String[][] options = {
            {"6", "7", "8", "9"},
            {"Python", "C#", "Java", "HTML"},
            {"Artificial Intelligence", "Automatic Info", "AI Generator", "Auto Intent"},
            {"Stephen King", "J.K. Rowling", "Rick Riordan", "George R.R. Martin"}
    };

    int[] correctAnswers = {2, 2, 0, 1}; // index of correct answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        textQuestion = findViewById(R.id.textQuestion);
        textProgress = findViewById(R.id.textProgress);
        radioGroup = findViewById(R.id.radioGroup);
        optionA = findViewById(R.id.radioA);
        optionB = findViewById(R.id.radioB);
        optionC = findViewById(R.id.radioC);
        optionD = findViewById(R.id.radioD);
        btnNext = findViewById(R.id.btnNext);

        loadQuestion();

        btnNext.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show();
                return;
            }

            int selectedIndex = radioGroup.indexOfChild(findViewById(selectedId));
            if (selectedIndex == correctAnswers[currentIndex]) {
                score++;
            }

            currentIndex++;
            if (currentIndex < questions.length) {
                loadQuestion();
            } else {
                showResult();
            }
        });
    }

    private void loadQuestion() {
        radioGroup.clearCheck();
        textQuestion.setText(questions[currentIndex]);
        optionA.setText(options[currentIndex][0]);
        optionB.setText(options[currentIndex][1]);
        optionC.setText(options[currentIndex][2]);
        optionD.setText(options[currentIndex][3]);
        textProgress.setText("Question " + (currentIndex + 1) + " of " + questions.length);
    }

    private void showResult() {
        textQuestion.setText("Quiz Completed! You scored " + score + " out of " + questions.length + ".");
        radioGroup.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
        textProgress.setVisibility(View.GONE);
    }
}
