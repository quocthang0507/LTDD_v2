package com.dinhtrongdat.danhbadienthoai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<contast> list;
    private CustomAdapter adapter;
    private EditText txtName;
    private EditText txtNum;
    private RadioButton btngrFamily;
    private RadioButton btngrFriend;
    private RadioButton btngrCompany;
    private RadioButton btngrSchool;
    private ListView listView;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidget();
        list = new ArrayList<>();
        adapter = new CustomAdapter(MainActivity.this, R.layout.custom_adapter, list);
        listView.setAdapter(adapter);
        checkAndRequesPermissions();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ShowDialog(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rela = "Gia đình";
                String name = txtName.getText().toString().trim();
                String num = txtNum.getText().toString().trim();
                if(btngrFamily.isChecked()){
                    rela = btngrFamily.getText().toString().trim();
                }
                else if(btngrFriend.isChecked()){
                    rela = btngrFriend.getText().toString().trim();
                }
                else if(btngrCompany.isChecked()){
                    rela = btngrCompany.getText().toString().trim();
                }
                else if(btngrSchool.isChecked()){
                    rela = btngrSchool.getText().toString().trim();
                }

                if(name.equals("") || num.equals("")){
                    Toast.makeText(MainActivity.this,"Xin mời nhập đầy đủ số điện thoại và tên", Toast.LENGTH_LONG).show();
                }
                else{
                    contast con = new contast(name,num,rela);
                    list.add(con);

                }
                adapter.notifyDataSetChanged();
            }
        });


    }

    public void setWidget(){
        txtName = (EditText) findViewById(R.id.txt_name);
        txtNum = (EditText) findViewById(R.id.txt_sdt);
        btngrFamily = (RadioButton) findViewById(R.id.btngr_fm);
        btngrFriend = (RadioButton) findViewById(R.id.btngr_bb);
        btngrCompany = (RadioButton) findViewById(R.id.btngt_cq);
        btngrSchool = (RadioButton) findViewById(R.id.btngr_th);
        listView = (ListView) findViewById(R.id.lv_contast);
        btnAdd = (Button) findViewById(R.id.btn_add);
    }

    public void ShowDialog(int position){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_view);

        ImageButton btnCall = (ImageButton) dialog.findViewById(R.id.btn_call);
        ImageButton btnMess = (ImageButton) dialog.findViewById(R.id.btn_mess);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCall(position);
            }
        });

        btnMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentSendMessage(position);
            }
        });

        dialog.show();
    }

    private void checkAndRequesPermissions(){
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS
        };

        List<String> listPermissionNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionNeeded.add(permission);
            }
        }
        if(!listPermissionNeeded.isEmpty()){
            ActivityCompat.requestPermissions(this, listPermissionNeeded.toArray(new String[listPermissionNeeded.size()]),1);

        }
    }

    private void intentCall(int posiotion){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+list.get(posiotion).getmNumPhone()));
        startActivity(intent);
    }

    private void intentSendMessage(int posiotion){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:"+list.get(posiotion).getmNumPhone()));
        startActivity(intent);
    }

}