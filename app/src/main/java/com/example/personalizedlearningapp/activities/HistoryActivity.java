package com.example.personalizedlearningapp.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.personalizedlearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    ListView listHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listHistory = findViewById(R.id.listHistory);

        List<String> historyItems = new ArrayList<>();
        historyItems.add("What are variables in Java?");
        historyItems.add("Explain OOP principles.");
        historyItems.add("What is polymorphism?");
        historyItems.add("Describe Android activity lifecycle.");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.item_history,
                R.id.textHistoryItem,
                historyItems
        );

        listHistory.setAdapter(adapter);
    }
}
