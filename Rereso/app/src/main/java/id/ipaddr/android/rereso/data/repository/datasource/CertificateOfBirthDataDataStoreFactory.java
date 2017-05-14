package id.ipaddr.android.rereso.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.ipaddr.android.rereso.data.cache.CertificateOfBirthDataCache;
import id.ipaddr.android.rereso.data.database.CertificateOfBirthDataDatabase;
import id.ipaddr.android.rereso.data.database.CertificateOfBirthDataDatabaseImpl;
import id.ipaddr.android.rereso.data.entity.mapper.CertificateOfBirthDataEntityJsonMapper;
import id.ipaddr.android.rereso.data.firebase.FirebaseRealtimeDatabaseImpl;
import id.ipaddr.android.rereso.data.net.RestApi;
import id.ipaddr.android.rereso.data.net.RestApiImpl;
import id.ipaddr.android.rereso.data.repository.datasource.local.DatabaseCertificateOfBirthDataDataStore;
import id.ipaddr.android.rereso.data.repository.datasource.local.DiskCertificateOfBirthDataDataStore;
import id.ipaddr.android.rereso.data.repository.datasource.remote.CloudCertificateOfBirthDataDataStore;
import id.ipaddr.android.rereso.data.repository.datasource.remote.FirebaseRealtimeDatabaseCertificateOfBirthDataDataStore;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;

/**
 * Created by iip on 3/19/17.
 *
 * Factory that creates different implementations of {@link CertificateOfBirthDataDataStore}.
 */
@Singleton
public class CertificateOfBirthDataDataStoreFactory {

    private final Context mContext;
    private final CertificateOfBirthDataCache mCache;

    @Inject
    CertificateOfBirthDataDataStoreFactory(@NonNull Context context
            , @NonNull CertificateOfBirthDataCache cache) {
        this.mContext = context.getApplicationContext();
        this.mCache = cache;
    }

    /**
     * Create {@link CertificateOfBirthDataDataStore} from id.
     */
    public CertificateOfBirthDataDataStore create(String id) {
        CertificateOfBirthDataDataStore certificateOfBirthDataDataStore;

        if (!this.mCache.isExpired() && this.mCache.isCached(id)) {
            certificateOfBirthDataDataStore = new DiskCertificateOfBirthDataDataStore(this.mCache);
        } else {
//            certificateOfBirthDataDataStore = createCloudDataStore();
            certificateOfBirthDataDataStore = createCloudDataStoreFromFirebaseDatabase();
        }

        return certificateOfBirthDataDataStore;
    }

    public CertificateOfBirthDataDataStore createCloudDataStoreFromDatabase(){
        final CertificateOfBirthDataDatabase certificateOfBirthDataDatabase = new CertificateOfBirthDataDatabaseImpl(mContext, mContext.getContentResolver(), new Gson());
        final CertificateOfBirthDataDataStore certificateOfBirthDataDataStore = new DatabaseCertificateOfBirthDataDataStore(certificateOfBirthDataDatabase);
        return certificateOfBirthDataDataStore;
    }

    /**
     * Create {@link CertificateOfBirthDataDataStore} to retrieve data from the Cloud.
     */
    public CertificateOfBirthDataDataStore createCloudDataStore() {
        final CertificateOfBirthDataEntityJsonMapper certificateOfBirthDataEntityJsonMapper = new CertificateOfBirthDataEntityJsonMapper();
        final RestApi restApi = new RestApiImpl(this.mContext, certificateOfBirthDataEntityJsonMapper);

        return new CloudCertificateOfBirthDataDataStore(restApi, this.mCache);
    }

    /**
     * Create {@link CertificateOfBirthDataDataStore} to retrieve data from the firebase.
     */
    public CertificateOfBirthDataDataStore createCloudDataStoreFromFirebaseDatabase() {
        final FirebaseDatabase fb = FirebaseDatabase.getInstance();
        final DatabaseReference db = fb.getReference(CertificateOfBirthData.class.getSimpleName());
        final FirebaseRealtimeDatabaseImpl realtimeDatabase = new FirebaseRealtimeDatabaseImpl(mContext, db);
        return new FirebaseRealtimeDatabaseCertificateOfBirthDataDataStore(realtimeDatabase);
    }

}
