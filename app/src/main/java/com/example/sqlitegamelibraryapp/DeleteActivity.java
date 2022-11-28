package com.example.sqlitegamelibraryapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    EditText name_input, developer_input, genre_input;
    Button delete_button;

    String id, name, developer, genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        name_input = findViewById(R.id.name_input_delete);
        developer_input = findViewById(R.id.developer_input_delete);
        genre_input = findViewById(R.id.genre_input_delete);
        delete_button = findViewById(R.id.delete_button);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }
    }
}