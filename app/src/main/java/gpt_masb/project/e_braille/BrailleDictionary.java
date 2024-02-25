package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

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
        });

        CardView Numbers = findViewById(R.id.cardFindNumbers);
        Numbers.setOnClickListener(view ->{
            Intent i=new Intent(this, Numberactivity.class);
            startActivity(i);
        });

        CardView Puctuation = findViewById(R.id.cardFindPunctuation);
        Puctuation.setOnClickListener(view ->{
            Intent i=new Intent(this, punctuation.class);
            startActivity(i);
        });

        CardView wordsigns = findViewById(R.id.cardFindwordsigns);
        wordsigns.setOnClickListener(view ->{
            Intent i=new Intent(this, wordsigns.class);
            startActivity(i);
        });

        CardView groupsigns = findViewById(R.id.cardFindgroupsigns);
        groupsigns.setOnClickListener(view ->{
            Intent i=new Intent(this, groupsigns.class);
            startActivity(i);
        });

        CardView Initialcontractions = findViewById(R.id.cardFindInitailcontractions);
        Initialcontractions.setOnClickListener(view ->{
            Intent i=new Intent(this, Initialcontractions.class);
            startActivity(i);
        });

        CardView Finalcontractions = findViewById(R.id.cardFindFinalcontractions);
        Finalcontractions.setOnClickListener(view ->{
            Intent i=new Intent(this, Finalcontractions.class);
            startActivity(i);
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}



