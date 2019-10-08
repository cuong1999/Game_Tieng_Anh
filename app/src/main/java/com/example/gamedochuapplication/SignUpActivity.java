package com.example.gamedochuapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.toolbox.StringRequest;
//import com.example.gamedochuapplication.user_data.User;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    EditText edtFullname, edtAge, edtDoB, edtEmail, edtUsername, edtPassword;
    Button btnSignUp;
    ImageButton btnBackSignup;
    Intent intent;
    ProgressDialog progressDialog;
    private static final String TAG = "SignUpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.layout_sign_up);
        //hide actionbar
//        ActionBar actionBar = getSupportActionBar();

        init();
//        actionBar.hide();
    }


    private void init() {
        btnSignUp = findViewById(R.id.btn_signUp);
        edtFullname = findViewById(R.id.edt_sign_up_fullname);
        edtAge = findViewById(R.id.edt_sign_up_age);
        edtDoB = findViewById(R.id.edt_sign_up_dob);
        edtEmail = findViewById(R.id.edt_sign_up_email);
        edtUsername = findViewById(R.id.edt_sign_up_username);
        edtPassword = findViewById(R.id.edt_sign_up_password);
        btnBackSignup = findViewById(R.id.btnBackSignup);
    }

    void clickSignUp(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    void clickBackSignup(){
        btnBackSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
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
