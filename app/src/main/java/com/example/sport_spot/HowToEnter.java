package com.example.sport_spot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HowToEnter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_enter);
    }

    public void ToMain1(View view) {
        Intent intent = new Intent(HowToEnter.this, MainActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }
    public void ToEnter(View view) {
        Intent intent = new Intent(HowToEnter.this, Enter.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }
}
