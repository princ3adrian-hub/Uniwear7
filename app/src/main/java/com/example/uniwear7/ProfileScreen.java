package com.example.uniwear7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.imageview.ShapeableImageView;

public class ProfileScreen extends AppCompatActivity {

    private ShapeableImageView imgProfileAvatar;
    private View btnEditAvatar;
    private ImageView btnBack;
    private ImageView btnSave;
    private EditText etName;
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etPhone;
    private ImageView btnTogglePassword;
    private ImageView navHome;
    private ImageView navProfile;

    private boolean isPasswordVisible = false;

    // Image Picker launcher to choose profile picture from device gallery
    private final ActivityResultLauncher<String> imagePickerLauncher =
            registerForActivityResult(new ActivityResultContracts.GetContent(), (Uri uri) -> {
                if (uri != null) {
                    imgProfileAvatar.setImageURI(uri);
                    Toast.makeText(ProfileScreen.this, "Profile picture updated!", Toast.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        imgProfileAvatar = findViewById(R.id.imgProfileAvatar);
        btnEditAvatar = findViewById(R.id.btnEditAvatar);
        btnBack = findViewById(R.id.btnBack);
        btnSave = findViewById(R.id.btnSave);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etPhone = findViewById(R.id.etPhone);
        btnTogglePassword = findViewById(R.id.btnTogglePassword);
        navHome = findViewById(R.id.navHome);
        navProfile = findViewById(R.id.navProfile);

        // Pre-fill initial sample profile data matching the UI mockup
        etName.setText("Alex Carter");
        etEmail.setText("alexcarter24@gmail.com");
        etUsername.setText("@alexcarter24");
        etPassword.setText("password123");
        etPhone.setText("+977 1234567890");

        // Profile Picture Click Listener (Pick image from gallery)
        View.OnClickListener avatarClickListener = v -> imagePickerLauncher.launch("image/*");
        imgProfileAvatar.setOnClickListener(avatarClickListener);
        btnEditAvatar.setOnClickListener(avatarClickListener);

        // Back Button
        btnBack.setOnClickListener(v -> finish());

        // Save Button Listener
        btnSave.setOnClickListener(v -> saveProfileChanges());

        // Password Visibility Toggle
        btnTogglePassword.setOnClickListener(v -> togglePasswordVisibility());

        // Navigation Bar Listeners
        navHome.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileScreen.this, DashBoardScreen.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        navProfile.setOnClickListener(v -> {
            // Already on ProfileScreen
        });
    }

    private void saveProfileChanges() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (name.isEmpty()) {
            etName.setError("Name cannot be empty");
            etName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError("Email cannot be empty");
            etEmail.requestFocus();
            return;
        }

        Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show();
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            btnTogglePassword.setImageResource(R.drawable.ic_eye_toggle);
            isPasswordVisible = false;
        } else {
            etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            btnTogglePassword.setImageResource(R.drawable.ic_eye_off);
            isPasswordVisible = true;
        }
        etPassword.setSelection(etPassword.getText().length());
    }
}
