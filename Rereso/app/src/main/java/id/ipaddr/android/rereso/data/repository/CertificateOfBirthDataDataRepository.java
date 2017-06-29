package id.ipaddr.android.rereso.data.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.data.entity.mapper.CertificateOfBirthDataEntityDataMapper;
import id.ipaddr.android.rereso.data.repository.datasource.CertificateOfBirthDataDataStore;
import id.ipaddr.android.rereso.data.repository.datasource.CertificateOfBirthDataDataStoreFactory;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.ECertificateOfBirthState;
import id.ipaddr.android.rereso.domain.repository.CertificateOfBirthDataRepository;
import io.reactivex.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by iip on 3/16/17.
 *
 * Concrete implementation to load CertificateOfBirthData from the data sources into a cache.
 * <p/>
 * For simplicity, this implements a dumb synchronisation between locally persisted data and data
 * obtained from the server, by using the remote data source only if the local database doesn't
 * exist or is empty.

 */

@Singleton
public class CertificateOfBirthDataDataRepository implements CertificateOfBirthDataRepository {

    private final CertificateOfBirthDataDataStoreFactory mDataStoreFactory;
    private final CertificateOfBirthDataEntityDataMapper mEntityDataMapper;

    @Inject
    CertificateOfBirthDataDataRepository(
            @NonNull CertificateOfBirthDataDataStoreFactory certificateOfBirthDataDataStoreFactory,
                            @NonNull CertificateOfBirthDataEntityDataMapper certificateOfBirthDataEntityDataMapper) {
        this.mDataStoreFactory = checkNotNull(certificateOfBirthDataDataStoreFactory);
        this.mEntityDataMapper = checkNotNull(certificateOfBirthDataEntityDataMapper);
    }

    /**
     * Gets tasks from cache, local data source (SQLite) or remote data source, whichever is
     * available first.
     */
    @Override
    public Observable<List<CertificateOfBirthData>> getCertificateOfBirthData() {
//        final CertificateOfBirthDataDataStore dataStore = mDataStoreFactory.createCloudDataStore();
        final CertificateOfBirthDataDataStore dataStore = mDataStoreFactory.createCloudDataStoreFromFirebaseDatabase();
        return dataStore.getCertificateOfBirthDataEntityList().map(mEntityDataMapper::transform);
    }

    /**
     * Gets tasks from local data source (sqlite) unless the table is new or empty. In that case it
     * uses the network data source. This is done to simplify the sample.
     */
    @Override
    public Observable<CertificateOfBirthData> getCertificateOfBirthData(@NonNull final String id) {
        final CertificateOfBirthDataDataStore dataStore = mDataStoreFactory.create(id);
        return dataStore.getCertificateOfBirthDataEntity(id).map(mEntityDataMapper::transform);
    }

