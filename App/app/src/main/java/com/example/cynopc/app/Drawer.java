package com.example.cynopc.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Drawer extends AppCompatActivity {
    RecyclerView recyclerView;

    private final String name[] = {"first", "second"};

    private final int images[]={R.mipmap.ic_ad_choices,R.mipmap.ic_ad_choices};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        data();
    }

    private void data() {

        recyclerView = (RecyclerView) findViewById(R.id.drawerRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Bean> bean_class = Data();

        DrawerAdapter adapter = new DrawerAdapter(getApplicationContext(), bean_class);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Bean> Data() {

        ArrayList<Bean> list = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Bean bean_class = new Bean();
            bean_class.setImage(images[i]);
            bean_class.setText(name[i]);
            list.add(bean_class);
        }
        return list;

    }
}