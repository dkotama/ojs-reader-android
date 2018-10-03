package com.dkotama.udayanaojsreader.view.issue;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.data.model.issue.IssueData;
import com.dkotama.udayanaojsreader.presenter.issue.AllIssueContract;
import com.dkotama.udayanaojsreader.presenter.issue.AllIssuePresenter;
import com.dkotama.udayanaojsreader.presenter.journal.IssueClickListener;
import com.dkotama.udayanaojsreader.view.common.BaseActivity;

import java.util.List;

public class AllIssueActivity extends BaseActivity implements AllIssueContract.View, IssueClickListener.View {
    public static final String JOURNAL_ID_KEY = "journal_id";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private int journalID;
    private AllIssueContract.Presenter presenter;
    private IssueAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_issue);

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progressbar);

        setTitle("All Issues");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        journalID = getIntent().getIntExtra(JOURNAL_ID_KEY, 0);

        presenter = new AllIssuePresenter(this);

        presenter.loadIssues(journalID);
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
    public void onLoadIssuesSuccess(List<IssueData> data) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new IssueAdapter(getBaseContext(), data, this);
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoadIssuesFailed(String str) {
        makeError(str, "Error");
    }

    @Override
    public void onPaperClickCallback(int id) {
        Log.d("AllIssueActivity", "onPaperClickCallback: " + id);
    }
}
