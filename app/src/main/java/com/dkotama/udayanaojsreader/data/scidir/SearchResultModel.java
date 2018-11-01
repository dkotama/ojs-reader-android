package com.dkotama.udayanaojsreader.data.scidir;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dkotama on 23/10/18.
 */

public class SearchResultModel {
    @SerializedName("search-results")
    @Expose
    private SearchResultData results;

    public String toString() {
        String temp = "{" +
                "results: " + results.toString() +
                "entries: [ ";

//        temp += results.entries.get(0).toString();
//        for (Iterator<SearchEntryItemData> i = results.entries.iterator(); i.hasNext();) {
//            SearchEntryItemData item = i.next();
//            temp += i.toString();
//        }
//
        temp += "] }";

        return temp;
    }

    public SearchResultData getResults() {
        return results;
    }

    public class SearchResultData {
        @SerializedName("opensearch:totalResults")
        @Expose
        private int totalResults;

        @SerializedName("opensearch:startIndex")
        @Expose
        private int startIndex;

        @SerializedName("opensearch:itemsPerPage")
        @Expose
        private int itemsPerPage;

        @SerializedName("entry")
        @Expose
        private List<HomeEntryItemData> entries;

        public List<HomeEntryItemData> getEntries() {
            return entries;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getItemsPerPage() {
            return itemsPerPage;
        }

        public String toString() {
            return "{ " +
                    "totalResults: " + totalResults +
                    ",startIndex: " + startIndex +
                    ",itemsPerPage: " + itemsPerPage + " }";

        }
    }
}
