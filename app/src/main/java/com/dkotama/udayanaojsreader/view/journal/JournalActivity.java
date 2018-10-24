package com.dkotama.udayanaojsreader.view.journal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.issue.IssueData;
import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;
import com.dkotama.udayanaojsreader.presenter.journal.IssueClickListener;
import com.dkotama.udayanaojsreader.presenter.issue.LatestIssueContract;
import com.dkotama.udayanaojsreader.presenter.issue.LatestIssuePresenter;
import com.dkotama.udayanaojsreader.view.common.BaseActivity;
import com.dkotama.udayanaojsreader.view.issue.AllIssueActivity;
import com.dkotama.udayanaojsreader.view.issue.IssueAdapter;
import com.squareup.picasso.Picasso;


public class JournalActivity extends BaseActivity implements LatestIssueContract.View, IssueClickListener.View {
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
    private Button allIssueBtn;

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
        allIssueBtn = findViewById(R.id.seeall_btn);

        scrollView.setVisibility(View.INVISIBLE);

        setTitle("Journal");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle data = getIntent().getExtras();
        journal = data.getParcelable(KEY_JOURNAL_ITEM);

        if (journal != null) {
//            presenter.loadLatest(journal.getId());

//            String imageUrl = Constant.PICTURE_URL + journal.getImageUrl();
//            String imageUrl =
//            Picasso.with(getBaseContext())
//                    .load(imageUrl)
//                    .into(journalImage);

//            journalTitle.setText(journal.getName());
//            journalDescription.setText(journal.getDesc());
//            scrollView.setVisibility(View.VISIBLE);
        } else {
            makeError("Load Journal Error", "Error");
        }

        allIssueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AllIssueActivity.class);
                intent.putExtra(AllIssueActivity.JOURNAL_ID_KEY, journal.getId());
                startActivity(intent);
            }
        });
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
