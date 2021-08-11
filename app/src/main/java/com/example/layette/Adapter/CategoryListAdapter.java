package com.example.layette.Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.layette.Model.CategoryItem;
import com.example.layette.R;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryListHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;
    private ItemClickListener itemClickListener;
    private View itemView;
    private int row_index = -1;

    public CategoryListAdapter(List<CategoryItem> categoryItemList, Context context, ItemClickListener itemClickListener){
        this.context = context;
        this.categoryItemList = categoryItemList;
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public CategoryListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new CategoryListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListHolder holder, int position) {

        CategoryItem categoryItem = categoryItemList.get(position);
        holder.categoryName.setText(categoryItem.getCategoryName());
        holder.categoryImage.setImageResource(categoryItem.getCategoryImage());
        holder.itemView.setOnClickListener(view -> {
                    row_index = holder.getPosition();
                    notifyDataSetChanged();
                    itemClickListener.onItemClick(categoryItemList.get(position));
            Toast.makeText(context,String.valueOf(row_index),Toast.LENGTH_SHORT).show();
                    if (row_index==position && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        holder.itemView.setForeground(ContextCompat.getDrawable(context,R.color.teal_200));
                    } else {
                        if (row_index != position && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                            holder.itemView.setForeground(ContextCompat.getDrawable(context,R.color.white));
                    }




                    }

                    /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        holder.itemView.setForeground(ContextCompat.getDrawable(context,R.color.teal_200));
                    }*/
                }
        );
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public interface ItemClickListener{
        void onItemClick(CategoryItem categoryItem);
    }

    public static class CategoryListHolder extends RecyclerView.ViewHolder {
            protected TextView categoryName;
            protected ImageView categoryImage;

            public CategoryListHolder(View v){
                super(v);
                categoryName = v.findViewById(R.id.categoryName);
                categoryImage = v.findViewById(R.id.categoryImage);
            }
    }
}
