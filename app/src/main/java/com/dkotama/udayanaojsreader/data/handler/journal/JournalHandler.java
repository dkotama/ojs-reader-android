package com.dkotama.udayanaojsreader.data.handler.journal;

import com.dkotama.udayanaojsreader.data.handler.common.BaseHandler;
import com.dkotama.udayanaojsreader.presenter.journal.JournalContract;

/**
 * Created by dkotama on 18/09/18.
 */

public class JournalHandler extends BaseHandler {
    private JournalContract.Presenter presenter;
    private String TAG = "JournalHandler";

    public JournalHandler(JournalContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    public void doService(int journalId) {
//        JournalContract.API api = createRetrofit().build().create(JournalContract.API.class);
//        Single<JournalModel> data = api.getJournal(journalId);
//
//        try {
//            data.subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new SingleObserver<JournalModel>() {
//                        @Override
//                        public void onSubscribe(Disposable d) {
//                            Log.d(TAG, "onSubscribe: ");
//                        }
//
//                        @Override
//                        public void onSuccess(JournalModel model) {
//                            String error = model.getError();
//
//                            if (error != null) {
//                                presenter.loadJournalFailed("Something Error");
//                            } else {
//                                presenter.loadJournalSuccess(model.getData());
//                            }
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            presenter.loadJournalFailed(e.getLocalizedMessage());
//                        }
//                    });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
