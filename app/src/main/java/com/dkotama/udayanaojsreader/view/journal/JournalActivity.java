package com.dkotama.udayanaojsreader.view.journal;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.journal.IssueData;
import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;
import com.dkotama.udayanaojsreader.presenter.journal.IssueClickListener;
import com.dkotama.udayanaojsreader.presenter.journal.LatestIssueContract;
import com.dkotama.udayanaojsreader.presenter.journal.LatestIssuePresenter;
import com.dkotama.udayanaojsreader.view.common.CommonActivity;
import com.squareup.picasso.Picasso;


public class JournalActivity extends CommonActivity implements LatestIssueContract.View, IssueClickListener.View {
    public static String KEY_JOURNAL_ITEM = "journal_item";

    private LatestIssueContract.Presenter presenter;
    private String TAG = "JournalActivity";

    private RecyclerView recyclerView;
    private TextView journalTitle, journalDescription;
    private ImageView journalImage;
    private JournalItemData journal;
    private ProgressBar progressBar;
    private ScrollView scrollView;
    private IssueAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        presenter = new LatestIssuePresenter(this);

        journalTitle = findViewById(R.id.journal_title);
        journalDescription = findViewById(R.id.journal_description);
        journalImage = findViewById(R.id.journal_image);
        progressBar = findViewById(R.id.progressbar);
        recyclerView = findViewById(R.id.recycler_view);
        scrollView = findViewById(R.id.journal_scrollview);
        scrollView.setVisibility(View.INVISIBLE);

        setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle data = getIntent().getExtras();
        journal = data.getParcelable(KEY_JOURNAL_ITEM);

        if (journal != null) {
            presenter.loadLatest(journal.getId());

            String imageUrl = Constant.PICTURE_URL + journal.getImageUrl();

            Picasso.with(getBaseContext())
                    .load(imageUrl)
                    .into(journalImage);

            journalTitle.setText(journal.getName());
            journalDescription.setText(journal.getDesc());
            scrollView.setVisibility(View.VISIBLE);
        } else {
            makeError("Load Journal Error", "Error");
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onLoadLatestSuccess(IssueData data) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        adapter = new IssueAdapter(getBaseContext(), data, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoadLatestFailed(String str) {
        makeError("Error Loading Latest Issue" + str, "Error");
    }

    @Override
    public void onPaperClickCallback(int id) {
        Log.d(TAG, "onPaperClickCallback: " + id);
    }
}
