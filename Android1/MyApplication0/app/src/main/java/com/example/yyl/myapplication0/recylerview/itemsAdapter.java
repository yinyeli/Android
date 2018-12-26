package com.example.yyl.myapplication0.recylerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yyl.myapplication0.R;

import java.util.List;


public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.ViewHolder>{
    private List<Item> itemsList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View personview;
        ImageView itemImage;
        TextView itemName;

        public ViewHolder(View view){
            super(view);
            personview = view;
            itemImage = (ImageView) view.findViewById(R.id.recy_ImageView);
            itemName = (TextView) view.findViewById(R.id.recy_textView);
        }
    }

    public itemsAdapter(List<Item> list){
        itemsList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.personview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Item person = itemsList.get(position);
                Toast.makeText(v.getContext(),"you have clicked view "+person.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int pos = holder.getAdapterPosition();
                Item person = itemsList.get(pos);
                Toast.makeText(v.getContext(),"you have clicked image" + person.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemsList.get(position);
        holder.itemImage.setImageResource(item.getImageId());
        holder.itemName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}