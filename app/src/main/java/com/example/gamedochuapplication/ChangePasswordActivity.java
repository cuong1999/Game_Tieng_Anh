package com.example.gamedochuapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.AsyncListUtil;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {
    EditText edt_old_pass, edt_new_pass, edt_re_pass;
    Button btn_save_change,btn_cancel;
    FirebaseAuth auth;
    ProgressDialog dialog;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        dialog = new ProgressDialog(this);
        auth = FirebaseAuth.getInstance();
        //hide action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        init();
    }

    //full screen
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void init(){
        btn_save_change = findViewById(R.id.btn_Save_change);
        btn_cancel = findViewById(R.id.btn_Cancel_change);
        edt_old_pass = findViewById(R.id.edt_Old_pass);
        edt_new_pass = findViewById(R.id.edt_New_pass);
        edt_re_pass = findViewById(R.id.edt_Confirm_pass);


        btn_save_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edt_re_pass.getText().toString().equals(edt_new_pass.getText().toString())){
                    change(v);
                }
//                if (edt_old_pass.getText().toString().equals(user.toString())){
//                    change(v);
//                }
                else {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Password could not be change", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cancel(v);
            }
        });
    }

    public void change (View v){
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            dialog.setMessage("Changing password, please wait...");
            dialog.show();
            user.updatePassword(edt_new_pass.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Your password has been changed", Toast.LENGTH_LONG).show();
                                auth.signOut();
                                finish();
                                Intent intent = new Intent(ChangePasswordActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Password could not be change", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

    public void Cancel(View v){
        showAlertDialog();
    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Would you like to stop changing password for an account?");
        builder.setCancelable(false);
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ChangePasswordActivity.this, "Change pass continue...", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(ChangePasswordActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
