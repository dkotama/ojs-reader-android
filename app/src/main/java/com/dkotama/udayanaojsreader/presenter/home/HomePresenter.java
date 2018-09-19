package com.dkotama.udayanaojsreader.presenter.home;

import com.dkotama.udayanaojsreader.common.UserPreference;
import com.dkotama.udayanaojsreader.data.handler.home.HomeHandler;
import com.dkotama.udayanaojsreader.data.model.home.HomeData;

/**
 * Created by dkotama on 19/09/18.
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    public HomePresenter(HomeContract.View v) {
        this.view = v;
    }

    @Override
    public void loadHome() {
        HomeHandler handler = new HomeHandler(this);

        handler.doService();
    }

    @Override
    public void loadHomeSuccess(HomeData data) {
        view.onLoadHomeSuccess(data.getJournals());
    }

    @Override
    public void loadHomeFailed(String message) {
        view.onLoadHomeFailed(message);
    }

    @Override
    public void logout() {
        UserPreference preference = new UserPreference();
        preference.clearPreference();

        view.onLogoutSuccess();
    }
}
