package gpt_masb.project.e_braille;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class BrailleDictionary extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braille_dictionary);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Practice Braille (Alphabets)");
        }

        CardView Alphabets = findViewById(R.id.cardFindAlphabets);
        Alphabets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(BrailleDictionary.this, Homeactivity.class)});
            }
        });


        CardView Numbers = findViewById(R.id.cardFindNumbers);
        Numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(BrailleDictionary.this, Numberactivity.class)});
            }
        });
        CardView Puctuation = findViewById(R.id.cardFindPunctuation);
        Puctuation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(BrailleDictionary.this, punctuation.class)});
            }
        });

        CardView wordsigns = findViewById(R.id.cardFindwordsigns);
        wordsigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(BrailleDictionary.this, wordsigns.class)});
            }
        });

        CardView groupsigns = findViewById(R.id.cardFindgroupsigns);
        groupsigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(BrailleDictionary.this,groupsigns.class)});
            }
        });

        CardView Initialcontractions = findViewById(R.id.cardFindInitailcontractions);
        Initialcontractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(BrailleDictionary.this,Initialcontractions.class)});
            }
        });

        CardView Finalcontractions = findViewById(R.id.cardFindFinalcontractions);
        Finalcontractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(BrailleDictionary.this,Finalcontractions.class)});
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



