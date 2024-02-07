package com.example.sport_spot;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Найдем ImageView для гифки
        ImageView gifImageView = findViewById(R.id.gifImageView);

        // Загрузим и отобразим анимированную GIF-картинку с помощью Glide
        Glide.with(this).asGif().load(R.drawable.planetgif2).into(gifImageView);
    }

    public void goToMap(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}

