package com.example.yyl.myapplication0;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                Toast.makeText(RegisterActivity.this,"正在注册",Toast.LENGTH_LONG).show();
                new Thread(new RegThread()).start();
                break;
        }
    }

    public class RegThread implements Runnable{
        @Override
        public void run() {

            //获取服务器返回数据
            String RegRet = WebServicePost.executeHttpPost(regUserName.getText().toString(),regPassWord.getText().toString(),"Servregister");

            //更新UI，界面处理
            showReq(RegRet);
        }
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
