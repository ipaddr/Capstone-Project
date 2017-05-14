package id.ipaddr.android.rereso.domain.model;

/**
 * Created by iip on 3/16/17.
 */

public class Address {

    private String streetDetail;
    private String village;
    private String subDistrict;
    private String district;
    private String state;
    private String postalCode;

    public Address(){}

    public Address(String streetDetail, String village, String subDistrict, String district, String state, String postalCode) {
        this.streetDetail = streetDetail;
        this.village = village;
        this.subDistrict = subDistrict;
        this.district = district;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String getStreetDetail() {
        return streetDetail;
    }

    public void setStreetDetail(String streetDetail) {
        this.streetDetail = streetDetail;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
