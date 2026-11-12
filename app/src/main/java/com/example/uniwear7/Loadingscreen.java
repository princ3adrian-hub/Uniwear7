package com.example.uniwear7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Loadingscreen extends AppCompatActivity {

    private ProgressBar loadingProgress;
    private TextView loadingText;
    private int progressStatus = 0;
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loadingscreen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadingProgress = findViewById(R.id.loadingProgress);
        loadingText = findViewById(R.id.loadingText);

        startLoading();
    }

    private void startLoading() {
        new Thread(() -> {
            while (progressStatus < 100) {
                progressStatus += 2;
                handler.post(() -> {
                    if (loadingProgress != null) {
                        loadingProgress.setProgress(progressStatus);
                    }
                    if (loadingText != null) {
                        loadingText.setText("Loading... " + progressStatus + "%");
                    }
                });
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            handler.post(() -> {
                Intent intent = new Intent(Loadingscreen.this, LoginScreen.class);
                startActivity(intent);
                finish();
            });
        }).start();
    }
}
