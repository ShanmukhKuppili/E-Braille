package gpt_masb.project.e_braille;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    private TextView scoreEdit,resultMsg;
    private Button restartButton,nextButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        int score = i.getIntExtra("Score",  0);
        int stageNo = i.getIntExtra("stageNo",  0);

        SharedPreferences sharedPreferences = getSharedPreferences("Challenge Module", MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        int currentStage = sharedPreferences.getInt("Current Stage", 0);
        if(stageNo > currentStage && score >= 800){
            ed.putInt("Current Stage", stageNo);
        }
        ed.putInt("Score"+stageNo, score);
        ed.apply();

        scoreEdit = findViewById(R.id.scoreEdit);
        resultMsg = findViewById(R.id.resultMsg);
        restartButton = findViewById(R.id.restartButton);
        nextButton = findViewById(R.id.nextButton2);
        exitButton = findViewById(R.id.exitButton2);

        scoreEdit.setText(score+"/1000");

        if(stageNo == 10){
            nextButton.setVisibility(View.GONE);
            ViewGroup.MarginLayoutParams layoutParams1 = (ViewGroup.MarginLayoutParams) exitButton.getLayoutParams();
            layoutParams1.setMarginStart(440);
            layoutParams1.topMargin = 1340;
            exitButton.setLayoutParams(layoutParams1);
        }
        if(score>= 800){
            resultMsg.setText("You have unlocked next Stage");
            resultMsg.setTextColor(Color.GREEN);
            nextButton.setOnClickListener(view -> {
                Intent i1 = new Intent(this, StageIntro.class);
                i1.putExtra("stageNo", stageNo + 1);
                startActivity(i1);
                finish();
            });
        }
        else{
            resultMsg.setText("Try again");
            resultMsg.setTextColor(Color.RED);
            nextButton.setEnabled(false);
        }
        restartButton.setOnClickListener(view -> {
            Intent i1 = new Intent(this, StageIntro.class);
            i1.putExtra("stageNo",stageNo);
            startActivity(i1);
            finish();
        });
        exitButton.setOnClickListener(view -> {
            Intent i1 = new Intent(this, Challenge.class);
            startActivity(i1);
            finish();
        });
    }
}