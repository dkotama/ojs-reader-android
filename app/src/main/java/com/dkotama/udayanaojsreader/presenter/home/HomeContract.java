package com.dkotama.udayanaojsreader.presenter.home;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteRealmData;
import com.dkotama.udayanaojsreader.data.scidir.HomeEntryItemData;
import com.dkotama.udayanaojsreader.data.scidir.SearchResultModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dkotama on 19/09/18.
 */

public interface HomeContract {
    interface View {
        void onLoadHomeSuccess(SearchResultModel model);
        void onLoadHomeFailed(String message);
        void onLogoutSuccess();
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
                @Query("start") String startPage,
                @Query("count") String count
        );
    }
}
