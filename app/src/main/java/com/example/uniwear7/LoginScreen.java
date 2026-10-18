package com.example.uniwear7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginScreen extends AppCompatActivity {

    private EditText emailInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailInput = findViewById(R.id.editTextTextEmailAddress4);
        passwordInput = findViewById(R.id.editTextTextEmailAddress5);
        Button loginButton = findViewById(R.id.loginbutton);
        Button registerButton = findViewById(R.id.loginbutton2);

        loginButton.setOnClickListener(v -> handleLogin());

        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginScreen.this, RegistrationScreen.class);
            startActivity(intent);
        });
    }

    private void handleLogin() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty()) {
            emailInput.setError("Please enter your email");
            emailInput.requestFocus();
            Toast.makeText(LoginScreen.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() && !email.contains("@")) {
            emailInput.setError("Please enter a valid email address");
            emailInput.requestFocus();
            Toast.makeText(LoginScreen.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            passwordInput.setError("Please enter your password");
            passwordInput.requestFocus();
            Toast.makeText(LoginScreen.this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        String displayName = extractDisplayName(email);

        Toast.makeText(LoginScreen.this, "Login successful!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(LoginScreen.this, DashBoardScreen.class);
        intent.putExtra("USER_EMAIL", email);
        intent.putExtra("USER_NAME", displayName);
        startActivity(intent);
        finish();
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
