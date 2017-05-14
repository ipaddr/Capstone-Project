package id.ipaddr.android.rereso.presentation.view.fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import id.ipaddr.android.rereso.presentation.internal.di.HasComponent;

/**
 * Created by iip on 3/21/17.
 */

public abstract class BaseFragment extends Fragment {

    /**
     * Show a {@link Toast} message
     *
     * @param message An string represent a message to be shown
     */
    protected void showToastMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected <C> C getComponent(Class<C> componentType){
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

}
