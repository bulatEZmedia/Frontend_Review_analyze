package com.example.review_analyze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceAnalyzeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_analyze);

        Button deficit = findViewById(R.id.then2);
        Button solution = findViewById(R.id.then3);
        Button benefit = findViewById(R.id.then4);

        deficit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceAnalyzeActivity.this, DeficitActivity.class);
                startActivity(intent);
            }
        });

        solution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceAnalyzeActivity.this, SolutionActivity.class);
                startActivity(intent);
            }
        });

        benefit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceAnalyzeActivity.this, BenefitActivity.class);
                startActivity(intent);
            }
        });

    }
}