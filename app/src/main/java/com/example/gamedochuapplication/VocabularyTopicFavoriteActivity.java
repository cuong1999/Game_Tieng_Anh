package com.example.gamedochuapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class VocabularyTopicFavoriteActivity extends AppCompatActivity {

    Intent intent = getIntent();
    ListView lv_word;
    ImageView imgSpeaker, imgHome;
    LinearLayout item_lvWord;
    //Controls
    ImageButton imvBack, imvFavorite, imvHome, imvRestore, imvNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_word);
        init();
    }

    private void init() {
        lv_word = findViewById(R.id.list_word);
        imgSpeaker = findViewById(R.id.img_speaker);
        imgHome = findViewById(R.id.img_home);
        item_lvWord = findViewById(R.id.item_list_word);
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

        item_lvWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VocabularyTopicFavoriteActivity.this, Level1Activity.class);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VocabularyTopicFavoriteActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
