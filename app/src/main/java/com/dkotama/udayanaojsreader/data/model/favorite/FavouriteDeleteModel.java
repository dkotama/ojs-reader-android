package com.dkotama.udayanaojsreader.data.model.favorite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dkotama on 19/09/18.
 */

public class FavouriteDeleteModel {
    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("data")
    @Expose
    private DeleteData data;


    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public DeleteData getData() {
        return data;
    }

    private class DeleteData {
        @SerializedName("success")
        @Expose
        private Boolean success;

        public Boolean getSuccess() {
            return success;
        }
    }
}
