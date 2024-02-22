package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StageIntro extends AppCompatActivity {
    int stageNo;
    TextView stageNoText;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_intro);

        Intent restart = getIntent();
        stageNo = restart.getIntExtra("stageNo",  0);

        stageNoText = findViewById(R.id.stageNoText);
        stageNoText.setText("Stage:"+stageNo);

        start = findViewById(R.id.start);
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
    }
}