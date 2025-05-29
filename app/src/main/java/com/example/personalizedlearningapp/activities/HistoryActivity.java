package com.example.personalizedlearningapp.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.personalizedlearningapp.R;

public class HistoryActivity extends AppCompatActivity {

    ListView listHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listHistory = findViewById(R.id.listHistory);

        // Dummy data for demonstration
        String[] historyItems = {
                "Quiz on Java - Score: 80%",
                "Task 1 Completed - Arrays",
                "Quiz on Android Basics - Score: 90%",
                "Custom Task - Completed on May 28"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, historyItems
        );

        listHistory.setAdapter(adapter);
    }
}
