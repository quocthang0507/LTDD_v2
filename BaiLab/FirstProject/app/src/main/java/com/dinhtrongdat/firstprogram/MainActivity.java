package com.dinhtrongdat.firstprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtX, edtY;
    TextView txtResult;
    Button btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }

    private void initControl(){
        edtX = (EditText) findViewById(R.id.edtX);
        edtY = (EditText) findViewById(R.id.edtY);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnPlus = (Button) findViewById(R.id.btnPlus);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                int result = x + y;
                txtResult.setText(String.valueOf(result));
            }
        });
    }
}