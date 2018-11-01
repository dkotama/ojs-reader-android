package com.dkotama.udayanaojsreader.common;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteData;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteRealmData;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by dkotama on 30/10/18.
 */

public class RealmController {
    private static RealmController instance;
    private final Realm realm;


    public RealmController(Application app) {
        this.realm = Realm.getDefaultInstance();
    }

    public RealmController() {
        this.realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Object obj) {
        if (instance == null) {
            instance = new RealmController();
        }

        return instance;
    }

    public static RealmController with(Fragment fragment) {
        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }

        return instance;
    }

    public static RealmController with(Activity activity) {
        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }

        return instance;
    }

    public static RealmController with(Application application) {
        if (instance == null) {
            instance = new RealmController(application);
        }

        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    public void refresh() {
        realm.refresh();
    }

    public void clearAll() {
        realm.beginTransaction();
        realm.delete(FavouriteRealmData.class);
        realm.commitTransaction();
    }

    public void removeByID(int favID) {
        final FavouriteRealmData fav = realm.where(FavouriteRealmData.class)
                .equalTo("id", favID)
                .findFirst();

        realm.beginTransaction();
        fav.deleteFromRealm();
        realm.commitTransaction();
    }

    public RealmResults<FavouriteRealmData> getFavourites() {
        return realm.where(FavouriteRealmData.class).findAll();
    }

    public FavouriteRealmData getFavourite(String doi) {
        return  realm.where(FavouriteRealmData.class)
                    .contains("doi", doi)
                    .findFirst();
    }

    public Boolean isFavorite(String doi) {
        return getFavourite(doi) != null;
    }
}
