package gpt_masb.project.e_braille;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class PracticeBrailleCharacters extends AppCompatActivity {
    TextView character;
    ImageView position0, position1, position2, position3, position4, position5;
    int[] brailleArr = {0, 0, 0, 0 , 0, 0};
    int currentCharIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_braille_characters);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Learn Braille");
        }

        character = findViewById(R.id.character);
        position0 = findViewById(R.id.position0);
        position1 = findViewById(R.id.position1);
        position2 = findViewById(R.id.position2);
        position3 = findViewById(R.id.position3);
        position4 = findViewById(R.id.position4);
        position5 = findViewById(R.id.position5);

        BrailleScript brailleScript = new BrailleScript();
        ArrayList<Character> charactersList = new ArrayList<>(brailleScript.getAlphabetsMap().keySet());

        charactersList.addAll(new ArrayList<>(brailleScript.getNumbersMap().keySet()));

        //Log.d("key list", charactersList.toString());
        character.setText(charactersList.get(currentCharIndex).toString());

        position0.setOnClickListener(v -> {
            if (brailleArr[0] == 0) {
                v.setBackgroundResource(R.drawable.round_image_black);
                brailleArr[0] = 1;
            } else {
                v.setBackgroundResource(R.drawable.round_image_white);
                brailleArr[0] = 0;
            }
        });

        position1.setOnClickListener(v -> {
            if (brailleArr[1] == 0) {
                v.setBackgroundResource(R.drawable.round_image_black);
                brailleArr[1] = 1;
            } else {
                v.setBackgroundResource(R.drawable.round_image_white);
                brailleArr[1] = 0;
            }
        });

        position2.setOnClickListener(v -> {
            if (brailleArr[2] == 0) {
                v.setBackgroundResource(R.drawable.round_image_black);
                brailleArr[2] = 1;
            } else {
                v.setBackgroundResource(R.drawable.round_image_white);
                brailleArr[2] = 0;
            }
        });

        position3.setOnClickListener(v -> {
            if (brailleArr[3] == 0) {
                v.setBackgroundResource(R.drawable.round_image_black);
                brailleArr[3] = 1;
            } else {
                v.setBackgroundResource(R.drawable.round_image_white);
                brailleArr[3] = 0;
            }
        });

        position4.setOnClickListener(v -> {
            if (brailleArr[4] == 0) {
                v.setBackgroundResource(R.drawable.round_image_black);
                brailleArr[4] = 1;
            } else {
                v.setBackgroundResource(R.drawable.round_image_white);
                brailleArr[4] = 0;
            }
        });

        position5.setOnClickListener(v -> {
            if (brailleArr[5] == 0) {
                v.setBackgroundResource(R.drawable.round_image_black);
                brailleArr[5] = 1;
            } else {
                v.setBackgroundResource(R.drawable.round_image_white);
                brailleArr[5] = 0;
            }
        });

        findViewById(R.id.nextButton).setOnClickListener(v -> {
            Map<Character, int[]> alphabetMap = brailleScript.getAlphabetsMap();
            Map<Character, int[]> numbericMap = brailleScript.getNumbersMap();
            if(Arrays.equals(alphabetMap.get(charactersList.get(currentCharIndex)), brailleArr) || Arrays.equals(numbericMap.get(charactersList.get(currentCharIndex)), brailleArr)) {
                currentCharIndex++;

                if (currentCharIndex == charactersList.size() - 1) {
                    Button next = (Button) v;
                    next.setText("Done");
                }

                if(currentCharIndex == charactersList.size()) {
                    Toast.makeText(this, "Congrats! You have completed this practice module.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    character.setText(charactersList.get(currentCharIndex).toString());
                    //Reset braille dot to white
                    brailleArr = new int[]{0, 0, 0, 0, 0, 0};
                    position0.setBackgroundResource(R.drawable.round_image_white);
                    position1.setBackgroundResource(R.drawable.round_image_white);
                    position2.setBackgroundResource(R.drawable.round_image_white);
                    position3.setBackgroundResource(R.drawable.round_image_white);
                    position4.setBackgroundResource(R.drawable.round_image_white);
                    position5.setBackgroundResource(R.drawable.round_image_white);
                }
            } else {
                Toast.makeText(this, "Incorrect Braille character!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}