package com.dinhtrongdat.truyencuoi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends Fragment {
    private Context mContext;

    LottieAnimationView splash;
    TextView txtName, txtDes;
    Animation animDes, animLayout, animName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_splash, container, false);
        initUI(rootView);
        return rootView;
    }

    private void initUI(View view) {
        splash = view.findViewById(R.id.splash_main);
        txtName = view.findViewById(R.id.txtName);
        txtDes = view.findViewById(R.id.txt_description);

        animDes = AnimationUtils.loadAnimation(mContext,R.anim.anim_fall_down);
        animName = AnimationUtils.loadAnimation(mContext,R.anim.anim_top);
        animLayout = AnimationUtils.loadAnimation(mContext,R.anim.anim_bot_to_top);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splash.setVisibility(View.VISIBLE);
                splash.setAnimation(animLayout);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtName.setVisibility(View.VISIBLE);
                        txtDes.setVisibility(View.VISIBLE);

                        txtName.setAnimation(animName);
                        txtDes.setAnimation(animDes);
                    }
                },1000);
            }
        },500);

        new Handler().postDelayed(this::gotoM001Screen, 6700);
    }

    private void gotoM001Screen() {
        ((MainActivity) getActivity()).gotoM001Screen();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

}