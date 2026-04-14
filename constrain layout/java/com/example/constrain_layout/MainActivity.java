package com.example.constrain_layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private EditText editTextUsername;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link XML views to Java
        textViewTitle = findViewById(R.id.textViewTitle);
        editTextUsername = findViewById(R.id.editTextUsername);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Button click listener
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                if (!username.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Hello, " + username + "!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter your username", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}