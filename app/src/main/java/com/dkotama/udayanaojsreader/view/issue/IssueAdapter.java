package com.dkotama.udayanaojsreader.view.issue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.data.model.issue.IssueData;
import com.dkotama.udayanaojsreader.data.model.paper.PaperData;
import com.dkotama.udayanaojsreader.presenter.journal.IssueClickListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class IssueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static final int TYPE_HEADER = 1;
    static final int TYPE_ITEM = 2;

    private Context context;
    private IssueClickListener.View view;
    private List<IssueItem> issueItems = new ArrayList<>();
    private String TAG ="IssueAdapter";

    public IssueAdapter(Context context, List<IssueData> issueData, IssueClickListener.View view) {
        this.context = context;
        this.view = view;
        generateIssueItems(issueData);
    }

    public IssueAdapter(Context context, IssueData issueData, IssueClickListener.View view) {
        List<IssueData> tempData = new ArrayList<>();
        tempData.add(issueData);

        this.context = context;
        this.view = view;
        generateIssueItems(tempData);
    }


    @Override
    public int getItemViewType(int position) {
        //Log.d(TAG, "getItemViewType: " + position + " - IS_HEADER: " + issueItems.get(position).isHeader());
        return (issueItems.get(position).isHeader() ? TYPE_HEADER : TYPE_ITEM);
    }

    @Override
    public int getItemCount() {
        return issueItems.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case TYPE_HEADER:
                //Log.d(TAG, "onCreateViewHolder: TYPE HEADER");
                View header = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.issue_section_header, parent, false);
                return new SectionHeaderViewHolder(header);
            case TYPE_ITEM:
                //Log.d(TAG, "onCreateViewHolder: TYPE ITEM");
                View item = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.issue_section_item, parent, false);

                return  new SectionItemViewHolder(item);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final IssueItem item = issueItems.get(position);

        if (item.isHeader()) {
            ((SectionHeaderViewHolder) holder).sectionTitle.setText(item.getTitle());

            //Log.d(TAG, "onBindViewHolder: TYPE HEADER " + position);
            return;
        }

        //Log.d(TAG, "onBindViewHolder: TYPE ITEM " + position);
        ((SectionItemViewHolder) holder).sectionItemTitle.setText(item.getTitle());
        ((SectionItemViewHolder) holder).authors.setText(item.getAuthors());
        ((SectionItemViewHolder) holder).pages.setText(item.getPages());
        ((SectionItemViewHolder) holder).sectionItemTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               view.onPaperClickCallback(item.getId());
            }
        });
    }


    class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        TextView sectionTitle;

        public SectionHeaderViewHolder(View itemView) {
            super(itemView);

            sectionTitle = itemView.findViewById(R.id.header_textview);
        }
    }


    class SectionItemViewHolder extends RecyclerView.ViewHolder {
        TextView sectionItemTitle, authors, pages;

        public SectionItemViewHolder(View itemView) {
            super(itemView);

            sectionItemTitle = itemView.findViewById(R.id.paper_title_textview);
            authors = itemView.findViewById(R.id.paper_authors_textview);
            pages = itemView.findViewById(R.id.paper_page_textview);
        }
    }

    private void generateIssueItems(List<IssueData> data) {
        for (Iterator<IssueData> i = data.iterator(); i.hasNext();) {
            IssueData issue = i.next();

            HeaderItem item = new HeaderItem();

            String sectionTitle = String.format("Vol %d No %d (%d): (%s - %s)",
                    issue.getVolume(),
                    issue.getNumber(),
                    issue.getYear(),
                    issue.getStartMonth(),
                    issue.getEndMonth());

            item.setTitle(sectionTitle);
            issueItems.add(item);

            for (int s = 0; s < issue.getPapers().size(); s++) {
                PaperData paperData = issue.getPapers().get(s);

                SectionItem sectionItem = new SectionItem();

                sectionItem.setTitle(paperData.getTitle());
                sectionItem.setAuthors(paperData.getAuthors());
                sectionItem.setPages(paperData.getPage());
                sectionItem.setId(paperData.getId());
                issueItems.add(sectionItem);
            }
        }
    }

    private interface IssueItem {
        boolean isHeader();
        String getTitle();
        String getAuthors();
        String getPages();
        int getId();
    }

    private class HeaderItem implements IssueItem{
        private String title;

        @Override
        public boolean isHeader() {
            return true;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getAuthors() {
            return null;
        }

        @Override
        public String getPages() {
            return null;
        }

        @Override
        public int getId() {
            return 0;
        }
    }

    private class SectionItem implements IssueItem {
        private String title, authors, pages;
        private int id;

        @Override
        public boolean isHeader() {
            return false;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getAuthors() {
            return authors;
        }

        @Override
        public String getPages() {
            return pages;
        }

        @Override
        public int getId() {
            return id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthors(String authors) {
            this.authors = authors;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}


