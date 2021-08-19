package com.example.layette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.layette.Adapter.CategoryListAdapter;
import com.example.layette.Adapter.ItemListAdapter;
import com.example.layette.Database.DatabaseHelper;
import com.example.layette.Model.CategoryItem;
import com.example.layette.Model.DefaultCategoryItemList;
import com.example.layette.Model.DefaultItemList;
import com.example.layette.Model.ListItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView categoryItems;
    RecyclerView listItems;
    LinearLayoutManager layoutManager;
    LinearLayoutManager layoutManager2;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryItems = findViewById(R.id.category_list);
        listItems = findViewById(R.id.item_list);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);


        layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);

        categoryItems.setLayoutManager(layoutManager);
        listItems.setLayoutManager(layoutManager2);

        databaseHelper = DatabaseHelper.getInstance(this);

        DefaultCategoryItemList defaultCategoryItemList = DefaultCategoryItemList.getInstance();
        DefaultItemList defaultItemList = DefaultItemList.getInstance();

        if (databaseHelper.isFirstUse()){
            databaseHelper.addCategoryItems(defaultCategoryItemList.getDefaultCategoryItems());
            databaseHelper.addItems(defaultItemList.getDefaultListItems());
        }


        List<CategoryItem> categoryItemList = databaseHelper.getCategoryItemList();
        List<ListItem> defaultListItem = defaultItemList.getDefaultListItems();

        List<ListItem> listItemList = new ArrayList();
            listItemList.add(new ListItem("első",true, true));
            listItemList.add(new ListItem("második",true, true));
            listItemList.add(new ListItem("harmadik",true, true));
            listItemList.add(new ListItem("negyedik",true, true));


        List<ListItem> listItemList2 = new ArrayList();
            listItemList2.add(new ListItem("első2",false, true));
            listItemList2.add(new ListItem("második2",false, true));
            listItemList2.add(new ListItem("harmadik2",false, true));
            listItemList2.add(new ListItem("negyedik2",false, true));


        ItemListAdapter itemListAdapter2 = new ItemListAdapter(listItemList2, this);
        ItemListAdapter itemListAdapter = new ItemListAdapter(listItemList, this);
        ItemListAdapter itemListAdapter3 = new ItemListAdapter(defaultListItem, this);

        itemListAdapter2.setOnItemClickListener(new ItemListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.i("asd","dsa");
            }
        });

        itemListAdapter3.setOnItemClickListener(new ItemListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.i("asd","dsa");
            }
        });


        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(categoryItemList, this);

        categoryListAdapter.setOnItemClickListener(new CategoryListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.i("asd","asd");
                categoryItemList.get(position);

                if (categoryItemList.get(position).getCategoryName().equals("Összes")) {
                    listItems.setAdapter(itemListAdapter3);
                } else {
                    listItems.setAdapter(itemListAdapter2);
                }



                //categoryItemList.add(new CategoryItem(6,"Kórház",R.mipmap.icon_hospital_foreground));
                //categoryItemList.add(new CategoryItem(7,"Ruha",R.mipmap.icon_babyclothes_foreground));
                //categoryListAdapter.notifyItemChanged(position);
            }
        });

        categoryItems.setAdapter(categoryListAdapter);
        listItems.setAdapter(itemListAdapter);




        /*

            - kattintáskor a kijelölt alulra kerüljön
            - valamilyen menürendszer:
                alul 3 menü: beépített, saját, beállítások (téma, )

         */

    }

}