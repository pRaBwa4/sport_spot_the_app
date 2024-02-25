package com.example.sport_spot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    // Method to log out and go to MainActivity2
    public void ToMainActivity2(View view) {
        FirebaseAuth.getInstance().signOut(); // Log out
        startActivity(new Intent(Profile.this, MainActivity2.class));
        finish(); // Finish the current activity
    }

    // Method to log out and go to MainEnter
    public void logoutToMainEnter(View view) {
        FirebaseAuth.getInstance().signOut(); // Выход из аккаунта

        new Thread(new Runnable() {
            @Override
            public void run() {
                // Задержка перед перезапуском для предотвращения немедленного перезапуска
                try {
                    Thread.sleep(1000); // Пауза на 1 секунду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Перезапуск приложения
                Intent intent = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finishAffinity(); // Закрытие всех активностей приложения
            }
        }).start();
    }

}
