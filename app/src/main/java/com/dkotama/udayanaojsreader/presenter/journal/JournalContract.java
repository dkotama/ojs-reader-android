package com.dkotama.udayanaojsreader.presenter.journal;

import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;

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
