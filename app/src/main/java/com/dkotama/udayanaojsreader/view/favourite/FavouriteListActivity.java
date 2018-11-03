package com.dkotama.udayanaojsreader.view.favourite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.common.RealmController;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteRealmData;
import com.dkotama.udayanaojsreader.data.scidir.HomeEntryItemData;
import com.dkotama.udayanaojsreader.view.common.ArticleViewHolder;
import com.dkotama.udayanaojsreader.view.common.BaseActivity;
import com.dkotama.udayanaojsreader.view.paper.PaperActivity;

public class FavouriteListActivity extends BaseActivity implements ArticleViewHolder.ArticleViewHolderClickListener{
    RecyclerView recyclerView;
    FavouriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        setupRecyclerView();
    }


    private void setupRecyclerView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new FavouriteAdapter(this, RealmController.with(this).getFavourites(), true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickJournalItem(HomeEntryItemData item) {

    }

    @Override
    public void onClickAddFavorite(HomeEntryItemData item, int position) {

    }

    @Override
    public void onClickJournalItem(FavouriteRealmData item) {
        Intent intent = new Intent(getBaseContext(), PaperActivity.class);
        intent.putExtra("pdfUrl", item.getPdfUrl());
        startActivity(intent);
    }

    @Override
    public void onClickRemoveFavorite(int favID) {
        RealmController.with(this).removeByID(favID);
    }
}
