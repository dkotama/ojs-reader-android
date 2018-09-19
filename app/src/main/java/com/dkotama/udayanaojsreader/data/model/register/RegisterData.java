package com.dkotama.udayanaojsreader.data.model.register;

/**
 * Created by dkotama on 16/09/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterData {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
