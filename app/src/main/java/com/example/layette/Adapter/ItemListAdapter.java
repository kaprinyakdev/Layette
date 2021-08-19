package com.example.layette.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.layette.Model.ListItem;
import com.example.layette.R;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListHolder> {

    private Context context;
    private List<ListItem> listItemList;
    private ItemListAdapter.OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(ItemListAdapter.OnItemClickListener listener) {
        mListener = listener;
    }

    public ItemListAdapter(List<ListItem> listItemList, Context context){
        this.context = context;
        this.listItemList = listItemList;
    }

    @NonNull
    @Override
    public ItemListAdapter.ItemListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ItemListAdapter.ItemListHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ItemListHolder holder, int position) {
        ListItem listItem = listItemList.get(position);
        holder.itemChecked.setChecked(listItem.isItemChecked());
        holder.itemChecked.setText(listItem.getItemName());



        holder.itemChecked.setOnClickListener(view -> {

            }
        );

    }

    @Override
    public int getItemCount() {
        return listItemList.size();
    }

    public static class ItemListHolder extends RecyclerView.ViewHolder {
        protected CheckBox itemChecked;

        public ItemListHolder(View v, final ItemListAdapter.OnItemClickListener listener){
            super(v);
            itemChecked = v.findViewById(R.id.itemChecked);
            v.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
