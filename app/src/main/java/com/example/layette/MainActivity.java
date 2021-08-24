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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryItems;
    RecyclerView listItems;
    LinearLayoutManager layoutManager;
    LinearLayoutManager layoutManager2;
    DatabaseHelper databaseHelper;
    List<ListItem> listitem_travel, listitem_hospital, listitem_clothes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = DatabaseHelper.getInstance(this);
        //databaseHelper.addDefaultCategoryItems();
        //databaseHelper.addDefaultItems();

        // KATEGÓRIA
            categoryItems = findViewById(R.id.category_list);
            layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            categoryItems.setLayoutManager(layoutManager);

        // TÉTELEK
            listItems = findViewById(R.id.item_list);
            layoutManager2 = new LinearLayoutManager(this);
            layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
            listItems.setLayoutManager(layoutManager2);

        // HA ELSŐ HASZNÁLAT, AKKOR ADATBÁZISBAN RÖGZÍTJÜK AZ ALAPÉRTELMEZETT KATEGÓRIÁKAT ÉS TÉTELEKET
        if (databaseHelper.isFirstUse()){
            DefaultCategoryItemList defaultCategoryItemList = DefaultCategoryItemList.getInstance();
            databaseHelper.addCategoryItems(defaultCategoryItemList.getDefaultCategoryItems());
            DefaultItemList defaultItemList = DefaultItemList.getInstance();
            databaseHelper.addItems(defaultItemList.getDefaultListItems());
        }

        // ALAPÉRTELMEZETT KATEGÓRIÁK ÉS TÉTELEK LEKÉRDEZÉSE
        List<CategoryItem> categoryItemList = databaseHelper.getCategoryItemList();
        List<ListItem> defaultListItem = databaseHelper.getDefaultItems();


        listitem_travel = new ArrayList<>();
        listitem_hospital = new ArrayList<>();
        listitem_clothes = new ArrayList<>();

        for (int i=0; i<defaultListItem.size(); i++){
            ListItem listItem = defaultListItem.get(i);
            switch (listItem.getCategoryName()){
                case "TRAVEL":
                    listitem_travel.add(listItem);
                    break;
                case "HOSPITAL":
                    listitem_hospital.add(listItem);
                    break;
                case "CLOTHES":
                    listitem_clothes.add(listItem);
                    break;
            }

        }

        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(categoryItemList, this);

        categoryListAdapter.setOnItemClickListener(new CategoryListAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position) {
                //categoryItemList.get(position);

                if (categoryItemList.get(position).getCategoryName().equals("Kórház")) {
                    ItemListAdapter itemAdapter_hospital = new ItemListAdapter(listitem_hospital,null);
                    listItems.setAdapter(itemAdapter_hospital);

                } else if (categoryItemList.get(position).getCategoryName().equals("Utazás")){
                    ItemListAdapter itemAdapter_travel = new ItemListAdapter(listitem_travel, null);
                    /*itemAdapter_travel.setOnItemClickListener(new ItemListAdapter.OnItemClickListener() {
                          @Override
                          public void onItemClick(int position) {
                              boolean isChecked = listitem_travel.get(position).isItemChecked();
                              databaseHelper.updateItem(listitem_travel.get(position).getItemId(), isChecked);
                              itemAdapter_travel.notifyDataSetChanged();
                              Log.i("qwe", "qwe");
                          }
                      });*/
                    listItems.setAdapter(itemAdapter_travel);

                    /*List<ListItem> defaultListItem = databaseHelper.getDefaultItems();
                    listitem_travel = new ArrayList<>();

                    for (int i=0; i<defaultListItem.size(); i++){
                        ListItem listItem = defaultListItem.get(i);
                        if (listItem.getCategoryName().equals("TRAVEL")){
                            listitem_travel.add(listItem);
                        }
                    }*/
                } else if (categoryItemList.get(position).getCategoryName().equals("Ruha")){
                    ItemListAdapter itemAdapter_clothes = new ItemListAdapter(listitem_clothes, null);
                    listItems.setAdapter(itemAdapter_clothes);
                }
            }
        });

        categoryItems.setAdapter(categoryListAdapter);










        //ItemListAdapter itemAdapter_travel = new ItemListAdapter(listitem_travel, null);
        /*itemAdapter_travel.setOnItemClickListener(new ItemListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                boolean isChecked = adapter_travel.get(position).isItemChecked();
                databaseHelper.updateItem(adapter_travel.get(position).getItemId(),isChecked);
                itemAdapter_travel.notifyDataSetChanged();
                Log.i("qwe","qwe");
            }
        });*/




        ItemListAdapter itemListAdapter3 = new ItemListAdapter(defaultListItem, this);

        itemListAdapter3.setOnItemClickListener(new ItemListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.i("asd","dsa");
            }

        });






        /*

            - kattintáskor a kijelölt alulra kerüljön
            - valamilyen menürendszer:
                alul 3 menü: beépített, saját, beállítások (téma, )

         */

    }

}