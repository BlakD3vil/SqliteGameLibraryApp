package com.example.sqlitegamelibraryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Games.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_game_library";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "game_name";
    private static final String COLUMN_DEVELOPER = "game_developer";
    private static final String COLUMN_GENRE = "game_genre";

    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_DEVELOPER + " TEXT, " + COLUMN_GENRE + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
       onCreate(db);
    }

    void addGame(String name, String developer, String genre){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_DEVELOPER, developer);
        cv.put(COLUMN_GENRE, genre);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Successfully added!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
