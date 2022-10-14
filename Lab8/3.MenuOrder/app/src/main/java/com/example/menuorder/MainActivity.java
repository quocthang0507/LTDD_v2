package com.example.menuorder;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvFood;
    ArrayList<Food> arrFood;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFood = (ListView) findViewById(R.id.listView);
        arrFood = new ArrayList<>();

        arrFood.add(new Food("Fried fish ball", "Cá viên chiên", 12.000,R.drawable.cavien));
        arrFood.add(new Food("Fruit tea", "Chè trái cây", 20.000,R.drawable.chetraincay));
        arrFood.add(new Food("Hamburgers", "Bánh mì kẹp thịt", 15.000,R.drawable.humberger));
        arrFood.add(new Food("Beef hotpot", "Lẩu bò", 100.000,R.drawable.laubo));
        arrFood.add(new Food("Instant noodle", "Mì tôm", 7.000,R.drawable.mitom));
        arrFood.add(new Food("Dog meat", "Thịt chó", 200.000,R.drawable.thitcho));
        arrFood.add(new Food("Grilled pork", "Thịt heo nướng", 100.000,R.drawable.thitnuong));

        adapter = new CustomListAdapter(arrFood, R.layout.menu_order, this);
        adapter.notifyDataSetChanged();
        lvFood.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_order, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuAdd:
                DialogAdd();
                break;
            case R.id.menuExit:
                Toast.makeText(this,"Nhấn nút Home để thoát", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogAdd(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add);

        EditText dienTen = (EditText) dialog.findViewById(R.id.txtNhapTen1);
        EditText dienTen2 = (EditText) dialog.findViewById(R.id.txtNhapTen2);
        EditText gia = (EditText) dialog.findViewById(R.id.txtGia);
        Button btnAdd = (Button) dialog.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = dienTen.getText().toString().trim();
                String name2 = dienTen2.getText().toString().trim();
                double price = Double.parseDouble(gia.getText().toString().trim());
                arrFood.add(new Food(name1,name2,price,R.drawable.food));
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Thêm thành công", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}