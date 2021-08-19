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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        setWidget();
        list = new ArrayList<>();
        adapter = new CustomAdapter(MainActivity.this, R.layout.layout_adapter,list);

        db = new Database(MainActivity.this, "congviec.sqlite",null, 1);
        db.QueryData("CREATE TABLE IF NOT EXISTS CongViec (Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV NVARCHAR(200))");

//        db.QueryData("INSERT INTO CongViec VALUES(null, 'Android self Study')");
//        db.QueryData("DELETE FROM CongViec");

        list.clear();
        Cursor cursor = db.GetData("SELECT * FROM CongViec");
        while (cursor.moveToNext()){
            list.add(new CongViec(cursor.getInt(0),cursor.getString(1)));
        }

        adapter.notifyDataSetChanged();
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


        btnDialog_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtDialog.getText().equals("")){
                    Toast.makeText(MainActivity.this, "Chua dien ten cong viec", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.QueryData("INSERT INTO CongViec VALUES (null, '" + edtDialog.getText() + "')");

                    list.clear();
                    Cursor cursor = db.GetData("SELECT * FROM CongViec");
                    while (cursor.moveToNext()){
                        list.add(new CongViec(cursor.getInt(0),cursor.getString(1)));
                    }

                    adapter.notifyDataSetChanged();

                    Toast.makeText(MainActivity.this, "Success!!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
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

    public void DialogEdit(String ten,final int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_edit);

        EditText edt_edit = (EditText) dialog.findViewById(R.id.dialog_edt_edit);
        Button btnOk = (Button) dialog.findViewById(R.id.dialog_btn_ok);
        Button btnClose = (Button) dialog.findViewById(R.id.dialog_btn_close);

        edt_edit.setText(ten);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.QueryData("UPDATE CongViec SET TenCV ='"+ edt_edit.getText()+"' WHERE Id = '"+id+"'");
                list.clear();
                Cursor cursor = db.GetData("SELECT * FROM CongViec");
                while (cursor.moveToNext()){
                    list.add(new CongViec(cursor.getInt(0),cursor.getString(1)));
                }

                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });


        dialog.show();
    }

    public void DeleteQuery(String ten, final int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_delete);

        Button btn_OK = (Button) dialog.findViewById(R.id.dialog_delete_ok);
        Button btn_Exit = (Button) dialog.findViewById(R.id.dialog_delete_exit);
        TextView txtView = (TextView) dialog.findViewById(R.id.txt_delete);

        txtView.setText("Bạn có muốn xóa công việc "+ ten+" không?");

        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.QueryData("DELETE FROM CongViec WHERE Id ='"+ id +"' ");

                list.clear();
                Cursor cursor = db.GetData("SELECT * FROM CongViec");
                while (cursor.moveToNext()){
                    list.add(new CongViec(cursor.getInt(0),cursor.getString(1)));
                }

                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        btn_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}