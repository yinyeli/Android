package com.example.yyl.app0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class recycler_main extends AppCompatActivity {

    private List<Item> itemList = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);//水平方向放几个Item
        recyclerView.setLayoutManager(layoutManager);
        ItemAdapter adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i = 0; i < 5; i++) {
            Item item_pic1 = new Item("hello world,hello world1", R.drawable.item_pic1);
            Item item_pic2 = new Item("aaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbb" +
                    "bbbbbbbbbbbbbbccccccccccccccccccccccdddddddddddddddddddddddd", R.drawable.item_pic2);
            Item item_pic3 = new Item("你好2", R.drawable.item_pic3);
            itemList.add(item_pic1);
            itemList.add(item_pic3);
            itemList.add(item_pic2);

        }
    }

}
