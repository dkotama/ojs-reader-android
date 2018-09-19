package com.dkotama.udayanaojsreader.data.handler.home;

import android.util.Log;

import com.dkotama.udayanaojsreader.data.handler.common.BaseHandler;
import com.dkotama.udayanaojsreader.data.model.register.RegisterModel;
import com.dkotama.udayanaojsreader.presenter.register.RegisterContract;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dkotama on 18/09/18.
 */

public class HomeHandler extends BaseHandler {
    private RegisterContract.Presenter presenter;
    private String TAG = "RegisterHandler";

    public HomeHandler(RegisterContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    public void doService(String username, String password) {
        RegisterContract.API api = createRetrofit().build().create(RegisterContract.API.class);
        Single<RegisterModel> data = api.postRegister(username, password);

        try {
            data.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<RegisterModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.d(TAG, "onSubscribe: ");
                        }

                        @Override
                        public void onSuccess(RegisterModel model) {
                            Log.d(TAG, "onSuccess: ");
                            String errMessage = model.getError();

                            if (errMessage != null) {
                                presenter.registerFailed("Something Error");
                            } else {
                                presenter.registerSuccess(model.getData());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            presenter.registerFailed(e.getLocalizedMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
