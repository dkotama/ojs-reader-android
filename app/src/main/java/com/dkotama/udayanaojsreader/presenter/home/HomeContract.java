package com.dkotama.udayanaojsreader.presenter.home;

import com.dkotama.udayanaojsreader.data.model.home.HomeData;
import com.dkotama.udayanaojsreader.data.model.home.HomeModel;
import com.dkotama.udayanaojsreader.data.model.home.JournalItemData;

import java.util.List;

/**
 * Created by dkotama on 19/09/18.
 */

public interface HomeContract {
    interface View {
        void onLoadHomeSuccess(List<JournalItemData> journals);
        void onLoadHomeFailed(String message);
        void onLogoutSuccess();
    }

    interface Presenter {
        void loadHome();
        void loadHomeSuccess(HomeData data);
        void loadHomeFailed(String message);
        void logout();
    }

    interface API {

    }
}
