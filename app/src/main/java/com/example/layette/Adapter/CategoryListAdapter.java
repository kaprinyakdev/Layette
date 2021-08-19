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
    private View itemView;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public CategoryListAdapter(List<CategoryItem> categoryItemList, Context context){
        this.context = context;
        this.categoryItemList = categoryItemList;
    }


    @NonNull
    @Override
    public CategoryListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new CategoryListHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListHolder holder, int position) {

        CategoryItem categoryItem = categoryItemList.get(position);
        holder.categoryName.setText(categoryItem.getCategoryName());
        holder.categoryImage.setImageResource(categoryItem.getCategoryImage());

        /*holder.categoryImage.setOnClickListener(view -> {

            int index = holder.getLayoutPosition();
            //itemClickListener.onItemClick(categoryItemList.get(position));

                    /*row_index = holder.getAdapterPosition();


                    if (row_index==position && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                        Toast.makeText(context,categoryItem.getCategoryName(),Toast.LENGTH_SHORT).show();
                        holder.itemView.setForeground(ContextCompat.getDrawable(context,R.color.teal_200));
                        holder.categoryName.setTextColor(Color.WHITE);


                    } else {
                        if (row_index != position && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                            holder.itemView.setForeground(ContextCompat.getDrawable(context,R.color.white));
                    }

                    }
                }
        );*/
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }


    public static class CategoryListHolder extends RecyclerView.ViewHolder {
            protected TextView categoryName;
            protected ImageView categoryImage;

            public CategoryListHolder(View v, final OnItemClickListener listener){
                super(v);
                categoryName = v.findViewById(R.id.categoryName);
                categoryImage = v.findViewById(R.id.categoryImage);

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
