package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class punctuation extends AppCompatActivity {
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punctuation);

        imageButton = findViewById(R.id.imageButton3);
        imageButton.setOnClickListener(view ->{
                startActivities(new Intent[]{new Intent(punctuation.this,BrailleDictionary.class)});
        });
    }
}