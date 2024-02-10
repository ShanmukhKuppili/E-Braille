package gpt_masb.project.e_braille;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PracticeEnglishCharacters extends AppCompatActivity {
    ImageView position0, position1, position2, position3, position4, position5;
    EditText enteredChar;
    ArrayList<Character> charactersList;
    Map<Character, int[]> allCharMap;
    int currentCharIndex;
    int[] curCharArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_english_characters);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Learn Braille");
        }

        enteredChar = findViewById(R.id.enteredChar);
        position0 = findViewById(R.id.position0);
        position1 = findViewById(R.id.position1);
        position2 = findViewById(R.id.position2);
        position3 = findViewById(R.id.position3);
        position4 = findViewById(R.id.position4);
        position5 = findViewById(R.id.position5);



        BrailleScript brailleScript = new BrailleScript();
        allCharMap = brailleScript.getAlphabetsMap();
        allCharMap.putAll(brailleScript.getNumbersMap());

        charactersList = new ArrayList<>(brailleScript.getAlphabetsMap().keySet());

        charactersList.addAll(new ArrayList<>(brailleScript.getNumbersMap().keySet()));

        Log.d("characterlist braille", charactersList.toString());

        if (currentCharIndex == 26) {
            enteredChar.setInputType(InputType.TYPE_CLASS_NUMBER);
            TextView question = (TextView) findViewById(R.id.question);
            question.setText("Enter Number for above Braille Character");
        } else if (currentCharIndex == charactersList.size() - 1) {
            Button next = (Button) findViewById(R.id.nextButton);
            next.setText("Done");
        }

        curCharArr = allCharMap.getOrDefault(charactersList.get(currentCharIndex), new int[]{0});
        assert curCharArr != null;
        if (curCharArr.length == 6) {
            setCurBrailleChar(curCharArr);

            findViewById(R.id.nextButton).setOnClickListener(v -> {
                String enteredCharacter = enteredChar.getText().toString().toLowerCase();
                if (!enteredCharacter.isEmpty()) {

                    if (charactersList.contains(enteredCharacter.charAt(0))){
                        int[] enteredCharArr = allCharMap.getOrDefault(enteredCharacter.charAt(0), new int[]{0});

                        if (Arrays.equals(enteredCharArr, curCharArr)) {
                            currentCharIndex++;
                            savePracticeData(currentCharIndex);

                            if (currentCharIndex == charactersList.size() - 1) {
                                Button next = (Button) v;
                                next.setText("Done");
                            }

                            if (currentCharIndex == charactersList.size()) {
                                Toast.makeText(this, "Congrats! You have completed this practice module.", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                curCharArr = allCharMap.getOrDefault(charactersList.get(currentCharIndex), new int[]{0});
                                setCurBrailleChar(curCharArr);
                                enteredChar.setText("");
                            }

                            if (currentCharIndex == 26) {
                                enteredChar.setInputType(InputType.TYPE_CLASS_NUMBER);
                                TextView question = (TextView) findViewById(R.id.question);
                                question.setText("Enter Number for above Braille Character");
                            }
                        } else {
                            Toast.makeText(this, "Incorrect Character for above Braille!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Invalid character!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Enter the character!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "No char available!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void setCurBrailleChar(int[] arrBraille) {
        ImageView[] dots = {position0, position1, position2, position3, position4, position5};
        for (int i = 0; i < arrBraille.length; i++) {
            if(arrBraille[i] == 0) {
                dots[i].setBackgroundResource(R.drawable.round_image_white);
            } else {
                dots[i].setBackgroundResource(R.drawable.round_image_black);
            }
        }
    }

    private void getPracticeHistory() {
        SharedPreferences sharedPreferences = getSharedPreferences("Practice Module", MODE_PRIVATE);
        currentCharIndex = sharedPreferences.getInt("Practice 2", 0);
    }

    private void savePracticeData(int currentCharIndex) {
        SharedPreferences.Editor ed = getSharedPreferences("Practice Module", MODE_PRIVATE).edit();
        ed.putInt("Practice 2", currentCharIndex);
        ed.apply();
    }
}