package com.example.ise1;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ise1.Activity_contact;

public class MainActivity extends AppCompatActivity {

    Button button;
    int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        // Open contact picker
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI);

                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    // THIS METHOD COMES AFTER onCreate()
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

            Uri contactUri = data.getData();

            Cursor cursor = getContentResolver().query(contactUri,
                    null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {

                int nameIndex = cursor.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);

                int numberIndex = cursor.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.NUMBER);

                String name = cursor.getString(nameIndex);
                String number = cursor.getString(numberIndex);

                cursor.close();

                // Open new activity
                Intent intent = new Intent(MainActivity.this, Activity_contact.class);
                intent.putExtra("name", name);
                intent.putExtra("number", number);
                startActivity(intent);
            }
        }
    }
}