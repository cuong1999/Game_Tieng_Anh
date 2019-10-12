package com.example.gamedochuapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gamedochuapplication.network.Network;
import com.example.gamedochuapplication.user_data.User;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin, btnSignUp, btnCancel;
    EditText edtUsername, edtPassword;
    Intent intent;
    String username, password, id;
    Context context;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide actionbar
        ActionBar actionBar = getSupportActionBar();

        actionBar.hide();
        //full screen
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
                showAlertDialog();
            }
        });

    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cancel");
        builder.setMessage("Would you like to stop login?");
        builder.setCancelable(false);
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LoginActivity.this, "Login continue...", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                intent = new Intent(LoginActivity.this, IntroActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


//     void clickLogin() {
//         username = edtUsername.getText().toString().trim();
//         password = edtPassword.getText().toString().trim();
//         btnLogin.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 username = edtUsername.getText().toString().trim();
//                 password = edtPassword.getText().toString().trim();
//                 if(username.equals("admin") && password.equals("123")){
//                     intent = new Intent(LoginActivity.this, StartActivity.class);
//                     startActivity(intent);
//                 }
//                 else
//                 {
//                     AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this)
//                             .setTitle("Error")
//                             .setMessage("Username or password not correct!!")
//                             .setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                         @Override
//                         public void onClick(DialogInterface dialogInterface, int i) {
//                             finish();
//                         }
//                     }).show();
//                 }
//
//             }
//         });
//    }

    void clickLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean error = false;

                // get data
                username = edtUsername.getText().toString().trim();
                password = edtPassword.getText().toString().trim();

                // password empty
                if (TextUtils.isEmpty(password)) {
                    edtPassword.requestFocus();
                    error = true;
                }

                // username empty
                if (TextUtils.isEmpty(username)) {
                    edtUsername.requestFocus();
                    error = true;
                }
                if (!error) {
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("username", userName);
//                    editor.putString("pass", password);
//                    editor.apply();
                    loading();
                    Login();
                }

            }
        });
    }


    void login(){
        boolean error = false;
        username = edtUsername.getText().toString().trim();
        password = edtPassword.getText().toString().trim();

        if(TextUtils.isEmpty(password)){
            edtPassword.requestFocus();
            error = true;
        }

        if(TextUtils.isEmpty(username)){
            edtUsername.requestFocus();
            error = true;
        }

        if(!error){
            Login();
            loading();
        }
    }

    Network network = Network.getInstance();

    void Login() {
        String json_post = create_Json_Login();
        network.executePOST(User.URL, json_post, new Network.Callback() {
            @Override
            public void onCallBack(String json) {
                final String jsons = json;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        checkLogin(jsons);
                    }
                });
            }

            @Override
            public void onFail(String error) {
                Log.e("Error:", error);
                android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(LoginActivity.this)
                        .setTitle("Warning")
                        .setMessage("Wifi is not connected!!!")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .show();
            }
        });
    }

    String create_Json_Login() {
        String json = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        return json;
    }

    private void checkLogin(String json) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
            Boolean result = jsonObject.getBoolean("result");
            String code = jsonObject.getString("code");
            if (!result) {
                showDialog_failLogin(code);
            } else {
                JSONObject jsonObject1Data = jsonObject.getJSONObject("data");
                id = jsonObject1Data.getString("id");
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(context, "Login Success", Toast.LENGTH_LONG).show();
                intent.putExtra(User.KEY_PASSWORD, password);
                intent.putExtra(User.KEY_USERNAME, username);
                intent.putExtra(User.KEY_USER_ID, id);
                startActivity(intent);
                progress.dismiss();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    void showDialog_failLogin(String code) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(context.getResources().getString(R.string.dialogTitleLoginFail));
        builder.setMessage(code);
        builder.setCancelable(false);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
        progress.dismiss();
    }

//    void wiFiCheck() {
//        boolean check = ConnectionReceiver.isConnected();
//        if (check == false) {
//            android.app.AlertDialog alertDialog = new AlertDialog.Builder(this)
//                    .setTitle("Warning")
//                    .setMessage("Wifi is not connected!!!")
//                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
//
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            finish();
//                        }
//                    })
//                    .show();
//        }
//    }

    private void loading() {
        progress = new ProgressDialog(LoginActivity.this);
        progress.setMax(100);
        progress.setMessage("Waiting....");
        progress.setTitle("LOGIN");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progress.getProgress() <= progress
                            .getMax()) {
                        Thread.sleep(1000);
//                        handle.sendMessage(handle.obtainMessage());
                        if (progress.getProgress() == progress
                                .getMax()) {
                            progress.dismiss();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
