package id.ipaddr.android.rereso.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ipaddr.android.rereso.R;

/**
 * Created by iip on 6/21/17.
 */

public class ImageViewActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imageview);
        ButterKnife.bind(this);

        if (getIntent() != null){
            Intent intent = getIntent();
            String uri = intent.getStringExtra("uri");
            if (uri != null){
                Glide.with(this).load(uri).placeholder(R.mipmap.ic_launcher).into(iv);
            }
        }

    }
}
