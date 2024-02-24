package gpt_masb.project.e_braille;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Translation extends AppCompatActivity {
    // Create a map to store the Braille characters
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

        // Initialize the map with the Braille characters
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

        // Find the button and the text view in the layout
        Button translateButton = findViewById(R.id.translateButton);
        final EditText inputText = findViewById(R.id.inputText);
        final TextView outputText = findViewById(R.id.outputText);

        outputText.setMovementMethod(new ScrollingMovementMethod());

        // Set a click listener for the button
        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input text and convert it to uppercase
                String input = inputText.getText().toString().toUpperCase();

                // Initialize an empty string for the output
                StringBuilder output = new StringBuilder();

                // Iterate over each character in the input
                for (int i = 0; i < input.length(); i++) {
                    // Get the current character
                    char c = input.charAt(i);

                    // Check if the character is in the map
                    if (brailleMap.containsKey(c)) {
                        // Add the Braille character to the output
                        output.append(brailleMap.get(c));
                    }
                    else if(brailleMapp.containsKey(c)) {
                        // Add the Braille character to the output
                        output.append(brailleMapp.get(c));
                    }
                    else if (braillePunctuationMap.containsKey(c)) {
                        // Add the Braille character to the output
                        output.append(braillePunctuationMap.get(c));
                    }
                    else {
                        // Add a space to the output
                        output.append(" ");
                    }
                }

                // Set the output text
                outputText.setText(output.toString());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}