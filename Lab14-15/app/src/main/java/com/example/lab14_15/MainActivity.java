package com.example.lab14_15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lab14_15.db.SQLiteHelper;
import com.example.lab14_15.fragment.M000LoginFragment;
import com.example.lab14_15.fragment.M000RegisterFragment;

public class MainActivity extends AppCompatActivity {
    SQLiteHelper helper;
    public static final String SAVE_PREF = "save_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialDB();

        gotoLoginScreen();

    }

    public void gotoRegisterScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_main, new M000RegisterFragment()).commit();
    }

    public void gotoLoginScreen() {
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_main, new M000LoginFragment()).commit();
    }

    private void InitialDB(){
        helper = new SQLiteHelper(this);
        helper.openDB();
        helper.createTable();
    }
}