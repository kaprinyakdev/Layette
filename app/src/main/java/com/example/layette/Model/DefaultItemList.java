package com.example.layette.Model;

import java.util.ArrayList;
import java.util.List;

public class DefaultItemList {

    private static DefaultItemList defaultItemList;
    private static List<ListItem> itemList;


    private DefaultItemList(){
        itemList = new ArrayList<>();
        itemList.add(new ListItem("test1",true,true));
        itemList.add(new ListItem("test2",true,true));
        itemList.add(new ListItem("test3",true,true));
        itemList.add(new ListItem("test4",false,true));
        itemList.add(new ListItem("test5",false,true));
        itemList.add(new ListItem("test6",false,true));
        itemList.add(new ListItem("test7",true,false));
        itemList.add(new ListItem("test8",true,false));
        itemList.add(new ListItem("test9",true,false));
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
