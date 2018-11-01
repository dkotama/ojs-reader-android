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

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by dkotama on 19/09/18.
 */

public class HomeVerticalAdapter extends RecyclerView.Adapter<HomeVerticalAdapter.ArticleItemViewHolder> {
    public static int PAYLOAD_UPDATED_ITEM = 0;

    private HomeContract.View view;
    public List<HomeEntryItemData> items = new ArrayList<>();
//    private Realm realm;
    private String TAG ="IssueAdapter";

    public HomeVerticalAdapter(List<HomeEntryItemData> items, HomeContract.View view) {
        this.items = items;
        this.view = view;

//        realm = RealmController.with(this).getRealm();
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
    public HomeVerticalAdapter.ArticleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View header = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_item, parent, false);
        return new ArticleItemViewHolder(header);
    }

    @Override
    public void onBindViewHolder(final HomeVerticalAdapter.ArticleItemViewHolder holder, final int position) {
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
                view.onClickJournalItem(item);
            }
        });

        holder.notfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.onClickAddFavorite(item, position);
                holder.showFavLoading();
            }
        });


        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.getId() != 0) {
                    view.onClickRemoveFavorite(item.getId());
                    holder.showFavLoading();
                }
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVerticalAdapter.ArticleItemViewHolder holder, int position, @NonNull List<Object> payloads) {
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


    class ArticleItemViewHolder extends RecyclerView.ViewHolder {
        TextView sectionItemTitle, authors, doi;
        ImageView pdfBtnImgView, fav, notfav;
        ProgressBar progressBar;
        Boolean isFavorited = false;
        Boolean isChecked = false;

        public ArticleItemViewHolder(View itemView) {
            super(itemView);

            sectionItemTitle = itemView.findViewById(R.id.paper_title_textview);
            authors = itemView.findViewById(R.id.paper_authors_textview);
            doi = itemView.findViewById(R.id.paper_doi);
            pdfBtnImgView = itemView.findViewById(R.id.paper_pdf_imgview);
            notfav = (ImageView) itemView.findViewById(R.id.paper_pdf_notfavorite);
            fav = (ImageView) itemView.findViewById(R.id.paper_pdf_favorite);
            progressBar = (ProgressBar) itemView.findViewById(R.id.favorite_btn_progress);
        }

        public void updateFav() {
            if (isFavorited) {
                fav.setVisibility(View.VISIBLE);
                notfav.setVisibility(View.GONE);
            } else {
                fav.setVisibility(View.GONE);
                notfav.setVisibility(View.VISIBLE);
            }

            progressBar.setVisibility(View.GONE);
        }

        public void showFavLoading() {
            progressBar.setVisibility(View.VISIBLE);
            fav.setVisibility(View.GONE);
            notfav.setVisibility(View.GONE);
        }
    }

}


