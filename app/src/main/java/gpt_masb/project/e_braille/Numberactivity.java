package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Numberactivity extends AppCompatActivity {
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numberactivity);

        imageButton = findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(view ->{
            Intent i=new Intent(this, BrailleDictionary.class);
            startActivity(i);
            finish();
        });
    }
}