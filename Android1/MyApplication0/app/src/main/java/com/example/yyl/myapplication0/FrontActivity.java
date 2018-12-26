package com.example.yyl.myapplication0;
import com.example.yyl.myapplication0.recylerview.recycle_mainActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class FrontActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"clicked add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.re_item:
                Toast.makeText(this,"clicked remove",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.id_quit:
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

        Button button = (Button)findViewById(R.id.button22);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FrontActivity.this, recycle_mainActivity.class);
                //上下文，目标活动
                startActivity(intent);//执行Intent
            }
        });
    }


}
