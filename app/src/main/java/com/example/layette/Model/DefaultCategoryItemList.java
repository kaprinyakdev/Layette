package com.example.layette.Model;

import com.example.layette.R;
import java.util.ArrayList;
import java.util.List;

public class DefaultCategoryItemList {

    private static DefaultCategoryItemList defaultCategoryItemList;
    private static List<CategoryItem> itemList;


    private DefaultCategoryItemList(){
        itemList = new ArrayList<>();
        itemList.add(new CategoryItem(1, "Összes", R.mipmap.icon_summary_foreground));
        itemList.add(new CategoryItem(1,"Kórház", R.mipmap.icon_hospital_foreground));
        itemList.add(new CategoryItem(1,"Ruha", R.mipmap.icon_babyclothes_foreground));
        itemList.add(new CategoryItem(1,"Alvás", R.mipmap.icon_babyclothes_foreground));
        itemList.add(new CategoryItem(1,"Utazás", R.mipmap.icon_travel_foreground));
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
