package id.ipaddr.android.rereso.domain.model;

/**
 * Created by iip on 3/25/17.
 */

public enum EUserType {
    Society(0), VillageOfficer(1), SubDistrictOfficer(2), DistrictOfficer(3), Unknow(-1);

    private int mId;

    EUserType(int id){
        mId = id;
    }

    public EUserType fromId(int id){
        switch (id){
            case 0: return Society;
            case 1: return VillageOfficer;
            case 2: return SubDistrictOfficer;
            case 3: return DistrictOfficer;
            default:return Unknow;
        }
    }
}
