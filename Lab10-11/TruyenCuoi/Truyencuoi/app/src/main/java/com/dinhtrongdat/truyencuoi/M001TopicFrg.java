package com.dinhtrongdat.truyencuoi;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;


public class M001TopicFrg extends Fragment implements View.OnClickListener {

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m001_frg_topic, container, false);
        initUI(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initUI(View view) {
        LinearLayout lnMain = view.findViewById(R.id.ln_Topic);
        lnMain.removeAllViews();
        try{
            String[] listItem = mContext.getAssets().list("photo");
            for(String fileName : listItem){
                String name = fileName.substring(0, fileName.indexOf("."));
                View vTopic = LayoutInflater.from(mContext).inflate(R.layout.item_topic, null);

                ImageView ivTopic = vTopic.findViewById(R.id.iv_topic);
                TextView tvTopic = vTopic.findViewById(R.id.tv_topic);

                ivTopic.setImageBitmap(BitmapFactory.decodeStream(mContext.getAssets().open("photo/" + fileName)));
                tvTopic.setText(name);
                lnMain.addView(vTopic);

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) vTopic.getLayoutParams();
                params.bottomMargin = 40;
                vTopic.setLayoutParams(params);
                vTopic.setTag(name);
                vTopic.setOnClickListener(this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        ((MainActivity) getActivity()).gotoM002Screen((String)view.getTag());
    }
}
