package com.dkotama.udayanaojsreader.view.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dkotama.udayanaojsreader.R;

/**
 * Created by dkotama on 01/11/18.
 */

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    public TextView sectionItemTitle, authors, doi;
    public ImageView pdfBtnImgView, fav, notfav;
    public ProgressBar progressBar;
    public Boolean isFavorited = false;
    public Boolean isChecked = false;

    public ArticleViewHolder(View itemView) {
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
