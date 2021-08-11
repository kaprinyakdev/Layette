package com.example.layette;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.layette.Database.DatabaseHelper;

public class AddCategoryItemActivity extends Activity {

    private EditText category_item_name;
    private Button category_item_add;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_item_add);

        category_item_name = findViewById(R.id.category_item_name);
        category_item_add = findViewById(R.id.category_item_add);


        databaseHelper = DatabaseHelper.getInstance(this);

        category_item_add.setOnClickListener(v -> {

            databaseHelper.addCategoryItem("test",R.drawable.ic_launcher_foreground);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });



    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
