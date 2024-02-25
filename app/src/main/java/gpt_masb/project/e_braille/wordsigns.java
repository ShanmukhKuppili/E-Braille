package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class wordsigns extends AppCompatActivity {
    ImageButton imageButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordsigns);

        imageButton1 = findViewById(R.id.imagebutton1);
        imageButton1.setOnClickListener(view ->{
            Intent i=new Intent(this, BrailleDictionary.class);
            startActivity(i);
            finish();
        });
    }
}