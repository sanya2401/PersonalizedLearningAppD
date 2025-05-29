package com.example.personalizedlearningapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.personalizedlearningapp.R;

public class UpgradeAccountActivity extends AppCompatActivity {

    Button btnStarter, btnIntermediate, btnAdvanced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade_account);

        btnStarter = findViewById(R.id.btnStarter);
        btnIntermediate = findViewById(R.id.btnIntermediate);
        btnAdvanced = findViewById(R.id.btnAdvanced);

        btnStarter.setOnClickListener(v -> showMessage("Starter Plan Purchased via GPay"));
        btnIntermediate.setOnClickListener(v -> showMessage("Intermediate Plan Purchased via GPay"));
        btnAdvanced.setOnClickListener(v -> showMessage("Advanced Plan Purchased via GPay"));
    }

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
