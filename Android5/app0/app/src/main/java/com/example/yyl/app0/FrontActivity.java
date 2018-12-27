package com.example.yyl.app0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FrontActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mtrip;
    private Button coach;
    private TextView wenzhang1;
    private TextView wenzhang2;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"clicked add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.re_item:
                Toast.makeText(this,"clicked remove",Toast.LENGTH_SHORT).show();
                break;
            case R.id.quit_item:
                finish();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;//false则无法显示菜单
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        findViewById(R.id.button22).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FrontActivity.this,recycler_main.class);
                startActivity(intent);//执行Intent
            }
        });

        findViewById(R.id.view_boxing).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String video_url = "http://192.168.10.105:8080/ad/movie.mp4";
                Intent intent = new Intent(FrontActivity.this,activity_videoplayer.class);
                intent.putExtra("video_url",video_url);
                startActivity(intent);//执行Intent
            }
        });
        findViewById(R.id.button23).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FrontActivity.this,home_activity.class);
                startActivity(intent);//执行Intent
            }
        });

        mtrip=(Button) findViewById(R.id.trip);
        mtrip.setOnClickListener(this);
        coach=(Button) findViewById(R.id.jiaolian);
        coach.setOnClickListener(this);
        wenzhang1=(TextView)findViewById(R.id.wenzhang1);
        wenzhang1.setOnClickListener(this);
        wenzhang2=(TextView)findViewById(R.id.wenzhang2);
        wenzhang2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.trip:
                Intent intent = new Intent(FrontActivity.this,tripActivity.class);
                startActivity(intent);
                break;
//                sendRequestWithHttpURLConnection("http://192.168.10.111:8080/ServLogin?"+"username="+username.getText()+"&password="+password.getText());//获取连接
//                Toast.makeText(LoginActivity.this,"running ",Toast.LENGTH_SHORT).show();
            case R.id.jiaolian:
                //跳转教练页面
                Intent intent1 = new Intent(FrontActivity.this,coachActivity.class);
                startActivity(intent1);
                break;
            case R.id.wenzhang1:
                //跳转文章页面
                Intent intent2 = new Intent(FrontActivity.this,articleActivity.class);
                startActivity(intent2);
                break;
            case R.id.wenzhang2:
                //跳转文章页面
                Intent intent3 = new Intent(FrontActivity.this,articleActivity.class);
                startActivity(intent3);
                break;

        }
    }

}
