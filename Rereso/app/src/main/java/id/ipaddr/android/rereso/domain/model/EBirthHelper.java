package id.ipaddr.android.rereso.domain.model;

/**
 * Created by iip on 3/16/17.
 */

public enum EBirthHelper {

    Dokter(0), Bidan_Perawat(1), Dukun(2), Lainnnya(3);

    private int mId;

    EBirthHelper(int id){
        mId=id;
    }

    public static EBirthHelper fromId(int id){
        switch (id){
            case 0: return Dokter;
            case 1: return Bidan_Perawat;
            case 2: return Dukun;
            default:return Lainnnya;
        }
    }

}
