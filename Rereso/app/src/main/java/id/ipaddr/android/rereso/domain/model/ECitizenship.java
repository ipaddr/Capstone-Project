package id.ipaddr.android.rereso.domain.model;

/**
 * Created by iip on 3/16/17.
 */

public enum ECitizenship {

    Native(0), NonNative(1), Unknow(-1);

    private int mId;

    ECitizenship(int id){
        mId = id;
    }

    public static ECitizenship fromId(int id){
        switch (id){
            case 0: return Native;
            case 1: return NonNative;
            default: return Unknow;
        }
    }

}
