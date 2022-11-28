package com.example.sqlitegamelibraryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabase myDB;
    ArrayList<String> game_id, game_name, game_developer, game_genre;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabase(MainActivity.this);
        game_id = new ArrayList<>();
        game_name = new ArrayList<>();
        game_developer = new ArrayList<>();
        game_genre = new ArrayList<>();

        storeData();

        adapter = new Adapter(MainActivity.this, game_id, game_name, game_developer, game_genre);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void storeData(){
        Cursor cursor = myDB.readData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                game_id.add(cursor.getString(0));
                game_name.add(cursor.getString(1));
                game_developer.add(cursor.getString(2));
                game_genre.add(cursor.getString(3));
            }
        }
    }
}