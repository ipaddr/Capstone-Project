package id.ipaddr.android.rereso.presentation;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.ipaddr.android.rereso.domain.executor.PostExecutionThread;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by iip on 3/19/17.
 *
 * MainThread (UI Thread) implementation based on a {@link Scheduler}
 * which will execute actions on the Android UI thread
 */

@Singleton
public class UiThread implements PostExecutionThread{

    @Inject UiThread(){}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
