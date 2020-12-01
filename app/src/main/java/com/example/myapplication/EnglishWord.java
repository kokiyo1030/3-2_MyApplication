package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EnglishWord extends AppCompatActivity {
    WordDBHelper mHelper;
    EditText mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.englishword);

        mHelper = new WordDBHelper(this);
        mText = (EditText) findViewById(R.id.edittext);
    }

    public void mOnClick(View view) {
        SQLiteDatabase db;
        ContentValues row;
        switch (view.getId()) {
            case R.id.insert:
                db = mHelper.getWritableDatabase();
                row = new ContentValues();
                row.put("eng","apple");
                row.put("han","사과");
                db.insert("dic", null, row);
                db.execSQL("INSERT INTO dic VALUES (null, 'banana', '바나나');");
                mHelper.close();
                mText.setText("Insert Success");
                break;
            case R.id.delete:
                db = mHelper.getWritableDatabase();
                db.delete("dic", null, null);
//                db.execSQL("DELETE FROM dic;");
                mHelper.close();
                mText.setText("Delete Success");
                break;
            case R.id.update:
                db = mHelper.getWritableDatabase();
                row = new ContentValues();
                row.put("eng", "orange");
                row.put("han", "오렌지");
                db.update("dic", row, "eng = ?", new String[]{"banana"});
                mHelper.close();
                mText.setText("Update Success");
                break;
            case R.id.select:
                db = mHelper.getReadableDatabase();
                Cursor cursor;
                cursor = db.query("dic", new String[]{"eng", "han"}, null, null, null, null, null);
//                cursor = db.rawQuery("SELECT eng, han FROM dic", null);
                String Result = "";
                while (cursor.moveToNext()) {
                    String eng = cursor.getString(0);
                    String han = cursor.getString(1);
                    Result += (eng + " = " + han + "\n");
                }
                if (Result.length() == 0) {
                    mText.setText("Empty Set");
                } else {
                    mText.setText(Result);
                }
                cursor.close();
                mHelper.close();
                break;
        }
    }
}

class WordDBHelper extends SQLiteOpenHelper {
    public WordDBHelper(@Nullable Context context) {
        super(context, "EngWord.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE dic ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "eng TEXT, han TEXT);");
        db.execSQL("INSERT INTO dic VALUES (null, 'apple', '사과');");
        db.execSQL("INSERT INTO dic VALUES (null, 'banana', '바나나');");
        db.execSQL("INSERT INTO dic VALUES (null, 'orange', '오렌지');");
        db.execSQL("INSERT INTO dic VALUES (null, 'fine apple', '파인애플');");
        db.execSQL("INSERT INTO dic VALUES (null, 'mandarin', '귤');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS dic");
        onCreate(db);
    }
}