package com.dkotama.udayanaojsreader.view.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.common.RealmController;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteRealmData;
import com.dkotama.udayanaojsreader.data.scidir.HomeEntryItemData;
import com.dkotama.udayanaojsreader.presenter.home.HomeContract;
import com.dkotama.udayanaojsreader.view.common.ArticleViewHolder;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by dkotama on 19/09/18.
 */

public class HomeVerticalAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    public static int PAYLOAD_UPDATED_ITEM = 0;

    private ArticleViewHolder.ArticleViewHolderClickListener listener;
    public List<HomeEntryItemData> items = new ArrayList<>();
    private String TAG ="IssueAdapter";

    public HomeVerticalAdapter(List<HomeEntryItemData> items, ArticleViewHolder.ArticleViewHolderClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    public HomeVerticalAdapter() {
    }

    public void resetData() {
        items = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View header = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new ArticleViewHolder(header);
    }

    @Override
    public void onBindViewHolder(final ArticleViewHolder holder, final int position) {
        final HomeEntryItemData item = items.get(position);
        Boolean isFav = false;

        if (!holder.isChecked) {
            holder.isChecked = true;

            FavouriteRealmData realmData = RealmController.with(this).getFavourite(item.getDoi());

            if (realmData != null) {
                isFav = true;
                item.setId(realmData.getId());
            }

        }

        item.setFavorited(isFav);

        holder.authors.setText(item.getCreator());
        holder.doi.setText(item.getIdentifier());
        holder.sectionItemTitle.setText(item.getTitle());
        holder.isFavorited = isFav;
        holder.updateFav();


        holder.pdfBtnImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickJournalItem(item);
            }
        });

        holder.notfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickAddFavorite(item, position);
                holder.showFavLoading();
            }
        });


        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.getId() != 0) {
                    listener.onClickRemoveFavorite(item.getId());
                    holder.showFavLoading();
                }
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (!payloads.isEmpty()) {
                final HomeEntryItemData item = items.get(position);

                for (final Object payload : payloads) {
                    if (payload.equals(PAYLOAD_UPDATED_ITEM)) {
                        holder.isFavorited = item.getFavorited();
                        holder.updateFav();
                    }
                }
        } else{
            super.onBindViewHolder(holder, position, payloads);
        }
    }

}


