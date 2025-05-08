package com.example.personalizedlearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.personalizedlearningapp.R;
import com.example.personalizedlearningapp.activities.InterestsActivity;


public class RegisterActivity extends AppCompatActivity {

    EditText username, email, confirmEmail, password, confirmPassword, phone;
    Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.editUsername);
        email = findViewById(R.id.editEmail);
        confirmEmail = findViewById(R.id.editConfirmEmail);
        password = findViewById(R.id.editPassword);
        confirmPassword = findViewById(R.id.editConfirmPassword);
        phone = findViewById(R.id.editPhone);
        createAccount = findViewById(R.id.btnCreateAccount);

        createAccount.setOnClickListener(v -> {

            Intent intent = new Intent(RegisterActivity.this, InterestsActivity.class);
            startActivity(intent);
        });
    }
}