    /**
     * Sets tasks from local data source (sqlite) unless the table is new or empty. In that case it
     * uses the network data source. This is done to simplify the sample.
     */
    @Override
    public Observable<CertificateOfBirthData> setCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
//        final CertificateOfBirthDataDataStore dataStore = mDataStoreFactory.createCloudDataStoreFromFirebaseDatabase();
//        final CertificateOfBirthDataEntity entity = new CertificateOfBirthDataEntity(certificateOfBirthData);
//        return dataStore.setCertificateOfBirthDataEntity(entity).map(mEntityDataMapper::transform);
        final CertificateOfBirthDataDataStore dataStore = mDataStoreFactory.createCloudDataStoreFromFirebaseDatabase();
        final CertificateOfBirthDataEntity entity = new CertificateOfBirthDataEntity(certificateOfBirthData);
        return dataStore.setCertificateOfBirthDataEntity(entity).map(mEntityDataMapper::transform);
    }

    @Override
    public void refreshCertificateOfBirthDatas(){
    }

    @Override
    public void saveCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
    }

    @Override
    public void deleteAllCertificateOfBirthData() {
    }

    @Override
    public void deleteCertificateOfBirthData(@NonNull String id) {
    }

    private void updatepdatedStateOfCertificateOfBirthData(CertificateOfBirthData certificateOfBirthData, ECertificateOfBirthState state){
//        checkNotNull(certificateOfBirthData);
//        checkNotNull(state);
//
//        mCertificateOfBirthDataLocalDataSource.submitedStateCertificateOfBirthData(certificateOfBirthData);
//        mCertificateOfBirthDataRemoteDataSource.submitedStateCertificateOfBirthData(certificateOfBirthData);
//
//        CertificateOfBirthData updatedStatusCertificateOfBirthData = new CertificateOfBirthData(certificateOfBirthData, state);
//        // Do in memory cache update to keep the app UI up to date
//        if (mCachedCertificateOfBirthData == null){
//            mCachedCertificateOfBirthData = new LinkedHashMap<>();
//        }
//        mCachedCertificateOfBirthData.put(updatedStatusCertificateOfBirthData.getId(), updatedStatusCertificateOfBirthData);
    }

    private void updatepdatedStateOfCertificateOfBirthData(@NonNull String id, @NonNull ECertificateOfBirthState state){
//        checkNotNull(id);
//        checkNotNull(state);
//
//        CertificateOfBirthData certificateOfBirthData = getCertificateOfBirthDataWithId(id);
//        if (certificateOfBirthData != null){
//            updatepdatedStateOfCertificateOfBirthData(certificateOfBirthData, state);
//        }
    }

    @Override
    public void submitedStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
        updatepdatedStateOfCertificateOfBirthData(certificateOfBirthData, ECertificateOfBirthState.Submited);
    }

    @Override
    public void submitedStateCertificateOfBirthData(@NonNull String id) {
        updatepdatedStateOfCertificateOfBirthData(id, ECertificateOfBirthState.Submited);
    }

    @Override
    public void declineByVillageOfficeStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
        updatepdatedStateOfCertificateOfBirthData(certificateOfBirthData, ECertificateOfBirthState.DeclineByVillageOffice);
    }

    @Override
    public void declineByVillageOfficeStateCertificateOfBirthData(@NonNull String id) {
        updatepdatedStateOfCertificateOfBirthData(id, ECertificateOfBirthState.DeclineByVillageOffice);
    }

    @Override
    public void approveByVillageOfficeStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
        updatepdatedStateOfCertificateOfBirthData(certificateOfBirthData, ECertificateOfBirthState.ApproveByVillageOffice);
    }

    @Override
    public void approveByVillageOfficeStateCertificateOfBirthData(@NonNull String id) {
        updatepdatedStateOfCertificateOfBirthData(id, ECertificateOfBirthState.ApproveByVillageOffice);
    }

    @Override
    public void declineBySubDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
        updatepdatedStateOfCertificateOfBirthData(certificateOfBirthData, ECertificateOfBirthState.DeclineBySubDistrictOfficer);
    }

    @Override
    public void declineBySubDistrictOfficerStateCertificateOfBirthData(@NonNull String id) {
        updatepdatedStateOfCertificateOfBirthData(id, ECertificateOfBirthState.DeclineBySubDistrictOfficer);
    }

    @Override
    public void approveBySubDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
        updatepdatedStateOfCertificateOfBirthData(certificateOfBirthData, ECertificateOfBirthState.ApproveBySubDistrictOfficer);
    }

    @Override
    public void approveBySubDistrictOfficerStateCertificateOfBirthData(@NonNull String id) {
        updatepdatedStateOfCertificateOfBirthData(id, ECertificateOfBirthState.ApproveBySubDistrictOfficer);
    }

    @Override
    public void declineByDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
        updatepdatedStateOfCertificateOfBirthData(certificateOfBirthData, ECertificateOfBirthState.DeclineByDistrictOfficer);
    }

    @Override
    public void DeclineByDistrictOfficerStateCertificateOfBirthData(@NonNull String id) {
        updatepdatedStateOfCertificateOfBirthData(id, ECertificateOfBirthState.DeclineByDistrictOfficer);
    }

    @Override
    public void approveByDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
        updatepdatedStateOfCertificateOfBirthData(certificateOfBirthData, ECertificateOfBirthState.ApproveByDistrictOfficer);
    }

    @Override
    public void approveByDistrictOfficerStateCertificateOfBirthData(@NonNull String id) {
        updatepdatedStateOfCertificateOfBirthData(id, ECertificateOfBirthState.ApproveByDistrictOfficer);
    }

    @Override
    public void printingByDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
        updatepdatedStateOfCertificateOfBirthData(certificateOfBirthData, ECertificateOfBirthState.PrintingByDistrictOfficer);
    }

    @Override
    public void printingByDistrictOfficerStateCertificateOfBirthData(@NonNull String id) {
        updatepdatedStateOfCertificateOfBirthData(id, ECertificateOfBirthState.PrintingByDistrictOfficer);
    }

    @Override
    public void approveToPickUpByDistrictOfficerStateCertificateOfBirthData(@NonNull CertificateOfBirthData certificateOfBirthData) {
        updatepdatedStateOfCertificateOfBirthData(certificateOfBirthData, ECertificateOfBirthState.ApproveToPickUpByDistrictOfficer);
    }

    @Override
    public void approveToPickUpByDistrictOfficerStateCertificateOfBirthData(@NonNull String id) {
        updatepdatedStateOfCertificateOfBirthData(id, ECertificateOfBirthState.ApproveToPickUpByDistrictOfficer);
    }
}
