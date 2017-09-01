package com.example.cynopc.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Deeksha PC on 12/26/2016.
 */

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder>implements View.OnClickListener {

    private ArrayList<Bean> List;
    private Context context;

    public DrawerAdapter( Context context,ArrayList<Bean> List){
        this.List=List;
        this.context=context;

    }



        @Override
    public DrawerAdapter.DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, parent, false);
            return new DrawerViewHolder(view);

        }

    @Override
    public void onBindViewHolder(DrawerAdapter.DrawerViewHolder holder, int position) {
        holder.title.setText(List.get(position).getText());
        holder.image.setImageResource(List.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    @Override
    public void onClick(View view) {

    }


    public class DrawerViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public DrawerViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.name);
            image=(ImageView)itemView.findViewById(R.id.img);
        }
    }
}
