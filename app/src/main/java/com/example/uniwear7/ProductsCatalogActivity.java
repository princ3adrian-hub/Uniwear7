package com.example.uniwear7;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductsCatalogActivity extends AppCompatActivity {

    private LinearLayout productContainer;
    private EditText searchInput;
    private TextView cartButton;

    private final List<Product> products = new ArrayList<>();

    private final int blue = Color.rgb(23, 59, 131);
    private final int lightGray = Color.rgb(230, 233, 240);

    private static class Product {
        String name;
        String description;
        String category;
        String emoji;
        double price;

        Product(String name, String description,
                String category, String emoji, double price) {
            this.name = name;
            this.description = description;
            this.category = category;
            this.emoji = emoji;
            this.price = price;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_catalog);

        productContainer = findViewById(R.id.productContainer);
        searchInput = findViewById(R.id.searchInput);
        cartButton = findViewById(R.id.cartButton);

        loadProducts();
        displayProducts();

        // All click listeners and navigation connections removed
    }

    private void loadProducts() {
        products.clear();

        products.add(new Product("Polo Shirt", "White", "Top", "👕", 350.00));
        products.add(new Product("P.E. Shirt", "Blue", "Top", "👕", 300.00));
        products.add(new Product("Skirt", "Navy Blue", "Bottom", "👗", 450.00));
        products.add(new Product("School Pants", "Black", "Bottom", "👖", 400.00));
        products.add(new Product("Tie", "School Tie", "Accessories", "👔", 150.00));
        products.add(new Product("Socks", "White Socks", "Accessories", "🧦", 80.00));
        products.add(new Product("School Belt", "Black", "Accessories", "🧷", 120.00));
    }

    private void displayProducts() {
        productContainer.removeAllViews();

        for (Product product : products) {
            addProductCard(product);
        }
    }

    private void addProductCard(Product product) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.HORIZONTAL);
        card.setGravity(Gravity.CENTER_VERTICAL);
        card.setPadding(dp(10), dp(10), dp(10), dp(10));

        GradientDrawable background = new GradientDrawable();
        background.setColor(Color.WHITE);
        background.setCornerRadius(dp(15));
        background.setStroke(dp(1), lightGray);
        card.setBackground(background);

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        dp(104));

        cardParams.bottomMargin = dp(10);
        card.setLayoutParams(cardParams);

        TextView image = new TextView(this);
        image.setText(product.emoji);
        image.setTextSize(30);
        image.setGravity(Gravity.CENTER);

        GradientDrawable imageBackground = new GradientDrawable();
        imageBackground.setColor(Color.rgb(245, 247, 252));
        imageBackground.setCornerRadius(dp(12));
        image.setBackground(imageBackground);

        LinearLayout.LayoutParams imageParams =
                new LinearLayout.LayoutParams(dp(55), dp(65));
        imageParams.setMarginEnd(dp(10));

        card.addView(image, imageParams);

        LinearLayout details = new LinearLayout(this);
        details.setOrientation(LinearLayout.VERTICAL);
        details.setGravity(Gravity.CENTER_VERTICAL);

        LinearLayout.LayoutParams detailsParams =
                new LinearLayout.LayoutParams(
                        0,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        1f);

        card.addView(details, detailsParams);

        TextView name = new TextView(this);
        name.setText(product.name);
        name.setTextColor(Color.BLACK);
        name.setTextSize(15);
        name.setTypeface(null, Typeface.BOLD);
        details.addView(name);

        TextView description = new TextView(this);
        description.setText(product.description);
        description.setTextColor(Color.DKGRAY);
        description.setTextSize(13);
        details.addView(description);

        TextView price = new TextView(this);
        price.setText(String.format(Locale.US, "₱%.2f", product.price));
        price.setTextColor(blue);
        price.setTextSize(14);
        price.setTypeface(null, Typeface.BOLD);
        details.addView(price);

        Button addButton = new Button(this);
        addButton.setText("+");
        addButton.setTextSize(20);
        addButton.setTextColor(Color.WHITE);
        addButton.setMinWidth(0);
        addButton.setMinimumWidth(0);
        addButton.setPadding(0, 0, 0, 0);
        addButton.setBackgroundTintList(ColorStateList.valueOf(blue));

        card.addView(addButton, new LinearLayout.LayoutParams(dp(42), dp(44)));

        productContainer.addView(card);
    }

    private int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }
}
