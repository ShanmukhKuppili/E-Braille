package gpt_masb.project.e_braille;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ProgressModule extends AppCompatActivity {
    PieChart progressGraphPractice, progressGraphChallenge;
    BarChart accuracyBarChart;
    TextView achievementPractice, achievementChallenge;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_module);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setSubtitle("Progress Analysis");
        }
        progressGraphPractice = findViewById(R.id.progressGraphPractice);
        progressGraphChallenge = findViewById(R.id.progressGraphChallenge);
        accuracyBarChart = findViewById(R.id.accuracyBarChart);
        achievementPractice = findViewById(R.id.achievementsPractice);
        achievementChallenge = findViewById(R.id.achievementsChallenge);

        generatePracticeAnalysisGraph();
        generateChallengeAnalysisGraph();
        updateUserAchievements();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
    private void generatePracticeAnalysisGraph() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        SharedPreferences sp = getSharedPreferences("Practice Module", MODE_PRIVATE);
        int practiceIndex1 = sp.getInt("Practice 1 index", 0);
        long practiceChars1Len1 = sp.getString("Practice 1 chars1", "").length();
        long practiceChars2Len1 = sp.getString("Practice 1 chars2", "").length();
        int practiceIndex2 = sp.getInt("Practice 2 index", 0);
        long practiceChars1Len2 = sp.getString("Practice 2 chars1", "").length();
        long practiceChars2Len2 = sp.getString("Practice 2 chars2", "").length();

        pieEntries.add(new PieEntry((float) practiceIndex1/(practiceChars1Len1+practiceChars2Len1)*100,"Braille Alphabets(%)"));
        pieEntries.add(new PieEntry((float) practiceIndex2/(practiceChars1Len2+practiceChars2Len2)*100,"Braille Numbers(%)"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries,"");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(12f);

        PieData pieData = new PieData(pieDataSet);
        progressGraphPractice.setData(pieData);
        progressGraphPractice.getDescription().setEnabled(false);
        progressGraphPractice.setCenterText("Practice Braille");
        progressGraphPractice.animate();
    }
    private void generateChallengeAnalysisGraph() {
        SharedPreferences sp = getSharedPreferences("Challenge Module", MODE_PRIVATE);
        int currentStage = sp.getInt("Current Stage", 0);
        float percentage = (float) currentStage/10*100;

        //For challenge progress
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(percentage,"Completed(%)"));
        pieEntries.add(new PieEntry(100-percentage,"Incomplete(%)"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries,"");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(12f);

        PieData pieData = new PieData(pieDataSet);
        progressGraphChallenge.setData(pieData);
        progressGraphChallenge.getDescription().setEnabled(false);
        progressGraphChallenge.setCenterText("Challenges Completed");
        progressGraphChallenge.animate();

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for (int i = 1; i <= currentStage; i++) {
            int score = sp.getInt("Score"+i, 0);
            Log.d("score challenge", score+"");
            float accuracy = (float) score/10;
            BarEntry barEntry = new BarEntry(i, accuracy);
            barEntries.add(barEntry);
        }
        BarDataSet barDataSet = new BarDataSet(barEntries, "Accuracy of Different Stages");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        BarData barData = new BarData(barDataSet);
        accuracyBarChart.setData(barData);
        accuracyBarChart.getDescription().setEnabled(false);

        XAxis xAxis = accuracyBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return "Stage-"+(int)value;
            }
        });

        accuracyBarChart.animateXY(1500, 2000);

    }
    private void updateUserAchievements() {
        SharedPreferences sp1 = getSharedPreferences("Practice Module", MODE_PRIVATE);
        int practiceIndex1 = sp1.getInt("Practice 1 index", 0);
        long practiceChars1Len1 = sp1.getString("Practice 1 chars1", "").length();
        long practiceChars2Len1 = sp1.getString("Practice 1 chars2", "").length();
        int practiceIndex2 = sp1.getInt("Practice 2 index", 0);
        long practiceChars1Len2 = sp1.getString("Practice 2 chars1", "").length();
        long practiceChars2Len2 = sp1.getString("Practice 2 chars2", "").length();

        if((float) practiceIndex1/(practiceChars1Len1+practiceChars2Len1) == 1) {
            achievementPractice.setText("   - Completed Practice Session - 1");
        } else if ((float) practiceIndex2/(practiceChars1Len2+practiceChars2Len2) == 1) {
            achievementPractice.setText("   - Completed Practice Session - 2");
        } else if ((float) practiceIndex1/(practiceChars1Len1+practiceChars2Len1) ==1 && (float) practiceIndex2/(practiceChars1Len2+practiceChars2Len2) == 1) {
            achievementPractice.setText("   - Completed Practice Session - 1\n   - Completed Practice Session - 2");
        }

        SharedPreferences sp2 = getSharedPreferences("Challenge Module", MODE_PRIVATE);
        int currentStage = sp2.getInt("Current Stage", 0);
        for (int i = 1; i <= currentStage; i++) {
            if(i==1)
                achievementChallenge.setText("   - Completed Stage - "+i);
            else
                achievementChallenge.append("\n   - Completed Stage - "+i);
        }
    }
}