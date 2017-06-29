package id.ipaddr.android.rereso.data.repository.datasource;

import android.support.annotation.NonNull;

import java.util.List;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.DocumentRequired;
import io.reactivex.Observable;

/**
 * Created by iip on 3/19/17.
 *
 * Interface that represents a data store from where data is retrieved.
 */

public interface CertificateOfBirthDataDataStore {

    /**
     *  Get an {@link Observable} which will emit a List of {@link CertificateOfBirthDataEntity}.
     *
     *  @return
     */
    Observable<List<CertificateOfBirthDataEntity>> getCertificateOfBirthDataEntityList();

    /**
     * Get an {@link Observable} which will emit a {@link CertificateOfBirthDataEntity} by its id.
     *
     * @param id
     * @return
     */
    Observable<CertificateOfBirthDataEntity> getCertificateOfBirthDataEntity(String id);

    /**
     * Set an {@link Observable} which will emit a {@link CertificateOfBirthDataEntity} by its id.
     *
     * @param certificateOfBirthDataEntity
     * @return
     */
    Observable<CertificateOfBirthDataEntity> setCertificateOfBirthDataEntity(@NonNull CertificateOfBirthDataEntity certificateOfBirthDataEntity);
}
