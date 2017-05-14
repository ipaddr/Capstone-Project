package id.ipaddr.android.rereso.domain.model;

import android.graphics.Bitmap;

/**
 * Created by iip on 3/16/17.
 */

public class CertificateOfBirthForm {

    private String patriarch;
    private String familyCardNumber;
    private Baby baby;
    private Citizen mother;
    private Citizen father;
    private Citizen rapporteur;
    private Citizen firstSpectator;
    private Citizen secondSpectator;
    private String rapporteurSignature;
    private String firstSpectatorSignature;
    private String secondSpectatorSignature;

    public CertificateOfBirthForm(){}

    public CertificateOfBirthForm(String patriarch, String familyCardNumber, Baby baby, Citizen mother, Citizen father, Citizen rapporteur, Citizen firstSpectator, Citizen secondSpectator, String rapporteurSignature, String firstSpectatorSignature, String secondSpectatorSignature) {
        this.patriarch = patriarch;
        this.familyCardNumber = familyCardNumber;
        this.baby = baby;
        this.mother = mother;
        this.father = father;
        this.rapporteur = rapporteur;
        this.firstSpectator = firstSpectator;
        this.secondSpectator = secondSpectator;
        this.rapporteurSignature = rapporteurSignature;
        this.firstSpectatorSignature = firstSpectatorSignature;
        this.secondSpectatorSignature = secondSpectatorSignature;
    }

    public String getPatriarch() {
        return patriarch;
    }

    public void setPatriarch(String patriarch) {
        this.patriarch = patriarch;
    }

    public String getFamilyCardNumber() {
        return familyCardNumber;
    }

    public void setFamilyCardNumber(String familyCardNumber) {
        this.familyCardNumber = familyCardNumber;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public Citizen getMother() {
        return mother;
    }

    public void setMother(Citizen mother) {
        this.mother = mother;
    }

    public Citizen getFather() {
        return father;
    }

    public void setFather(Citizen father) {
        this.father = father;
    }

    public Citizen getRapporteur() {
        return rapporteur;
    }

    public void setRapporteur(Citizen rapporteur) {
        this.rapporteur = rapporteur;
    }

    public Citizen getFirstSpectator() {
        return firstSpectator;
    }

    public void setFirstSpectator(Citizen firstSpectator) {
        this.firstSpectator = firstSpectator;
    }

    public Citizen getSecondSpectator() {
        return secondSpectator;
    }

    public void setSecondSpectator(Citizen secondSpectator) {
        this.secondSpectator = secondSpectator;
    }

    public String getRapporteurSignature() {
        return rapporteurSignature;
    }

    public void setRapporteurSignature(String rapporteurSignature) {
        this.rapporteurSignature = rapporteurSignature;
    }

    public String getFirstSpectatorSignature() {
        return firstSpectatorSignature;
    }

    public void setFirstSpectatorSignature(String firstSpectatorSignature) {
        this.firstSpectatorSignature = firstSpectatorSignature;
    }

    public String getSecondSpectatorSignature() {
        return secondSpectatorSignature;
    }

    public void setSecondSpectatorSignature(String secondSpectatorSignature) {
        this.secondSpectatorSignature = secondSpectatorSignature;
    }
}
