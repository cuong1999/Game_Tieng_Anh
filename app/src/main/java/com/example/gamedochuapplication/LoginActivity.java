package com.example.gamedochuapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin, btnSignUp, btnCancel;
    EditText edtUsername, edtPassword;
    Intent intent;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        clickLogin();
    }

    private void init() {
        btnLogin = findViewById(R.id.btn_login);
        btnSignUp = findViewById(R.id.btn_sign_up_in_login);
        btnCancel = findViewById(R.id.btn_cancel);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LoginActivity.this, IntroActivity.class);
                startActivity(intent);
            }
        });
    }

//    boolean error = false;
//    void login(){
//        username = edtUsername.getText().toString().trim();
//        password = edtPassword.getText().toString().trim();
//
//        if(TextUtils.isEmpty(password)){
//            edtPassword.requestFocus();
//            error = true;
//        }
//
//        if(TextUtils.isEmpty(username)){
//            edtUsername.requestFocus();
//            error = true;
//        }
//
//        if(!error){
//            Login();
//        }
//    }

     void clickLogin() {
         username = edtUsername.getText().toString().trim();
         password = edtPassword.getText().toString().trim();
         btnLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 username = edtUsername.getText().toString().trim();
                 password = edtPassword.getText().toString().trim();
                 if(username.equals("admin") && password.equals("123")){
                     intent = new Intent(LoginActivity.this, StartActivity.class);
                     startActivity(intent);
                 }
                 else
                 {
                     AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this)
                             .setTitle("Error")
                             .setMessage("Username or password not correct!!")
                             .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             finish();
                         }
                     }).show();
                 }

             }
         });
    }
}
