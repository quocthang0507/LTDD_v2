package com.dinhtrongdat.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtX, edtY;
    TextView txtResult;
    Button btnPlus, btnSub, btnMul, btnDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        edtX = (EditText) findViewById(R.id.edtX);
        edtY = (EditText) findViewById(R.id.edtY);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnSub = (Button) findViewById(R.id.btnTru);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDev = (Button) findViewById(R.id.btnDev);

            btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int x = Integer.parseInt(edtX.getText().toString());
                    int y = Integer.parseInt(edtY.getText().toString());
                    int result = x + y;
                    txtResult.setText(String.valueOf(result));
                }

            });

            btnSub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int x = Integer.parseInt(edtX.getText().toString());
                    int y = Integer.parseInt(edtY.getText().toString());
                    int result = x - y;
                    txtResult.setText(String.valueOf(result));
                }
            });

            btnMul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int x = Integer.parseInt(edtX.getText().toString());
                    int y = Integer.parseInt(edtY.getText().toString());
                    int result = x * y;
                    txtResult.setText(String.valueOf(result));
                }
            });

            btnDev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int x = Integer.parseInt(edtX.getText().toString());
                    int y = Integer.parseInt(edtY.getText().toString());
                    int result = x / y;
                    txtResult.setText(String.valueOf(result));
                }
            });
    }


}