package id.ipaddr.android.rereso.data.entity;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthForm;
import id.ipaddr.android.rereso.domain.model.DocumentRequired;
import id.ipaddr.android.rereso.domain.model.ECertificateOfBirthState;
import id.ipaddr.android.rereso.domain.model.UserAction;

/**
 * Created by iip on 3/19/17.
 *
 * CertificateOfBirthData Entity used in the data layer.
 */

public class CertificateOfBirthDataEntity {

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
    public UserAction userAction;

    public CertificateOfBirthDataEntity(){}

    public CertificateOfBirthDataEntity(CertificateOfBirthData certificateOfBirthData){
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
        this.userAction = certificateOfBirthData.getUserAction();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CertificateOfBirthForm getCertificateOfBirthForm() {
        return certificateOfBirthForm;
    }

    public void setCertificateOfBirthForm(CertificateOfBirthForm certificateOfBirthForm) {
        this.certificateOfBirthForm = certificateOfBirthForm;
    }

    public DocumentRequired getImgOfCertificateOfBirthForm() {
        return imgOfCertificateOfBirthForm;
    }

    public void setImgOfCertificateOfBirthForm(DocumentRequired imgOfCertificateOfBirthForm) {
        this.imgOfCertificateOfBirthForm = imgOfCertificateOfBirthForm;
    }

    public DocumentRequired getHouseholdRecommendationLetter() {
        return householdRecommendationLetter;
    }

    public void setHouseholdRecommendationLetter(DocumentRequired householdRecommendationLetter) {
        this.householdRecommendationLetter = householdRecommendationLetter;
    }

    public DocumentRequired getPlaceOfBirthCertificateLetter() {
        return placeOfBirthCertificateLetter;
    }

    public void setPlaceOfBirthCertificateLetter(DocumentRequired placeOfBirthCertificateLetter) {
        this.placeOfBirthCertificateLetter = placeOfBirthCertificateLetter;
    }

    public DocumentRequired getFamilyIdentityCard() {
        return familyIdentityCard;
    }

    public void setFamilyIdentityCard(DocumentRequired familyIdentityCard) {
        this.familyIdentityCard = familyIdentityCard;
    }

    public DocumentRequired getFatherIdCard() {
        return fatherIdCard;
    }

    public void setFatherIdCard(DocumentRequired fatherIdCard) {
        this.fatherIdCard = fatherIdCard;
    }

    public DocumentRequired getMotherIdCard() {
        return motherIdCard;
    }

    public void setMotherIdCard(DocumentRequired motherIdCard) {
        this.motherIdCard = motherIdCard;
    }

    public DocumentRequired getMaritalCertificateLetter() {
        return maritalCertificateLetter;
    }

    public void setMaritalCertificateLetter(DocumentRequired maritalCertificateLetter) {
        this.maritalCertificateLetter = maritalCertificateLetter;
    }

    public DocumentRequired getFatherCertificateOfBirth() {
        return fatherCertificateOfBirth;
    }

    public void setFatherCertificateOfBirth(DocumentRequired fatherCertificateOfBirth) {
        this.fatherCertificateOfBirth = fatherCertificateOfBirth;
    }

    public DocumentRequired getMotherCertificateOfBirth() {
        return motherCertificateOfBirth;
    }

    public void setMotherCertificateOfBirth(DocumentRequired motherCertificateOfBirth) {
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

    public void setFirstSpectatorIdCard(DocumentRequired firstSpectatorIdCard) {
        this.firstSpectatorIdCard = firstSpectatorIdCard;
    }

    public DocumentRequired getSecondSpectatorIdCard() {
        return secondSpectatorIdCard;
    }

    public void setSecondSpectatorIdCard(DocumentRequired secondSpectatorIdCard) {
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

    public void seteCertificateOfBirthState(ECertificateOfBirthState eCertificateOfBirthState) {
        this.eCertificateOfBirthState = eCertificateOfBirthState;
    }

    public UserAction getUserAction() {
        return userAction;
    }

    public void setUserAction(UserAction userAction) {
        this.userAction = userAction;
    }
}
