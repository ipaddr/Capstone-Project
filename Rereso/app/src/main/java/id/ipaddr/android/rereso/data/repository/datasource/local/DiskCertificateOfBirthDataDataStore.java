package id.ipaddr.android.rereso.data.repository.datasource.local;

import android.support.annotation.NonNull;

import java.util.List;

import id.ipaddr.android.rereso.data.cache.CertificateOfBirthDataCache;
import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.repository.datasource.CertificateOfBirthDataDataStore;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import io.reactivex.Observable;

/**
 * Created by iip on 3/19/17.
 */

 /**
 * {@link CertificateOfBirthDataDataStore} implementation based on file system data store.
 */
public class DiskCertificateOfBirthDataDataStore implements CertificateOfBirthDataDataStore {

    private final CertificateOfBirthDataCache mCertificateOfBirthDataCache;

    /**
     * Construct a {@link CertificateOfBirthDataDataStore} based file system data store.
     *
     * @param certificateOfBirthDataCache A {@link CertificateOfBirthDataCache} to cache data retrieved from the api.
     */
    public DiskCertificateOfBirthDataDataStore(CertificateOfBirthDataCache certificateOfBirthDataCache) {
        this.mCertificateOfBirthDataCache = certificateOfBirthDataCache;
    }

    @Override
    public Observable<List<CertificateOfBirthDataEntity>> getCertificateOfBirthDataEntityList() {
        //TODO: implement simple cache for storing/retrieving collections of users.
        throw new UnsupportedOperationException("Operation is not available!!!");
    }

    @Override
    public Observable<CertificateOfBirthDataEntity> getCertificateOfBirthDataEntity(final String id) {
        return this.mCertificateOfBirthDataCache.get(id);
    }

     @Override public Observable<CertificateOfBirthDataEntity> setCertificateOfBirthDataEntity(@NonNull CertificateOfBirthDataEntity certificateOfBirthDataEntity){
         return null;
     }
}

