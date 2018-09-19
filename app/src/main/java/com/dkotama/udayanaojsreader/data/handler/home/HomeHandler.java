package com.dkotama.udayanaojsreader.data.handler.home;

import android.util.Log;

import com.dkotama.udayanaojsreader.data.handler.common.BaseHandler;
import com.dkotama.udayanaojsreader.data.model.home.HomeModel;
import com.dkotama.udayanaojsreader.data.model.register.RegisterModel;
import com.dkotama.udayanaojsreader.presenter.home.HomeContract;
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
    private HomeContract.Presenter presenter;
    private String TAG = "HomeHandler";

    public HomeHandler(HomeContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    public void doService() {
        HomeContract.API api = createRetrofit().build().create(HomeContract.API.class);
        Single<HomeModel> data = api.getHome();

        try {
            data.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<HomeModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.d(TAG, "onSubscribe: ");
                        }

                        @Override
                        public void onSuccess(HomeModel model) {
                            Log.d(TAG, "onSuccess: ");
                            String errMessage = model.getError();

                            if (errMessage != null) {
                                presenter.loadHomeFailed("Something Error");
                            } else {
                                presenter.loadHomeSuccess(model.getData());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            presenter.loadHomeFailed(e.getLocalizedMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
