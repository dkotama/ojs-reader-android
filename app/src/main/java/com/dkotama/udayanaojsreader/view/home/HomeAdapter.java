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
import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;
import com.dkotama.udayanaojsreader.presenter.home.HomeContract;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.JournalViewHolder>{
    private Context context;
    private List<JournalItemData> journals;
    private HomeContract.View view;

    public HomeAdapter(Context ctx, List<JournalItemData> jl, HomeContract.View view) {
        context = ctx;
        journals = jl;
        this.view = view;
    }

    @Override
    public JournalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.journal_cardview, parent, false);

        return new JournalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JournalViewHolder holder, int position) {
        final JournalItemData item = journals.get(position);
        holder.name.setText(item.getName());

        String imgUrl = Constant.PICTURE_URL + item.getImageUrl();

        Picasso.with(context)
                .load(imgUrl)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Journal CardView", "onClick: " + item.getId());
                view.onClickJournalItem(item.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return journals.size();
    }

    public class JournalViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;

        public JournalViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.journal_name);
            imageView = (ImageView) itemView.findViewById(R.id.journal_image);
        }
    }
}
