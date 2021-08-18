package com.dinhtrongdat.todolistt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Database db;
    private CustomAdapter adapter;
    private ArrayList<CongViec> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        setWidget();

        db = new Database(MainActivity.this, "congviec.sqlite",null, 1);
        db.QueryData("CREATE TABLE IF NOT EXISTS CongViec (Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV NVARCHAR(200))");

        adapter = new CustomAdapter(MainActivity.this, R.layout.layout_adapter,list);
        adapter.setNotifyOnChange(true);
        listView.setAdapter(adapter);

    }

    private void setWidget(){
        listView = (ListView) findViewById(R.id.list_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                DialogAđd();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogAđd(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_layout);

        EditText edtDialog = (EditText) dialog.findViewById(R.id.dialog_edt);
        Button btnDialog_add = (Button) dialog.findViewById(R.id.dialog_btn_add);
        Button btnDialog_edit = (Button) dialog.findViewById(R.id.dialog_btn_exit);

        String name = edtDialog.getText().toString().trim();

        btnDialog_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.QueryData("INSERT INTO CongViec VALUES (null, '"+ name +"')");

                Cursor cursor = db.GetData("SELECT * FROM CongViec");
                while (cursor.moveToNext()){
                    list.add(new CongViec(cursor.getInt(0),cursor.getString(1)));
                }
            }
        });

        btnDialog_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}