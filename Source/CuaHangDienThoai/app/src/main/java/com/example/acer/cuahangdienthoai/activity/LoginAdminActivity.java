package com.example.acer.cuahangdienthoai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.cuahangdienthoai.R;
import com.example.acer.cuahangdienthoai.RetrofitLoginAdmin.ResenterLogin;
import com.example.acer.cuahangdienthoai.RetrofitLoginAdmin.ViewImLogin;

public class LoginAdminActivity extends AppCompatActivity implements ViewImLogin {
    Button btnLogin,btnHuy;
    EditText edtUserName, edtPassWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        Anhxa();

        final ResenterLogin resenterLogin= new ResenterLogin(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String username = edtUserName.getText().toString();
                 String password = edtPassWord.getText().toString();
                //Toast.makeText(LoginAdminActivity.this, ""+username+password, Toast.LENGTH_SHORT).show();
                 resenterLogin.CheckLogin(username,password);
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Huy();
            }
        });
    }
    private void Anhxa() {
        btnLogin=(Button)findViewById(R.id.buttonLogin);
        btnHuy=(Button)findViewById(R.id.buttonHuy);
        edtUserName=(EditText)findViewById(R.id.editTextUserName);
        edtPassWord=(EditText)findViewById(R.id.editTextPassWord);
    }

    @Override
    public void LoginSuccess() {
        fileList();
        Toast.makeText(this, "Login Admin", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(LoginAdminActivity.this,AdminActivity.class);
        startActivity(intent);
    }

    public void Huy() {
        fileList();
        Toast.makeText(this, "Đã hủy", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(LoginAdminActivity.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void LoginFail() {
        Toast.makeText(this, "Login Fail", Toast.LENGTH_SHORT).show();
    }
}
