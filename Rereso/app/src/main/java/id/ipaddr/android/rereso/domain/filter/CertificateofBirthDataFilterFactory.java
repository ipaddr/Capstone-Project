package id.ipaddr.android.rereso.domain.filter;

import java.util.HashMap;
import java.util.Map;

import id.ipaddr.android.rereso.domain.model.ECertificateOfBirthState;

/**
 * Created by iip on 3/19/17.
 *
 * Factory of {@link CertificateOfBirthDataFilter}s.
 *
 */

public class CertificateofBirthDataFilterFactory {
    private static final Map<ECertificateOfBirthState, CertificateOfBirthDataFilter> mFilters = new HashMap<>();

    public CertificateofBirthDataFilterFactory(){
        mFilters.put(ECertificateOfBirthState.Submited, new CertificateOfBirthDataFilterSubmited());
        mFilters.put(ECertificateOfBirthState.DeclineByVillageOffice, new CertificateOfBirthDataFilterDeclineByVillageOfficer());
        mFilters.put(ECertificateOfBirthState.ApproveByVillageOffice, new CertificateOfBirthDataFilterApproveByVillageOfficer());
        mFilters.put(ECertificateOfBirthState.DeclineBySubDistrictOfficer, new CertificateOfBirthDataFilterDeclineBySubDistrictOfficer());
        mFilters.put(ECertificateOfBirthState.ApproveBySubDistrictOfficer, new CertificateOfBirthDataFilterApproveBySubDistrictOfficer());
        mFilters.put(ECertificateOfBirthState.DeclineByDistrictOfficer, new CertificateOfBirthDataFilterDeclineByDistrictOfficer());
        mFilters.put(ECertificateOfBirthState.ApproveByDistrictOfficer, new CertificateOfBirthDataFilterApproveByDistrictOfficer());
        mFilters.put(ECertificateOfBirthState.PrintingByDistrictOfficer, new CertificateOfBirthDataFilterPrintingByDistrictOfficer());
        mFilters.put(ECertificateOfBirthState.ApproveToPickUpByDistrictOfficer, new CertificateOfBirthDataFilterApproveToPickUpByDistrictOfficer());
    }
}
