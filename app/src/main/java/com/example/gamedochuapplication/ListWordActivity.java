package com.example.gamedochuapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class ListWordActivity extends AppCompatActivity {

    Intent intent = getIntent();
    ListView lv_word;
    ImageView imgSpeaker, imgHome;
    LinearLayout item_lvWord;
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

        item_lvWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ListWordActivity.this, ShowWordActivity.class);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ListWordActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
