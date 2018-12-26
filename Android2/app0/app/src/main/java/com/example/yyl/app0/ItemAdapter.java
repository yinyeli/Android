package com.example.yyl.app0;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private List<Item> mItemList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public ItemAdapter(List<Item> itemList) {
        mItemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Item item = mItemList.get(position);
                Toast.makeText(v.getContext(), "click view: " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Item item = mItemList.get(position);
                Toast.makeText(v.getContext(), "click image: " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = mItemList.get(position);
        holder.fruitImage.setImageResource(item.getImageId());
        holder.fruitName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @SuppressLint("Registered")
    public static class MainActivity extends AppCompatActivity {

        private List<Item> itemList = new ArrayList<Item>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.recycler_main);
            initFruits();
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            StaggeredGridLayoutManager layoutManager = new
                    StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            ItemAdapter adapter = new ItemAdapter(itemList);
            recyclerView.setAdapter(adapter);
        }

        private void initFruits() {
            for (int i = 0; i < 5; i++) {
                Item item_pic1 = new Item("hello world,hello world", R.drawable.item_pic1);
                Item item_pic2 = new Item("hello world,hello world", R.drawable.item_pic2);
                Item item_pic3 = new Item("hello world,hello world", R.drawable.item_pic3);
                itemList.add(item_pic1);
                itemList.add(item_pic3);
                itemList.add(item_pic2);

            }
        }

        private String getRandomLengthName(String name) {
            Random random = new Random();
            int length = random.nextInt(20) + 1;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                builder.append(name);
            }
            return builder.toString();
        }

    }
}