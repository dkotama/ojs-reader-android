package com.dkotama.udayanaojsreader.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.common.UserPreference;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteData;
import com.dkotama.udayanaojsreader.data.scidir.SearchResultModel;
import com.dkotama.udayanaojsreader.presenter.favourite.FavouriteContract;
import com.dkotama.udayanaojsreader.presenter.favourite.FavouritePresenter;
import com.dkotama.udayanaojsreader.view.common.BaseActivity;
import com.dkotama.udayanaojsreader.view.home.HomeActivity;

public class LoadingActivity extends BaseActivity implements FavouriteContract.View {

    FavouriteContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        presenter = new FavouritePresenter(this);
        presenter.loadFavorite();
    }


    @Override
    public void onLoadFavouriteSuccess() {
        Intent intent =  new Intent(getBaseContext(), HomeActivity.class);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    public void onLoadFavouriteFailed(String message) {
        makeError(message, "Error");
    }

    @Override
    public void onAddFavouriteSuccess(FavouriteData data) {

    }

    @Override
    public void onAddFavouriteFailed(String message) {

    }

    @Override
    public void onRemoveFavoriteSuccess(FavouriteData data) {
    }

    @Override
    public void onRemoveFavoriteFailed(String message) {

    }
}
