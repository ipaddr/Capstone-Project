package id.ipaddr.android.rereso.data.entity.mapper;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;

/**
 * Created by iip on 3/19/17.
 *
 * Mapper class used to transform {@link CertificateOfBirthDataEntity} (in the data layer)
 * to {@link CertificateOfBirthData} in the domain layer.
 */

public class CertificateOfBirthDataEntityDataMapper {

    @Inject
    CertificateOfBirthDataEntityDataMapper(){}

    /**
     * Transform a {@link CertificateOfBirthDataEntity} into an {@link CertificateOfBirthData}.
     *
     * @param certificateOfBirthDataEntity Object to be transformed.
     * @return {@link CertificateOfBirthData} if valid {@link CertificateOfBirthDataEntity} otherwise null.
     */
    public CertificateOfBirthData transform(CertificateOfBirthDataEntity certificateOfBirthDataEntity) {
        CertificateOfBirthData certificateOfBirthData = null;
        if (certificateOfBirthDataEntity != null) {
            certificateOfBirthData = new CertificateOfBirthData(certificateOfBirthDataEntity.id
                    , certificateOfBirthDataEntity.certificateOfBirthForm, certificateOfBirthDataEntity.imgOfCertificateOfBirthForm
                    , certificateOfBirthDataEntity.householdRecommendationLetter, certificateOfBirthDataEntity.placeOfBirthCertificateLetter
                    , certificateOfBirthDataEntity.familyIdentityCard, certificateOfBirthDataEntity.fatherIdCard, certificateOfBirthDataEntity.motherIdCard
                    , certificateOfBirthDataEntity.maritalCertificateLetter, certificateOfBirthDataEntity.fatherCertificateOfBirth
                    , certificateOfBirthDataEntity.motherCertificateOfBirth, certificateOfBirthDataEntity.fatherPassport, certificateOfBirthDataEntity.motherPassport
                    , certificateOfBirthDataEntity.firstSpectatorIdCard, certificateOfBirthDataEntity.secondSpectatorIdCard
                    , certificateOfBirthDataEntity.policeCertificateForUnfamiliyBaby, certificateOfBirthDataEntity.socialServicesCertificateForVulnerableResidents
                    , certificateOfBirthDataEntity.eCertificateOfBirthState, certificateOfBirthDataEntity.getUserAction());
        }
        return certificateOfBirthData;
    }

    /**
     * Transform a List of {@link CertificateOfBirthDataEntity} into a Collection of {@link CertificateOfBirthData}.
     *
     * @param certificateOfBirthDataEntities Object Collection to be transformed.
     * @return {@link CertificateOfBirthData} if valid {@link CertificateOfBirthDataEntity} otherwise null.
     */
    public List<CertificateOfBirthData> transform(Collection<CertificateOfBirthDataEntity> certificateOfBirthDataEntities) {
        final List<CertificateOfBirthData> certificateOfBirthDatas = new ArrayList<>();
        for (CertificateOfBirthDataEntity entity : certificateOfBirthDataEntities) {
            final CertificateOfBirthData data = transform(entity);
            if (data != null) {
                certificateOfBirthDatas.add(data);
            }
        }
        return certificateOfBirthDatas;
    }

}
