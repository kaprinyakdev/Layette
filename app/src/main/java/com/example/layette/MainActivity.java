package com.example.layette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
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
    List<ListItem> adapter_sum, adapter_travel;


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


        // DEFAULT KATEGÓRIÁK ÉS ITEMEK LEKÉRDEZÉSE
        DefaultCategoryItemList defaultCategoryItemList = DefaultCategoryItemList.getInstance();
        DefaultItemList defaultItemList = DefaultItemList.getInstance();


        // HA ELSŐ HASZNÁLAT, AKKOR HOZZÁADJUK AZ ALAPÉRTELMEZETT KATEGÓRIÁKAT
        if (databaseHelper.isFirstUse()){
            databaseHelper.addCategoryItems(defaultCategoryItemList.getDefaultCategoryItems());
            databaseHelper.addItems(defaultItemList.getDefaultListItems());
        }


        List<CategoryItem> categoryItemList = databaseHelper.getCategoryItemList();
        List<ListItem> defaultListItem = defaultItemList.getDefaultListItems();
        adapter_sum = new ArrayList<>();
        adapter_travel = new ArrayList<>();

        for (int i=0; i<defaultListItem.size(); i++){
            ListItem listItem = defaultListItem.get(i);
            if (listItem.getCategoryName().equals("SUM")){
                adapter_sum.add(listItem);
            } else if (listItem.getCategoryName().equals("TRAVEL")){
                adapter_travel.add(listItem);
            }
        }

        ItemListAdapter itemAdapter_sum = new ItemListAdapter(adapter_sum, null);
        ItemListAdapter itemAdapter_travel = new ItemListAdapter(adapter_travel, null);


        ItemListAdapter itemListAdapter3 = new ItemListAdapter(defaultListItem, this);

        itemAdapter_travel.setOnItemClickListener(new ItemListAdapter.OnItemClickListener() {
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

                } else if (categoryItemList.get(position).getCategoryName().equals("Utazás")){
                    listItems.setAdapter(itemAdapter_travel);
                }



                //categoryItemList.add(new CategoryItem(6,"Kórház",R.mipmap.icon_hospital_foreground));
                //categoryItemList.add(new CategoryItem(7,"Ruha",R.mipmap.icon_babyclothes_foreground));
                //categoryListAdapter.notifyItemChanged(position);
            }
        });

        categoryItems.setAdapter(categoryListAdapter);
        listItems.setAdapter(itemListAdapter3);




        /*

            - kattintáskor a kijelölt alulra kerüljön
            - valamilyen menürendszer:
                alul 3 menü: beépített, saját, beállítások (téma, )

         */

    }

}