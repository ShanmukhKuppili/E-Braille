package gpt_masb.project.e_braille;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class PracticeBrailleAlphabets extends AppCompatActivity {
    private EditText enteredChar;
    private TextView character;
    private ImageView position0, position1, position2, position3, position4, position5;
    private int[] brailleArr = {0, 0, 0, 0 , 0, 0};
    private BrailleScript brailleScript;
    Map<Character, int[]> charMap;
    private int currentCharIndex;
    private ArrayList<Character> charactersList1, charactersList2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        brailleScript = new BrailleScript();
        getPracticeHistory();

        if(currentCharIndex < charactersList1.size()) {
            setLayout(R.layout.activity_practice_braille_dots);
        } else {
            setLayout(R.layout.activity_practice_braille_text);
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    private void setLayout(int layoutResID) {
        setContentView(layoutResID);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Practice Braille (Alphabets)");
        }

        position0 = findViewById(R.id.position0);
        position1 = findViewById(R.id.position1);
        position2 = findViewById(R.id.position2);
        position3 = findViewById(R.id.position3);
        position4 = findViewById(R.id.position4);
        position5 = findViewById(R.id.position5);

        if (layoutResID == R.layout.activity_practice_braille_dots){
            character = findViewById(R.id.character);

            character.setText(charactersList1.get(currentCharIndex).toString().toUpperCase());

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
            findViewById(R.id.submit).setOnClickListener(v -> {
                Map<Character, int[]> alphabetMap = brailleScript.getAlphabetsMap();

                boolean answerStatus = Arrays.equals(alphabetMap.get(charactersList1.get(currentCharIndex)), brailleArr);

                Dialog dialogResult = new Dialog(this, R.style.dialog_window_style);
                dialogResult.setContentView(R.layout.dialog_result);
                dialogResult.setCancelable(false);
                if (!answerStatus) {
                    TextView dialogText = dialogResult.findViewById(R.id.resultText);
                    dialogText.setText("You have answered incorrectly");

                    ImageView imageView = dialogResult.findViewById(R.id.resultImage);
                    imageView.setImageResource(R.drawable.failed);

                    charactersList1.add(charactersList1.get(currentCharIndex));
                }
                dialogResult.findViewById(R.id.resultButton).setOnClickListener(v1 -> {
                    if (currentCharIndex == charactersList1.size()) {
                        Toast.makeText(this, "Congrats! You have completed this practice module part1.", Toast.LENGTH_SHORT).show();
                        currentCharIndex--;
                        setLayout(R.layout.activity_practice_braille_text);
                    } else {
                        character.setText(charactersList1.get(currentCharIndex).toString());
                        //Reset braille dot to white
                        brailleArr = new int[]{0, 0, 0, 0, 0, 0};
                        position0.setBackgroundResource(R.drawable.round_image_white);
                        position1.setBackgroundResource(R.drawable.round_image_white);
                        position2.setBackgroundResource(R.drawable.round_image_white);
                        position3.setBackgroundResource(R.drawable.round_image_white);
                        position4.setBackgroundResource(R.drawable.round_image_white);
                        position5.setBackgroundResource(R.drawable.round_image_white);
                    }
                    dialogResult.dismiss();
                });
                dialogResult.show();

                currentCharIndex++;
                savePracticeData(currentCharIndex, "Practice 1 chars1", charactersList1);
            });
        } else if (layoutResID == R.layout.activity_practice_braille_text) {
            enteredChar = findViewById(R.id.enteredChar);
            getPracticeHistory();

            charMap = brailleScript.getAlphabetsMap();

            Log.d("characterlist braille", charactersList2.toString());

            if ((currentCharIndex - charactersList2.size()) < charactersList2.size()) {
                brailleArr = charMap.getOrDefault(charactersList2.get(currentCharIndex - charactersList1.size()), new int[]{0});
                assert brailleArr != null;
                setCurBrailleChar(brailleArr);

                findViewById(R.id.submit).setOnClickListener(v -> {
                    String enteredCharacter = enteredChar.getText().toString().toLowerCase();
                    if (!enteredCharacter.isEmpty()) {
                        int[] enteredCharArr = charMap.getOrDefault(enteredCharacter.charAt(0), new int[]{0});
                        boolean answerStatus = Arrays.equals(enteredCharArr, brailleArr);

                        Dialog dialogResult = new Dialog(this, R.style.dialog_window_style);
                        dialogResult.setContentView(R.layout.dialog_result);
                        dialogResult.setCancelable(false);
                        if (!answerStatus) {
                            TextView dialogText = dialogResult.findViewById(R.id.resultText);
                            dialogText.setText("You have answered incorrectly");

                            ImageView imageView = dialogResult.findViewById(R.id.resultImage);
                            imageView.setImageResource(R.drawable.failed);

                            charactersList2.add(charactersList2.get(currentCharIndex - charactersList1.size()));
                        }
                        currentCharIndex++;
                        savePracticeData(currentCharIndex, "Practice 1 chars2", charactersList2);

                        dialogResult.findViewById(R.id.resultButton).setOnClickListener(v1 -> {
                            if ((currentCharIndex - charactersList1.size()) == charactersList2.size()) {
                                Toast.makeText(this, "Congrats! You have completed this practice module part2.", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                brailleArr = charMap.getOrDefault(charactersList2.get(currentCharIndex - charactersList1.size()), new int[]{0});
                                setCurBrailleChar(brailleArr);
                                enteredChar.setText("");
                            }
                            dialogResult.dismiss();
                        });
                        dialogResult.show();
                    } else {
                        Toast.makeText(this, "Enter the character!", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(this, "No char available!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
    private void getPracticeHistory() {
        SharedPreferences sharedPreferences = getSharedPreferences("Practice Module", MODE_PRIVATE);
        currentCharIndex = sharedPreferences.getInt("Practice 1 index", 0);
        String characters1 = sharedPreferences.getString("Practice 1 chars1", null);
        charactersList1 = getCharactersList(characters1);
        String characters2 = sharedPreferences.getString("Practice 1 chars2", null);
        charactersList2 = getCharactersList(characters2);
    }
    private void savePracticeData(int currentCharIndex, String charsKey, ArrayList<Character> charactersList) {
        SharedPreferences.Editor ed = getSharedPreferences("Practice Module", MODE_PRIVATE).edit();
        ed.putInt("Practice 1 index", currentCharIndex);

        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : charactersList) {
            stringBuilder.append(c);
        }
        Log.d("Charset", charactersList.toString());
        ed.putString(charsKey, stringBuilder.toString());
        ed.apply();
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
    private ArrayList<Character> getCharactersList(String characters) {
        ArrayList<Character> charactersList = new ArrayList<>();
        if (characters != null) {
            for (int i = 0; i < characters.length(); i++) {
                charactersList.add(characters.charAt(i));
            }
        } else {
            ArrayList<Character> chars = new ArrayList<>(brailleScript.getAlphabetsMap().keySet());
            Log.d("Charset", chars.toString());
            charactersList = new ArrayList<>();
            int charLen = chars.size();
            Random random = new Random();
            for (int i = 0; i < charLen; i++) {
                int index = random.nextInt(chars.size());
                charactersList.add(chars.remove(index));
            }
        }
        return charactersList;
    }
}