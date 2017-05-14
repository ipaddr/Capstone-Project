package id.ipaddr.android.rereso.presentation.view.widget;

import android.graphics.Bitmap;

/**
 * Created by iip on 5/11/17.
 */

public class WidgetItem {

    private Bitmap bitmap;
    private String fatherName;
    private String babyName;
    private String applicationStatus;

    public WidgetItem(Bitmap bitmap, String fatherName, String babyName, String applicationStatus) {
        this.bitmap = bitmap;
        this.fatherName = fatherName;
        this.babyName = babyName;
        this.applicationStatus = applicationStatus;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
