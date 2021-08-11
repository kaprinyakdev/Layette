package com.example.layette.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.layette.Model.ImageItem;
import com.example.layette.Model.ListItem;
import com.example.layette.R;

import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListHolder> {

    private Context context;
    private List<ImageItem> imageItemList;


    public ImageListAdapter(List<ImageItem> imageItemList, Context context){
        this.context = context;
        this.imageItemList = imageItemList;
    }

    @NonNull
    @Override
    public ImageListAdapter.ImageListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
        return new ImageListAdapter.ImageListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.ImageListHolder holder, int position) {
        ImageItem imageItem = imageItemList.get(position);


    }

    @Override
    public int getItemCount() {
        return imageItemList.size();
    }

    public static class ImageListHolder extends RecyclerView.ViewHolder {
        protected ImageView image;
        protected String name;

        public ImageListHolder(View v) {
            super(v);
            image = v.findViewById(R.id.defaultCategoryImage);
        }
    }
}
