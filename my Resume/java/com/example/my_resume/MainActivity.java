package com.example.my_resume;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v ->
                Toast.makeText(
                        MainActivity.this,
                        "Resume Submitted Successfully!",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }
}