package com.example.uniwear7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

public class DashBoardScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dash_board_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView welcomeUserText = findViewById(R.id.welcomeUserText);
        ImageView notificationBell = findViewById(R.id.notificationBell);
        MaterialCardView cardItemsAvailable = findViewById(R.id.cardItemsAvailable);
        Button btnViewItems = findViewById(R.id.btnViewItems);
        MaterialCardView cardMyOrders = findViewById(R.id.cardMyOrders);
        MaterialCardView cardProfile = findViewById(R.id.cardProfile);
        Button btnLogout = findViewById(R.id.btnLogout);

        // Retrieve user login information passed from LoginScreen
        String userNameExtra = getIntent().getStringExtra("USER_NAME");
        String finalUserName;
        if (userNameExtra != null && !userNameExtra.trim().isEmpty()) {
            finalUserName = userNameExtra;
        } else {
            String userEmail = getIntent().getStringExtra("USER_EMAIL");
            if (userEmail != null && !userEmail.trim().isEmpty()) {
                finalUserName = extractDisplayName(userEmail);
            } else {
                finalUserName = "Juan";
            }
        }

        welcomeUserText.setText(getString(R.string.welcome_user, finalUserName));

        // Set click listeners
        notificationBell.setOnClickListener(v ->
                Toast.makeText(DashBoardScreen.this, "Notifications", Toast.LENGTH_SHORT).show()
        );

        btnViewItems.setOnClickListener(v ->
                Toast.makeText(DashBoardScreen.this, "Browsing items available...", Toast.LENGTH_SHORT).show()
        );

        cardItemsAvailable.setOnClickListener(v ->
                Toast.makeText(DashBoardScreen.this, "Browsing items available...", Toast.LENGTH_SHORT).show()
        );

        cardMyOrders.setOnClickListener(v ->
                Toast.makeText(DashBoardScreen.this, "Opening My Orders...", Toast.LENGTH_SHORT).show()
        );

        cardProfile.setOnClickListener(v ->
                Toast.makeText(DashBoardScreen.this, "Opening Profile...", Toast.LENGTH_SHORT).show()
        );

        btnLogout.setOnClickListener(v -> {
            Toast.makeText(DashBoardScreen.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashBoardScreen.this, LoginScreen.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }

    private String extractDisplayName(String email) {
        String trimmedEmail = email.trim();
        String namePart = trimmedEmail.contains("@") ? trimmedEmail.substring(0, trimmedEmail.indexOf("@")) : trimmedEmail;
        String finalPart = namePart.contains(".") ? namePart.substring(0, namePart.indexOf(".")) : namePart;

        if (!finalPart.isEmpty()) {
            return Character.toUpperCase(finalPart.charAt(0)) + (finalPart.length() > 1 ? finalPart.substring(1) : "");
        }
        return "Juan";
    }
}
