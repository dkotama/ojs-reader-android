package com.dkotama.udayanaojsreader.data.handler.home;

import android.util.Log;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.handler.common.ScidirBaseHandler;
import com.dkotama.udayanaojsreader.data.scidir.SearchResultModel;
import com.dkotama.udayanaojsreader.presenter.home.HomeContract;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dkotama on 18/09/18.
 */

public class HomeHandler extends ScidirBaseHandler {
    private HomeContract.Presenter presenter;
    private String TAG = "HomeHandler";

    public HomeHandler(HomeContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    public void doService(String searchQuery) {
        Log.d(TAG, "doService: START DO SERVICE"); int startPage = 0;
        HomeContract.SearchService service = createRetrofit().build()
                .create(HomeContract.SearchService.class);
        Single<SearchResultModel> model = service.getSearchResult(
                Constant.API_STRING,
                searchQuery + " and openaccess(1)",
                "application/json",
//                "contenttype(sort=fd);srctitle(sort=fd,count=100)",
                String.valueOf(0),
                String.valueOf(10)
        );

        try {
            model.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<SearchResultModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            Log.d(TAG, "onSubscribe: ");
                        }

                        @Override
                        public void onSuccess(SearchResultModel model) {
                            presenter.loadHomeSuccess(model);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: ", e.getCause());
                            presenter.loadHomeFailed(e.getLocalizedMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
