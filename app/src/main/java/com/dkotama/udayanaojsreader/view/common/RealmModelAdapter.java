package com.dkotama.udayanaojsreader.view.common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.dkotama.udayanaojsreader.view.common.RealmRecyclerViewAdapter;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by dkotama on 01/11/18.
 */

public class RealmModelAdapter<T extends RealmObject> extends RealmBaseAdapter<T>{

    public RealmModelAdapter(Context context, OrderedRealmCollection<T> realmResults, boolean automaticUpdate) {
        super(realmResults);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
