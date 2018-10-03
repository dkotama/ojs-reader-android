package com.dkotama.udayanaojsreader.presenter.issue;

import com.dkotama.udayanaojsreader.common.Constant;
import com.dkotama.udayanaojsreader.data.model.issue.AllIssueModel;
import com.dkotama.udayanaojsreader.data.model.issue.IssueData;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dkotama on 21/09/18.
 */

public interface AllIssueContract {
   interface View {
       void onLoadIssuesSuccess(List<IssueData> data);
       void onLoadIssuesFailed(String str);
   }

   interface Presenter {
       void loadIssues(int journalID);
       void loadIssuesSuccess(List<IssueData> data);
       void loadIssuesFailed(String str);
   }

    interface API {
        @GET(Constant.ACTION_ALL_ISSUE+ "/{journalID}")
        Single<AllIssueModel> getIssues(
                @Path("journalID") int journalID);
    }
}
