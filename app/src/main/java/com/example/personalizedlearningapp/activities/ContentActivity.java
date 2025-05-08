package com.example.personalizedlearningapp.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.personalizedlearningapp.R;

public class ContentActivity extends AppCompatActivity {

    TextView textTitle, textDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        textTitle = findViewById(R.id.textContentTitle);
        textDescription = findViewById(R.id.textContentDesc);

        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("description");

        textTitle.setText(title);
        textDescription.setText(desc);
    }
}
