package gpt_masb.project.e_braille;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.HashMap;
import java.util.Map;

public class Translation extends AppCompatActivity {
    private Map<String, Integer> brailleMap;
    private HashMap<Object, Object> brailleMapp;
    private Map<Character, String> braillePunctuationMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Translation");
        }

        brailleMapp = new HashMap<>();
        brailleMapp.put('A', "⠁");
        brailleMapp.put('B', "⠃");
        brailleMapp.put('C', "⠉");
        brailleMapp.put('D', "⠙");
        brailleMapp.put('E', "⠑");
        brailleMapp.put('F', "⠋");
        brailleMapp.put('G', "⠛");
        brailleMapp.put('H', "⠓");
        brailleMapp.put('I', "⠊");
        brailleMapp.put('J', "⠚");
        brailleMapp.put('K', "⠅");
        brailleMapp.put('L', "⠇");
        brailleMapp.put('M', "⠍");
        brailleMapp.put('N', "⠝");
        brailleMapp.put('O', "⠕");
        brailleMapp.put('P', "⠏");
        brailleMapp.put('Q', "⠟");
        brailleMapp.put('R', "⠗");
        brailleMapp.put('S', "⠎");
        brailleMapp.put('T', "⠞");
        brailleMapp.put('U', "⠥");
        brailleMapp.put('V', "⠧");
        brailleMapp.put('W', "⠺");
        brailleMapp.put('X', "⠭");
        brailleMapp.put('Y', "⠽");
        brailleMapp.put('Z', "⠵");

        brailleMap = new HashMap<>();
        brailleMap.put("⠼⠚", 0);
        brailleMapp.put("⠼⠁", 1);
        brailleMap.put("⠼⠃", 2);
        brailleMap.put("⠼⠉", 3);
        brailleMap.put("⠼⠙", 4);
        brailleMap.put("⠼⠑", 5);
        brailleMap.put("⠼⠋", 6);
        brailleMap.put("⠼⠛", 7);
        brailleMap.put("⠼⠓", 8);
        brailleMap.put("⠼⠊", 9);

        braillePunctuationMap = new HashMap<>();
        braillePunctuationMap.put('.', "⠲");
        braillePunctuationMap.put(',', "⠐");
        braillePunctuationMap.put('?', "⠢");
        braillePunctuationMap.put('!', "⠤");
        braillePunctuationMap.put(';', "⠆");
        braillePunctuationMap.put(':', "⠒");
        braillePunctuationMap.put('(', "⠘");
        braillePunctuationMap.put(')', "⠰");
        braillePunctuationMap.put('-', "⠤");
        braillePunctuationMap.put('/', "⠲⠐");
        braillePunctuationMap.put('@', "⠈⠢⠈");
        braillePunctuationMap.put('&', "⠯");
        braillePunctuationMap.put('#', "⠼⠒⠒⠒⠒⠒⠲");
        braillePunctuationMap.put('\'', "⠄");
        braillePunctuationMap.put('"', "⠶⠶");
        braillePunctuationMap.put('[', "⠈⠲");
        braillePunctuationMap.put(']', "⠘⠲");
        braillePunctuationMap.put('{', "⠈⠶");
        braillePunctuationMap.put('}', "⠘⠶");

        Button translateButton = findViewById(R.id.translateButton);
        final EditText inputText = findViewById(R.id.inputText);
        final TextView outputText = findViewById(R.id.outputText);

        outputText.setMovementMethod(new ScrollingMovementMethod());
        translateButton.setOnClickListener(view ->{
                String input = inputText.getText().toString().toUpperCase();
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);

                    if (brailleMap.containsKey(c))
                        output.append(brailleMap.get(c));
                    else if(brailleMapp.containsKey(c))
                        output.append(brailleMapp.get(c));
                    else if (braillePunctuationMap.containsKey(c))
                        output.append(braillePunctuationMap.get(c));
                    else
                        output.append(" ");
                }
                outputText.setText(output.toString());
            });
        }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}