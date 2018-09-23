package com.dkotama.udayanaojsreader.presenter.home;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.home.HomeData;
import com.dkotama.udayanaojsreader.data.model.home.HomeModel;
import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by dkotama on 19/09/18.
 */

public interface HomeContract {
    interface View {
        void onLoadHomeSuccess(List<JournalItemData> journals);
        void onLoadHomeFailed(String message);
        void onLogoutSuccess();

        void onClickJournalItem(int journalID);
    }

    interface Presenter {
        void loadHome();
        void loadHomeSuccess(HomeData data);
        void loadHomeFailed(String message);
        void logout();
    }

    interface API {
        @GET(Constant.ACTION_JOURNALS)
        Single<HomeModel> getHome();
    }
}
