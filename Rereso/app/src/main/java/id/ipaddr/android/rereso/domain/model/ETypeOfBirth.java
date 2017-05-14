package id.ipaddr.android.rereso.domain.model;

/**
 * Created by iip on 3/16/17.
 */

public enum ETypeOfBirth {

    Tunggal(0), Kembar_2(1), Kembar_3(2),Kembar_4(3), Lainnya(5);

    private int mId;

    ETypeOfBirth(int id){
        mId = id;
    }

    public static ETypeOfBirth fromId(int id){
        switch (id){
            case 0: return Tunggal;
            case 1: return Kembar_2;
            case 2: return Kembar_3;
            case 3: return Kembar_4;
            default: return Lainnya;
        }
    }

}
