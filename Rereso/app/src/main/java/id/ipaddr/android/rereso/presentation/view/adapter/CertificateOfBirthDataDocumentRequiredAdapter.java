package id.ipaddr.android.rereso.presentation.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.design.widget.CheckableImageButton;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ipaddr.android.rereso.R;
import id.ipaddr.android.rereso.domain.model.DocumentRequired;
import id.ipaddr.android.rereso.presentation.model.CertificateOfBirthDataModel;
import id.ipaddr.android.rereso.util.ImageUtil;

/**
 * Created by iip on 3/26/17.
 *
 * Adaptar that manages a collection of {@link CertificateOfBirthDataModel}.
 */
public class CertificateOfBirthDataDocumentRequiredAdapter extends RecyclerView.Adapter<CertificateOfBirthDataDocumentRequiredAdapter.UserViewHolder> {

    private static final String TAG = CertificateOfBirthDataDocumentRequiredAdapter.class.getSimpleName();

    public interface OnItemClickListener {
        void onCloseDocumentItemClicked(int position);
        void onDocumentRequiredItemClicked(int position);
    }

    private List<DocumentRequired> mDocumentRequiredsCollection;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    @Inject
    public CertificateOfBirthDataDocumentRequiredAdapter(Context context) {
        this.mContext = context;
        if (mDocumentRequiredsCollection == null)
            this.mDocumentRequiredsCollection = Collections.emptyList();
    }

    public DocumentRequired getDocumentRequired(int position){
        return mDocumentRequiredsCollection.get(position);
    }

    public void setDocumentRequired(int position, DocumentRequired documentRequired){
        mDocumentRequiredsCollection.set(position, documentRequired);
        notifyDataSetChanged();
    }

    @Override public int getItemCount() {
        return (this.mDocumentRequiredsCollection != null) ? this.mDocumentRequiredsCollection.size() : 0;
    }

    @Override public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.row_certificateofbirthdatadetail, parent, false);
        return new UserViewHolder(view);
    }

    @Override public void onBindViewHolder(UserViewHolder holder, final int position) {
        final DocumentRequired documentRequiredModel = this.mDocumentRequiredsCollection.get(position);
        holder.docTitle.setText(documentRequiredModel.getDocumentTitle());

        byte[] data = documentRequiredModel.getDatas();

        Glide.with(mContext)
                .load(data)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.docImageView);

        if (data != null){
            showIconToDeleteImage(holder, position);
        } else {
            holder.docClickableImageButton.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onDocumentRequiredItemClicked(position);
                }
            }
        });
    }

    private void showIconToDeleteImage(UserViewHolder holder, int position){
        holder.docClickableImageButton.setVisibility(View.VISIBLE);
        holder.docClickableImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onCloseDocumentItemClicked(position);
                    Log.d(TAG, "onClick 1");
                }
            }
        });
    }

    @Override public long getItemId(int position) {
        return position;
    }

    public void setDocumentRequiredCollection(Collection<DocumentRequired> documentRequiredCollection) {
        this.validateUsersCollection(documentRequiredCollection);
        this.mDocumentRequiredsCollection = (List<DocumentRequired>) documentRequiredCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    private void validateUsersCollection(Collection<DocumentRequired> documentRequiredCollection) {
        if (documentRequiredCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.doc_title)
        AppCompatTextView docTitle;
        @BindView(R.id.doc_image_view)
        ImageView docImageView;
        @BindView(R.id.doc_clickable_image_button)
        CheckableImageButton docClickableImageButton;

        UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
