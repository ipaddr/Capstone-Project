package id.ipaddr.android.rereso.presentation.view.activity;

import android.os.Bundle;

/**
 * Created by iip on 5/11/17.
 */

public interface OnAuthCallback {
    void onAuth(Bundle savedInstanceState);
    void onNotAuth();
}
