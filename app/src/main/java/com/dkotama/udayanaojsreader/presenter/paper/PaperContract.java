package com.dkotama.udayanaojsreader.presenter.paper;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.journal.JournalItemData;
import com.dkotama.udayanaojsreader.data.model.journal.JournalModel;
import com.dkotama.udayanaojsreader.data.model.paper.PaperData;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

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
        @GET(Constant.ACTION_JOURNALS + "/{journalID}/")
        Single<JournalModel> getJournal(
                @Path("journalID") int journalID);
    }
}
