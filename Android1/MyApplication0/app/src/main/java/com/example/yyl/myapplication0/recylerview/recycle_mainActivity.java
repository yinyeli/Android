package com.example.yyl.myapplication0.recylerview;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.yyl.myapplication0.R;
import java.util.ArrayList;
import java.util.List;


public class recycle_mainActivity extends AppCompatActivity {

    private List<Item> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//继承父类
        setContentView(R.layout.recycler_activity);//设置界面资源

        initPersons();//初始化数据
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        itemsAdapter adapter = new itemsAdapter(personList);
        recyclerView.setAdapter(adapter);
    }

    private void initPersons(){
        for (int i = 0;i < 6;i++){
            Item p1 = new Item("p1",R.drawable.ic_icon_archary);
            personList.add(p1);

            Item p2 = new Item("p2",R.drawable.ic_icon_volleyball);
            personList.add(p2);

            Item p3 = new Item("p3",R.drawable.ic_icon_football);
            personList.add(p3);

        }
    }
}
