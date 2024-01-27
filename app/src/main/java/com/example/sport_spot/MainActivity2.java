package com.example.sport_spot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sport_spot.R;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class MainActivity2 extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler((thread, e) -> e.printStackTrace());

        // Инициализация Yandex MapKit с использованием API-ключа
        MapKitFactory.setApiKey("02dbc26f-aab3-4622-8f53-f585185338d0");
        MapKitFactory.initialize(this);

        setContentView(R.layout.activity_main2);
        mapView = findViewById(R.id.mapview);

        // Установка начального положения карты
        mapView.getMap().move(
                new CameraPosition(new Point(56.833716, 60.612949), 13.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0f),
                null
        );

        Log.d("MainActivity2", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
        MapKitFactory.getInstance().onStart();
        Log.d("MainActivity2", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        Log.d("MainActivity2", "onStop");
    }
}
