package com.example.sport_spot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Enter extends AppCompatActivity {

    private static final String TAG = "Enter";

    private EditText emailEditText;
    private EditText passwordEditText;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        mAuth = FirebaseAuth.getInstance();

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        // Load and display the animated GIF image using Glide
        ImageView gifImageView = findViewById(R.id.gifImageView2);
        Glide.with(this)
                .asGif()
                .load(R.drawable.planetgif2min)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(gifImageView);
    }

    public void loginUser(View view) {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            // Login successful, proceed to the map activity
                            startActivity(new Intent(Enter.this, MainActivity2.class));
                            finish(); // Finish the Enter activity
                        }
                    } else {
                        // Login failed
                        Log.w(TAG, "signInWithEmailAndPassword:failure", task.getException());
                        Toast.makeText(Enter.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
