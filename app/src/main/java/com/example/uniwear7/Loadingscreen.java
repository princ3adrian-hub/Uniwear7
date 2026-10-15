
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

    private final Handler handler =
            new Handler(Looper.getMainLooper());

    private int progress = 0;

    private final Runnable loadingRunnable = new Runnable() {
        @Override
        public void run() {

            progress += 2;

            loadingProgress.setProgress(progress);
            loadingText.setText("Loading... " + progress + "%");

            if (progress < 100) {

                handler.postDelayed(this, 60);

            } else {

                loadingText.setText("Welcome to UniWear!");

                handler.postDelayed(() -> {
                    Intent intent = new Intent(
                            Loadingscreen.this,
                            LoginScreen.class
                    );

                    startActivity(intent);
                    finish();

                }, 400);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loadingscreen);

        loadingProgress = findViewById(R.id.loadingProgress);
        loadingText = findViewById(R.id.loadingText);

        loadingProgress.setProgress(0);

        handler.postDelayed(loadingRunnable, 100);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(loadingRunnable);
        super.onDestroy();
    }
}
