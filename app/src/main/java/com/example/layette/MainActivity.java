package com.example.layette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.layette.Adapter.CategoryListAdapter;
import com.example.layette.Adapter.ItemListAdapter;
import com.example.layette.Database.DatabaseHelper;
import com.example.layette.Model.CategoryItem;
import com.example.layette.Model.DefaultCategoryItemList;
import com.example.layette.Model.DefaultItemList;
import com.example.layette.Model.ListItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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
    List<ListItem> listitem_travel, listitem_hospital, listitem_clothes, listitem_sleep, listitem_room;
    fragment_menu_defaultitems menu_defaultitems = new fragment_menu_defaultitems();
    fragment_menu_customitems menu_customitems = new fragment_menu_customitems();
    fragment_menu_settings menu_settings = new fragment_menu_settings();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         /*
            - progress bar a megjelölt tételekről
            - kattintáskor a kijelölt alulra kerüljön
            - valamilyen menürendszer:
                alul 3 menü: beépített, saját, beállítások (téma, )
            - excelben letölteni

         */


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
        listitem_sleep = new ArrayList<>();
        listitem_room = new ArrayList();

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
                case "SLEEP":
                    listitem_sleep.add(listItem);
                    break;
                case "ROOM":
                    listitem_room.add(listItem);
                    break;
            }

        }

        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(categoryItemList, this);

        categoryListAdapter.setOnItemClickListener(position -> {

            if (categoryItemList.get(position).getCategoryName().equals("Kórház")) {
                // sort

               /* Collections.sort(listitem_hospital, new Comparator<ListItem>() {

                    @Override
                    public int compare(ListItem o1, ListItem o2) {
                        return o1.getItemName().compareTo(o2.getItemName());
                    }
                });
*/


                ItemListAdapter itemAdapter_hospital = new ItemListAdapter(listitem_hospital,null);
                listItems.setAdapter(itemAdapter_hospital);

            } else if (categoryItemList.get(position).getCategoryName().equals("Utazás")){
                Collections.sort(listitem_travel, new Comparator<ListItem>() {

                    @Override
                    public int compare(ListItem o1, ListItem o2) {
                        int c;
                        boolean checked = o1.isItemChecked() == o2.isItemChecked();
                        if (checked){
                            c = 0;
                        } else
                            c = 1;

                        /*if (c == 0){
                            c = o1.getItemName().compareTo(o2.getItemName());
                        }*/
                        return c;
                        //return o1.getItemName().compareTo(o2.getItemName());
                    }
                });

                ItemListAdapter itemAdapter_travel = new ItemListAdapter(listitem_travel, null);
                listItems.setAdapter(itemAdapter_travel);

            } else if (categoryItemList.get(position).getCategoryName().equals("Ruha")){
                ItemListAdapter itemAdapter_clothes = new ItemListAdapter(listitem_clothes, null);
                listItems.setAdapter(itemAdapter_clothes);

            }
            else if (categoryItemList.get(position).getCategoryName().equals("Babaszoba")){
                ItemListAdapter itemAdapter_room = new ItemListAdapter(listitem_room,null);
                listItems.setAdapter(itemAdapter_room);
            }

            else if (categoryItemList.get(position).getCategoryName().equals("Alvás")){
                ItemListAdapter itemAdapter_sleep = new ItemListAdapter(listitem_sleep,null);
                listItems.setAdapter(itemAdapter_sleep);

            } else if (categoryItemList.get(position).getCategoryName().equals("Összes")){
                Collections.sort(defaultListItem, new Comparator<ListItem>() {

                    @Override
                    public int compare(ListItem o1, ListItem o2) {
                        return o1.getItemName().compareTo(o2.getItemName());
                    }
                });
                ItemListAdapter itemAdapter_sum = new ItemListAdapter(defaultListItem, null);
                listItems.setAdapter(itemAdapter_sum);
            }
        });

        categoryItems.setAdapter(categoryListAdapter);

        ItemListAdapter itemListAdapter3 = new ItemListAdapter(defaultListItem, this);

        itemListAdapter3.setOnItemClickListener(new ItemListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

        });
    }
}