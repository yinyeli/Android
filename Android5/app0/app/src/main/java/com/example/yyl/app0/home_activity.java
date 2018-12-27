package com.example.yyl.app0;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class home_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        findViewById(R.id.btn_end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.btn_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_activity.this,lbs_activity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "18813015780";
                //查看系统自带的call活动，配置参数
                Intent intent = new Intent(Intent.ACTION_DIAL);
//            intent.addCategory("android.intent.category.DEFAULT");//不需要
                intent.setData(Uri.parse("tel:" + phone));

                //将意图传给操作系统，激活activity
                startActivity(intent);//方法内部会自动为inent添加类别。android.intent.category.DEFAULT
                //！！！！但是需要申请权限，所以还要到清单文件去注册
// <uses-permission android:name="android.permission.CALL_PHONE"/>

            }
        });
    }
}
