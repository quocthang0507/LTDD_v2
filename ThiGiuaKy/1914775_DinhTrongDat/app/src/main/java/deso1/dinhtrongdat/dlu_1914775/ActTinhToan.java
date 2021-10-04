package deso1.dinhtrongdat.dlu_1914775;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActTinhToan extends AppCompatActivity {

    TextView txtHoTen, txtPlus, txtMul, txtExp;
    Button btnBack;

    int plus, mul, exp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_tinh_toan);

        initUI();
    }

    private void initUI() {
        txtHoTen = findViewById(R.id.txtHoTen);
        txtPlus = findViewById(R.id.txtPlus);
        txtMul = findViewById(R.id.txtMul);
        txtExp = findViewById(R.id.txtExp);
        btnBack = findViewById(R.id.btnBack);

        String name = getIntent().getStringExtra("HoTen");
        int x = Integer.parseInt(getIntent().getStringExtra("X"));
        int y = Integer.parseInt(getIntent().getStringExtra("Y"));
        int z = Integer.parseInt(getIntent().getStringExtra("Z"));

        plus = x + y +z;
        mul = x*y*z;
        exp = x*x +y*y +z*z;

        txtHoTen.setText("Họ và tên" +name);
        txtPlus.setText( "Phép cộng: "+ String.valueOf(plus));
        txtMul.setText("Phéo nhân: " +String.valueOf(mul));
        txtExp.setText("Phép lũy thừa :" +String.valueOf(exp));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(ActTinhToan.this, MainActivity.class)
                );
            }
        });
    }
}