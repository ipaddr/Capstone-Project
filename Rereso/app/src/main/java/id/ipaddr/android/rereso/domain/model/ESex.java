package id.ipaddr.android.rereso.domain.model;

/**
 * Created by iip on 3/16/17.
 */

public enum ESex {
    Female(0), Male(1), Unknow(-1);

    private int mId;

    ESex(int id){
        mId = id;
    }

    public static ESex fromId(int id){
        switch (id){
            case 0:
                return ESex.Female;
            case 1:
                return ESex.Male;
            default:
                return ESex.Unknow;
        }
    }
}
