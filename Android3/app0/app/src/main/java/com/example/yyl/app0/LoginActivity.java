package com.example.yyl.app0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

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
                showResponse("true");//不访问服务器，测试用

                //访问服务器
//                sendRequestWithHttpURLConnection("http://192.168.10.111:8080/ServLogin?"+"username="+username.getText()+"&password="+password.getText());//获取连接
//                Toast.makeText(LoginActivity.this,"running ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button02:
                //跳转注册页面
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

     private void sendRequestWithHttpURLConnection(final String strurl){
        //发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try{
                    URL url = new URL(strurl);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    //对获取的数据流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder responseStringBulider = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) !=null){
                        responseStringBulider.append(line);
                    }
                    //调用自定义函数，显示接受的str
                    Log.d("mimi",responseStringBulider.toString());
                    showResponse(responseStringBulider.toString());
                }catch (Exception e){
                    Log.e("nimei","Ecceptions is happend"+e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();
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
