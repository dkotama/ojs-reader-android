package com.dkotama.udayanaojsreader.view.favourite;

import android.content.Context;

import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteRealmData;
import com.dkotama.udayanaojsreader.view.common.RealmModelAdapter;

import io.realm.OrderedRealmCollection;

/**
 * Created by dkotama on 01/11/18.
 */

public class RealmFavoriteAdapter  extends RealmModelAdapter<FavouriteRealmData>{
    public RealmFavoriteAdapter(Context context, OrderedRealmCollection<FavouriteRealmData> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
