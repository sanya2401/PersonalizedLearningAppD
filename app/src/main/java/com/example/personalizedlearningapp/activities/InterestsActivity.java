package com.example.personalizedlearningapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.personalizedlearningapp.R;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;

public class InterestsActivity extends AppCompatActivity {

    Button btnNext;
    List<CheckBox> checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        btnNext = findViewById(R.id.btnNext);

        checkBoxes = new ArrayList<>();
        checkBoxes.add(findViewById(R.id.cbAlgorithms));
        checkBoxes.add(findViewById(R.id.cbDataStructures));
        checkBoxes.add(findViewById(R.id.cbWebDev));
        checkBoxes.add(findViewById(R.id.cbTesting));
        checkBoxes.add(findViewById(R.id.cbAndroid));
        checkBoxes.add(findViewById(R.id.cbAI));
        checkBoxes.add(findViewById(R.id.cbML));
        checkBoxes.add(findViewById(R.id.cbCyber));
        checkBoxes.add(findViewById(R.id.cbDB));
        checkBoxes.add(findViewById(R.id.cbCloud));

        btnNext.setOnClickListener(v -> {
            int selected = 0;
            for (CheckBox cb : checkBoxes) {
                if (cb.isChecked()) selected++;
            }
            if (selected > 10) {
                Toast.makeText(this, "Please select up to 10 topics only.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Interests saved! Proceeding to Dashboard...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InterestsActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
