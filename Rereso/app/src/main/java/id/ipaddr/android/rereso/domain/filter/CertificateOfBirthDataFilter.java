package id.ipaddr.android.rereso.domain.filter;

import java.util.List;

import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;

/**
 * Created by iip on 3/19/17.
 */

public interface CertificateOfBirthDataFilter {
    List<CertificateOfBirthData> filter(List<CertificateOfBirthData> certificateOfBirthDatas);
}
