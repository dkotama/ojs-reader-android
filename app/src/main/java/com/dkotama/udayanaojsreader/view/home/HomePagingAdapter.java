package com.dkotama.udayanaojsreader.view.home;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.dkotama.udayanaojsreader.data.scidir.HomeEntryItemData;

/**
 * Created by dkotama on 23/10/18.
 */

public class HomePagingAdapter extends PagedListAdapter<HomeEntryItemData, HomeAdapter.JournalViewHolder> {
    protected HomePagingAdapter(@NonNull DiffUtil.ItemCallback<HomeEntryItemData> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public HomeAdapter.JournalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.JournalViewHolder holder, int position) {

    }
}
