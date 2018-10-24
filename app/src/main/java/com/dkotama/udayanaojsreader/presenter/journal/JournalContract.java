package com.dkotama.udayanaojsreader.presenter.journal;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;
import com.dkotama.udayanaojsreader.data.model.journal.JournalModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dkotama on 21/09/18.
 */

public interface  JournalContract {
   interface View {
       void onLoadJournalSuccess(JournalItemData data);
       void onLoadJournalFailed(String str);
   }

   interface Presenter {
       void loadJournal(int journalID);
       void loadJournalSuccess(JournalItemData data);
       void loadJournalFailed(String str);
   }

   interface API {
//        @GET(Constant.ACTION_JOURNALS + "/{journalID}/")
//        Single<JournalModel> getJournal(
//                @Path("journalID") int journalID);
    }
}
