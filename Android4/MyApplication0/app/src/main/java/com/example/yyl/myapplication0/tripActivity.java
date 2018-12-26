package com.example.yyl.myapplication0;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import database.gymarticleBaseHelper;
import database.*;

import static java.security.AccessController.getContext;


public class tripActivity extends AppCompatActivity implements View.OnClickListener{

    private Button next;
    private TextView jilv;
    private String content1;
    private int mInt;
    gymtripLab gLab=gymtripLab.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
        next=(Button)findViewById(R.id.next);
        jilv=(TextView)findViewById(R.id.passage_content) ;
        next.setOnClickListener(this);

        if (gLab.getLen() <= 0) {
            gymtripBaseHelper dbHelper = new gymtripBaseHelper(tripActivity.this, "gymtrip", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("gymtrip", null, null, null, null, null, null);
            cursor.moveToFirst();

            for (int i = 0; i < 2; i++) {
                gLab.add(new gymtripBean(cursor.getInt(0), cursor.getString(1),cursor.getString(2)));
                cursor.moveToNext();
            }
            cursor.close();
        }
        content1=gLab.get(mInt).toString();
        jilv.setText(content1);
    }

    @Override
    public void onClick(View view) {
         mInt++;
        content1=gLab.get(mInt).toString();
        jilv.setText(content1);
    }

}
