package com.dkotama.udayanaojsreader.common;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by dkotama on 18/09/18.
 */

public class Core extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        Core.context = getApplicationContext();

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Constant.REALM_FILENAME)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static Context getAppContext() {
        return context;
    }
}
