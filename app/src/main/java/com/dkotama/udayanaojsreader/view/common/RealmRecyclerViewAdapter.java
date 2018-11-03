package com.dkotama.udayanaojsreader.view.common;

import android.support.v7.widget.RecyclerView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;

/**
 * Created by dkotama on 01/11/18.
 */

public abstract class RealmRecyclerViewAdapter<T extends RealmObject> extends RecyclerView.Adapter {
    private io.realm.RealmBaseAdapter<T> baseAdapter;

    public T getItem(int position) {
        return baseAdapter.getItem(position);
    }


    public io.realm.RealmBaseAdapter<T> getBaseAdapter() {
        return baseAdapter;
    }

    public void setBaseAdapter(io.realm.RealmBaseAdapter<T> baseAdapter) {
        this.baseAdapter = baseAdapter;
    }
}
