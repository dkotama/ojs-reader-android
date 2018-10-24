package com.dkotama.udayanaojsreader.presenter.issue;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.issue.IssueData;
import com.dkotama.udayanaojsreader.data.model.issue.LatestIssueModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dkotama on 21/09/18.
 */

public interface LatestIssueContract {
   interface View {
       void onLoadLatestSuccess(IssueData data);
       void onLoadLatestFailed(String str);
   }

   interface Presenter {
       void loadLatest(int journalID);
       void loadLatestSuccess(IssueData data);
       void loadLatestFailed(String str);
   }

    interface API {
//        @GET(Constant.ACTION_JOURNALS+ "/{journalID}/" + Constant.ACTION_LATEST_ISSUE)
//        Single<LatestIssueModel> getLatestIssue(
//                @Path("journalID") int journalID);
    }
}
