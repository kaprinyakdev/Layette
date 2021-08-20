package com.example.layette.Model;

public class ListItem {

    private String itemName;
    private boolean itemChecked;
    private String categoryName;
    private boolean isDefault;

    public ListItem(String itemName, boolean itemChecked, boolean isDefault, String categoryName) {
        this.itemName = itemName;
        this.itemChecked = itemChecked;
        this.isDefault = isDefault;
        this.categoryName = categoryName;
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

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
