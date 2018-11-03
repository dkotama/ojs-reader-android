package com.dkotama.udayanaojsreader.view.favourite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dkotama.udayanaojsreader.R;

public class FavouriteListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FavouriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        // create an empty adapter and add it to the recycler view
        adapter = new FavouriteAdapter();
//        recycler.setAdapter(adapter);

    }
}
