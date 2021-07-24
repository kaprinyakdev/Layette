package com.example.layette.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.layette.Model.CategoryItem;
import com.example.layette.R;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryListHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;
    private ItemClickListener itemClickListener;

    public CategoryListAdapter(List<CategoryItem> categoryItemList, Context context, ItemClickListener itemClickListener){
        this.context = context;
        this.categoryItemList = categoryItemList;
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public CategoryListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new CategoryListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.CategoryListHolder holder, int position) {
        CategoryItem categoryItem = categoryItemList.get(position);
        holder.categoryName.setText(categoryItem.getCategoryName());
        holder.categoryImage.setImageResource(categoryItem.getCategoryImage());
        holder.itemView.setOnClickListener(view -> {
                    itemClickListener.onItemClick(categoryItemList.get(position));
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
