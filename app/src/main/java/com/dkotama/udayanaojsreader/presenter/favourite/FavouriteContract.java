package com.dkotama.udayanaojsreader.presenter.favourite;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteData;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteDeleteModel;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteListModel;
import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteModel;
import com.dkotama.udayanaojsreader.data.scidir.HomeEntryItemData;
import com.dkotama.udayanaojsreader.data.scidir.SearchResultModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by dkotama on 19/09/18.
 */

public interface FavouriteContract {
    interface View {
        void onLoadFavouriteSuccess();
        void onLoadFavouriteFailed(String message);

        void onAddFavouriteSuccess(FavouriteData data);
        void onAddFavouriteFailed(String message);

        void onRemoveFavoriteSuccess(FavouriteData data);
        void onRemoveFavoriteFailed(String message);
    }

    interface Presenter {
        void loadFavorite();
        void loadFavoriteSuccess(FavouriteListModel model);
        void loadFavoriteFailed(String str);
        void addFavoriteSuccess(FavouriteModel model);
        void addFavorite(HomeEntryItemData data);

        void addFavoriteFailed(String str);

        void removeFavorite(int favID);
        void removeFavoriteSuccess(FavouriteData data);
        void removeFavoriteFailed(String str);
    }

    interface FavoriteService {
        @GET(Constant.ACTION_FAVORITES)
        Single<FavouriteListModel> getFavourites(
                @Query("user_id") int userID
        );

        @DELETE(Constant.ACTION_FAVORITES)
        Single<FavouriteModel> removeFavorite(
                @Query("fav_id") int favID
        );

        @FormUrlEncoded
        @POST(Constant.ACTION_FAVORITES)
        Single<FavouriteModel> addFavourite(
                @Query("user_id") int userID,
                @Field("identifier") String identifier,
                @Field("issn") String issn,
                @Field("title") String title,
                @Field("creator") String creator,
                @Field("publicationName") String publicationName,
                @Field("doi") String doi,
                @Field("teaser") String teaser);
    }
}
