package gpt_masb.project.e_braille;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

public class Challenge extends AppCompatActivity {

    private Button stage1, stage2, stage3, stage4, stage5, stage6, stage7, stage8, stage9, stage10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Challenge");
        }

        stage1 = findViewById(R.id.Stage1);
        stage2 = findViewById(R.id.Stage2);
        stage3 = findViewById(R.id.Stage3);
        stage4 = findViewById(R.id.Stage4);
        stage5 = findViewById(R.id.Stage5);
        stage6 = findViewById(R.id.Stage6);
        stage7 = findViewById(R.id.Stage7);
        stage8 = findViewById(R.id.Stage8);
        stage9 = findViewById(R.id.Stage9);
        stage10 = findViewById(R.id.Stage10);

        stage1.setOnClickListener(view ->{
            Intent i=new Intent(this, StageIntro.class);
            i.putExtra("stageNo", 1);
            startActivity(i);
            finish();
        } );
        stage2.setOnClickListener(view ->{
            Intent i=new Intent(this, StageIntro.class);
            i.putExtra("stageNo", 2);
            startActivity(i);
            finish();
        } );
        stage3.setOnClickListener(view ->{
            Intent i=new Intent(this, StageIntro.class);
            i.putExtra("stageNo", 3);
            startActivity(i);
            finish();
        } );
        stage4.setOnClickListener(view ->{
            Intent i=new Intent(this, StageIntro.class);
            i.putExtra("stageNo", 4);
            startActivity(i);
            finish();
        } );
        stage5.setOnClickListener(view ->{
            Intent i=new Intent(this, StageIntro.class);
            i.putExtra("stageNo", 5);
            startActivity(i);
            finish();
        } );
        stage6.setOnClickListener(view ->{
            Intent i=new Intent(this, StageIntro.class);
            i.putExtra("stageNo", 6);
            startActivity(i);
            finish();
        } );
        stage7.setOnClickListener(view ->{
            Intent i=new Intent(this, StageIntro.class);
            i.putExtra("stageNo", 7);
            startActivity(i);
            finish();
        } );
        stage8.setOnClickListener(view ->{
            Intent i=new Intent(this, StageIntro.class);
            i.putExtra("stageNo", 8);
            startActivity(i);
            finish();
        } );

        stage9.setOnClickListener(view ->{
            Intent i=new Intent(this, quiztext.class);
            i.putExtra("stageNo", 9);
            startActivity(i);
            finish();
        } );
        stage10.setOnClickListener(view ->{
            Intent i=new Intent(this, quiz.class);
            i.putExtra("stageNo", 10);
            startActivity(i);
            finish();
        } );

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}