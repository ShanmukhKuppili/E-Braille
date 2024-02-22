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
        int practiceIndex1 = sp.getInt("Practice 1 index", 0);
        long practiceChars1Len1 = sp.getString("Practice 1 chars1", "").length();
        long practiceChars2Len1 = sp.getString("Practice 1 chars2", "").length();
        int practiceIndex2 = sp.getInt("Practice 2 index", 0);
        long practiceChars1Len2 = sp.getString("Practice 2 chars1", "").length();
        long practiceChars2Len2 = sp.getString("Practice 2 chars2", "").length();

        //Log.d("current state braille", ""+currentStateBraille2);

        pieEntries.add(new PieEntry((float) practiceIndex1/(practiceChars1Len1+practiceChars2Len1)*100,"Braille Alphabets(%)"));
        pieEntries.add(new PieEntry((float) practiceIndex2/(practiceChars1Len2+practiceChars2Len2)*100,"Braille Numbers(%)"));

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
        int practiceIndex1 = sp.getInt("Practice 1 index", 0);
        long practiceChars1Len1 = sp.getString("Practice 1 chars1", "").length();
        long practiceChars2Len1 = sp.getString("Practice 1 chars2", "").length();
        int practiceIndex2 = sp.getInt("Practice 2 index", 0);
        long practiceChars1Len2 = sp.getString("Practice 2 chars1", "").length();
        long practiceChars2Len2 = sp.getString("Practice 2 chars2", "").length();

        if((float) practiceIndex1/(practiceChars1Len1+practiceChars2Len1) == 1) {
            achievementPractice.setText("   - Completed Stage - 1");
        } else if ((float) practiceIndex2/(practiceChars1Len2+practiceChars2Len2) == 1) {
            achievementPractice.setText("   - Completed Stage - 2");
        } else if ((float) practiceIndex1/(practiceChars1Len1+practiceChars2Len1) ==1 && (float) practiceIndex2/(practiceChars1Len2+practiceChars2Len2) == 1) {
            achievementPractice.setText("   - Completed Stage - 1\n   - Completed Stage - 2");
        }
    }
}