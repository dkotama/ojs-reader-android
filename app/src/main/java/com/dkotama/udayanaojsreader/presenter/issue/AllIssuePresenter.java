package com.dkotama.udayanaojsreader.presenter.issue;

import com.dkotama.udayanaojsreader.data.handler.issue.AllIssueHandler;
import com.dkotama.udayanaojsreader.data.handler.issue.LatestIssueHandler;
import com.dkotama.udayanaojsreader.data.model.issue.IssueData;

import java.util.List;

/**
 * Created by dkotama on 29/09/18.
 */

public class AllIssuePresenter implements AllIssueContract.Presenter {
    private AllIssueContract.View view;

    public AllIssuePresenter(AllIssueContract.View view) {
        this.view = view;
    }


    @Override
    public void loadIssues(int journalID) {
        AllIssueHandler handler = new AllIssueHandler(this);

        handler.doService(journalID);
    }

    @Override
    public void loadIssuesSuccess(List<IssueData> data) {
        view.onLoadIssuesSuccess(data);
    }

    @Override
    public void loadIssuesFailed(String str) {
        view.onLoadIssuesFailed(str);
    }
}
