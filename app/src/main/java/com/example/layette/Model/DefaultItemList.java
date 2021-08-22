package com.example.layette.Model;

import java.util.ArrayList;
import java.util.List;

public class DefaultItemList {

    private static DefaultItemList defaultItemList;
    private static List<ListItem> itemList;


    private DefaultItemList(){
        itemList = new ArrayList<>();
        itemList.add(new ListItem(1,"test1",false,true,"SUM"));
        itemList.add(new ListItem(2,"test2",false,true,"SUM"));
        itemList.add(new ListItem(3,"test3",false,true,"SUM"));
        itemList.add(new ListItem(4,"test4",false,true,"SUM"));
        itemList.add(new ListItem(5,"test5",false,true,"SUM"));
        itemList.add(new ListItem(6,"test6",false,true,"SUM"));
        itemList.add(new ListItem(7,"test7",false,true,"SUM"));
        itemList.add(new ListItem(8,"test8",false,true,"SUM"));
        itemList.add(new ListItem(9,"test9",false,true,"SUM"));

        // UTAZÁS
            itemList.add(new ListItem(1,"Babakocsi",false,true,"TRAVEL"));
            itemList.add(new ListItem(2,"Hordozó",false,true,"TRAVEL"));
            itemList.add(new ListItem(3,"Pelenkázó táska",false,true,"TRAVEL"));
        //


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
