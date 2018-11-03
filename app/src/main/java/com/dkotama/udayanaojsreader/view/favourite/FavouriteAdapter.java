package com.dkotama.udayanaojsreader.view.favourite;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.common.RealmController;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteRealmData;
import com.dkotama.udayanaojsreader.view.common.ArticleViewHolder;
import com.dkotama.udayanaojsreader.view.common.RealmRecyclerViewAdapter;

import io.realm.Realm;

/**
 * Created by dkotama on 01/11/18.
 */

public class FavouriteAdapter extends RealmRecyclerViewAdapter<FavouriteRealmData> {
    Realm realm;

    public FavouriteAdapter() {
        this.realm = RealmController.with(this).getRealm();
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.article_item, viewGroup, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final FavouriteRealmData item = getItem(i);
        final ArticleViewHolder holder = (ArticleViewHolder) viewHolder;


        holder.authors.setText(item.getCreator());
        holder.doi.setText(item.getIdentifier());
        holder.sectionItemTitle.setText(item.getTitle());
        holder.isFavorited = true;
        holder.updateFav();

        holder.pdfBtnImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                view.onClickJournalItem(item);
            }
        });

        holder.notfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                view.onClickAddFavorite(item, position);
//                holder.showFavLoading();
            }
        });


        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (item.getId() != 0) {
//                    view.onClickRemoveFavorite(item.getId());
//                    holder.showFavLoading();
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
