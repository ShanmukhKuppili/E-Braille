package gpt_masb.project.e_braille;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
public class PracticeBraille extends AppCompatActivity {
    private Button brailleAlphabets, brailleNum;
    int alphabetCharIndex, numCharIndex;
    ArrayList<Character> alphabetList1, alphabetList2, numericList1, numericList2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_braille);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Practice Braille");
        }

        brailleAlphabets = findViewById(R.id.brailleAlphabets);
        brailleNum = findViewById(R.id.brailleNumbers);

        brailleAlphabets.setOnClickListener(v -> startActivity(new Intent(this, PracticeBrailleAlphabets.class)));
        brailleNum.setOnClickListener(v -> startActivity(new Intent(this, PracticeBrailleNumbers.class)));

        getPracticeHistory();
        setupBraillePracticeSession();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        getPracticeHistory();
        setupBraillePracticeSession();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    private void getPracticeHistory() {
        SharedPreferences sp = getSharedPreferences("Practice Module", MODE_PRIVATE);
        alphabetCharIndex = sp.getInt("Practice 1 index", 0);
        numCharIndex = sp.getInt("Practice 2 index", 0);

        BrailleScript brailleScript = new BrailleScript();
        ArrayList<Character> chars1 = new ArrayList<>(brailleScript.getAlphabetsMap().keySet());
        ArrayList<Character> chars2 = new ArrayList<>(brailleScript.getAlphabetsMap().keySet());

        String alphabetsCharacters1 = sp.getString("Practice 1 chars1", null);
        alphabetList1 = getCharactersList(alphabetsCharacters1, chars1);
        String alphabetsCharacters2 = sp.getString("Practice 1 chars2", null);
        alphabetList2 = getCharactersList(alphabetsCharacters2, chars1);

        String numericCharacters1 = sp.getString("Practice 2 chars1", null);
        numericList1 = getCharactersList(numericCharacters1, chars2);
        String numericCharacters2 = sp.getString("Practice 2 chars2", null);
        numericList2 = getCharactersList(numericCharacters2, chars2);
    }
    private ArrayList<Character> getCharactersList(String characters, ArrayList<Character> chars) {
        ArrayList<Character> charactersList = new ArrayList<>();
        if (characters != null) {
            for (int i = 0; i < characters.length(); i++) {
                charactersList.add(characters.charAt(i));
            }
        } else {
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
    private void setupBraillePracticeSession() {
        if(alphabetCharIndex == (alphabetList1.size()+alphabetList2.size())) {
            brailleAlphabets.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.check_circle), null, null, null);
            brailleAlphabets.setOnClickListener(v -> {
                showAlertDialogBox(new Intent(this, PracticeBrailleAlphabets.class));
            });
        }
        if(numCharIndex == (numericList1.size()+numericList2.size())) {
            brailleNum.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.check_circle), null, null, null);
            brailleNum.setOnClickListener(v -> {
                showAlertDialogBox(new Intent(this, PracticeBrailleNumbers.class));
            });
        }
    }
    private void showAlertDialogBox(Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.dialog_window_style);
        builder.setTitle("You have already completed\nthis Practice Session!");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Practice Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences sp = getSharedPreferences("Practice Module", MODE_PRIVATE);
                if(Objects.equals(intent.getComponent(), new ComponentName(PracticeBraille.this, PracticeBrailleAlphabets.class))) {
                    SharedPreferences.Editor ed = sp.edit();
                    ed.remove("Practice 1 index");
                    ed.remove("Practice 1 char1");
                    ed.remove("Practice 1 char2");
                    ed.apply();
                } else if(Objects.equals(intent.getComponent(), new ComponentName(PracticeBraille.this, PracticeBrailleNumbers.class))) {
                    SharedPreferences.Editor ed = sp.edit();
                    Log.d("Entered Inside", "entered this block");
                    ed.remove("Practice 2 index");
                    ed.remove("Practice 2 char1");
                    ed.remove("Practice 2 char2");
                    ed.apply();
                }
                startActivity(intent);
            }
        });
        builder.show();
    }
}