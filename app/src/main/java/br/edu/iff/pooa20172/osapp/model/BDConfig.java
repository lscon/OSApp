package br.edu.iff.pooa20172.osapp.model;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by fazenda on 17/03/18.
 */

public class BDConfig extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());

        RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
        builder.name("osApp.realm");
        builder.schemaVersion(0);
        builder.deleteRealmIfMigrationNeeded();
        RealmConfiguration realmConfiguration = builder.build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

}