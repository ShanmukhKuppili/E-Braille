package gpt_masb.project.e_braille;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BrailleDictionary extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braille_dictionary);
        CardView Alphabets = findViewById(R.id.cardFindAlphabets);
        Alphabets.setOnClickListener(view ->{
                startActivities(new Intent[]{new Intent(BrailleDictionary.this, Homeactivity.class)});
        });
        CardView Numbers = findViewById(R.id.cardFindNumbers);
        Numbers.setOnClickListener(view ->{
                startActivities(new Intent[]{new Intent(BrailleDictionary.this, Numberactivity.class)});
        });
        CardView Puctuation = findViewById(R.id.cardFindPunctuation);
        Puctuation.setOnClickListener(view ->{
                startActivities(new Intent[]{new Intent(BrailleDictionary.this, punctuation.class)});
        });
        CardView wordsigns = findViewById(R.id.cardFindwordsigns);
        wordsigns.setOnClickListener(view ->{
                startActivities(new Intent[]{new Intent(BrailleDictionary.this, wordsigns.class)});
        });
        CardView groupsigns = findViewById(R.id.cardFindgroupsigns);
        groupsigns.setOnClickListener(view ->{
                startActivities(new Intent[]{new Intent(BrailleDictionary.this,groupsigns.class)});
        });
        CardView Initialcontractions = findViewById(R.id.cardFindInitailcontractions);
        Initialcontractions.setOnClickListener(view ->{
                startActivities(new Intent[]{new Intent(BrailleDictionary.this,Initialcontractions.class)});
        });
        CardView Finalcontractions = findViewById(R.id.cardFindFinalcontractions);
        Finalcontractions.setOnClickListener(view ->{
                startActivities(new Intent[]{new Intent(BrailleDictionary.this,Finalcontractions.class)});
        });
    }
}



