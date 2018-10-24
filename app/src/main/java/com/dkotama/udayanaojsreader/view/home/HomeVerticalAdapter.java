package com.dkotama.udayanaojsreader.view.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.data.scidir.HomeEntryItemData;
import com.dkotama.udayanaojsreader.presenter.home.HomeContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class HomeVerticalAdapter extends RecyclerView.Adapter<HomeVerticalAdapter.ArticleItemViewHolder> {
    private HomeContract.View view;
    private List<HomeEntryItemData> items = new ArrayList<>();
    private String TAG ="IssueAdapter";

    public HomeVerticalAdapter(List<HomeEntryItemData> items, HomeContract.View view) {
        this.items = items;
        this.view = view;
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
    public void onBindViewHolder(HomeVerticalAdapter.ArticleItemViewHolder holder, int position) {
        final HomeEntryItemData item = items.get(position);

        holder.authors.setText(item.getCreator());
        holder.doi.setText(item.getIdentifier());
        holder.sectionItemTitle.setText(item.getTitle());

//        holder.sectionItemTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                view.onClickJournalItem(item);
//            }
//        });

        holder.pdfBtnImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.onClickJournalItem(item);
            }
        });
    }


    class ArticleItemViewHolder extends RecyclerView.ViewHolder {
        TextView sectionItemTitle, authors, doi;
        ImageView pdfBtnImgView;

        public ArticleItemViewHolder(View itemView) {
            super(itemView);

            sectionItemTitle = itemView.findViewById(R.id.paper_title_textview);
            authors = itemView.findViewById(R.id.paper_authors_textview);
            doi = itemView.findViewById(R.id.paper_doi);
            pdfBtnImgView = itemView.findViewById(R.id.paper_pdf_imgview);
        }
    }

}


