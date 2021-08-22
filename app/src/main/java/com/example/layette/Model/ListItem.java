package com.example.layette.Model;

import androidx.annotation.Nullable;

public class ListItem {


    private @Nullable int itemId;
    private String itemName;
    private boolean itemChecked;
    private String categoryName;
    private boolean isDefault;

    public ListItem(@Nullable int itemId, String itemName, boolean itemChecked, boolean isDefault, String categoryName) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemChecked = itemChecked;
        this.isDefault = isDefault;
        this.categoryName = categoryName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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
