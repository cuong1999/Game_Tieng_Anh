package com.example.gamedochuapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {
    Button btn_edit;
    EditText edt_Fullname, edt_Age, edt_dob, edt_email, edt_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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
        edt_Fullname = findViewById(R.id.edt_fullName_profile);
        edt_Age = findViewById(R.id.edt_age_profile);
        edt_dob = findViewById(R.id.edt_dob_profile);
        edt_email = findViewById(R.id.edt_email_profile);
        edt_user = findViewById(R.id.edt_username_profile);
        btn_edit = findViewById(R.id.btnEditProfile);



       FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       if (user != null){
           FirebaseDatabase database = FirebaseDatabase.getInstance();
//Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
           DatabaseReference myRef = database.getReference("user");
           String username = edt_user.getText().toString();
           String fullname= edt_Fullname.getText().toString();
           String age = edt_Age.getText().toString();
           String dob = edt_dob.getText().toString();
           String email = edt_email.getText().toString();
           //String email = edtEmail.getText().toString();
           myRef.child(username).child("fullname").setValue(fullname);
           myRef.child(username).child("age").setValue(age);
           myRef.child(username).child("dob").setValue(dob);
           myRef.child(username).child("email").setValue(email);
       }
       else {
           Toast.makeText(ProfileActivity.this,"Not get profile",Toast.LENGTH_LONG).show();
       }
   }

//    public void Load(View view) {
//        try {
//            FirebaseDatabase database = FirebaseDatabase.getInstance();
////Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
//            DatabaseReference myRef = database.getReference("user");
//            String username = edt_user.getText().toString();
//            String fullname= edt_Fullname.getText().toString();
//            String age = edt_Age.getText().toString();
//            String dob = edt_dob.getText().toString();
//            String email = edt_email.getText().toString();
//            //String email = edtEmail.getText().toString();
//            myRef.child(username).child("fullname").setValue(fullname);
//            myRef.child(username).child("age").setValue(age);
//            myRef.child(username).child("dob").setValue(dob);
//            myRef.child(username).child("email").setValue(email);
//            finish();
//        }
//        catch (Exception ex)
//        {
//            Toast.makeText(ProfileActivity.this,"Error:"+ex.toString(),Toast.LENGTH_LONG).show();
//        }
//    }

}
