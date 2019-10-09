package com.example.gamedochuapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    EditText edtFullname, edtAge, edtDoB, edtEmail, edtUsername, edtPassword;
    Button btnSignUp;
    ProgressDialog progressDialog;
    private static final String TAG = "SignUpActivity";
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
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

//    void registerUser(String username, String password, String email, String dob, String age, String fullname){
//        boolean error = false;
//        username = edtUsername.getText().toString().trim();
//        password = edtPassword.getText().toString().trim();
//        email = edtEmail.getText().toString().trim();
//        dob = edtDoB.getText().toString().trim();
//        age = edtAge.getText().toString().trim();
//        fullname = edtFullname.getText().toString().trim();
//        if(TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && TextUtils.isEmpty(email) && TextUtils.isEmpty(dob) && TextUtils.isEmpty(age) && TextUtils.isEmpty(fullname)){
//            progressDialog.show();
//            StringRequest requestUser = new StringRequest(Request.Method.POST, User.URL,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Log.d(TAG, response);
//                            String message = "";
//                            try {
//                                JSONObject jsonObject = new JSONObject(response);
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//            });
//        }
//    }
}
