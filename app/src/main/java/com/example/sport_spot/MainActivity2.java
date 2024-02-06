package com.example.sport_spot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sport_spot.MainActivity3;
import com.example.sport_spot.R;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.mapkit.map.MapObjectTapListener;

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
                new CameraPosition(new Point(56.834716, 60.612949), 13.0f, 0.0f, 0.0f)
        );

        MapObjectCollection pinsCollection = mapView.getMap().getMapObjects().addCollection();

        // Список координат для меток
        Point[] points = {
                new Point(56.829674, 60.634673),
                new Point(56.826192, 60.621252),
                new Point(56.833092, 60.631720),
                new Point(56.832533, 60.626737)
        };

        // Добавление меток в коллекцию
        for (Point point : points) {
            PlacemarkMapObject placemark = pinsCollection.addPlacemark(point);

            // Используем стандартный маркер
            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.basket);

            // Указываем новую ширину и высоту для уменьшенного изображения
            int newWidth = originalBitmap.getWidth() / 2; // Уменьшение вдвое
            int newHeight = originalBitmap.getHeight() / 2; // Уменьшение вдвое

            // Создаем уменьшенное изображение
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, false);

            ImageProvider imageProvider = ImageProvider.fromBitmap(scaledBitmap);
            placemark.setIcon(imageProvider); // Установите уменьшенное изображение для метки

            // Добавляем обработчик нажатия на метку
            placemark.addTapListener(new MapObjectTapListener() {
                @Override
                public boolean onMapObjectTap(@NonNull com.yandex.mapkit.map.MapObject mapObject, @NonNull Point point) {
                    // Проверяем, что нажатый объект - метка
                    if (mapObject instanceof PlacemarkMapObject) {
                        // Действия при нажатии на метку
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(intent);
                        return true;
                    }
                    return false;
                }
            });
        }

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
