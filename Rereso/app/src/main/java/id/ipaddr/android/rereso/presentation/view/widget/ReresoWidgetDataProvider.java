package id.ipaddr.android.rereso.presentation.view.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.data.entity.CertificateOfBirthDataEntity;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthData;
import id.ipaddr.android.rereso.domain.model.ECertificateOfBirthState;
import id.ipaddr.android.rereso.util.ImageUtil;

/**
 * Created by iip on 5/11/17.
 */

public class ReresoWidgetDataProvider implements RemoteViewsService.RemoteViewsFactory {

    private static final String TAG = ReresoWidgetDataProvider.class.getSimpleName();

    private Context mContext;
    private List<WidgetItem> mCollection = new ArrayList();

    public ReresoWidgetDataProvider(Context context, Intent intent){
        this.mContext = context;
    }

    private void initData(){
        mCollection.clear();
        DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference(CertificateOfBirthData.class.getSimpleName());
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mCollection.clear();
                Log.d(TAG, "onDataChange");
                Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                while (iterator.hasNext()){
                    DataSnapshot ds = iterator.next();
                    String id = ds.getKey();
                    CertificateOfBirthDataEntity entity = ds.getValue(CertificateOfBirthDataEntity.class);
                    entity.setId(id);
                    String base64Image = entity.getImgOfCertificateOfBirthForm().getDocumentImageBase64();
                    Bitmap bitmap = ImageUtil.fromStringBase64toBitmap(base64Image);
                    String fatherName = entity.getCertificateOfBirthForm().getFather().getFullName();
                    String babyName = entity.getCertificateOfBirthForm().getBaby().getName();
                    String status = entity.geteCertificateOfBirthState() == null ? ECertificateOfBirthState.Unknow.toString():entity.geteCertificateOfBirthState().toString();
                    WidgetItem widgetItem = new WidgetItem(bitmap, fatherName, babyName, status);
                    mCollection.add(widgetItem);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled");
            }
        });
    }

    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
        initData();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
    }

    @Override
    public int getCount() {
        return mCollection.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        WidgetItem wi = mCollection.get(position);

        RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.row_widget);
        views.setImageViewBitmap(R.id.avatar, wi.getBitmap());
        views.setTextViewText(R.id.father_name, wi.getFatherName());
        views.setTextViewText(R.id.baby_name, wi.getBabyName());
        views.setTextViewText(R.id.status, wi.getApplicationStatus());
        views.setTextColor(R.id.father_name, Color.WHITE);
        views.setTextColor(R.id.baby_name, Color.WHITE);
        views.setTextColor(R.id.status, Color.WHITE);
        return views;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
