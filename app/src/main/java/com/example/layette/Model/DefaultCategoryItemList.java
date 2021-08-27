package com.example.layette.Model;

import com.example.layette.R;
import java.util.ArrayList;
import java.util.List;

public class DefaultCategoryItemList {

    private static DefaultCategoryItemList defaultCategoryItemList;
    private static List<CategoryItem> itemList;


    private DefaultCategoryItemList(){
        itemList = new ArrayList<>();
        itemList.add(new CategoryItem(1,"Összes", R.mipmap.icon_sum_foreground));
        itemList.add(new CategoryItem(1,"Kórház", R.mipmap.icon_hospital_foreground));
        itemList.add(new CategoryItem(1,"Ruha", R.mipmap.icon_clothes_foreground));
        itemList.add(new CategoryItem(1,"Alvás", R.mipmap.icon_sleep_foreground));
        itemList.add(new CategoryItem(1,"Utazás", R.mipmap.icon_travel_foreground));
        itemList.add(new CategoryItem(1,"Terhesség", R.mipmap.icon_pregnancy_foreground));
        itemList.add(new CategoryItem(1,"Játék", R.mipmap.icon_toys_foreground));
        itemList.add(new CategoryItem(1,"Szoptatás", R.mipmap.icon_feeding_foreground));
        itemList.add(new CategoryItem(1,"Ápolás", R.mipmap.icon_care_foreground));
        itemList.add(new CategoryItem(1,"Babaszoba", R.mipmap.icon_travel_foreground));


        /*
        itemList.add(new CategoryItem(1,"Babaszoba", R.mipmap.icon_travel_foreground));
        itemList.add(new CategoryItem(1,"Kiegészítők", R.mipmap.icon_travel_foreground));;*/
    }

    public static DefaultCategoryItemList getInstance(){
        if (defaultCategoryItemList == null){
            defaultCategoryItemList = new DefaultCategoryItemList();
        }
        return defaultCategoryItemList;
    }

    public List<CategoryItem> getDefaultCategoryItems(){
        return itemList;
    }

}
