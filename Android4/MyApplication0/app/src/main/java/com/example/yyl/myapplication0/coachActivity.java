package com.example.yyl.myapplication0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import database.gymtripBaseHelper;
import database.gymtripBean;
import database.*;

public class coachActivity extends AppCompatActivity implements View.OnClickListener{

    private Button next;
    private TextView jilv;
    private String content1;
    private int mInt;
    gymcoachLab gLab=gymcoachLab.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);
        next=(Button)findViewById(R.id.next1);
        jilv=(TextView)findViewById(R.id.passage_content1) ;
        next.setOnClickListener(this);

        if (gLab.getLen() <= 0) {
            gymcoachBaseHelper dbHelper = new gymcoachBaseHelper(coachActivity.this, "gymcoach", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("gymcoach", null, null, null, null, null, null);
            cursor.moveToFirst();

            for (int i = 0; i < 2; i++) {
                gLab.add(new gymcoachBean(cursor.getInt(0), cursor.getString(1),cursor.getString(2)));
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
