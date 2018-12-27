package com.example.yyl.app0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import database.gymarticleBaseHelper;
import database.gymarticleBean;
import database.gymarticleLab;

public class articleActivity extends AppCompatActivity implements View.OnClickListener{

    private Button next;
    private TextView jilv;
    private String content1;
    private int mInt;
    private TextView title;
    gymarticleLab gLab=gymarticleLab.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        next=(Button)findViewById(R.id.next3);
        jilv=(TextView)findViewById(R.id.passage_content3) ;
        title=(TextView)findViewById(R.id.title) ;
        next.setOnClickListener(this);

        if (gLab.getLen() <= 0) {
            gymarticleBaseHelper dbHelper = new gymarticleBaseHelper(articleActivity.this, "gymarticle", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("gymarticle", null, null, null, null, null, null);
            cursor.moveToFirst();

            for (int i = 0; i < 2; i++) {
                gLab.add(new gymarticleBean(cursor.getInt(0), cursor.getString(1),cursor.getString(2)));
                cursor.moveToNext();
            }
            cursor.close();
        }
        content1=gLab.get(mInt).toString1();
        title.setText(content1);

        content1=gLab.get(mInt).toString2();
        jilv.setText(content1);
    }

    @Override
    public void onClick(View view) {
        mInt++;
        content1=gLab.get(mInt).toString2();
        jilv.setText(content1);
        content1=gLab.get(mInt).toString1();
        title.setText(content1);
    }
}
