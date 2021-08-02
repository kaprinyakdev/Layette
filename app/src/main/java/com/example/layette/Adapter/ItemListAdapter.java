package com.example.layette.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.layette.AddCategoryItemActivity;
import com.example.layette.Model.ListItem;
import com.example.layette.R;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListHolder> {

    private Context context;
    private List<ListItem> listItemList;
    private CategoryListAdapter.ItemClickListener itemClickListener;


    public ItemListAdapter(List<ListItem> listItemList, Context context){
        this.context = context;
        this.listItemList = listItemList;
    }

    @NonNull
    @Override
    public ItemListAdapter.ItemListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ItemListAdapter.ItemListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ItemListHolder holder, int position) {
        ListItem listItem = listItemList.get(position);
        //holder.itemName.setText(listItem.getItemName());
        holder.itemChecked.setChecked(listItem.isItemChecked());
        holder.itemChecked.setText(listItem.getItemName());



        holder.itemChecked.setOnClickListener(view -> {

            }
        );

        /*holder.itemChecked.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return listItemList.size();
    }

    public static class ItemListHolder extends RecyclerView.ViewHolder {
        //protected TextView itemName;
        protected CheckBox itemChecked;

        public ItemListHolder(View v){
            super(v);
            //itemName = v.findViewById(R.id.itemName);
            itemChecked = v.findViewById(R.id.itemChecked);
        }
    }
}
