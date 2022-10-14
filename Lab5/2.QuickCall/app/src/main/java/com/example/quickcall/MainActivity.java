package com.example.quickcall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivHotLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_call);
        initUI();
    }

    private void initUI() {
        findViewById(R.id.fr_mom).setOnClickListener(this);
        findViewById(R.id.fr_dad).setOnClickListener(this);
        findViewById(R.id.fr_crush).setOnClickListener(this);
        findViewById(R.id.fr_best_friend).setOnClickListener(this);
        findViewById(R.id.iv_dialer).setOnClickListener(this);
        ivHotLine = findViewById(R.id.iv_hotline);
        ivHotLine.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        view.animate().alpha(0).translationX(80).setDuration(300).start();
        if (view instanceof FrameLayout) {
            processCall((String) view.getTag());
            return;
        }
        gotoDialPad();
    }

    private void gotoDialPad() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void processCall(String phone) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 101);
                }
                Toast.makeText(this, "Hãy thực hiện lại sau khi cấp quyền!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: " + phone));
        startActivity(intent);
    }
}