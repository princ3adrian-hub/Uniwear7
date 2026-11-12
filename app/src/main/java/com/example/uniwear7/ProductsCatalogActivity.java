package com.example.uniwear7;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductsCatalogActivity extends AppCompatActivity {

    private ImageView backButton;
    private ImageView cartButton;
    private TextView categoryAll, categoryTop, categoryBottom, categoryAccessories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_products_catalog);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backButton = findViewById(R.id.backButton);
        cartButton = findViewById(R.id.cartButton);

        categoryAll = findViewById(R.id.categoryAll);
        categoryTop = findViewById(R.id.categoryTop);
        categoryBottom = findViewById(R.id.categoryBottom);
        categoryAccessories = findViewById(R.id.categoryAccessories);

        if (backButton != null) {
            backButton.setOnClickListener(v -> finish());
        }

        setupCategoryClickListeners();
    }

    private void setupCategoryClickListeners() {
        View.OnClickListener categoryClickListener = v -> {
            resetCategorySelection();
            v.setBackgroundResource(R.drawable.bg_category_selected);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(getResources().getColor(android.R.color.white, getTheme()));
            }
        };

        if (categoryAll != null) categoryAll.setOnClickListener(categoryClickListener);
        if (categoryTop != null) categoryTop.setOnClickListener(categoryClickListener);
        if (categoryBottom != null) categoryBottom.setOnClickListener(categoryClickListener);
        if (categoryAccessories != null) categoryAccessories.setOnClickListener(categoryClickListener);
    }

    private void resetCategorySelection() {
        int unselectedBg = R.drawable.bg_category_unselected;
        int unselectedTextColor = 0xFF334155;

        if (categoryAll != null) {
            categoryAll.setBackgroundResource(unselectedBg);
            categoryAll.setTextColor(unselectedTextColor);
        }
        if (categoryTop != null) {
            categoryTop.setBackgroundResource(unselectedBg);
            categoryTop.setTextColor(unselectedTextColor);
        }
        if (categoryBottom != null) {
            categoryBottom.setBackgroundResource(unselectedBg);
            categoryBottom.setTextColor(unselectedTextColor);
        }
        if (categoryAccessories != null) {
            categoryAccessories.setBackgroundResource(unselectedBg);
            categoryAccessories.setTextColor(unselectedTextColor);
        }
    }
}
