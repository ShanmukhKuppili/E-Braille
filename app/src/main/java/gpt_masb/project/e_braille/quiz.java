package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class quiz extends AppCompatActivity {

    ImageView black1, white1, black2, white2, black3, white3, black4, white4, black5, white5, black6, white6, nextButton, pauseButton;
    Button restartButton2, resumeButton, exitButton;
    ConstraintLayout dialog_box;
    TextView questionText, scoreText, qNoText, answerView, stageNoT;
    int[] ar = new int[]{0, 0, 0, 0, 0, 0};
    private HashMap<String, String> brailleMap;
    int score, qNo, stageNo, question_count = 0, x = 0;
    String qText, key ,ans = "";
    char q[] = new char[5];
    Map<String, int[]> hashMap;
    private TextView timerTextView;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    public static long COUNTDOWN_IN_MILLIS, left_time;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent restart = getIntent();
        stageNo = restart.getIntExtra("stageNo", 0);

        stageNoT = findViewById(R.id.stageNoT);

        stageNoT.setText("Stage " + stageNo);

        hashMap = new HashMap<>();
        int[] aArray = {1, 0, 0, 0, 0, 0};
        int[] bArray = {1, 1, 0, 0, 0, 0};
        int[] cArray = {1, 0, 0, 1, 0, 0};
        int[] dArray = {1, 0, 0, 1, 1, 0};
        int[] eArray = {1, 0, 0, 0, 1, 0};
        int[] fArray = {1, 1, 0, 1, 0, 0};
        int[] gArray = {1, 1, 0, 1, 1, 0};
        int[] hArray = {1, 1, 0, 0, 1, 0};
        int[] iArray = {0, 1, 0, 1, 0, 0};
        int[] jArray = {0, 1, 0, 1, 1, 0};
        int[] kArray = {1, 0, 1, 0, 0, 0};
        int[] lArray = {1, 1, 1, 0, 0, 0};
        int[] mArray = {1, 0, 1, 1, 0, 0};
        int[] nArray = {1, 0, 1, 1, 1, 0};
        int[] oArray = {1, 0, 1, 0, 1, 0};
        int[] pArray = {1, 1, 1, 1, 0, 0};
        int[] qArray = {1, 1, 1, 1, 1, 0};
        int[] rArray = {1, 1, 1, 0, 1, 0};
        int[] sArray = {0, 1, 1, 1, 0, 0};
        int[] tArray = {0, 1, 1, 1, 1, 0};
        int[] uArray = {1, 0, 1, 0, 0, 1};
        int[] vArray = {1, 1, 1, 0, 0, 1};
        int[] wArray = {0, 1, 0, 1, 1, 1};
        int[] xArray = {1, 0, 1, 1, 0, 1};
        int[] yArray = {1, 0, 1, 1, 1, 1};
        int[] zArray = {1, 0, 1, 0, 1, 1};

        int[] numberArray = {0, 0, 1, 1, 1, 1};

        brailleMap = new HashMap<>();

        if (stageNo == 2 || stageNo == 4) {
            brailleMap.put("a", "⠁");
            brailleMap.put("b", "⠃");
            brailleMap.put("c", "⠉");
            brailleMap.put("d", "⠙");
            brailleMap.put("e", "⠑");
            brailleMap.put("f", "⠋");
            brailleMap.put("g", "⠛");
            brailleMap.put("h", "⠓");
            brailleMap.put("i", "⠊");
            brailleMap.put("j", "⠚");
            brailleMap.put("k", "⠅");
            brailleMap.put("l", "⠇");
            brailleMap.put("m", "⠍");
            brailleMap.put("n", "⠝");
            brailleMap.put("o", "⠕");
            brailleMap.put("p", "⠏");
            brailleMap.put("q", "⠟");
            brailleMap.put("r", "⠗");
            brailleMap.put("s", "⠎");
            brailleMap.put("t", "⠞");
            brailleMap.put("u", "⠥");
            brailleMap.put("v", "⠧");
            brailleMap.put("w", "⠺");
            brailleMap.put("x", "⠭");
            brailleMap.put("y", "⠽");
            brailleMap.put("z", "⠵");

            hashMap.put("a", aArray);
            hashMap.put("b", bArray);
            hashMap.put("c", cArray);
            hashMap.put("d", dArray);
            hashMap.put("e", eArray);
            hashMap.put("f", fArray);
            hashMap.put("g", gArray);
            hashMap.put("h", hArray);
            hashMap.put("i", iArray);
            hashMap.put("j", jArray);
            hashMap.put("k", kArray);
            hashMap.put("l", lArray);
            hashMap.put("m", mArray);
            hashMap.put("n", nArray);
            hashMap.put("o", oArray);
            hashMap.put("p", pArray);
            hashMap.put("q", qArray);
            hashMap.put("r", rArray);
            hashMap.put("s", sArray);
            hashMap.put("t", tArray);
            hashMap.put("u", uArray);
            hashMap.put("v", vArray);
            hashMap.put("w", wArray);
            hashMap.put("x", xArray);
            hashMap.put("y", yArray);
            hashMap.put("z", zArray);
        } else if (stageNo == 6 || stageNo == 8) {
            brailleMap.put("1", "⠁");
            brailleMap.put("2", "⠃");
            brailleMap.put("3", "⠉");
            brailleMap.put("4", "⠙");
            brailleMap.put("5", "⠑");
            brailleMap.put("6", "⠋");
            brailleMap.put("7", "⠛");
            brailleMap.put("8", "⠓");
            brailleMap.put("9", "⠊");
            brailleMap.put("0", "⠚");

            hashMap.put("0", jArray);
            hashMap.put("1", aArray);
            hashMap.put("2", bArray);
            hashMap.put("3", cArray);
            hashMap.put("4", dArray);
            hashMap.put("5", eArray);
            hashMap.put("6", fArray);
            hashMap.put("7", gArray);
            hashMap.put("8", hArray);
            hashMap.put("9", iArray);
            hashMap.put("n", numberArray);
            x = 0;
        } else if (stageNo == 10) {
            int[] comma = {0, 0, 0, 1, 1, 0};
            int[] period = {0, 1, 0, 0, 1, 0};
            int[] question = {0, 1, 1, 0, 1, 0};
            int[] exclamation = {0, 1, 1, 1, 0, 0};
            int[] semicolon = {0, 1, 0, 1, 0, 0};
            int[] colon = {0, 1, 1, 0, 0, 0};
            int[] dash = {0, 0, 0, 0, 1, 1};
            int[] hyphen = {0, 0, 0, 0, 1, 0};
            int[] ellipsis = {0, 1, 0, 1, 0, 1};  // Represents "..."
            int[] singleQuote = {0, 0, 0, 0, 1, 0};
            int[] doubleQuote = {0, 0, 0, 1, 1, 1};
            int[] openParenthesis = {1, 0, 1, 0, 1, 0};
            int[] closeParenthesis = {0, 1, 0, 1, 0, 1};
            int[] slash = {0, 0, 1, 0, 0, 1};
            int[] backslash = {1, 0, 0, 1, 0, 0};
            int[] ampersand = {0, 1, 1, 1, 0, 1};
            int[] atSymbol = {0, 1, 1, 0, 1, 1};
            int[] hashSymbol = {1, 0, 1, 0, 1, 1};
            int[] percent = {1, 0, 0, 0, 1, 1};
            int[] dollar = {0, 1, 0, 0, 0, 1};
            int[] euro = {1, 0, 1, 1, 0, 1};
            int[] pound = {1, 0, 1, 0, 0, 1};
            int[] yen = {0, 1, 0, 1, 1, 1};

            hashMap.put(",", comma);
            hashMap.put(".", period);
            hashMap.put("?", question);
            hashMap.put("!", exclamation);
            hashMap.put(";", semicolon);
            hashMap.put(":", colon);
            hashMap.put("-", dash);
            hashMap.put("-", hyphen);
            hashMap.put("...", ellipsis);
            hashMap.put("'", singleQuote);
            hashMap.put("\"", doubleQuote);
            hashMap.put("(", openParenthesis);
            hashMap.put(")", closeParenthesis);
            hashMap.put("/", slash);
            hashMap.put("\\", backslash);
            hashMap.put("&", ampersand);
            hashMap.put("@", atSymbol);
            hashMap.put("#", hashSymbol);
            hashMap.put("%", percent);
            hashMap.put("$", dollar);
            hashMap.put("€", euro);
            hashMap.put("£", pound);
            hashMap.put("¥", yen);
        }

        black1 = findViewById(R.id.black1);
        white1 = findViewById(R.id.white1);
        black2 = findViewById(R.id.black2);
        white2 = findViewById(R.id.white2);
        black3 = findViewById(R.id.black3);
        white3 = findViewById(R.id.white3);
        black4 = findViewById(R.id.black4);
        white4 = findViewById(R.id.white4);
        black5 = findViewById(R.id.black5);
        white5 = findViewById(R.id.white5);
        black6 = findViewById(R.id.black6);
        white6 = findViewById(R.id.white6);

        pauseButton = findViewById(R.id.pauseButton);
        nextButton = findViewById(R.id.nextButton);

        questionText = findViewById(R.id.questionText);
        scoreText = findViewById(R.id.scoreText);
        qNoText = findViewById(R.id.qNoText);
        answerView = findViewById(R.id.answerView);

        dialog_box = findViewById(R.id.dialog_box);
        restartButton2 = findViewById(R.id.restartButton2);
        resumeButton = findViewById(R.id.resumemButton);
        exitButton = findViewById(R.id.exitButton);

        timerTextView = findViewById(R.id.timer);

        black1.setOnClickListener(view -> {
            black1.setVisibility(View.INVISIBLE);
            white1.setVisibility(View.VISIBLE);
            ar[0] = 0;
        });
        white1.setOnClickListener(view -> {
            white1.setVisibility(View.INVISIBLE);
            black1.setVisibility(View.VISIBLE);
            ar[0] = 1;
        });

        black2.setOnClickListener(view -> {
            black2.setVisibility(View.INVISIBLE);
            white2.setVisibility(View.VISIBLE);
            ar[1] = 0;
        });
        white2.setOnClickListener(view -> {
            white2.setVisibility(View.INVISIBLE);
            black2.setVisibility(View.VISIBLE);
            ar[1] = 1;
        });

        black3.setOnClickListener(view -> {
            black3.setVisibility(View.INVISIBLE);
            white3.setVisibility(View.VISIBLE);
            ar[2] = 0;
        });
        white3.setOnClickListener(view -> {
            white3.setVisibility(View.INVISIBLE);
            black3.setVisibility(View.VISIBLE);
            ar[2] = 1;
        });

        black4.setOnClickListener(view -> {
            black4.setVisibility(View.INVISIBLE);
            white4.setVisibility(View.VISIBLE);
            ar[3] = 0;
        });
        white4.setOnClickListener(view -> {
            white4.setVisibility(View.INVISIBLE);
            black4.setVisibility(View.VISIBLE);
            ar[3] = 1;
        });

        black5.setOnClickListener(view -> {
            black5.setVisibility(View.INVISIBLE);
            white5.setVisibility(View.VISIBLE);
            ar[4] = 0;
        });
        white5.setOnClickListener(view -> {
            white5.setVisibility(View.INVISIBLE);
            black5.setVisibility(View.VISIBLE);
            ar[4] = 1;
        });

        black6.setOnClickListener(view -> {
            black6.setVisibility(View.INVISIBLE);
            white6.setVisibility(View.VISIBLE);
            ar[5] = 0;
        });
        white6.setOnClickListener(view -> {
            white6.setVisibility(View.INVISIBLE);
            black6.setVisibility(View.VISIBLE);
            ar[5] = 1;
        });

        dialog_box.setVisibility(View.INVISIBLE);
        pauseButton.setOnClickListener(view -> {
            dialog_box.setVisibility(View.VISIBLE);
            resumeButton.setOnClickListener(v -> {
                dialog_box.setVisibility(View.INVISIBLE);
            });
            restartButton2.setOnClickListener(v2 -> {
                Intent i1 = new Intent(this, StageIntro.class);
                i1.putExtra("stageNo", stageNo);
                startActivity(i1);
                finish();
            });
            exitButton.setOnClickListener(v3 -> {
                Intent i1 = new Intent(this, MainActivity.class);
                startActivity(i1);
                finish();
            });
        });
        startTimer();
        displayQuestion();
        nextButton.setOnClickListener(view -> {
            updateScore();
            reset();
            if (qNo < 10) {
                if (stageNo == 2 || stageNo == 10) {
                    COUNTDOWN_IN_MILLIS = 10000;
                    cancelTimer();
                    startTimer();
                    displayQuestion();
                }
                if (stageNo == 6) {
                    if (x == 0) {
                        COUNTDOWN_IN_MILLIS = 10000;
                        cancelTimer();
                        startTimer();
                        displayQuestion();
                    }
                }
                if (stageNo == 4 || stageNo == 8) {
                    if (x % 6 == 0) {
                        COUNTDOWN_IN_MILLIS = 40000;
                        cancelTimer();
                        startTimer();
                        ans = "";
                        answerView.setText(ans);
                        displayQuestion();
                    }
                }
            } else {
                Intent i = new Intent(this, Result.class);
                i.putExtra("Score", score);
                i.putExtra("stageNo", stageNo);
                startActivity(i);
                finish();
            }
        });
    }
    int c = 0;
    public void updateScore() {
        key = getKeyByValue(hashMap, ar);
        if (stageNo == 2 || stageNo == 10) {
            if (qText.equals(key)) {
                if( left_time >= 6000)
                    score += 100;
                else if(left_time >= 5000)
                    score += 90;
                else if(left_time >= 4000)
                    score += 70;
                else if (left_time >= 1000)
                    score += 40;
//                score += 100;
            }
        }
        if (stageNo == 6) {
            if (x == 0) {
                if (qText.equals(key)) {
                    if( left_time >= 6000)
                        score += 100;
                    else if(left_time >= 5000)
                        score += 90;
                    else if(left_time >= 4000)
                        score += 70;
                    else if (left_time >= 1000)
                        score += 40;
//                    score += 100;
                }
            } else {
                if ("n".equals(key))
                    x = 0;
            }
        }
        if (stageNo == 4 || stageNo == 8) {
            String value = getValueByKey(brailleMap, key);
            if(value == null)
                ans += " ";
            else
                ans += value;
            answerView.setText(ans);
            if (x % 6 != 0) {
                x += 1;
                if (String.valueOf(q[x - 2]).equals(key))
                    c += 1;
            }
            if (x == 6 && c == 5){
                if( left_time >= 30000)
                    score += 100;
                else if(left_time >= 20000)
                    score += 90;
                else if(left_time >= 10000)
                    score += 70;
                else if (left_time >= 5000)
                    score += 40;
//                score += 100;
            }
        }
//        if(score )
        scoreText.setText(" " + score);
    }
    private String LoadQuestion() {
        String question = "";
        List<String> quesList = new ArrayList<>(hashMap.keySet());
        Collections.shuffle(quesList);
        if (stageNo == 2 || stageNo == 6)
            question = quesList.get(0);
        else if (stageNo == 4 || stageNo == 8) {
            for (int i = 0; i < 5; i++) {
                question += quesList.get(i);
                q[i] = quesList.get(i).charAt(0);
            }
        }
        return question;
    }
    private void displayQuestion() {
        qText = LoadQuestion();
        questionText.setText("" + qText);
        qNo = question_count + 1;
        qNoText.setText("" + qNo + "/10");
        question_count++;
        x = 1;
        c = 0;
    }
    private static <K, V> V getValueByKey(Map<K, V> map, K key) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }
    private static <K, V> K getKeyByValue(Map<K, V> map, V value) {

        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Arrays.equals((int[]) entry.getValue(), (int[]) value)) {
                return entry.getKey();
            }
        }
        return null;
    }
    private void reset() {
        Arrays.fill(ar, 0);
        white1.setVisibility(View.VISIBLE);
        white2.setVisibility(View.VISIBLE);
        white3.setVisibility(View.VISIBLE);
        white4.setVisibility(View.VISIBLE);
        white5.setVisibility(View.VISIBLE);
        white6.setVisibility(View.VISIBLE);
        black1.setVisibility(View.INVISIBLE);
        black2.setVisibility(View.INVISIBLE);
        black3.setVisibility(View.INVISIBLE);
        black4.setVisibility(View.INVISIBLE);
        black5.setVisibility(View.INVISIBLE);
        black6.setVisibility(View.INVISIBLE);
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