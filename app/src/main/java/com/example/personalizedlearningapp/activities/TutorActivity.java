package com.example.personalizedlearningapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.AuthFailureError;
import com.example.personalizedlearningapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class TutorActivity extends AppCompatActivity {

    EditText inputQuestion;
    Button btnAsk;
    TextView textResponse;

    private static final String API_URL = "https://llm-1n24.onrender.com/generate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);

        inputQuestion = findViewById(R.id.editQuestion);
        btnAsk = findViewById(R.id.btnAsk);
        textResponse = findViewById(R.id.textResponse);

        btnAsk.setOnClickListener(v -> {
            String question = inputQuestion.getText().toString().trim();
            if (question.isEmpty()) {
                Toast.makeText(this, "Please enter a question", Toast.LENGTH_SHORT).show();
                return;
            }
            sendToLLM(question);
        });
    }

    private void sendToLLM(String question) {
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST, API_URL,
                response -> {
                    try {
                        JSONObject obj = new JSONObject(response);
                        String reply = obj.getString("response");
                        textResponse.setText(reply);
                    } catch (JSONException e) {
                        textResponse.setText("Error parsing response.");
                    }
                },
                error -> {
                    textResponse.setText("Error: " + error.toString());
                }) {

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                JSONObject json = new JSONObject();
                try {
                    json.put("prompt", question);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                return json.toString().getBytes(StandardCharsets.UTF_8);
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(
                15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));

        queue.add(request);
    }
}
