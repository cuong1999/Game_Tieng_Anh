package com.example.gamedochuapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {

    Button btnKid, btnStudent;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        init();
    }

    private void init() {
        btnKid = findViewById(R.id.btn_kid);
        btnStudent = findViewById(R.id.btn_student);
        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnKid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(IntroActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }
}
