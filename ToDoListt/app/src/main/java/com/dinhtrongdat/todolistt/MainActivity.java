package com.dinhtrongdat.todolistt;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
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

        db.QueryData("INSERT INTO CongViec VALUES (null, 'Android self study')");

        Cursor cursor = db.GetData("SELECT * FROM CongViec");
        while (cursor.moveToNext()){
            list.add(new CongViec(cursor.getInt(0),cursor.getString(1)));
        }

        adapter = new CustomAdapter(MainActivity.this, R.layout.layout_adapter, list);
        adapter.setNotifyOnChange(true);
        listView.setAdapter(adapter);



    }

    private void setWidget(){
        listView = (ListView) findViewById(R.id.list_view);
    }
}