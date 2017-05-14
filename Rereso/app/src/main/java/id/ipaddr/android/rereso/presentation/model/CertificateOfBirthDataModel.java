package id.ipaddr.android.rereso.presentation.model;

import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthForm;
import id.ipaddr.android.rereso.domain.model.DocumentRequired;
import id.ipaddr.android.rereso.domain.model.ECertificateOfBirthState;

/**
 * Created by iip on 3/19/17.
 */

public class CertificateOfBirthDataModel {

    public String id;
    public CertificateOfBirthForm certificateOfBirthForm;
    public DocumentRequired imgOfCertificateOfBirthForm;
    public DocumentRequired householdRecommendationLetter;
    public DocumentRequired placeOfBirthCertificateLetter;
    public DocumentRequired familyIdentityCard;
    public DocumentRequired fatherIdCard;
    public DocumentRequired motherIdCard;
    public DocumentRequired maritalCertificateLetter;
    public DocumentRequired fatherCertificateOfBirth;
    public DocumentRequired motherCertificateOfBirth;
    public DocumentRequired fatherPassport;
    public DocumentRequired motherPassport;
    public DocumentRequired firstSpectatorIdCard;
    public DocumentRequired secondSpectatorIdCard;
    public DocumentRequired policeCertificateForUnfamiliyBaby;
    public DocumentRequired socialServicesCertificateForVulnerableResidents;
    public ECertificateOfBirthState eCertificateOfBirthState;



    public CertificateOfBirthDataModel(CertificateOfBirthData certificateOfBirthData){
        this.id = certificateOfBirthData.getId();
        this.certificateOfBirthForm = certificateOfBirthData.getCertificateOfBirthForm();
        this.imgOfCertificateOfBirthForm = certificateOfBirthData.getImgOfCertificateOfBirthForm();
        this.householdRecommendationLetter = certificateOfBirthData.getHouseholdRecommendationLetter();
        this.placeOfBirthCertificateLetter = certificateOfBirthData.getPlaceOfBirthCertificateLetter();
        this.familyIdentityCard = certificateOfBirthData.getFamilyIdentityCard();
        this.fatherIdCard = certificateOfBirthData.getFatherIdCard();
        this.motherIdCard = certificateOfBirthData.getMotherIdCard();
        this.maritalCertificateLetter = certificateOfBirthData.getMaritalCertificateLetter();
        this.fatherCertificateOfBirth = certificateOfBirthData.getFatherCertificateOfBirth();
        this.motherCertificateOfBirth = certificateOfBirthData.getMotherCertificateOfBirth();
        this.fatherPassport = certificateOfBirthData.getFatherPassport();
        this.motherPassport = certificateOfBirthData.getMotherPassport();
        this.firstSpectatorIdCard = certificateOfBirthData.getFirstSpectatorIdCard();
        this.secondSpectatorIdCard = certificateOfBirthData.getSecondSpectatorIdCard();
        this.policeCertificateForUnfamiliyBaby = certificateOfBirthData.getPoliceCertificateForUnfamiliyBaby();
        this.socialServicesCertificateForVulnerableResidents = certificateOfBirthData.getSocialServicesCertificateForVulnerableResidents();
        this.eCertificateOfBirthState = certificateOfBirthData.geteCertificateOfBirthState();
    }

}
