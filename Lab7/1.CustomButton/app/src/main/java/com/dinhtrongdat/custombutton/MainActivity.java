package com.dinhtrongdat.custombutton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button btnDialog, btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        btnDialog = findViewById(R.id.btn_dialog);
        btnToast = findViewById(R.id.btn_toast);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_dialog);

                TextInputLayout txtUser = (TextInputLayout) dialog.findViewById(R.id.username);
                TextInputLayout txtPass = (TextInputLayout) dialog.findViewById(R.id.password);

                Button btnLogin = (Button) dialog.findViewById(R.id.btnLogin);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast();
            }
        });
    }

    private void showToast(){
        Toast toast = new Toast(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast));
        toast.setView(view);

        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}