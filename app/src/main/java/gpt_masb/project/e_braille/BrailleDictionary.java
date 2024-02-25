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
            toolbar.setSubtitle("Braille Dictionary");
        }

        CardView Alphabets = findViewById(R.id.cardFindAlphabets);
        Alphabets.setOnClickListener(view ->{
            Intent i=new Intent(this, Homeactivity.class);
            startActivity(i);
            finish();
        });

        CardView Numbers = findViewById(R.id.cardFindNumbers);
        Numbers.setOnClickListener(view ->{
            Intent i=new Intent(this, Numberactivity.class);
            startActivity(i);
            finish();
        });

        CardView Puctuation = findViewById(R.id.cardFindPunctuation);
        Puctuation.setOnClickListener(view ->{
            Intent i=new Intent(this, punctuation.class);
            startActivity(i);
            finish();
        });

        CardView wordsigns = findViewById(R.id.cardFindwordsigns);
        wordsigns.setOnClickListener(view ->{
            Intent i=new Intent(this, wordsigns.class);
            startActivity(i);
            finish();
        });

        CardView groupsigns = findViewById(R.id.cardFindgroupsigns);
        groupsigns.setOnClickListener(view ->{
            Intent i=new Intent(this, groupsigns.class);
            startActivity(i);
            finish();
        });

        CardView Initialcontractions = findViewById(R.id.cardFindInitailcontractions);
        Initialcontractions.setOnClickListener(view ->{
            Intent i=new Intent(this, Initialcontractions.class);
            startActivity(i);
            finish();
        });

        CardView Finalcontractions = findViewById(R.id.cardFindFinalcontractions);
        Finalcontractions.setOnClickListener(view ->{
            Intent i=new Intent(this, Finalcontractions.class);
            startActivity(i);
            finish();
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}



