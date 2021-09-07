package com.example.layette.Model;

import java.util.ArrayList;
import java.util.List;

public class DefaultItemList {

    private static DefaultItemList defaultItemList;
    private static List<ListItem> itemList;


    private DefaultItemList(){
        itemList = new ArrayList<>();

        // TRAVEL
            itemList.add(new ListItem(1,"Újszülött babakocsi",false,true,"TRAVEL"));
            itemList.add(new ListItem(1,"Autós hordozó",false, true, "TRAVEL"));
            itemList.add(new ListItem(1,"Babahordozó",false,true,"TRAVEL"));
            itemList.add(new ListItem(1,"Pelenkázó táska",false,true,"TRAVEL"));

        // CLOTHES
            itemList.add(new ListItem(1,"Body",false,true,"CLOTHES"));

        // HOSPITAL
            itemList.add(new ListItem(1,"Táska",false,true,"HOSPITAL"));


        // ROOM
            itemList.add(new ListItem(1,"Kiságy vagy kombiágy",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Matrac (kókusz vagy szivacs)",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Matracvédő (2-3 db)",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Lepedő (2-3 db)",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Ágyneműgarnitúra (2-3 db)",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Éjjeli fény",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Szekrény",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Pelenkázó komód",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Pelenkázó lap",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Pelenkatároló szemetes",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Rácsvédő",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Babatakaró (3 db)",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Hálózsák (3 db)",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Légzésfigyelő",false, true, "ROOM"));
            itemList.add(new ListItem(1,"Bébiőr",false, true, "ROOM"));



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
