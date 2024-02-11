package com.example.sport_spot;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private Button myButton;
    private boolean isCancelled = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // передаем инфу про адрес из MainActivity2
        String address = getIntent().getStringExtra("ADDRESS");

        // отображение адреса
        TextView addressTextView = findViewById(R.id.addressTextView);
        addressTextView.setText(address);

        // Set up button
        myButton = findViewById(R.id.iam_here_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleButtonTextAndColor();
            }
        });
    }
        // кнопка меняется в зависимости от нажатия
    private void toggleButtonTextAndColor() {
        if (isCancelled) {
            myButton.setText("Буду тут!");
            myButton.setBackgroundColor(getResources().getColor(android.R.color.black));
        } else {
            myButton.setText("Отменить");
            myButton.setBackgroundColor(getResources().getColor(R.color.red_color_for_button_cancel));
        }
        isCancelled = !isCancelled;
    }
}
