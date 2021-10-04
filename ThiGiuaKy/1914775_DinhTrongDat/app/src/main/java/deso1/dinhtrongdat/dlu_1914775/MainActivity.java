package deso1.dinhtrongdat.dlu_1914775;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtName, edtX, edtY,edtZ;
    Button btnName,btnOK,btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        edtName = findViewById(R.id.edt_hovaten);
        edtX = findViewById(R.id.edt_giatrix);
        edtY = findViewById(R.id.edt_giatriy);
        edtZ = findViewById(R.id.edt_giatriz);

        findViewById(R.id.btnFullName).setOnClickListener(this);
        findViewById(R.id.btnOK).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFullName:
                if(validation()){
                    Toast.makeText(MainActivity.this,edtName.getText().toString(),Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Cảnh báo! Chưa nhập dữ liệu",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnOK:
                Intent intent = new Intent(MainActivity.this, ActTinhToan.class);
                intent.putExtra("HoTen",edtName.getText().toString());
                intent.putExtra("X", edtX.getText().toString());
                intent.putExtra("Y", edtY.getText().toString());
                intent.putExtra("Z", edtZ.getText().toString());

                startActivity(intent);
                break;
            case R.id.btnClear:
                edtName.setText("");
                edtX.setText("");
                edtY.setText("");
                edtZ.setText("");
                break;
        }
    }

    private boolean validation(){
        if(edtName.getText().toString().isEmpty()) return false;
        return true;
    }
}