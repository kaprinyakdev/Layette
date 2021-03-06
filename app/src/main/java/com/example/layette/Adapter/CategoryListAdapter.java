package com.example.layette.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.layette.Model.CategoryItem;
import com.example.layette.R;
import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryListHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;
    private View itemView;
    private OnItemClickListener mListener;
    private int row_index = 0;


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

                    if (row_index==holder.getAdapterPosition()){
                        holder.cardView.setBackgroundColor(Color.GREEN);
                    } else {
                        holder.cardView.setBackgroundColor(Color.WHITE);
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
            protected ConstraintLayout category_item_background;
            protected CardView cardView;

            public CategoryListHolder(View v, final OnItemClickListener listener){
                super(v);
                categoryName = v.findViewById(R.id.categoryName);
                categoryImage = v.findViewById(R.id.categoryImage);
                //category_item_background = v.findViewById(R.id.category_item_background);
                cardView = v.findViewById(R.id.cardView);

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
