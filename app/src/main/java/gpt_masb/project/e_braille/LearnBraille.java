package gpt_masb.project.e_braille;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Map;
import java.util.Objects;

public class LearnBraille extends AppCompatActivity {
    TextInputLayout findCharacter;
    TextView character;
    ImageView position0, position1, position2, position3, position4, position5;
    LinearLayout displayLayout;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_braille);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Learn Braille");
        }
        findCharacter = findViewById(R.id.findCharacter);
        character = findViewById(R.id.character);

        position0 = findViewById(R.id.position0);
        position1 = findViewById(R.id.position1);
        position2 = findViewById(R.id.position2);
        position3 = findViewById(R.id.position3);
        position4 = findViewById(R.id.position4);
        position5 = findViewById(R.id.position5);

        displayLayout = findViewById(R.id.displayLayout);
        displayLayout.setVisibility(View.INVISIBLE);

        // Initialize the Vibrator
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        findCharacter.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String character = Objects.requireNonNull(findCharacter.getEditText()).getText().toString();
                if (!character.isEmpty()) {
                    BrailleScript brailleScript = new BrailleScript();
                    Map<Character, int[]> alphabetMap = brailleScript.getAlphabetsMap();
                    Map<Character, int[]> numericMap = brailleScript.getNumbersMap();

                    Character ch = character.toLowerCase().charAt(0);
                    if (alphabetMap.containsKey(ch)) {
                        setBrailleScript(ch, Objects.requireNonNull(alphabetMap.get(ch)));
                    } else if (numericMap.containsKey(ch)) {
                        setBrailleScript(ch, Objects.requireNonNull(numericMap.get(ch)));
                    } else {
                        Toast.makeText(LearnBraille.this, "No character available!", Toast.LENGTH_SHORT).show();
                        displayLayout.setVisibility(View.INVISIBLE);
                    }
                } else {
                    Toast.makeText(LearnBraille.this, "Enter any character!", Toast.LENGTH_SHORT).show();
                    displayLayout.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    private void setBrailleScript(Character ch, int[] array) {
        displayLayout.setVisibility(View.VISIBLE);
        character.setText(findCharacter.getEditText().getText());
        ImageView[] imageViewArray = {position0, position1, position2, position3, position4, position5};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                imageViewArray[i].setBackgroundResource(R.drawable.round_image_black);
                imageViewArray[i].setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            // Trigger vibration when the Braille dot is touched
                            activateVibrationMotor();
                        }
                        return true;
                    }
                });
            } else {
                imageViewArray[i].setBackgroundResource(R.drawable.round_image_white);
                imageViewArray[i].setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return false;
                    }
                });
            }
        }
    }
    private void activateVibrationMotor() {
        if (vibrator != null) {
            // Vibrate for a short duration when a Braille dot is touched
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                // Deprecated in API 26
                vibrator.vibrate(150);
            }
        }
    }
}
