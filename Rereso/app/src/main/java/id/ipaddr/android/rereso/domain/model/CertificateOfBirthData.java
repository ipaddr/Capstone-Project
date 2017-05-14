package id.ipaddr.android.rereso.domain.model;

import android.support.annotation.NonNull;

import java.util.Date;
import java.util.UUID;

/**
 * Created by iip on 3/16/17.
 */

public class CertificateOfBirthData {

    
    private String id;
    
    private CertificateOfBirthForm certificateOfBirthForm;
    
    private DocumentRequired imgOfCertificateOfBirthForm;
    
    private DocumentRequired householdRecommendationLetter;
    
    private DocumentRequired placeOfBirthCertificateLetter;
    
    private DocumentRequired familyIdentityCard;
    
    private DocumentRequired fatherIdCard;
    
    private DocumentRequired motherIdCard;
    
    private DocumentRequired maritalCertificateLetter;
    
    private DocumentRequired fatherCertificateOfBirth;
    
    private DocumentRequired motherCertificateOfBirth;

    private DocumentRequired fatherPassport;
    private DocumentRequired motherPassport;
    
    private DocumentRequired firstSpectatorIdCard;
    
    private DocumentRequired secondSpectatorIdCard;
    private DocumentRequired policeCertificateForUnfamiliyBaby;
    private DocumentRequired socialServicesCertificateForVulnerableResidents;

    
    private ECertificateOfBirthState eCertificateOfBirthState;

    private UserAction userAction;

    public CertificateOfBirthData(){}

    public CertificateOfBirthData( CertificateOfBirthForm certificateOfBirthForm,  DocumentRequired imgOfCertificateOfBirthForm,  DocumentRequired householdRecommendationLetter,  DocumentRequired placeOfBirthCertificateLetter,  DocumentRequired familyIdentityCard,  DocumentRequired fatherIdCard,  DocumentRequired motherIdCard,  DocumentRequired maritalCertificateLetter,  DocumentRequired fatherCertificateOfBirth,  DocumentRequired motherCertificateOfBirth, DocumentRequired fatherPassport, DocumentRequired motherPassport, DocumentRequired firstSpectatorIdCard, DocumentRequired secondSpectatorIdCard, DocumentRequired policeCertificateForUnfamiliyBaby, DocumentRequired socialServicesCertificateForVulnerableResidents,  ECertificateOfBirthState eCertificateOfBirthState, UserAction userAction) {
        this.id = UUID.randomUUID().toString();
        this.certificateOfBirthForm = certificateOfBirthForm;
        this.imgOfCertificateOfBirthForm = imgOfCertificateOfBirthForm;
        this.householdRecommendationLetter = householdRecommendationLetter;
        this.placeOfBirthCertificateLetter = placeOfBirthCertificateLetter;
        this.familyIdentityCard = familyIdentityCard;
        this.fatherIdCard = fatherIdCard;
        this.motherIdCard = motherIdCard;
        this.maritalCertificateLetter = maritalCertificateLetter;
        this.fatherCertificateOfBirth = fatherCertificateOfBirth;
        this.motherCertificateOfBirth = motherCertificateOfBirth;
        this.fatherPassport = fatherPassport;
        this.motherPassport = motherPassport;
        this.firstSpectatorIdCard = firstSpectatorIdCard;
        this.secondSpectatorIdCard = secondSpectatorIdCard;
        this.policeCertificateForUnfamiliyBaby = policeCertificateForUnfamiliyBaby;
        this.socialServicesCertificateForVulnerableResidents = socialServicesCertificateForVulnerableResidents;
        this.eCertificateOfBirthState = eCertificateOfBirthState;
        this.userAction = userAction;
    }

    public CertificateOfBirthData( String id,  CertificateOfBirthForm certificateOfBirthForm,  DocumentRequired imgOfCertificateOfBirthForm,  DocumentRequired householdRecommendationLetter,  DocumentRequired placeOfBirthCertificateLetter,  DocumentRequired familyIdentityCard,  DocumentRequired fatherIdCard,  DocumentRequired motherIdCard,  DocumentRequired maritalCertificateLetter,  DocumentRequired fatherCertificateOfBirth,  DocumentRequired motherCertificateOfBirth, DocumentRequired fatherPassport, DocumentRequired motherPassport, DocumentRequired firstSpectatorIdCard, DocumentRequired secondSpectatorIdCard, DocumentRequired policeCertificateForUnfamiliyBaby, DocumentRequired socialServicesCertificateForVulnerableResidents,  ECertificateOfBirthState eCertificateOfBirthState, UserAction userAction) {
        this.id = id;
        this.certificateOfBirthForm = certificateOfBirthForm;
        this.imgOfCertificateOfBirthForm = imgOfCertificateOfBirthForm;
        this.householdRecommendationLetter = householdRecommendationLetter;
        this.placeOfBirthCertificateLetter = placeOfBirthCertificateLetter;
        this.familyIdentityCard = familyIdentityCard;
        this.fatherIdCard = fatherIdCard;
        this.motherIdCard = motherIdCard;
        this.maritalCertificateLetter = maritalCertificateLetter;
        this.fatherCertificateOfBirth = fatherCertificateOfBirth;
        this.motherCertificateOfBirth = motherCertificateOfBirth;
        this.fatherPassport = fatherPassport;
        this.motherPassport = motherPassport;
        this.firstSpectatorIdCard = firstSpectatorIdCard;
        this.secondSpectatorIdCard = secondSpectatorIdCard;
        this.policeCertificateForUnfamiliyBaby = policeCertificateForUnfamiliyBaby;
        this.socialServicesCertificateForVulnerableResidents = socialServicesCertificateForVulnerableResidents;
        this.eCertificateOfBirthState = eCertificateOfBirthState;
        this.userAction = userAction;
    }

