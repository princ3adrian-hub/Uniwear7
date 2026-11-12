package com.example.uniwear7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Loadingscreen extends AppCompatActivity {

    private ProgressBar loadingProgress;
    private TextView loadingText;
    private int progressStatus = 0;
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingscreen);

        loadingProgress = findViewById(R.id.loadingProgress);
        loadingText = findViewById(R.id.loadingText);

        startLoading();
    }

    private void startLoading() {
        new Thread(() -> {
            while (progressStatus < 100) {
                progressStatus += 2;
                handler.post(() -> {
                    loadingProgress.setProgress(progressStatus);
                    loadingText.setText("Loading... " + progressStatus + "%");
                });
                try {
                    Thread.sleep(50); // Total loading time ~2.5 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Transition to LoginScreen after loading reaches 100%
            handler.post(() -> {
                Intent intent = new Intent(Loadingscreen.this, LoginScreen.class);
                startActivity(intent);
                finish(); // Close LoadingScreen so user cannot return to it via back button
            });
        }).start();
    }
}
