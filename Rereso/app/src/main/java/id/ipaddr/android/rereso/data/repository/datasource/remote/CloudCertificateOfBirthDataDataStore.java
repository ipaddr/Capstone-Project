package id.ipaddr.android.rereso.data.repository.datasource.remote;

import android.support.annotation.NonNull;

import java.util.List;

import id.ipaddr.android.rereso.data.cache.CertificateOfBirthDataCache;
import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.net.RestApi;
import id.ipaddr.android.rereso.data.repository.datasource.CertificateOfBirthDataDataStore;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import io.reactivex.Observable;

/**
 * Created by iip on 3/19/17.
 *
 * {@link CloudCertificateOfBirthDataDataStore} implementation based on connections to the api (Cloud).
 */
public class CloudCertificateOfBirthDataDataStore implements CertificateOfBirthDataDataStore {

    private final RestApi restApi;
    private final CertificateOfBirthDataCache mCertificateOfBirthDataCache;

    /**
     * Construct a {@link CertificateOfBirthDataDataStore} based on connections to the api (Cloud).
     *
     * @param restApi The {@link RestApi} implementation to use.
     * @param certificateOfBirthDataCache A {@link CertificateOfBirthDataCache} to cache data retrieved from the api.
     */
    public CloudCertificateOfBirthDataDataStore(RestApi restApi, CertificateOfBirthDataCache certificateOfBirthDataCache) {
        this.restApi = restApi;
        this.mCertificateOfBirthDataCache = certificateOfBirthDataCache;
    }

    @Override public Observable<List<CertificateOfBirthDataEntity>> getCertificateOfBirthDataEntityList() {
        return this.restApi.certificateOfBirthDataEntityList();
    }

    @Override public Observable<CertificateOfBirthDataEntity> getCertificateOfBirthDataEntity(final String userId) {
        return null;
    }

    @Override public Observable<CertificateOfBirthDataEntity> setCertificateOfBirthDataEntity(@NonNull CertificateOfBirthDataEntity certificateOfBirthDataEntity){
        return null;
    }
}