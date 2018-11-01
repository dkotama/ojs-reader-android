package com.dkotama.udayanaojsreader.presenter.paper;

import com.dkotama.udayanaojsreader.data.model.paper.PaperData;

/**
 * Created by dkotama on 21/09/18.
 */

public interface PaperContract {
   interface View {
       void onLoadPaperSuccess(PaperData data);
       void onLoadPaperFailed(String str);
   }

   interface Presenter {
       void loadPaper(int journalID);
       void loadPaperSuccess(PaperData data);
       void loadPaperFailed(String str);
   }

   interface API {
//        @GET(Constant.ACTION_JOURNALS + "/{journalID}/")
//        Single<JournalModel> getJournal(
//                @Path("journalID") int journalID);
    }
}
