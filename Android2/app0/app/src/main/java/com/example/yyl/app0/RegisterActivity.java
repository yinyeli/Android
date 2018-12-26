package com.example.yyl.app0;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText regUserName;
    private EditText regPassWord;
    private Button btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //修改标题栏title
        ActionBar ac = getSupportActionBar();
        ac.setTitle("注册");

        //初始化
        regUserName = (EditText)findViewById(R.id.regetext1);
        regPassWord = (EditText)findViewById(R.id.regtext2);
        btn_reg = (Button)findViewById(R.id.regbutton);
        btn_reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regbutton:
                sendRequestWithHttpURLConnection("http://192.168.10.111:8080/Servregister?"+"username="+regUserName.getText()+"&password="+regPassWord.getText());//注册
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
                    showReq(responseStringBulider.toString());
                }catch (Exception e){
                    Log.e("nimei","Ecceptions is happend"+e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void showReq(final String RegRet){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(RegRet.equals("true")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("注册信息");
                    builder.setMessage("注册成功");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                    });
                    builder.show();
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("注册信息");
                    builder.setMessage("注册失败");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}
