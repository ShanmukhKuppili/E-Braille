package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class quiztext extends AppCompatActivity {
    ConstraintLayout dialog_box;
    ImageView nextButton, pauseButton, answerImage1, answerImage2, answerImage3, answerImage4, answerImage5;
    Button restartButton2, resumeButton, exitButton;
    TextView scoreText, qNoText, stageNoT, timerTextView;
    EditText answerText;
    HashMap<String, Integer> hashMap2;
    CountDownTimer countDownTimer;
    String answer, key;
    long timeLeftInMillis, COUNTDOWN_IN_MILLIS, left_time;
    int score, qNo, stageNo, question_count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiztext);

        Intent restart = getIntent();
        stageNo = restart.getIntExtra("stageNo", 0);

        hashMap2 = new HashMap<>();

        nextButton = findViewById(R.id.nextButton);
        qNoText = findViewById(R.id.qNoText);
        scoreText = findViewById(R.id.scoreText);
        answerText = findViewById(R.id.answerText);
        answerImage1 = findViewById(R.id.answerImage1);
        answerImage2 = findViewById(R.id.answerImage2);
        answerImage3 = findViewById(R.id.answerImage3);
        answerImage4 = findViewById(R.id.answerImage4);
        answerImage5 = findViewById(R.id.answerImage5);

        pauseButton = findViewById(R.id.pauseButton);
        dialog_box = findViewById(R.id.dialog_box);
        restartButton2 = findViewById(R.id.restartButton2);
        resumeButton = findViewById(R.id.resumemButton);
        exitButton = findViewById(R.id.exitButton);
        timerTextView = findViewById(R.id.timer);

        stageNoT = findViewById(R.id.stageNoT);
        stageNoT.setText("Stage " + stageNo);

        if (stageNo == 1 || stageNo == 9) {
            answerImage1.setVisibility(View.INVISIBLE);
            answerImage2.setVisibility(View.VISIBLE);
            answerImage3.setVisibility(View.INVISIBLE);
            answerImage4.setVisibility(View.INVISIBLE);
            answerImage5.setVisibility(View.INVISIBLE);

            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) answerImage2.getLayoutParams();
            layoutParams.setMarginStart(350);
            answerImage2.setLayoutParams(layoutParams);
        }
        else if (stageNo == 5) {
            answerImage1.setVisibility(View.VISIBLE);
            answerImage2.setVisibility(View.VISIBLE);
            answerImage3.setVisibility(View.INVISIBLE);
            answerImage4.setVisibility(View.INVISIBLE);
            answerImage5.setVisibility(View.INVISIBLE);

            ViewGroup.MarginLayoutParams layoutParams1 = (ViewGroup.MarginLayoutParams) answerImage1.getLayoutParams();
            layoutParams1.setMarginStart(270);
            answerImage1.setLayoutParams(layoutParams1);

            ViewGroup.MarginLayoutParams layoutParams2 = (ViewGroup.MarginLayoutParams) answerImage2.getLayoutParams();
            layoutParams2.setMarginStart(450);
            answerImage2.setLayoutParams(layoutParams2);
        }

        else if (stageNo == 3) {
            answerImage1.setVisibility(View.VISIBLE);
            answerImage2.setVisibility(View.VISIBLE);
            answerImage3.setVisibility(View.VISIBLE);
            answerImage4.setVisibility(View.VISIBLE);
            answerImage5.setVisibility(View.VISIBLE);
        }

        if (stageNo == 1 || stageNo == 3) {
            hashMap2.put("a", R.drawable.a);
            hashMap2.put("b", R.drawable.b);
            hashMap2.put("c", R.drawable.c);
            hashMap2.put("d", R.drawable.d);
            hashMap2.put("e", R.drawable.e);
            hashMap2.put("f", R.drawable.f);
            hashMap2.put("g", R.drawable.g);
            hashMap2.put("h", R.drawable.h);
            hashMap2.put("i", R.drawable.i);
            hashMap2.put("j", R.drawable.j);
            hashMap2.put("k", R.drawable.k);
            hashMap2.put("l", R.drawable.l);
            hashMap2.put("m", R.drawable.m);
            hashMap2.put("n", R.drawable.n);
            hashMap2.put("o", R.drawable.o);
            hashMap2.put("p", R.drawable.p);
            hashMap2.put("q", R.drawable.q);
            hashMap2.put("r", R.drawable.r);
            hashMap2.put("s", R.drawable.s);
            hashMap2.put("t", R.drawable.t);
            hashMap2.put("u", R.drawable.u);
            hashMap2.put("v", R.drawable.v);
            hashMap2.put("w", R.drawable.w);
            hashMap2.put("x", R.drawable.x);
            hashMap2.put("y", R.drawable.y);
            hashMap2.put("z", R.drawable.z);
            answerText.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        if (stageNo == 5 || stageNo == 7) {
            hashMap2.put("1", R.drawable.a);
            hashMap2.put("2", R.drawable.b);
            hashMap2.put("3", R.drawable.c);
            hashMap2.put("4", R.drawable.d);
            hashMap2.put("5", R.drawable.e);
            hashMap2.put("6", R.drawable.f);
            hashMap2.put("7", R.drawable.g);
            hashMap2.put("8", R.drawable.h);
            hashMap2.put("9", R.drawable.i);
            hashMap2.put("0", R.drawable.j);
            answerText.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        if (stageNo == 9){
            hashMap2.put(".", R.drawable.fullstop);
            hashMap2.put(";", R.drawable.semicolon);
            hashMap2.put("!", R.drawable.exclamation);
            hashMap2.put("?", R.drawable.questionmark);
            hashMap2.put("-", R.drawable.dash);
            hashMap2.put("#", R.drawable.hash);
            hashMap2.put("'", R.drawable.apostrophe);
            hashMap2.put("@", R.drawable.attherate);
            hashMap2.put("=", R.drawable.equalto);
            hashMap2.put("<", R.drawable.lessthan);
            hashMap2.put(">", R.drawable.attherate);
            answerText.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        dialog_box.setVisibility(View.INVISIBLE);
        pauseButton.setOnClickListener(view -> {
            cancelTimer();
            dialog_box.setVisibility(View.VISIBLE);
            resumeButton.setOnClickListener(v -> {
                dialog_box.setVisibility(View.INVISIBLE);
                COUNTDOWN_IN_MILLIS = left_time;
                startTimer();
                setTime();
            });
            restartButton2.setOnClickListener(v2 -> {
                Intent i1 = new Intent(this, StageIntro.class);
                i1.putExtra("stageNo", stageNo);
                startActivity(i1);
                finish();
            });
            exitButton.setOnClickListener(v3 -> {
                Intent i1 = new Intent(this, Challenge.class);
                startActivity(i1);
                finish();
            });
        });
        displayQuestion();
        startTimer();
        nextButton.setOnClickListener(view -> {
            check();
        });
    }
    public void check(){
        if(qNo == 10) {
            cancelTimer();
            Intent i = new Intent(this, Result.class);
            i.putExtra("Score", score);
            i.putExtra("stageNo", stageNo);
            startActivity(i);
            finish();
        }
        else {
            cancelTimer();
            startTimer();
            answer = answerText.getText().toString();
            updateScore();
            displayQuestion();
        }
    }
    public void setTime(){
        if(stageNo == 1 || stageNo == 5 || stageNo == 9)
            COUNTDOWN_IN_MILLIS = 10000;
        else
            COUNTDOWN_IN_MILLIS = 40000;
    }
    public void updateScore() {
        if(stageNo == 1 || stageNo == 5 || stageNo == 9) {
            if (answer != null && answer.equals(key)) {
                Toast.makeText(quiztext.this, "correct",Toast.LENGTH_SHORT).show();
                if( left_time >= 6000)
                    score += 100;
                else if(left_time >= 5000)
                    score += 90;
                else if(left_time >= 4000)
                    score += 70;
                else if (left_time >= 1000)
                    score += 40;
                else
                    score += 30;
            }
            else
                Toast.makeText(quiztext.this, "incorrect", Toast.LENGTH_SHORT).show();
        }
        else if(stageNo == 3 || stageNo == 7){
            if (answer != null && answer.equals(key)) {
                Toast.makeText(quiztext.this, "correct",Toast.LENGTH_SHORT).show();
                if( left_time >= 30000)
                    score += 100;
                else if(left_time >= 25000)
                    score += 95;
                else if(left_time >= 20000)
                    score += 90;
                else if (left_time >= 10000)
                    score += 80;
                else if (left_time >= 5000)
                    score += 70;
                else
                    score += 40;
            }
            else
                Toast.makeText(quiztext.this, "incorrect", Toast.LENGTH_SHORT).show();
        }
        scoreText.setText("" + score);
        answerText.setText("");
    }
    private void LoadQuestion() {
        List<Integer> quesList = new ArrayList<>(hashMap2.values());
        Collections.shuffle(quesList);
        if(stageNo == 1 || stageNo == 5 || stageNo == 9) {
            answerImage2.setImageResource(quesList.get(0));
            key = getKeyByValue(hashMap2, quesList.get(0));
//            Toast.makeText(quiztext.this, key,Toast.LENGTH_SHORT).show();
        }
        if(stageNo == 3 || stageNo == 7) {
            if(stageNo == 3)
                answerImage1.setImageResource(quesList.get(0));
            answerImage2.setImageResource(quesList.get(1));
            answerImage3.setImageResource(quesList.get(2));
            answerImage4.setImageResource(quesList.get(3));
            answerImage5.setImageResource(quesList.get(4));
            key = "";
            for (int i = 0; i < 5; i++)
                key += getKeyByValue(hashMap2, quesList.get(i));
        }
    }
    private void displayQuestion() {
        LoadQuestion();
        qNo = question_count + 1;
        qNoText.setText(qNo + "/10");
        question_count++;
        setTime();
    }
    private static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
    private void startTimer() {
        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                timerTextView.setText("Time's up!");
                updateScore();
                check();
            }
        }.start();
    }
    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        timerTextView.setText(timeLeftFormatted);
    }
    private void cancelTimer() {
        if (countDownTimer != null) {
            left_time = timeLeftInMillis;
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelTimer();
    }
}