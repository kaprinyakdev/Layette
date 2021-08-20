package com.example.layette.Model;

import java.util.ArrayList;
import java.util.List;

public class DefaultItemList {

    private static DefaultItemList defaultItemList;
    private static List<ListItem> itemList;


    private DefaultItemList(){
        itemList = new ArrayList<>();
        itemList.add(new ListItem("test1",false,true,"SUM"));
        itemList.add(new ListItem("test2",false,true,"SUM"));
        itemList.add(new ListItem("test3",false,true,"SUM"));
        itemList.add(new ListItem("test4",false,true,"SUM"));
        itemList.add(new ListItem("test5",false,true,"SUM"));
        itemList.add(new ListItem("test6",false,true,"SUM"));
        itemList.add(new ListItem("test7",false,true,"SUM"));
        itemList.add(new ListItem("test8",false,true,"SUM"));
        itemList.add(new ListItem("test9",false,true,"SUM"));

        // UTAZÁS
        itemList.add(new ListItem("Babakocsi",false,true,"TRAVEL"));
        itemList.add(new ListItem("Hordozó",false,true,"TRAVEL"));


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
