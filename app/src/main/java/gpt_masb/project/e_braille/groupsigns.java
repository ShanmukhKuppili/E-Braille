package gpt_masb.project.e_braille;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class groupsigns extends AppCompatActivity {
    ImageButton groupbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupsigns);

        groupbutton = (ImageButton) findViewById(R.id.groupbutton);
        groupbutton.setOnClickListener(view ->{
                startActivities(new Intent[]{new Intent(groupsigns.this,BrailleDictionary.class)});
        });
    }
}