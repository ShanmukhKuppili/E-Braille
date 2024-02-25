package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Finalcontractions extends AppCompatActivity {
    
    ImageButton imageButton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalcontractions);

        imageButton9 =findViewById(R.id.imageButton9);
        imageButton9.setOnClickListener(view ->{
                startActivities(new Intent[]{new Intent(Finalcontractions.this,BrailleDictionary.class)});
        });
    }
}