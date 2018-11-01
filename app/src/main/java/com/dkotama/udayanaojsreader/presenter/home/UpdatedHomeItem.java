package com.dkotama.udayanaojsreader.presenter.home;

/**
 * Created by dkotama on 30/10/18.
 */

public class UpdatedHomeItem {
    private String doi;
    private int position;
    private int id;

    public UpdatedHomeItem(String doi, int position) {
        this.doi = doi;
        this.position = position;
    }

    public String getDoi() {
        return doi;
    }

    public int getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

