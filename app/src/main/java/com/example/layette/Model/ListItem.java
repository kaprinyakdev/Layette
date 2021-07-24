package com.example.layette.Model;

public class ListItem {

    private String itemName;
    private boolean itemChecked;
    private int categoryId;

    public ListItem(String itemName, boolean itemChecked) {
        this.itemName = itemName;
        this.itemChecked = itemChecked;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isItemChecked() {
        return itemChecked;
    }

    public void setItemChecked(boolean itemChecked) {
        this.itemChecked = itemChecked;
    }
}