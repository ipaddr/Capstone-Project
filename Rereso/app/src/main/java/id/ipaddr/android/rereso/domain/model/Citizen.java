package id.ipaddr.android.rereso.domain.model;

import java.util.Date;

/**
 * Created by iip on 3/16/17.
 */

public class Citizen {

    private String nik;
    private String fullName;
    private ESex eSex;
    private Date birthday;
    private int age;
    private String occupation;
    private Address address;
    private ECitizenship eCitizenship;
    private String nationality;
    private Date maritalDate;

    public Citizen(){}

    public Citizen(String nik, String fullName, Date birthday, int age, String occupation, Address address, ECitizenship eCitizenship, String nationality, Date maritalDate) {
        this.nik = nik;
        this.fullName = fullName;
        this.birthday = birthday;
        this.age = age;
        this.occupation = occupation;
        this.address = address;
        this.eCitizenship = eCitizenship;
        this.nationality = nationality;
        this.maritalDate = maritalDate;
    }

    public Citizen(String nik, String fullName, ESex eSex, Date birthday, int age, String occupation, Address address, ECitizenship eCitizenship, String nationality, Date maritalDate) {
        this.nik = nik;
        this.fullName = fullName;
        this.eSex = eSex;
        this.birthday = birthday;
        this.age = age;
        this.occupation = occupation;
        this.address = address;
        this.eCitizenship = eCitizenship;
        this.nationality = nationality;
        this.maritalDate = maritalDate;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ESex getESex() {
        return eSex;
    }

    public void setESex(ESex eSex) {
        this.eSex = eSex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ECitizenship geteCitizenship() {
        return eCitizenship;
    }

    public void seteCitizenship(ECitizenship eCitizenship) {
        this.eCitizenship = eCitizenship;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getMaritalDate() {
        return maritalDate;
    }

    public void setMaritalDate(Date maritalDate) {
        this.maritalDate = maritalDate;
    }
}
