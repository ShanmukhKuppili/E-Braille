package gpt_masb.project.e_braille;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        findViewById(R.id.practice).setOnClickListener(v -> startActivity(new Intent(this, Practice.class)));
        findViewById(R.id.challenge).setOnClickListener(v -> startActivity(new Intent(this, Challenge.class)));
        findViewById(R.id.progress).setOnClickListener(v -> startActivity(new Intent(this, ProgressModule.class)));
        findViewById(R.id.translation).setOnClickListener(v -> startActivity(new Intent(this, Translation.class)));
        findViewById(R.id.dictionary).setOnClickListener(v -> startActivity(new Intent(this, BrailleDictionary.class)));
    }
}