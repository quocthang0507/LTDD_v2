package com.dinhtrongdat.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivShop;
    private Random rand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }
    private void initUI(){
        ivShop = (ImageView)findViewById(R.id.iv_shoping);
        findViewById(R.id.btn_alpha).setOnClickListener(this);
        findViewById(R.id.bt_rotate).setOnClickListener(this);
        findViewById(R.id.bt_scale).setOnClickListener(this);
        findViewById(R.id.bt_trans).setOnClickListener(this);
        ivShop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_alpha:
                ivShop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha_anim));
                break;
            case R.id.bt_rotate:
                ivShop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation_anim));
                break;
            case R.id.bt_scale:
                ivShop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));
                break;
            case R.id.bt_trans:
                ivShop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate_anim));
                break;
            case R.id.iv_shoping:
                rand = new Random();
                int random = rand.nextInt(4);
//                Toast.makeText(MainActivity.this, String.valueOf(random),Toast.LENGTH_LONG).show();
                switch (random){
                    case 0:
                        ivShop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha_anim));
                        break;
                    case 1:
                        ivShop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation_anim));
                        break;
                    case 2:
                        ivShop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_anim));
                        break;
                    case 3:
                        ivShop.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate_anim));
                        break;
                }
                break;
        }
    }
}