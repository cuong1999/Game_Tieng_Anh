package com.example.gamedochuapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    EditText edtFullname, edtAge, edtDoB, edtEmail, edtUsername, edtPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sign_up);
        init();
    }

    private void init() {
        btnSignUp = findViewById(R.id.btn_signUp);
        edtFullname = findViewById(R.id.edt_sign_up_fullname);
        edtAge = findViewById(R.id.edt_sign_up_age);
        edtDoB = findViewById(R.id.edt_sign_up_dob);
        edtEmail = findViewById(R.id.edt_sign_up_email);
        edtUsername = findViewById(R.id.edt_sign_up_username);
        edtPassword = findViewById(R.id.edt_sign_up_password);
    }

    void clickSignUp(){

    }
}
