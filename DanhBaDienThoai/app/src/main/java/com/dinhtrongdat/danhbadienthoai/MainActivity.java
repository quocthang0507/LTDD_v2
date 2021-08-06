package com.dinhtrongdat.danhbadienthoai;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ShowDialog();
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

    public void ShowDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_view);

        ImageButton btnCall = (ImageButton) dialog.findViewById(R.id.btn_call);
        ImageButton btnMess = (ImageButton) dialog.findViewById(R.id.btn_mess);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Call", Toast.LENGTH_LONG).show();
            }
        });

        btnMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Mess", Toast.LENGTH_LONG).show();
            }
        });

        dialog.show();
    }
}