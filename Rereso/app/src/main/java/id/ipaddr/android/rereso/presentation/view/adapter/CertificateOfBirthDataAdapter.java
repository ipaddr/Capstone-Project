package id.ipaddr.android.rereso.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.domain.model.Baby;
import id.ipaddr.android.rereso.domain.model.CertificateOfBirthForm;
import id.ipaddr.android.rereso.domain.model.Citizen;
import id.ipaddr.android.rereso.domain.model.DocumentRequired;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;

/**
 * Created by iip on 3/23/17.
 */

public class CertificateOfBirthDataAdapter
        extends RecyclerView.Adapter<CertificateOfBirthDataAdapter.CertificateOfBirthDataViewHolder> {

    public interface OnItemClickListener{
        void onCertificateOfBirthDataItemClicked(CertificateOfBirthDataModel certificateOfBirthDataModel);
    }

    private List<CertificateOfBirthDataModel> mCertificateOfBirthDataModelCollections;
    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    @Inject CertificateOfBirthDataAdapter(Context context){
        mContext = context;
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCertificateOfBirthDataModelCollections = Collections.emptyList();
    }

    @Override
    public CertificateOfBirthDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = mLayoutInflater.inflate(R.layout.row_certificateofbirthdatalist, parent, false);
        return new CertificateOfBirthDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CertificateOfBirthDataViewHolder holder, int position) {
        final CertificateOfBirthDataModel model = mCertificateOfBirthDataModelCollections.get(position);
        final CertificateOfBirthForm form = model.certificateOfBirthForm;
        final Citizen father = form.getFather();
        final Baby baby = form.getBaby();

        final DocumentRequired dc = model.imgOfCertificateOfBirthForm;
        if (dc != null && dc.getDocumentImageBase64() != null) {
            byte[] imageByteArray = Base64.decode(dc.getDocumentImageBase64(), Base64.DEFAULT);
            Glide.with(mContext)
                    .load(imageByteArray)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .crossFade()
                    .into(holder.pIv);
        }

        if (father != null) holder.kkTv.setText(father.getFullName());
        if (baby != null) holder.babyNameTv.setText(baby.getName());
        if (model != null && model.eCertificateOfBirthState != null) holder.statusTv.setText(model.eCertificateOfBirthState.toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onCertificateOfBirthDataItemClicked(model);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCertificateOfBirthDataModelCollections != null ? mCertificateOfBirthDataModelCollections.size():0;
    }

    static class CertificateOfBirthDataViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.avatar)ImageView pIv;
        @BindView(R.id.kk) TextView kkTv;
        @BindView(R.id.baby_name) TextView babyNameTv;
        @BindView(R.id.status) TextView statusTv;

        CertificateOfBirthDataViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setCertificateOfBirthDataCollection(Collection<CertificateOfBirthDataModel> certificateOfBirthDataModelCollection) {
        this.validateCertificateOfBirthDataCollection(certificateOfBirthDataModelCollection);
        this.mCertificateOfBirthDataModelCollections = (List<CertificateOfBirthDataModel>) certificateOfBirthDataModelCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private void validateCertificateOfBirthDataCollection(Collection<CertificateOfBirthDataModel> certificateOfBirthDataModels){
        if (certificateOfBirthDataModels == null){
            throw new IllegalArgumentException("The list cannot be null");
        }
    }
}
