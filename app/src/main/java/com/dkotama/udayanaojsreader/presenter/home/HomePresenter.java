package com.dkotama.udayanaojsreader.presenter.home;

import com.dkotama.udayanaojsreader.common.UserPreference;
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

    }

    @Override
    public void loadHomeSuccess(HomeData data) {

    }

    @Override
    public void loadHomeFailed(String message) {

    }

    @Override
    public void logout() {
        UserPreference preference = new UserPreference();
        preference.clearPreference();

        view.onLogoutSuccess();
    }
}
