package id.ipaddr.android.rereso.data.repository.datasource.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import id.ipaddr.android.rereso.data.cache.CertificateOfBirthDataCache;
import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.firebase.FirebaseRealtimeDatabaseImpl;
import id.ipaddr.android.rereso.data.repository.datasource.CertificateOfBirthDataDataStore;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import io.reactivex.Observable;

/**
 * Created by iip on 3/24/17.
 */

public class FirebaseRealtimeDatabaseCertificateOfBirthDataDataStore implements CertificateOfBirthDataDataStore {

    private final FirebaseRealtimeDatabaseImpl mFirebaseRealtimeDatabase;

    public FirebaseRealtimeDatabaseCertificateOfBirthDataDataStore(@NonNull FirebaseRealtimeDatabaseImpl firebaseRealtimeDatabase){
        mFirebaseRealtimeDatabase = firebaseRealtimeDatabase;
    }

    @Override
    public Observable<List<CertificateOfBirthDataEntity>> getCertificateOfBirthDataEntityList() {
        return mFirebaseRealtimeDatabase.getCertificateOfBirthDataEntityList();
    }

    @Override
    public Observable<CertificateOfBirthDataEntity> getCertificateOfBirthDataEntity(String id) {
        return mFirebaseRealtimeDatabase.getCertificateOfBirthDataEntity(id);
    }

    @Override public Observable<CertificateOfBirthDataEntity> setCertificateOfBirthDataEntity(@NonNull CertificateOfBirthDataEntity certificateOfBirthDataEntity){
        return mFirebaseRealtimeDatabase.setCertificateOfBirthDataEntity(certificateOfBirthDataEntity);
    }
}
