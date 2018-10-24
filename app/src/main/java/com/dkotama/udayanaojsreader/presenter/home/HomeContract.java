package com.dkotama.udayanaojsreader.presenter.home;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.home.HomeData;
import com.dkotama.udayanaojsreader.data.model.home.HomeModel;
import com.dkotama.udayanaojsreader.data.model.journal.ElsevierJournalItemData;
import com.dkotama.udayanaojsreader.data.model.journal.ElsevierJournalModel;
import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;
import com.dkotama.udayanaojsreader.data.scidir.HomeEntryItemData;
import com.dkotama.udayanaojsreader.data.scidir.SearchEntryItemData;
import com.dkotama.udayanaojsreader.data.scidir.SearchResultModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by dkotama on 19/09/18.
 */

public interface HomeContract {
    interface View {
        void onLoadHomeSuccess(SearchResultModel model);
        void onLoadHomeFailed(String message);
        void onLogoutSuccess();

        void onClickJournalItem(HomeEntryItemData item);
    }

    interface Presenter {
        void loadHome(String searchQuery);
        void loadHomeSuccess(SearchResultModel model);
        void loadHomeFailed(String message);
        void logout();
    }

    interface SearchService {
        @GET(Constant.ACTION_SEARCH_SCIDIR)
        Single<SearchResultModel> getSearchResult(
                @Query("apiKey") String apikey,
                @Query("query") String query,
                @Query("httpAccept") String acceptType,
//                @Query("facets") String facet,
                @Query("start") String startPage,
                @Query("count") String count
        );
    }
}
