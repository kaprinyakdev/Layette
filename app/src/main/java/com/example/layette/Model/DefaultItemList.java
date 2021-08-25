package com.example.layette.Model;

import java.util.ArrayList;
import java.util.List;

public class DefaultItemList {

    private static DefaultItemList defaultItemList;
    private static List<ListItem> itemList;


    private DefaultItemList(){
        itemList = new ArrayList<>();

        // TRAVEL
            itemList.add(new ListItem(1,"Babakocsi",false,true,"TRAVEL"));
            itemList.add(new ListItem(1,"Hordozó",false,true,"TRAVEL"));
            itemList.add(new ListItem(1,"Pelenkázó táska",false,true,"TRAVEL"));

        // SLEEP
            itemList.add(new ListItem(1, "Kiságy",false,true,"SLEEP"));
            itemList.add(new ListItem(1, "Matrac",false,true,"SLEEP"));

        // CLOTHES
            itemList.add(new ListItem(1,"Body",false,true,"CLOTHES"));

        // HOSPITAL
            itemList.add(new ListItem(1,"Táska",false,true,"HOSPITAL"));


    }

    public static DefaultItemList getInstance(){
        if (defaultItemList == null){
            defaultItemList = new DefaultItemList();
        }
        return defaultItemList;
    }

    public List<ListItem> getDefaultListItems(){
        return itemList;
    }

}
