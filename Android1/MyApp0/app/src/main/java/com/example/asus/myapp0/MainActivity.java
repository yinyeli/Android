package com.example.asus.myapp0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.view);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取网络连接
                Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_SHORT).show();
                sendRequestWithHttpURLConnection("http://192.168.10.111:8000/login/");//注意，此处不能输入：www.baidu.com。必须是全连接
            }
        });
    }

    private void sendRequestWithHttpURLConnection(final String strurl){
        //开启线程来发起网络请求
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
                    Toast.makeText(MainActivity.this,responseStringBulider.toString(),Toast.LENGTH_SHORT).show();
                    showReponse(responseStringBulider.toString());
                }catch (Exception e){
                    Log.e("nimei","Ecceptions is happend"+e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showReponse(final String responseStr){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(responseStr);

            }
        });
    }
}