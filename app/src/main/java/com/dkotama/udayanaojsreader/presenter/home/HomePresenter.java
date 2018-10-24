package com.dkotama.udayanaojsreader.presenter.home;

import android.util.Log;

import com.dkotama.udayanaojsreader.common.UserPreference;
import com.dkotama.udayanaojsreader.data.handler.home.HomeHandler;
import com.dkotama.udayanaojsreader.data.model.home.HomeData;
import com.dkotama.udayanaojsreader.data.model.journal.ElsevierJournalItemData;
import com.dkotama.udayanaojsreader.data.scidir.SearchResultModel;

import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    public HomePresenter(HomeContract.View v) {
        this.view = v;
    }

    @Override
    public void loadHome(String searchQuery) {
        HomeHandler handler = new HomeHandler(this);
//
        handler.doService(searchQuery);
    }

    @Override
    public void loadHomeSuccess(SearchResultModel model) {
        view.onLoadHomeSuccess(model);
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
