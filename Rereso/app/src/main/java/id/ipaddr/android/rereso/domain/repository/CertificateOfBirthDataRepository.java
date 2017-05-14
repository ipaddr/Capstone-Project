package id.ipaddr.android.rereso.domain.repository;

import android.support.annotation.NonNull;
import java.util.List;

import id.ipaddr.android.rereso.domain.interactor.GetCertificateOfBirthDataList;
import id.ipaddr.android.rereso.domain.interactor.SetCertificateOfBirthDataDetail;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import io.reactivex.Observable;

/**
 * Created by iip on 3/19/17.
 *
 * Interface that represents a Repository for getting {@link CertificateOfBirthData} related data.
 */

public interface CertificateOfBirthDataRepository {

    /**
     * Get an {@link Observable} which will emit a List of {@link CertificateOfBirthData}.
     */
    Observable<List<CertificateOfBirthData>> getCertificateOfBirthData();

    /**
     * Get an {@link Observable} which will emit a {@link GetCertificateOfBirthDataList}.
     *
     * @param id The user id used to retrieve GetCertificateOfBirthDataList data.
     */
    Observable<CertificateOfBirthData> getCertificateOfBirthData(@NonNull String id);

    /**
     * Get an {@link Observable} which will emit a {@link SetCertificateOfBirthDataDetail}.
     *
     * @param certificateOfBirthData The user id used to retrieve SetCertificateOfBirthDataDetail data.
     */
    Observable<CertificateOfBirthData> setCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void refreshCertificateOfBirthDatas();

    void saveCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void deleteAllCertificateOfBirthData();

    void deleteCertificateOfBirthData(@NonNull String id);

    void submitedStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void submitedStateCertificateOfBirthData(@NonNull String id);

    void declineByVillageOfficeStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void declineByVillageOfficeStateCertificateOfBirthData(@NonNull String id);

    void approveByVillageOfficeStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void approveByVillageOfficeStateCertificateOfBirthData(@NonNull String id);

    void declineBySubDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void declineBySubDistrictOfficerStateCertificateOfBirthData(@NonNull String id);

    void approveBySubDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void approveBySubDistrictOfficerStateCertificateOfBirthData(@NonNull String id);

    void declineByDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void DeclineByDistrictOfficerStateCertificateOfBirthData(@NonNull String id);

    void approveByDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void approveByDistrictOfficerStateCertificateOfBirthData(@NonNull String id);

    void printingByDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void printingByDistrictOfficerStateCertificateOfBirthData(@NonNull String id);

    void approveToPickUpByDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData);

    void approveToPickUpByDistrictOfficerStateCertificateOfBirthData(@NonNull String id);
}
