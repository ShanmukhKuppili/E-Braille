package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
public class Homeactivity extends AppCompatActivity {
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(view-> {
                startActivities(new Intent[]{new Intent(Homeactivity.this,BrailleDictionary.class)});
        });
    }
}