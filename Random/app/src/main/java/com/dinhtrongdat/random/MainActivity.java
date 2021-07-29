package com.dinhtrongdat.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button btnRand;
    EditText min;
    EditText max;
    TextView resutl;
    int minValue, maxValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRand = (Button) findViewById(R.id.btnRand);
        min = (EditText) findViewById(R.id.txtMin);
        max = (EditText) findViewById(R.id.txtMax);
        resutl = (TextView) findViewById(R.id.lbResult);

        btnRand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (min.getText().toString().isEmpty() || max.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Nhập cả 2 ô", Toast.LENGTH_LONG).show();
                }
                else {
                    minValue = Integer.parseInt(min.getText().toString());
                    maxValue = Integer.parseInt(max.getText().toString());

                    Random random = new Random();
                    int randNumber = random.nextInt(maxValue - minValue + 1) + minValue;
                    resutl.setText(String.valueOf(randNumber));
                }
            }
        });
    }
}