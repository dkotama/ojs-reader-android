package com.dkotama.udayanaojsreader.data.handler.favourite;

import android.util.Log;

import com.dkotama.udayanaojsreader.data.handler.common.BaseHandler;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteDeleteModel;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteListModel;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteModel;
import com.dkotama.udayanaojsreader.data.scidir.HomeEntryItemData;
import com.dkotama.udayanaojsreader.data.scidir.SearchResultModel;
import com.dkotama.udayanaojsreader.presenter.favourite.FavouriteContract;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dkotama on 18/09/18.
 */

public class FavouriteHandler extends BaseHandler {
    private FavouriteContract.Presenter presenter;
    private String TAG = "FavoriteHandler";

    public FavouriteHandler(FavouriteContract.Presenter presenter) {
        super();
        this.presenter = presenter;
    }

    public void getFavourites(int userID) {
        FavouriteContract.FavoriteService service = createRetrofit().build()
                .create(FavouriteContract.FavoriteService.class);
        Single<FavouriteListModel> model = service.getFavourites(userID);

        try {
            model.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<FavouriteListModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onSuccess(FavouriteListModel model) {
                            if (model.getStatus() == 0) {
                                presenter.loadFavoriteFailed(model.getError());
                            } else {
                                presenter.loadFavoriteSuccess(model);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: ", e.getCause());

                            presenter.loadFavoriteFailed(e.getLocalizedMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addFavourite(int userID, HomeEntryItemData data) {
        FavouriteContract.FavoriteService service = createRetrofit().build()
                .create(FavouriteContract.FavoriteService.class);
        Single<FavouriteModel> model = service.addFavourite(
                userID,
                data.getIdentifier(),
                data.getIssn(),
                data.getTitle(),
                data.getCreator(),
                data.getPublicationName(),
                data.getDoi(),
                data.getTeaser()
        );

        try {
            model.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<FavouriteModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onSuccess(FavouriteModel model) {
                            if (model.getStatus() == 0) {
                                presenter.addFavoriteFailed(model.getError());
                            } else {
                                presenter.addFavoriteSuccess(model);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: ", e.getCause());

                            presenter.addFavoriteFailed(e.getLocalizedMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void removeFavorite(int favID) {
        FavouriteContract.FavoriteService service = createRetrofit().build()
                .create(FavouriteContract.FavoriteService.class);

        Single<FavouriteModel> model = service.removeFavorite(favID);

        try {
            model.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<FavouriteModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onSuccess(FavouriteModel model) {
                            if (model.getStatus() == 0) {
                                presenter.removeFavoriteFailed(model.getError());
                            } else {
                                presenter.removeFavoriteSuccess(model.getData());
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: ", e.getCause());

                            presenter.removeFavoriteFailed(e.getLocalizedMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
