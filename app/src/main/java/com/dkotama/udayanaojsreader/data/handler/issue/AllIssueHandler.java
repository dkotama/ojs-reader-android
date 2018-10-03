package com.dkotama.udayanaojsreader.data.handler.issue;

import android.util.Log;

import com.dkotama.udayanaojsreader.data.handler.common.BaseHandler;
import com.dkotama.udayanaojsreader.data.model.issue.AllIssueModel;
import com.dkotama.udayanaojsreader.presenter.issue.AllIssueContract;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dkotama on 18/09/18.
 */

public class AllIssueHandler extends BaseHandler {
    private AllIssueContract.Presenter presenter;
    private String TAG = "AllIssueHandler";

    public AllIssueHandler(AllIssueContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    public void doService(int journalId) {
        AllIssueContract.API api = createRetrofit().build().create(AllIssueContract.API.class);
        Single<AllIssueModel> data = api.getIssues(journalId);

        try {
            data.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<AllIssueModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.d(TAG, "onSubscribe: ");
                        }

                        @Override
                        public void onSuccess(AllIssueModel model) {
                            String error = model.getError();

                            if (error != null) {
                                presenter.loadIssuesFailed("Something Error");
                            } else {
                                presenter.loadIssuesSuccess(model.getData());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            presenter.loadIssuesFailed(e.getLocalizedMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
