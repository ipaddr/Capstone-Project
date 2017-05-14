package id.ipaddr.android.rereso.domain.model;

import java.util.Date;

/**
 * Created by iip on 3/16/17.
 */

public class Baby {

    private String babyFoto;
    private String name;
    private ESex eSex;
    private EPlaceOfBirth ePlaceOfBirth;
    private String placeOfBirth;
    private Date dateOfBirth;
    private Date timeOfBirth;
    private ETypeOfBirth eTypeOfBirth;
    private int birthSequenceAt;
    private EBirthHelper eBirthHelper;
    private float babyWeight;
    private float babyHeight;

    public Baby(){}

    public Baby(String babyFoto, String name, ESex eSex, EPlaceOfBirth ePlaceOfBirth, String placeOfBirth, Date dateOfBirth, Date timeOfBirth, ETypeOfBirth eTypeOfBirth, int birthSequenceAt, EBirthHelper eBirthHelper, float babyWeight, float babyHeight) {
        this.babyFoto = babyFoto;
        this.name = name;
        this.eSex = eSex;
        this.ePlaceOfBirth = ePlaceOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.timeOfBirth = timeOfBirth;
        this.eTypeOfBirth = eTypeOfBirth;
        this.birthSequenceAt = birthSequenceAt;
        this.eBirthHelper = eBirthHelper;
        this.babyWeight = babyWeight;
        this.babyHeight = babyHeight;
    }

    public Baby(String name, ESex eSex, EPlaceOfBirth ePlaceOfBirth, String placeOfBirth, Date dateOfBirth, Date timeOfBirth, ETypeOfBirth eTypeOfBirth, int birthSequenceAt, EBirthHelper eBirthHelper, float babyWeight, float babyHeight) {
        this.name = name;
        this.eSex = eSex;
        this.ePlaceOfBirth = ePlaceOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.timeOfBirth = timeOfBirth;
        this.eTypeOfBirth = eTypeOfBirth;
        this.birthSequenceAt = birthSequenceAt;
        this.eBirthHelper = eBirthHelper;
        this.babyWeight = babyWeight;
        this.babyHeight = babyHeight;
    }

    public String getBabyFoto() {
        return babyFoto;
    }

    public void setBabyFoto(String babyFoto) {
        this.babyFoto = babyFoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ESex geteSex() {
        return eSex;
    }

    public void seteSex(ESex eSex) {
        this.eSex = eSex;
    }

    public EPlaceOfBirth getePlaceOfBirth() {
        return ePlaceOfBirth;
    }

    public void setePlaceOfBirth(EPlaceOfBirth ePlaceOfBirth) {
        this.ePlaceOfBirth = ePlaceOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getTimeOfBirth() {
        return timeOfBirth;
    }

    public void setTimeOfBirth(Date timeOfBirth) {
        this.timeOfBirth = timeOfBirth;
    }

    public ETypeOfBirth geteTypeOfBirth() {
        return eTypeOfBirth;
    }

    public void seteTypeOfBirth(ETypeOfBirth eTypeOfBirth) {
        this.eTypeOfBirth = eTypeOfBirth;
    }

    public int getBirthSequenceAt() {
        return birthSequenceAt;
    }

    public void setBirthSequenceAt(int birthSequenceAt) {
        this.birthSequenceAt = birthSequenceAt;
    }

    public EBirthHelper geteBirthHelper() {
        return eBirthHelper;
    }

    public void seteBirthHelper(EBirthHelper eBirthHelper) {
        this.eBirthHelper = eBirthHelper;
    }

    public float getBabyWeight() {
        return babyWeight;
    }

    public void setBabyWeight(float babyWeight) {
        this.babyWeight = babyWeight;
    }
}
