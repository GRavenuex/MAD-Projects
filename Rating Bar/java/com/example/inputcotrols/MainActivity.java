package com.example.inputcotrols;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name;
    ToggleButton toggleBtn;
    RatingBar ratingBar;
    ProgressBar progressBar;
    ImageButton imgBtn;
    Button submitBtn;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        toggleBtn = findViewById(R.id.toggleBtn);
        ratingBar = findViewById(R.id.ratingBar);
        progressBar = findViewById(R.id.progressBar);
        imgBtn = findViewById(R.id.imgBtn);
        submitBtn = findViewById(R.id.submitBtn);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress += 25;
                progressBar.setProgress(progress);

                if(progress == 100){
                    Toast.makeText(MainActivity.this,"Form Ready to Submit",Toast.LENGTH_SHORT).show();
                }
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString();
                float rating = ratingBar.getRating();
                boolean satisfied = toggleBtn.isChecked();

                String status;

                if(satisfied){
                    status = "Satisfied";
                } else {
                    status = "Not Satisfied";
                }

                Toast.makeText(MainActivity.this,
                        "Name: "+username+
                                "\nStatus: "+status+
                                "\nRating: "+rating,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}