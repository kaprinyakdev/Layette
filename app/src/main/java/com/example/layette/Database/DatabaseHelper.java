package com.example.layette.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.layette.Model.CategoryItem;
import com.example.layette.Model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "layette";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper databaseInstance;

    private static final String TABLE_CATEGORYITEM = "categoryitem";
    private static final String KEY_CATEGORYITEM_ID = "id";
    private static final String KEY_CATEGORYITEM_NAME = "name";

    private static final String TABLE_LISTITEM = "listitem";
    private static final String KEY_LISTITEM_ID = "id";
    private static final String KEY_LISTITEM_NAME = "name";
    private static final String KEY_LISTITEM_CATEGORYITEMID = "categoryitemid";



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
                + KEY_CATEGORYITEM_NAME + " TEXT"
                +")";
        db.execSQL(create_categoryitem_table);

        String create_listitem_table = "CREATE TABLE IF NOT EXISTS " + TABLE_LISTITEM + "("
                + KEY_LISTITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_LISTITEM_NAME + " TEXT,"
                + KEY_LISTITEM_CATEGORYITEMID + " INTEGER"
                +")";
        db.execSQL(create_listitem_table);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public List<CategoryItem> getCategoryItemList(){
        List<CategoryItem> categoryItemList = new ArrayList<>();

        /*
        String query = String.format("SELECT * FROM %s",TABLE_BABY);
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        try {
            if(cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndex(KEY_BABY_ID));
                    String name = cursor.getString(cursor.getColumnIndex(KEY_BABY_NAME));
                    boolean isGirl = cursor.getString(cursor.getColumnIndex(KEY_BABY_GENDER)).matches("true");
                    int weight = cursor.getInt(cursor.getColumnIndex(KEY_BABY_BIRTHWEIGHT));
                    String date = cursor.getString(cursor.getColumnIndex(KEY_BABY_BIRTHDATE));

                    BabyCard babyItem = new BabyCard(id, name, date, weight, isGirl);
                    babyList.add(babyItem);

                } while (cursor.moveToNext());
            }
        } catch (Exception e){
            Log.i("asd", e.getMessage());
        } finally {
            if (cursor != null || !cursor.isClosed()){
                cursor.close();
            }
        }
        */

        return categoryItemList;
    }

    public List<ListItem> getListItemList(){
        List<ListItem> listItemList = new ArrayList<>();



        return listItemList;
    }
}
