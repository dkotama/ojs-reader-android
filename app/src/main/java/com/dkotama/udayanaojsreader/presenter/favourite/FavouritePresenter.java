package com.dkotama.udayanaojsreader.presenter.favourite;

import android.util.Log;

import com.dkotama.udayanaojsreader.common.RealmController;
import com.dkotama.udayanaojsreader.common.UserPreference;
import com.dkotama.udayanaojsreader.data.handler.favourite.FavouriteHandler;
import com.dkotama.udayanaojsreader.data.handler.home.HomeHandler;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteData;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteListModel;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteModel;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteRealmData;
import com.dkotama.udayanaojsreader.data.scidir.HomeEntryItemData;
import com.dkotama.udayanaojsreader.data.scidir.SearchResultModel;
import com.dkotama.udayanaojsreader.presenter.home.HomeContract;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.realm.Realm;

/**
 * Created by dkotama on 19/09/18.
 */

public class FavouritePresenter implements FavouriteContract.Presenter {
    private FavouriteContract.View view;
    private FavouriteHandler handler;
    private UserPreference preference;
    private Realm realm;

    public FavouritePresenter(FavouriteContract.View view) {
        this.view = view;
        handler = new FavouriteHandler(this);
        preference = new UserPreference();

        realm = RealmController.with(this).getRealm();
    }

    @Override
    public void loadFavorite() {
        handler.getFavourites(preference.getUserId());

    }

    @Override
    public void loadFavoriteSuccess(FavouriteListModel model) {
        List<FavouriteRealmData> newDataList = new ArrayList<>();

        for(FavouriteData data: model.getData()) {
            FavouriteRealmData newData = new FavouriteRealmData(data);
            newDataList.add(newData);
            Log.d("FavouritePresenter", "loadFavoriteSuccess: " + data.getDoi());
        }

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(newDataList);
        realm.commitTransaction();

        view.onLoadFavouriteSuccess();
    }

    @Override
    public void loadFavoriteFailed(String str) {
        view.onLoadFavouriteFailed(str);
    }

    @Override
    public void addFavorite(HomeEntryItemData data) {
        handler.addFavourite(preference.getUserId(), data);
    }

    @Override
    public void addFavoriteSuccess(FavouriteModel model) {
        FavouriteData data = model.getData();
        FavouriteRealmData newData = new FavouriteRealmData(data);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(newData);
        realm.commitTransaction();

        view.onAddFavouriteSuccess(data);
    }

    @Override
    public void addFavoriteFailed(String str) {
        view.onAddFavouriteFailed(str);
    }

    @Override
    public void removeFavorite(int favID) {
        handler.removeFavorite(favID);
    }

    @Override
    public void removeFavoriteSuccess(FavouriteData data) {
        RealmController.with(this).removeByID(data.getId());
        view.onRemoveFavoriteSuccess(data);
    }

    @Override
    public void removeFavoriteFailed(String str) {
        view.onRemoveFavoriteFailed(str);
    }
}
