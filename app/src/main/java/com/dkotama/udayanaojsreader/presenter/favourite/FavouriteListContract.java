package com.dkotama.udayanaojsreader.presenter.favourite;

import com.dkotama.udayanaojsreader.data.model.favorite.FavouriteRealmData;

/**
 * Created by dkotama on 01/11/18.
 */

public interface FavouriteListContract {
    interface View {
        void onClickJournalItem(FavouriteRealmData item);
        void onClickRemoveFavorite(int favID);
    }
}
