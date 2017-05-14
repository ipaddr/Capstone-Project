package id.ipaddr.android.rereso.domain.model;

/**
 * Created by iip on 3/16/17.
 */

public enum EPlaceOfBirth {

    RS_RB(0), Puskesmas(1), Polindes(2), Rumah(3), Lainnya(4);

    private int mId;
    EPlaceOfBirth(int id){
        mId = id;
    }

    public static EPlaceOfBirth fromId(int id){
        switch (id){
            case 0:
                return EPlaceOfBirth.RS_RB;
            case 1:
                return EPlaceOfBirth.Puskesmas;
            case 2:
                return EPlaceOfBirth.Polindes;
            case 3:
                return EPlaceOfBirth.Rumah;
            default:
                return EPlaceOfBirth.Lainnya;
        }
    }

}
