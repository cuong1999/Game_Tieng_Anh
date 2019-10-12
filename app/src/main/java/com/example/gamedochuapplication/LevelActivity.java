package com.example.gamedochuapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.example.gamedochuapplication.R;

public class LevelActivity extends AppCompatActivity {
    //Controls
    ImageButton imvBack, imvFavorite, imvHome, imvRestore, imvNext;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
    }


    public void init()
    {
        imvBack = findViewById(R.id.imv_back);
        imvFavorite = findViewById(R.id.imv_favorite);
        imvHome = findViewById(R.id.imv_home);
        imvRestore = findViewById(R.id.imv_restore);
        imvNext = findViewById(R.id.imv_next);

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LevelActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        imvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LevelActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        imvRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
