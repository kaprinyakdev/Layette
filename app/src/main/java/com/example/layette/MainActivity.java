package com.example.layette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.layette.Adapter.CategoryListAdapter;
import com.example.layette.Model.CategoryItem;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView categoryItems;
    LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryItems = findViewById(R.id.category_list);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        categoryItems.setLayoutManager(layoutManager);

        List<CategoryItem> categoryItemList = new ArrayList();
            categoryItemList.add(new CategoryItem("test1"));
            categoryItemList.add(new CategoryItem("test2"));
            categoryItemList.add(new CategoryItem("test3"));

        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(categoryItemList, this);
        categoryItems.setAdapter(categoryListAdapter);


    }




}