package com.dkotama.udayanaojsreader.view.favourite;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteRealmData;
import com.dkotama.udayanaojsreader.view.common.ArticleViewHolder;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by dkotama on 03/11/18.
 */

public class FavouriteAdapter extends RealmRecyclerViewAdapter<FavouriteRealmData, ArticleViewHolder> {
    ArticleViewHolder.ArticleViewHolderClickListener listener;

    public FavouriteAdapter(ArticleViewHolder.ArticleViewHolderClickListener listener, @Nullable OrderedRealmCollection<FavouriteRealmData> data, boolean autoUpdate) {
        super(data, autoUpdate);
        setHasStableIds(true);

        this.listener = listener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.article_item, viewGroup, false);

        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleViewHolder holder, int position) {
        final FavouriteRealmData item = getItem(position);

        holder.authors.setText(item.getCreator());
        holder.doi.setText(item.getIdentifier());
        holder.sectionItemTitle.setText(item.getTitle());
        holder.isFavorited = true;
        holder.updateFav();


        holder.pdfBtnImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickJournalItem(item);
            }
        });


        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickRemoveFavorite(item.getId());
            }
        });
    }
}
