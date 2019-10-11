package com.example.gamedochuapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Level1Activity extends AppCompatActivity {

    TextView tvEng, tvVi;
    ImageView imgSpeaker, imgHome;
    Intent intent;
    Button btnChecked;
    //Controls
    ImageButton imvBack, imvFavorite, imvHome, imvRestore, imvNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);

        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
//        ActionBar actionBar = getActionBar();
//        actionBar.hide();

        init();
    }

    private void init() {
        tvEng = findViewById(R.id.tv_english);
        tvVi = findViewById(R.id.tv_vietnamese);
        imgSpeaker = findViewById(R.id.btn_speaker);
        imgHome = findViewById(R.id.img_home);
        btnChecked = findViewById(R.id.btn_check_showWord);
        imvBack = findViewById(R.id.imv_back);
        imvFavorite = findViewById(R.id.imv_favorite);
        imvHome = findViewById(R.id.imv_home);
        imvRestore = findViewById(R.id.imv_restore);
        imvNext = findViewById(R.id.imv_next);

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
        btnChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Level1Activity.this, VocabularyTopicFavoriteActivity.class);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Level1Activity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
