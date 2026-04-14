package com.example.ise1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_contact extends AppCompatActivity {

    TextView tvName, tvNumber;
    ImageButton btnCall, btnSMS, btnWhatsApp;

    String name, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        tvName = findViewById(R.id.tvName);
        tvNumber = findViewById(R.id.tvNumber);
        btnCall = findViewById(R.id.btnCall);
        btnSMS = findViewById(R.id.btnSMS);
        btnWhatsApp = findViewById(R.id.btnWhatsApp);

        name = getIntent().getStringExtra("name");
        number = getIntent().getStringExtra("number");

        tvName.setText(name);
        tvNumber.setText(number);

        // Call
        btnCall.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + number));
            startActivity(callIntent);
        });

        // SMS
        btnSMS.setOnClickListener(v -> {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("sms:" + number));
            startActivity(smsIntent);
        });

        // WhatsApp
        btnWhatsApp.setOnClickListener(v -> {
            Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
            whatsappIntent.setData(Uri.parse("https://wa.me/" + number));
            startActivity(whatsappIntent);
        });
    }
}