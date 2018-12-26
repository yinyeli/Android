package com.example.yyl.myapplication0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText username;
    private EditText password;
    private Button login;
    private Button register;
    private String infoString;//服务器返回的数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //初始化信息
        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button01);
        register = (Button)findViewById(R.id.button02);

        //设置按钮监听器
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button01:
                //设置提示框
                Toast.makeText(LoginActivity.this,"正在登陆",Toast.LENGTH_SHORT).show();
                //设置子线程，分别进行Get和Post传输数据
                new Thread(new MyThread()).start();
                break;
            case R.id.button02:
                //跳转注册页面
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    public class MyThread implements Runnable{
        @Override
        public void run() {
            infoString = WebServiceGet.executeHttpGet(username.getText().toString(),password.getText().toString(),"ServLogin");//获取服务器返回的数据

            //更新UI，使用runOnUiThread()方法
            showResponse(infoString);
        }
    }
    private void showResponse(final String response){
        runOnUiThread(new Runnable() {
            //更新UI
            @Override
            public void run() {
                if(response.equals("false")){
                    Toast.makeText(LoginActivity.this,"登陆失败！", Toast.LENGTH_SHORT).show();
                }else {
//                    Toast.makeText(LoginActivity.this,"登陆成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,FrontActivity.class);
                    //上下文，目标活动
                    startActivity(intent);//执行Intent
                }
            }
        });
    }
}
