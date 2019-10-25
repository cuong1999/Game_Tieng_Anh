package com.example.gamedochuapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.example.gamedochuapplication.R;
import com.example.gamedochuapplication.data.Data;
import com.example.gamedochuapplication.gameScreen.ListenAndChooseMeansScreen;

public class LevelActivity extends AppCompatActivity {
    //Controls
    ImageButton imvBack, imvFavorite, imvHome, imvRestore, imvNext;
    Button btn_lv1, btn_lv2, btn_lv3;
    Intent intent;
    String topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        //hide actionbar
        ActionBar actionBar = getSupportActionBar();

        actionBar.hide();

        Intent intent = getIntent();
        topic = intent.getStringExtra(Data.KEY_TOPIC);
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


    public void init()
    {
        imvBack = findViewById(R.id.imv_back);
        imvFavorite = findViewById(R.id.imv_favorite);
        imvHome = findViewById(R.id.imv_home);
        imvRestore = findViewById(R.id.imv_restore);
        imvNext = findViewById(R.id.imv_next);
        btn_lv1 = findViewById(R.id.btn_lv1);
        btn_lv2 = findViewById(R.id.btn_lv2);
        btn_lv3 = findViewById(R.id.btn_lv3);

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
        btn_lv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LevelActivity.this, ListenAndChooseMeansScreen.class);
                intent.putExtra(Data.KEY_TOPIC, topic);
                startActivity(intent);
            }
        });
    }
}
