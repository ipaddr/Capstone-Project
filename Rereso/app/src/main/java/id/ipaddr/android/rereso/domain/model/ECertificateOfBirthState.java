package id.ipaddr.android.rereso.domain.model;

/**
 * Created by iip on 3/16/17.
 */

public enum ECertificateOfBirthState {

    Submited(0),
    DeclineByVillageOffice(1), ApproveByVillageOffice(2),
    DeclineBySubDistrictOfficer(3), ApproveBySubDistrictOfficer(4),
    DeclineByDistrictOfficer(5), ApproveByDistrictOfficer(6),
    PrintingByDistrictOfficer(7), ApproveToPickUpByDistrictOfficer(8),
    Unknow(-1);

    private int mId;

    ECertificateOfBirthState(int id){
        mId = id;
    }

    public ECertificateOfBirthState fromId(int id){
        switch (id){
            case 0: return Submited;
            case 1: return DeclineByVillageOffice;
            case 2: return ApproveByVillageOffice;
            case 3: return DeclineBySubDistrictOfficer;
            case 4: return ApproveBySubDistrictOfficer;
            case 5: return DeclineByDistrictOfficer;
            case 6: return ApproveByDistrictOfficer;
            case 7: return PrintingByDistrictOfficer;
            case 8: return ApproveToPickUpByDistrictOfficer;
            default: return Unknow;
        }
    }

}
