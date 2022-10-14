package com.example.lab14_15.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab14_15.Account;
import com.example.lab14_15.MainActivity;
import com.example.lab14_15.R;
import com.example.lab14_15.db.SQLiteHelper;

public class M000RegisterFragment extends Fragment implements View.OnClickListener {

    private EditText edtEmail, edtPass, edtRepass;
    private Context mContext;
    SQLiteHelper helper;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m000_frg_register, container, false);
        helper = new SQLiteHelper(mContext);
        initView(rootView);

        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;

    }

    private void initView(View rootView) {
        edtEmail = rootView.findViewById(R.id.edt_email);
        edtPass = rootView.findViewById(R.id.edt_pass);
        edtRepass = rootView.findViewById(R.id.edt_re_pass);

        rootView.findViewById(R.id.tv_register).setOnClickListener(this);
        rootView.findViewById(R.id.iv_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(mContext,
                androidx.appcompat.R.anim.abc_fade_in));
        if (v.getId() == R.id.iv_back) {
            gotoLoginScreen();
        } else if (v.getId() == R.id.tv_register) {
            register(edtEmail.getText().toString(), edtPass.getText().toString(), edtRepass.getText().toString());
        }
    }

    private void gotoLoginScreen() {
        ((MainActivity) mContext).gotoLoginScreen();
    }

    private void register(String mail, String pass, String repass) {
        if (mail.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
            Toast.makeText(mContext, "Empty value", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!pass.equals(repass)) {
            Toast.makeText(mContext, "Password is not match", Toast.LENGTH_SHORT).show();
        }
        Account account = new Account(mail, pass);
        helper.insert(account);

//        SharedPreferences pref = mContext.getSharedPreferences(MainActivity.SAVE_PREF,
//                Context.MODE_PRIVATE);
//        String savedPass = pref.getString(mail, null);
//        if (savedPass != null) {
//            Toast.makeText(mContext, "Email is existed!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        pref.edit().putString(mail, pass).apply();
        Toast.makeText(mContext, "Register account successfully!", Toast.LENGTH_SHORT).show();
        gotoLoginScreen();
    }
}
