package id.ipaddr.android.rereso.presentation.view.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by iip on 5/11/17.
 */

public class ReresoRemoteWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        ReresoWidgetDataProvider data = new ReresoWidgetDataProvider(getApplicationContext(), intent);
        return data;
    }
}