    public CertificateOfBirthData( CertificateOfBirthData certificateOfBirthData,  ECertificateOfBirthState eCertificateOfBirthState,  UserAction userAction){
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
        this.eCertificateOfBirthState = eCertificateOfBirthState;
        this.userAction = userAction;
    }

    
    public String getId() {
        return id;
    }

    public void setId( String id) {
        this.id = id;
    }

    
    public CertificateOfBirthForm getCertificateOfBirthForm() {
        return certificateOfBirthForm;
    }

    public void setCertificateOfBirthForm( CertificateOfBirthForm certificateOfBirthForm) {
        this.certificateOfBirthForm = certificateOfBirthForm;
    }

    
    public DocumentRequired getImgOfCertificateOfBirthForm() {
        return imgOfCertificateOfBirthForm;
    }

    public void setImgOfCertificateOfBirthForm( DocumentRequired imgOfCertificateOfBirthForm) {
        this.imgOfCertificateOfBirthForm = imgOfCertificateOfBirthForm;
    }

    
    public DocumentRequired getHouseholdRecommendationLetter() {
        return householdRecommendationLetter;
    }

    public void setHouseholdRecommendationLetter( DocumentRequired householdRecommendationLetter) {
        this.householdRecommendationLetter = householdRecommendationLetter;
    }

    
    public DocumentRequired getPlaceOfBirthCertificateLetter() {
        return placeOfBirthCertificateLetter;
    }

    public void setPlaceOfBirthCertificateLetter( DocumentRequired placeOfBirthCertificateLetter) {
        this.placeOfBirthCertificateLetter = placeOfBirthCertificateLetter;
    }

    
    public DocumentRequired getFamilyIdentityCard() {
        return familyIdentityCard;
    }

    public void setFamilyIdentityCard( DocumentRequired familyIdentityCard) {
        this.familyIdentityCard = familyIdentityCard;
    }

    
    public DocumentRequired getFatherIdCard() {
        return fatherIdCard;
    }

    public void setFatherIdCard( DocumentRequired fatherIdCard) {
        this.fatherIdCard = fatherIdCard;
    }

    
    public DocumentRequired getMotherIdCard() {
        return motherIdCard;
    }

    public void setMotherIdCard( DocumentRequired motherIdCard) {
        this.motherIdCard = motherIdCard;
    }

    
    public DocumentRequired getMaritalCertificateLetter() {
        return maritalCertificateLetter;
    }

    public void setMaritalCertificateLetter( DocumentRequired maritalCertificateLetter) {
        this.maritalCertificateLetter = maritalCertificateLetter;
    }

    
    public DocumentRequired getFatherCertificateOfBirth() {
        return fatherCertificateOfBirth;
    }

    public void setFatherCertificateOfBirth( DocumentRequired fatherCertificateOfBirth) {
        this.fatherCertificateOfBirth = fatherCertificateOfBirth;
    }

    
    public DocumentRequired getMotherCertificateOfBirth() {
        return motherCertificateOfBirth;
    }

    public void setMotherCertificateOfBirth( DocumentRequired motherCertificateOfBirth) {
        this.motherCertificateOfBirth = motherCertificateOfBirth;
    }

    public DocumentRequired getFatherPassport() {
        return fatherPassport;
    }

    public void setFatherPassport(DocumentRequired fatherPassport) {
        this.fatherPassport = fatherPassport;
    }

    public DocumentRequired getMotherPassport() {
        return motherPassport;
    }

    public void setMotherPassport(DocumentRequired motherPassport) {
        this.motherPassport = motherPassport;
    }

    
    public DocumentRequired getFirstSpectatorIdCard() {
        return firstSpectatorIdCard;
    }

    public void setFirstSpectatorIdCard( DocumentRequired firstSpectatorIdCard) {
        this.firstSpectatorIdCard = firstSpectatorIdCard;
    }

    
    public DocumentRequired getSecondSpectatorIdCard() {
        return secondSpectatorIdCard;
    }

    public void setSecondSpectatorIdCard( DocumentRequired secondSpectatorIdCard) {
        this.secondSpectatorIdCard = secondSpectatorIdCard;
    }

    public DocumentRequired getPoliceCertificateForUnfamiliyBaby() {
        return policeCertificateForUnfamiliyBaby;
    }

    public void setPoliceCertificateForUnfamiliyBaby(DocumentRequired policeCertificateForUnfamiliyBaby) {
        this.policeCertificateForUnfamiliyBaby = policeCertificateForUnfamiliyBaby;
    }

    public DocumentRequired getSocialServicesCertificateForVulnerableResidents() {
        return socialServicesCertificateForVulnerableResidents;
    }

    public void setSocialServicesCertificateForVulnerableResidents(DocumentRequired socialServicesCertificateForVulnerableResidents) {
        this.socialServicesCertificateForVulnerableResidents = socialServicesCertificateForVulnerableResidents;
    }

    
    public ECertificateOfBirthState geteCertificateOfBirthState() {
        return eCertificateOfBirthState;
    }

    public void seteCertificateOfBirthState( ECertificateOfBirthState eCertificateOfBirthState) {
        this.eCertificateOfBirthState = eCertificateOfBirthState;
    }

    public UserAction getUserAction() {
        return userAction;
    }

    public void setUserAction(UserAction userAction) {
        this.userAction = userAction;
    }
}
