package com.example.gamedochuapplication.gameScreen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gamedochuapplication.FavoriteTopicActivity;
import com.example.gamedochuapplication.LevelActivity;
import com.example.gamedochuapplication.R;
import com.example.gamedochuapplication.StartActivity;
import com.example.gamedochuapplication.data.Data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ViewTextAndChooseMeanScreen extends AppCompatActivity {
    TextView txv_Vocabulary3;
    String topic;
    int[] id_button = {R.id.btn_answer1_screen3, R.id.btn_answer2_screen3, R.id.btn_answer3_screen3, R.id.btn_answer4_screen3};
    String TAG = "FIREBASE";
    ImageView back, favorite, home, back_level, next;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_text_and_choose_means);

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
            showSystemUI();
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

    void init(){
        txv_Vocabulary3 = findViewById(R.id.txv_Vocabulary3);
        back = findViewById(R.id.imv_back);
        favorite = findViewById(R.id.imv_favorite);
        home = findViewById(R.id.imv_home);
        back_level = findViewById(R.id.imv_restore);
        next = findViewById(R.id.imv_next);

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTextAndChooseMeanScreen.this, FavoriteTopicActivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTextAndChooseMeanScreen.this, StartActivity.class);
                startActivity(intent);
            }
        });

        back_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTextAndChooseMeanScreen.this, LevelActivity.class);
                startActivity(intent);
            }
        });
        getData();
    }

    List<Button> buttons = new ArrayList<Button>();
    void getData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("topic/Actions (Hành động)");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> arrayListAnswer = new ArrayList<>();
                for (DataSnapshot data : dataSnapshot.getChildren()){
                    String mean = data.getValue().toString();
//                    String key = data.getKey();
//                    arrayListAnswer.add(key);
                    arrayListAnswer.add(mean);
                }
                Random random = new Random();
                int kq = random.nextInt(4);
                for (int i = 0; i < 4; i++){
                    Button button_answer;
                    button_answer = findViewById(id_button[i]);

                    if (i == kq){
                        button_answer.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Toast.makeText(ViewTextAndChooseMeanScreen.this, "answer", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    else {
                        button_answer.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(ViewTextAndChooseMeanScreen.this, "wrong answer", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    int rand;
                    rand = random.nextInt(arrayListAnswer.size());
                    String mean = arrayListAnswer.get(rand);
                    arrayListAnswer.remove(mean);
                    button_answer.setVisibility(View.VISIBLE);
                    if (mean != null){
                        button_answer.setText(mean);
                    }
                    buttons.add(button_answer);
                }
                Log.e("result", arrayListAnswer + "");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });

    }

}

