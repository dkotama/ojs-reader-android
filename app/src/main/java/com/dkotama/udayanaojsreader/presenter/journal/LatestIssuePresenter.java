package com.dkotama.udayanaojsreader.presenter.journal;

import com.dkotama.udayanaojsreader.data.handler.journal.LatestIssueHandler;
import com.dkotama.udayanaojsreader.data.model.journal.IssueData;

/**
 * Created by dkotama on 29/09/18.
 */

public class LatestIssuePresenter implements LatestIssueContract.Presenter {
    private LatestIssueContract.View view;

    public LatestIssuePresenter(LatestIssueContract.View view) {
        this.view = view;
    }

    @Override
    public void loadLatest(int journalID) {
        LatestIssueHandler handler = new LatestIssueHandler(this);

        handler.doService(journalID);
    }

    @Override
    public void loadLatestSuccess(IssueData data) {
        view.onLoadLatestSuccess(data);

    }

    @Override
    public void loadLatestFailed(String str) {
        view.onLoadLatestFailed(str);
    }
}
