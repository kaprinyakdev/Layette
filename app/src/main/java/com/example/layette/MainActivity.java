package com.example.layette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.Toast;

import com.example.layette.Adapter.CategoryListAdapter;
import com.example.layette.Adapter.ItemListAdapter;
import com.example.layette.Model.CategoryItem;
import com.example.layette.Model.ListItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView categoryItems;
    RecyclerView listItems;
    LinearLayoutManager layoutManager;
    LinearLayoutManager layoutManager2;


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

        List<CategoryItem> categoryItemList = new ArrayList();
            categoryItemList.add(new CategoryItem("Összes",R.drawable.ic_launcher_foreground));
            categoryItemList.add(new CategoryItem("Új",R.drawable.ic_launcher_foreground));
            categoryItemList.add(new CategoryItem("test3",R.drawable.ic_launcher_foreground));

        List<ListItem> listItemList = new ArrayList();
            listItemList.add(new ListItem("első",true));
            listItemList.add(new ListItem("második",true));
            listItemList.add(new ListItem("harmadik",true));
            listItemList.add(new ListItem("negyedik",true));


        List<ListItem> listItemList2 = new ArrayList();
            listItemList2.add(new ListItem("első2",false));
            listItemList2.add(new ListItem("második2",false));
            listItemList2.add(new ListItem("harmadik2",false));
            listItemList2.add(new ListItem("negyedik2",false));


        ItemListAdapter itemListAdapter2 = new ItemListAdapter(listItemList2, this);
        ItemListAdapter itemListAdapter = new ItemListAdapter(listItemList, this);

        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(categoryItemList, this, new CategoryListAdapter.ItemClickListener() {
            @Override
            public void onItemClick(CategoryItem categoryItem) {
                showToast(categoryItem.getCategoryName());
                if (categoryItem.getCategoryName().equals("Összes")){
                    listItems.setAdapter(itemListAdapter);
                } else {
                    listItems.setAdapter(itemListAdapter2);
                }
            }
        });
        categoryItems.setAdapter(categoryListAdapter);

        //listItems.setAdapter(itemListAdapter);



        /*

            - kattintáskor a kijelölt alulra kerüljön
            - valamilyen menürendszer
            - adatbázis műveletek

         */


    }

    private void showToast(String asd){
        Toast.makeText(this,asd,Toast.LENGTH_LONG).show();
    }
}