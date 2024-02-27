package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class StageIntro extends AppCompatActivity {
    int stageNo;
    TextView stageNoText,desText;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_intro);

        Intent restart = getIntent();
        stageNo = restart.getIntExtra("stageNo",  0);
        stageNoText = findViewById(R.id.stageNoText);
        desText = findViewById(R.id.desText);
        stageNoText.setText("Stage:"+stageNo);
        start = findViewById(R.id.start);
        String desTextS = "";
        if(stageNo == 1)
            desTextS = "Braille - To - Alphabets";
        else if(stageNo == 2)
            desTextS = "Alphabets - To - Braille";
        else if(stageNo == 3)
            desTextS = "5 Braille - To - 5 Alphabets";
        else if(stageNo == 4)
            desTextS = "5 Alphabets - To - 5 Braille";
        else if(stageNo == 5)
            desTextS = "Braille - To - Numbers";
        else if(stageNo == 6)
            desTextS = "Numbers - To - Braille";
        else if(stageNo == 7)
            desTextS = "5 Braille - To - 5 Numbers";
        else if(stageNo == 8)
            desTextS = "5 Numbers - To - 5 Braille";
        else if(stageNo == 9)
            desTextS = "Braille - To - Punctuation";
        else if(stageNo == 10)
            desTextS = "Punctuation - To - Braille";

        desText.setText(desTextS);

        start.setOnClickListener(view->{
            if(stageNo%2 != 0){
                Intent i1 = new Intent(this, quiztext.class);
                i1.putExtra("stageNo",stageNo);
                startActivity(i1);
                finish();
            }
            else{
                Intent i1 = new Intent(this, quiz.class);
                i1.putExtra("stageNo",stageNo);
                startActivity(i1);
                finish();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Stage "+stageNo);
        }
    }
}