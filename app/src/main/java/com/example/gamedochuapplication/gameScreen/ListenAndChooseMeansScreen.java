package com.example.gamedochuapplication.gameScreen;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gamedochuapplication.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListenAndChooseMeansScreen extends AppCompatActivity {

    ImageButton btnSpeaker, btnNext, btnBack, btnHome, btnFavorList;
    ArrayList<String> arrayListAnswer;
    int[] id_button = {R.id.btn_answer1_screen2, R.id.btn_answer2_screen2, R.id.btn_answer3_screen2, R.id.btn_answer4_screen2};
    String TAG = "FIREBASE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listen_and_choose_means);
    }

    void init(){
        btnSpeaker = findViewById(R.id.btn_speaker);
        btnBack = findViewById(R.id.imv_back);
        btnNext = findViewById(R.id.imv_next);
        btnFavorList = findViewById(R.id.imv_favorite);
        btnHome = findViewById(R.id.imv_home);
    }

    List<Button> buttons;
    void getData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("topic1");
        Random random = new Random();
//        int randData = random.nextInt();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(int i = 0; i< dataSnapshot.getChildrenCount(); i++) {
                    for (DataSnapshot data: dataSnapshot.getChildren()){
                        //String key = data.getKey();
                        String value = data.getValue().toString();
                        Button buttonAnswer;
                        buttonAnswer = (Button) findViewById(id_button[i]);
                        String mean = data.getValue().toString();
                        if(mean != null) {
                            buttonAnswer.setText(mean);
                            Log.e("AAA", mean+"");
                        }

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });

    }
}
