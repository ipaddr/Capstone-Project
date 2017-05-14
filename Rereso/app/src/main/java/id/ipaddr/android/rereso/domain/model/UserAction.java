package id.ipaddr.android.rereso.domain.model;

import java.util.Date;

/**
 * Created by iip on 3/25/17.
 */

public class UserAction {
    private String email;
    private EUserType eUserType;
    private Date actionDate;
    private ECertificateOfBirthState eCertificateOfBirthState;

    public UserAction(){}

    public UserAction(String email, EUserType eUserType, Date actionDate, ECertificateOfBirthState eCertificateOfBirthState) {
        this.email = email;
        this.eUserType = eUserType;
        this.actionDate = actionDate;
        this.eCertificateOfBirthState = eCertificateOfBirthState;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EUserType geteUserType() {
        return eUserType;
    }

    public void seteUserType(EUserType eUserType) {
        this.eUserType = eUserType;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public ECertificateOfBirthState geteCertificateOfBirthState() {
        return eCertificateOfBirthState;
    }

    public void seteCertificateOfBirthState(ECertificateOfBirthState eCertificateOfBirthState) {
        this.eCertificateOfBirthState = eCertificateOfBirthState;
    }
}
