package com.example.personalizedlearningapp.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.personalizedlearningapp.R;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class ShareProfileActivity extends AppCompatActivity {

    ImageView imageQrCode;
    Button btnShareLink;

    String profileUrl = "https://myapp.com/profile/username123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_profile);

        imageQrCode = findViewById(R.id.imageQrCode);
        btnShareLink = findViewById(R.id.btnShareLink);

        // Generate QR Code
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(profileUrl, BarcodeFormat.QR_CODE, 400, 400);
            imageQrCode.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Share intent
        btnShareLink.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, profileUrl);
            startActivity(Intent.createChooser(shareIntent, "Share Profile Link"));
        });
    }
}
