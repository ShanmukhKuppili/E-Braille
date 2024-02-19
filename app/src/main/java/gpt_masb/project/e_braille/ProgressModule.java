package gpt_masb.project.e_braille;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ProgressModule extends AppCompatActivity {
    PieChart progressGraph;
    TextView achievementPractice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_module);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Progress & Analysis");
        }

        progressGraph = findViewById(R.id.progressGraph);
        achievementPractice = findViewById(R.id.achievementsPractice);

        generatePracticeAnalysisGraph();
        updateUserAchievements();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void generatePracticeAnalysisGraph() {
        // creating a new array list
        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        SharedPreferences sp = getSharedPreferences("Practice Module", MODE_PRIVATE);
        int currentStateBraille1 = sp.getInt("Practice 1 index", 0);
        int currentStateBraille2 = sp.getInt("Practice 2", 0);

        //Log.d("current state braille", ""+currentStateBraille2);

        pieEntries.add(new PieEntry((float) currentStateBraille1/36*100,"English - Braille(%)"));
        pieEntries.add(new PieEntry((float) currentStateBraille2/36*100,"Braille - English(%)"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries,"");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(12f);

        PieData pieData = new PieData(pieDataSet);
        progressGraph.setData(pieData);
        progressGraph.getDescription().setEnabled(false);
        progressGraph.setCenterText("Practice Braille");
        progressGraph.animate();
    }

    private void updateUserAchievements() {
        SharedPreferences sp = getSharedPreferences("Practice Module", MODE_PRIVATE);
        int currentStateBraille1 = sp.getInt("Practice 1 index", 0);
        int currentStateBraille2 = sp.getInt("Practice 2", 0);

        if((float) currentStateBraille1/36 == 1) {
            achievementPractice.setText("   - Completed Stage - 1");
        } else if ((float) currentStateBraille2/36 == 1) {
            achievementPractice.setText("   - Completed Stage - 2");
        } else if ((float) currentStateBraille1/36==1 && (float) currentStateBraille2/36 == 1) {
            achievementPractice.setText("   - Completed Stage - 1\n   - Completed Stage - 2");
        }
    }
}