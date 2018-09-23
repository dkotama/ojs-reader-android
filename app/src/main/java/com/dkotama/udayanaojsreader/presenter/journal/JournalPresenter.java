package com.dkotama.udayanaojsreader.presenter.journal;

import com.dkotama.udayanaojsreader.data.handler.journal.JournalHandler;
import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;

/**
 * Created by dkotama on 23/09/18.
 */

public class JournalPresenter implements JournalContract.Presenter {
    private JournalContract.View view;

    public JournalPresenter(JournalContract.View view) {
        this.view = view;
    }

    @Override
    public void loadJournal(int journalID) {
        JournalHandler handler = new JournalHandler(this);

        handler.doService(journalID);
    }

    @Override
    public void loadJournalSuccess(JournalItemData data) {

    }

    @Override
    public void loadJournalFailed(String str) {

    }
}
