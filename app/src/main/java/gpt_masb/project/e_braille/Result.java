package gpt_masb.project.e_braille;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

        scoreEdit = findViewById(R.id.scoreEdit);
        resultMsg = findViewById(R.id.resultMsg);
        restartButton = findViewById(R.id.restartButton);
        nextButton = findViewById(R.id.nextButton2);
        exitButton = findViewById(R.id.exitButton2);

        scoreEdit.setText(score+"/1000");
        if(score>= 800){
            resultMsg.setText("You have unlocked next Stage");
            resultMsg.setTextColor(Color.GREEN);
        }
        else{
            resultMsg.setText("Try again");
            resultMsg.setTextColor(Color.RED);
        }
        restartButton.setOnClickListener(view -> {
            Intent i1 = new Intent(this, StageIntro.class);
            i1.putExtra("stageNo",stageNo);
            startActivity(i1);
            finish();
        });
        nextButton.setOnClickListener(view -> {
            Intent i1 = new Intent(this, StageIntro.class);
            i1.putExtra("stageNo",stageNo+1);
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