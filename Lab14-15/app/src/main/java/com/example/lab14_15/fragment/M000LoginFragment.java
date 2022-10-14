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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab14_15.MainActivity;
import com.example.lab14_15.R;
import com.example.lab14_15.db.SQLiteHelper;

public class M000LoginFragment extends Fragment implements View.OnClickListener {

    private EditText edtEmail,edtPass;
    private Context mContext;
    SQLiteHelper helper;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m000_frg_login, container,false);
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

        rootView.findViewById(R.id.tv_login).setOnClickListener(this);
        rootView.findViewById(R.id.tv_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(mContext, androidx.appcompat.R.anim.abc_fade_in));
        if(v.getId()==R.id.tv_login){
            login(edtEmail.getText().toString(), edtPass.getText().toString());
        }else if(v.getId()==R.id.tv_register){
            gotoRegisterScreen();
        }
    }

    private void gotoRegisterScreen() {
        ((MainActivity) mContext).gotoRegisterScreen();
    }

    private void login(String mail, String pass) {
        if (mail.isEmpty() || pass.isEmpty()) {
            Toast.makeText(mContext, "Empty value", Toast.LENGTH_SHORT).show();
            return;
        }
//        SharedPreferences pref = mContext.getSharedPreferences(MainActivity.SAVE_PREF, Context.MODE_PRIVATE);
//        String savedPass = pref.getString(mail,null);
//        if(savedPass == null){
//            Toast.makeText(mContext, "Email is not existed!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(!pass.equals(savedPass)){
//            Toast.makeText(mContext, "Password is not correct!", Toast.LENGTH_SHORT).show();
//            return;
//        }

        if(helper.login(mail,pass))
            Toast.makeText(mContext, "Login account successfully!", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(mContext, "Wrong email or password", Toast.LENGTH_SHORT).show();
    }
}
