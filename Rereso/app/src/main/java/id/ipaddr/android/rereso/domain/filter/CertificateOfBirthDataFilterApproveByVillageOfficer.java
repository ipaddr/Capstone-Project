package id.ipaddr.android.rereso.domain.filter;

import java.util.ArrayList;
import java.util.List;

import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.ECertificateOfBirthState;

/**
 * Created by iip on 3/19/17.
 */

public class CertificateOfBirthDataFilterApproveByVillageOfficer implements CertificateOfBirthDataFilter {
    @Override
    public List<CertificateOfBirthData> filter(List<CertificateOfBirthData> certificateOfBirthDatas) {
        List<CertificateOfBirthData> filteredData = new ArrayList<>();
        for (CertificateOfBirthData data : certificateOfBirthDatas){
            if (data.geteCertificateOfBirthState() == ECertificateOfBirthState.ApproveByVillageOffice){
                filteredData.add(data);
            }
        }
        return filteredData;
    }
}
