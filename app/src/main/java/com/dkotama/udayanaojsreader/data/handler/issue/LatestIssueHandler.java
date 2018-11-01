package com.dkotama.udayanaojsreader.data.handler.issue;

import com.dkotama.udayanaojsreader.data.handler.common.BaseHandler;
import com.dkotama.udayanaojsreader.presenter.issue.LatestIssueContract;

/**
 * Created by dkotama on 18/09/18.
 */

public class LatestIssueHandler extends BaseHandler {
    private LatestIssueContract.Presenter presenter;
    private String TAG = "LatestIssueHandler";

    public LatestIssueHandler(LatestIssueContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    public void doService(int journalId) {
//        LatestIssueContract.API api = createRetrofit().build().create(LatestIssueContract.API.class);
//        Single<LatestIssueModel> data = api.getLatestIssue(journalId);
//
//        try {
//            data.subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new SingleObserver<LatestIssueModel>() {
//                        @Override
//                        public void onSubscribe(Disposable d) {
//                            Log.d(TAG, "onSubscribe: ");
//                        }
//
//                        @Override
//                        public void onSuccess(LatestIssueModel model) {
//                            String error = model.getError();
//
//                            if (error != null) {
//                                presenter.loadLatestFailed("Something Error");
//                            } else {
//                                presenter.loadLatestSuccess(model.getData());
//                            }
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            presenter.loadLatestFailed(e.getLocalizedMessage());
//                        }
//                    });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
