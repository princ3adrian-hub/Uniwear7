package com.example.uniwear7;

import android.app.AlertDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductsCatalogActivity extends AppCompatActivity {

    private LinearLayout productContainer;
    private EditText searchInput;
    private TextView cartButton;

    private final List<Product> products = new ArrayList<>();
    private final List<Product> cart = new ArrayList<>();

    private String selectedCategory = "All";

    private final int blue = Color.rgb(23, 59, 131);
    private final int lightGray = Color.rgb(230, 233, 240);

    // Product information
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
        setupCategories();
        setupSearch();
        setupButtons();
        updateCartCount();
        displayProducts();
    }

    // Sample catalog
    private void loadProducts() {
        products.clear();

        products.add(new Product(
                "Polo Shirt", "White", "Top", "👕", 350.00));

        products.add(new Product(
                "P.E. Shirt", "Blue", "Top", "👕", 300.00));

        products.add(new Product(
                "Skirt", "Navy Blue", "Bottom", "👗", 450.00));

        products.add(new Product(
                "School Pants", "Black", "Bottom", "👖", 400.00));

        products.add(new Product(
                "Tie", "School Tie", "Accessories", "👔", 150.00));

        products.add(new Product(
                "Socks", "White Socks", "Accessories", "🧦", 80.00));

        products.add(new Product(
                "School Belt", "Black", "Accessories", "🧷", 120.00));
    }

    // Category buttons
    private void setupCategories() {
        setCategoryButton(R.id.categoryAll, "All");
        setCategoryButton(R.id.categoryTop, "Top");
        setCategoryButton(R.id.categoryBottom, "Bottom");
        setCategoryButton(
                R.id.categoryAccessories, "Accessories");

        updateCategoryStyles();
    }

    private void setCategoryButton(int id, String category) {
        Button button = findViewById(id);

        button.setOnClickListener(v -> {
            selectedCategory = category;
            updateCategoryStyles();
            displayProducts();
        });
    }

    private void updateCategoryStyles() {
        int[] ids = {
                R.id.categoryAll,
                R.id.categoryTop,
                R.id.categoryBottom,
                R.id.categoryAccessories
        };

        String[] categories = {
                "All", "Top", "Bottom", "Accessories"
        };

        for (int i = 0; i < ids.length; i++) {
            Button button = findViewById(ids[i]);
            boolean selected =
                    categories[i].equals(selectedCategory);

            button.setBackgroundTintList(
                    ColorStateList.valueOf(
                            selected ? blue : Color.WHITE));

            button.setTextColor(
                    selected ? Color.WHITE : Color.DKGRAY);
        }
    }

    // Search while typing
    private void setupSearch() {
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                displayProducts();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    // Filter and display matching products
    private void displayProducts() {
        productContainer.removeAllViews();

        String query = searchInput.getText()
                .toString().trim().toLowerCase(Locale.ROOT);

        int count = 0;

        for (Product product : products) {
            boolean categoryMatches =
                    selectedCategory.equals("All")
                            || product.category.equals(selectedCategory);

            boolean searchMatches =
                    product.name.toLowerCase(Locale.ROOT)
                            .contains(query)
                            || product.description.toLowerCase(Locale.ROOT)
                            .contains(query);

            if (categoryMatches && searchMatches) {
                addProductCard(product);
                count++;
            }
        }

        if (count == 0) {
            TextView empty = new TextView(this);
            empty.setText("No products found.");
            empty.setTextColor(Color.GRAY);
            empty.setTextSize(16);
            empty.setGravity(Gravity.CENTER);
            empty.setPadding(12, dp(30), 12, dp(30));

            productContainer.addView(empty);
        }
    }

    // Create a product card programmatically
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

        // Product image placeholder
        TextView image = new TextView(this);
        image.setText(product.emoji);
        image.setTextSize(30);
        image.setGravity(Gravity.CENTER);

        GradientDrawable imageBackground =
                new GradientDrawable();
        imageBackground.setColor(
                Color.rgb(245, 247, 252));
        imageBackground.setCornerRadius(dp(12));
        image.setBackground(imageBackground);

        LinearLayout.LayoutParams imageParams =
                new LinearLayout.LayoutParams(dp(55), dp(65));
        imageParams.setMarginEnd(dp(10));

        card.addView(image, imageParams);

        // Product details
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
        price.setText(String.format(
                Locale.US, "₱%.2f", product.price));
        price.setTextColor(blue);
        price.setTextSize(14);
        price.setTypeface(null, Typeface.BOLD);
        details.addView(price);

        // Add to cart button
        Button addButton = new Button(this);
        addButton.setText("+");
        addButton.setTextSize(20);
        addButton.setTextColor(Color.WHITE);
        addButton.setMinWidth(0);
        addButton.setMinimumWidth(0);
        addButton.setPadding(0, 0, 0, 0);
        addButton.setBackgroundTintList(
                ColorStateList.valueOf(blue));

        card.addView(addButton,
                new LinearLayout.LayoutParams(dp(42), dp(44)));

        addButton.setOnClickListener(v -> {
            cart.add(product);
            updateCartCount();

            Toast.makeText(
                    this,
                    product.name + " added to cart!",
                    Toast.LENGTH_SHORT
            ).show();
        });

        productContainer.addView(card);
    }

    // Cart item count
    private void updateCartCount() {
        cartButton.setText("🛒 " + cart.size());
    }

    // Show cart contents and total price
    private void showCart() {
        if (cart.isEmpty()) {
            Toast.makeText(
                    this, "Your cart is empty.",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        StringBuilder message = new StringBuilder();
        double total = 0;

        for (Product product : cart) {
            message.append(product.name)
                    .append(" - ")
                    .append(String.format(
                            Locale.US, "₱%.2f", product.price))
                    .append("\n");

            total += product.price;
        }

        message.append("\nTotal: ")
                .append(String.format(
                        Locale.US, "₱%.2f", total));

        new AlertDialog.Builder(this)
                .setTitle("Your Shopping Cart")
                .setMessage(message.toString())
                .setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                })
                .setNegativeButton("Clear Cart", (dialog, which) -> {
                    cart.clear();
                    updateCartCount();

                    Toast.makeText(
                            this, "Cart cleared.",
                            Toast.LENGTH_SHORT
                    ).show();
                })
                .show();
    }

    // Screen buttons
    private void setupButtons() {
        cartButton.setOnClickListener(v -> showCart());

        findViewById(R.id.backButton).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.navHome).setOnClickListener(v ->
                Toast.makeText(this, "Home",
                        Toast.LENGTH_SHORT).show());

        findViewById(R.id.navOrders).setOnClickListener(v ->
                Toast.makeText(this, "My Orders",
                        Toast.LENGTH_SHORT).show());

        findViewById(R.id.navProfile).setOnClickListener(v ->
                Toast.makeText(this, "Profile",
                        Toast.LENGTH_SHORT).show());
    }

    private int dp(float value) {
        return (int) (value * getResources()
                .getDisplayMetrics().density + 0.5f);
    }
}

