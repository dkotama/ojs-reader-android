package com.dkotama.udayanaojsreader.view.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dkotama.udayanaojsreader.R;
import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;
import com.dkotama.udayanaojsreader.presenter.journal.JournalContract;
import com.dkotama.udayanaojsreader.presenter.journal.JournalPresenter;
import com.dkotama.udayanaojsreader.view.common.CommonActivity;

public class JournalActivity extends CommonActivity implements JournalContract.View {
    public static String KEY_JOURNALID = "journal_id";

    private JournalContract.Presenter presenter;
    private int journalId = 0;
    private String TAG = "JournalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        Intent intent = getIntent();
        journalId = intent.getIntExtra(KEY_JOURNALID, 0);

        if (journalId != 0) {
            presenter = new JournalPresenter(this);
            presenter.loadJournal(journalId);
        } else {
            makeError("Load Journal error", "Error");
        }
    }

    @Override
    public void onLoadJournalSuccess(JournalItemData data) {
        Log.d(TAG, "onLoadJournalSuccess: " + data);
    }

    @Override
    public void onLoadJournalFailed(String str) {
        makeError(str, "Error");
    }
}
