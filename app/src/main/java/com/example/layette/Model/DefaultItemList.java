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
            itemList.add(new ListItem(2,"Hordozó",false,true,"TRAVEL"));
            itemList.add(new ListItem(3,"Pelenkázó táska",false,true,"TRAVEL"));

        // CLOTHES
            itemList.add(new ListItem(4,"Body",false,true,"CLOTHES"));

        // HOSPITAL
            itemList.add(new ListItem(5,"Táska",false,true,"HOSPITAL"));


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
