package com.example.layette.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.layette.Model.CategoryItem;
import com.example.layette.Model.ListItem;
import com.example.layette.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "layette";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper databaseInstance;
    private static final String TABLE_CATEGORYITEM = "categoryitem";
    private static final String KEY_CATEGORYITEM_ID = "id";
    private static final String KEY_CATEGORYITEM_NAME = "name";
    private static final String KEY_CATEGORYITEM_IMAGE = "image";
    private static final String TABLE_LISTITEM = "listitem";
    private static final String KEY_LISTITEM_ID = "id";
    private static final String KEY_LISTITEM_NAME = "name";
    private static final String KEY_LISTITEM_CATEGORYITEMID = "categoryitemid";
    private static final String KEY_LISTITEM_ISDEFAULT = "isdefault";



    private DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    public static synchronized DatabaseHelper getInstance(Context context){
        if (databaseInstance == null){
            databaseInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return databaseInstance;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_categoryitem_table = "CREATE TABLE IF NOT EXISTS " + TABLE_CATEGORYITEM + "("
                + KEY_CATEGORYITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_CATEGORYITEM_NAME + " TEXT,"
                + KEY_CATEGORYITEM_IMAGE + " INTEGER "
                +")";
        db.execSQL(create_categoryitem_table);

        String create_listitem_table = "CREATE TABLE IF NOT EXISTS " + TABLE_LISTITEM + "("
                + KEY_LISTITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_LISTITEM_NAME + " TEXT,"
                + KEY_LISTITEM_CATEGORYITEMID + " INTEGER,"
                + KEY_LISTITEM_ISDEFAULT + " INTEGER DEFAULT 0"
                +")";
        db.execSQL(create_listitem_table);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addCategoryItem(String name, int image){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put(KEY_CATEGORYITEM_NAME, name);
            values.put(KEY_CATEGORYITEM_IMAGE, image);
        database.insert(TABLE_CATEGORYITEM,null,values);

    }

    public void addCategoryItems(List<CategoryItem> categoryItemList){
        SQLiteDatabase database = this.getWritableDatabase();
        for (int i=0; i<categoryItemList.size(); i++){
            ContentValues values = new ContentValues();
                values.put(KEY_CATEGORYITEM_NAME, categoryItemList.get(i).getCategoryName());
                values.put(KEY_CATEGORYITEM_IMAGE, categoryItemList.get(i).getCategoryImage());
                database.insert(TABLE_CATEGORYITEM,null,values);
        }
    }

    public void addItems(List<ListItem> itemList){
        SQLiteDatabase database = this.getWritableDatabase();
        for (int i=0; i<itemList.size(); i++){
            ContentValues values = new ContentValues();
                values.put(KEY_LISTITEM_NAME, itemList.get(i).getItemName());
                values.put(KEY_LISTITEM_ISDEFAULT, 1);
                database.insert(TABLE_LISTITEM, null, values);
        }
    }

    public boolean isFirstUse(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor categoryItemCounter = database.rawQuery("select count(*) from " + TABLE_CATEGORYITEM, null);
        categoryItemCounter.moveToFirst();
        int count = categoryItemCounter.getInt(0);
        categoryItemCounter.close();

        return count == 0;
    }

    public void addDefaultCategoryItem(){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put(KEY_CATEGORYITEM_ID,1);
            values.put(KEY_CATEGORYITEM_NAME, "Összes");
            values.put(KEY_CATEGORYITEM_IMAGE, R.mipmap.icon_summary_foreground);
        database.insert(TABLE_CATEGORYITEM,null,values);

    }

    public void deleteCategoryItems(){
        SQLiteDatabase database = this.getWritableDatabase();
            database.execSQL("delete from "+ TABLE_CATEGORYITEM);
            database.close();
    }

    public List<CategoryItem> getCategoryItemList(){
        List<CategoryItem> categoryItemList = new ArrayList<>();

        String query = String.format("SELECT * FROM %s",TABLE_CATEGORYITEM);

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        try {
            if(cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndex(KEY_CATEGORYITEM_ID));
                    String name = cursor.getString(cursor.getColumnIndex(KEY_CATEGORYITEM_NAME));
                    int image = cursor.getInt(cursor.getColumnIndex(KEY_CATEGORYITEM_IMAGE));

                    CategoryItem categoryItem = new CategoryItem(id, name, image);
                    categoryItemList.add(categoryItem);
                } while (cursor.moveToNext());
            }
        } catch (Exception e){
            Log.i("asd", e.getMessage());
        } finally {
            if (cursor != null || !cursor.isClosed()){
                cursor.close();
            }
        }
        return categoryItemList;
    }


    public List<ListItem> getAllDefaultItem(){
        List<ListItem> defaultItems = new ArrayList<>();

        String query = String.format("SELECT * FROM " + TABLE_LISTITEM + " WHERE " + KEY_LISTITEM_ISDEFAULT + " = 1");

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        try {
            if(cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex(KEY_LISTITEM_NAME));
                    ListItem listItem = new ListItem(name, false, true, "TRAVEL");
                    defaultItems.add(listItem);
                } while (cursor.moveToNext());
            }
        } catch (Exception e){
            Log.i("asd", e.getMessage());
        } finally {
            if (cursor != null || !cursor.isClosed()){
                cursor.close();
            }
        }

        return defaultItems;
    }

}
