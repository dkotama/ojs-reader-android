package com.dkotama.udayanaojsreader.view.journal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.journal.IssueData;
import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;
import com.dkotama.udayanaojsreader.data.model.journal.PaperData;
import com.dkotama.udayanaojsreader.presenter.home.HomeContract;
import com.dkotama.udayanaojsreader.presenter.journal.IssueClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class IssueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private IssueData issueData;
    private IssueClickListener.View view;

    public IssueAdapter(Context context, IssueData issueData, IssueClickListener.View view) {
        this.context = context;
        this.issueData = issueData;
        this.view = view;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View header = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.issue_section_header, parent, false);
            return new SectionHeaderViewHolder(header);
        }

        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.issue_section_item, parent, false);

        return  new SectionItemViewHolder(item);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            String sectionTitle = String.format("Vol %d No %d (%d): (%s - %s)",
                    issueData.getVolume(),
                    issueData.getNumber(),
                    issueData.getYear(),
                    issueData.getStartMonth(),
                    issueData.getEndMonth());

            ((SectionHeaderViewHolder) holder).sectionTitle.setText(sectionTitle);

            return;
        }

        int index = position - 1;

        final PaperData item = issueData.getPapers().get(index);
        ((SectionItemViewHolder) holder).sectionItemTitle.setText(item.getTitle());
        ((SectionItemViewHolder) holder).authors.setText(item.getAuthors());
        ((SectionItemViewHolder) holder).pages.setText(item.getPage());
        ((SectionItemViewHolder) holder).sectionItemTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               view.onPaperClickCallback(item.getId());
            }
        });
    }


    @Override
    public int getItemCount() {
        return issueData.getPapers().size() + 1; // +1 with section header
    }

    public class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        TextView sectionTitle;

        public SectionHeaderViewHolder(View itemView) {
            super(itemView);

            sectionTitle = itemView.findViewById(R.id.header_textview);
        }
    }


    public class SectionItemViewHolder extends RecyclerView.ViewHolder {
        TextView sectionItemTitle, authors, pages;

        public SectionItemViewHolder(View itemView) {
            super(itemView);

            sectionItemTitle = itemView.findViewById(R.id.paper_title_textview);
            authors = itemView.findViewById(R.id.paper_authors_textview);
            pages = itemView.findViewById(R.id.paper_page_textview);
        }
    }
}
