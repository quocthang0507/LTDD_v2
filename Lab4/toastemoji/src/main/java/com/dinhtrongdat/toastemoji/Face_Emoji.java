package com.dinhtrongdat.toastemoji;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Face_Emoji extends Fragment implements View.OnClickListener {

    private static final int[] ids = {R.id.iv_face1, R.id.iv_face2, R.id.iv_face3, R.id.iv_face4,
            R.id.iv_face5, R.id.iv_face6, R.id.iv_face7, R.id.iv_face8, R.id.iv_face9};
    private Context mContext;
    ImageButton btnRand;
    public static ArrayList<String> arrName;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_face_emoji,container,false);
        initUI(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }
    private void initUI(View v){
        for(int id :ids){
            v.findViewById(id).setOnClickListener(this);
        }

        btnRand = v.findViewById(R.id.btn_refres);
        btnRand.setOnClickListener(this);

        String[] face = getResources().getStringArray(R.array.arr_face);
        arrName = new ArrayList<>(Arrays.asList(face));

    }

    @Override
    public void onClick(View view) {
//        ImageView ivFace = (ImageView) view;
//        showToast(ivFace.getDrawable());
        switch (view.getId()){
            case R.id.btn_refres:
                //Tron mang cac hinh anh
                Collections.shuffle(arrName);
                int idHinh = getResources().getIdentifier(arrName.get(5), "drawable", mContext.getPackageName());
                randToast(idHinh);
                break;
            default:
                ImageView ivFace = (ImageView) view;
                showToast(ivFace.getDrawable());
                break;
        }
    }

    private void showToast(Drawable drawable){
        Toast toast = new Toast(mContext);
        ImageView ivEmoji = new ImageView(mContext);
        ivEmoji.setImageDrawable(drawable);
        toast.setView(ivEmoji);
        toast.show();
    }

    private void randToast(int id){
        Toast toast = new Toast(mContext);
        ImageView ivEmoji = new ImageView(mContext);
        ivEmoji.setImageResource(id);
        toast.setView(ivEmoji);
        toast.show();
    }
}