package com.dkotama.udayanaojsreader.view.home;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteData;
import com.dkotama.udayanaojsreader.data.scidir.HomeEntryItemData;
import com.dkotama.udayanaojsreader.data.scidir.SearchResultModel;
import com.dkotama.udayanaojsreader.presenter.favourite.FavouriteContract;
import com.dkotama.udayanaojsreader.presenter.favourite.FavouritePresenter;
import com.dkotama.udayanaojsreader.presenter.home.HomeContract;
import com.dkotama.udayanaojsreader.presenter.home.HomePresenter;
import com.dkotama.udayanaojsreader.presenter.home.UpdatedHomeItem;
import com.dkotama.udayanaojsreader.view.common.BaseActivity;
import com.dkotama.udayanaojsreader.view.login.LoginActivity;
import com.dkotama.udayanaojsreader.view.paper.PaperActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements HomeContract.View, FavouriteContract.View {

    HomeContract.Presenter presenter;
    FavouriteContract.Presenter favPresenter;
    String TAG = "HomeActivity";

    RecyclerView recyclerView;
    ProgressBar progressBar;
    HomeVerticalAdapter adapter = new HomeVerticalAdapter();
    TextView totalJournalTV, emptyFillTV;
    String searchQuery = "";
    List<UpdatedHomeItem> updatedHomeItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle("Home");

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progressbar);
        totalJournalTV = findViewById(R.id.total_journal_tv);
        emptyFillTV   = findViewById(R.id.empty_fill);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getBaseContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);

        favPresenter = new FavouritePresenter(this);
        presenter = new HomePresenter(this);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            searchQuery = intent.getStringExtra(SearchManager.QUERY);
            emptyFillTV.setVisibility(View.INVISIBLE);
            totalJournalTV.setText("Searching...");

            if (adapter.getItemCount() > 0) {
                adapter.resetData();
                adapter.notifyDataSetChanged();
            }

            presenter.loadHome(searchQuery);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, "NULL", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true); // Do not iconify the widget; expand it by default

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorite_btn :
                makeError("Fav Selected", "selected").show();
                return true;
            case R.id.logout_btn:
                askLogout();
                return true;
            default:
                return true;
        }
    }

    @Override
    public void onLoadHomeSuccess(SearchResultModel model) {

        adapter = new HomeVerticalAdapter(model.getResults().getEntries(), this);
        recyclerView.setAdapter(adapter);

        totalJournalTV.setText("Total Open Access Articles: " + model.getResults().getTotalResults());

        progressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onLoadHomeFailed(String message) {
        progressBar.setVisibility(View.INVISIBLE);
        makeError(message, "Error").show();
    }

    @Override
    public void onLogoutSuccess() {
        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    public void onClickJournalItem(HomeEntryItemData item) {
        Intent intent = new Intent(getBaseContext(), PaperActivity.class);
        intent.putExtra("pdfUrl", item.getPdfUrl());
        startActivity(intent);
    }

    @Override
    public void onClickAddFavorite(HomeEntryItemData item, int position) {
        UpdatedHomeItem newItem = new UpdatedHomeItem(item.getDoi(), position);
        updatedHomeItems.add(newItem);
        favPresenter.addFavorite(item);
    }


    @Override
    public void onClickRemoveFavorite(int favID) {
        favPresenter.removeFavorite(favID);
    }

    private void askLogout() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(true);
        dialog.setTitle("Konfirmasi");
        dialog.setMessage("Apakah anda yakin ingin logout ?");
        dialog.setNegativeButton("Tidak", null);
        dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.logout();
            }
        });

        dialog.create().show();
    }

    @Override
    public void onLoadFavouriteSuccess() {

    }

    @Override
    public void onLoadFavouriteFailed(String message) {

    }

    @Override
    public void onAddFavouriteSuccess(FavouriteData data) {
        Log.d(TAG, "onAddFavouriteSuccess: " + data.getDoi());

        int count = 0;

        for (HomeEntryItemData item: adapter.items) {
            if (item.getDoi().equals(data.getDoi())) {
                Log.d(TAG, "SAME DOI FOUND: ");

                item.setFavorited(true);
                item.setId(data.getId());

                adapter.notifyItemChanged(count, HomeVerticalAdapter.PAYLOAD_UPDATED_ITEM);
                break;
            }

            count++;
        }

        Toast.makeText(this, "Add Favorite Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddFavouriteFailed(String message) {
        makeError(message, "Error Add Favorite");
    }

    @Override
    public void onRemoveFavoriteSuccess(FavouriteData data) {
        Log.d(TAG, "onRemoveFavoriteSuccess: " + data.getDoi());

        int count = 0;

        for (HomeEntryItemData item: adapter.items) {
            if (item.getId() == data.getId()){

                item.setFavorited(false);
                item.setId(0);

                adapter.notifyItemChanged(count, HomeVerticalAdapter.PAYLOAD_UPDATED_ITEM);
                break;
            }

            count++;
        }

        Toast.makeText(this, "Remove Favorite Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRemoveFavoriteFailed(String message) {
        makeError(message, "Error Remove Favorite");
    }
}
