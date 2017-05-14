package id.ipaddr.android.rereso.domain.model;

/**
 * Created by iip on 4/29/17.
 */

public enum EDocumentRequired {
    al_a(0), al_i(1), form(2), kk(3), ktp_a(4), ktp_i(5), ktp_s1(6), ktp_s2(7), kua(8)
    , pass_a(9), pass_i(10), sk_rs(11), sk_rt_rw(12), sk_kua(13), sk_pol(14), sk_sos(15), unknow(-1);

    private int mId;

    EDocumentRequired(int id){
        mId = id;
    }

    public EDocumentRequired fromId(int id){
        switch (id){
            case 0: return al_a;
            case 1: return al_i;
            case 2: return form;
            case 3: return kk;
            case 4: return ktp_a;
            case 5: return ktp_i;
            case 6: return ktp_s1;
            case 7: return ktp_s2;
            case 8: return kua;
            case 9: return pass_a;
            case 10: return pass_i;
            case 11: return sk_rs;
            case 12: return sk_rt_rw;
            case 13: return sk_kua;
            case 14: return sk_pol;
            case 15: return sk_sos;
            case -1:
            default: return unknow;
        }
    }
}
