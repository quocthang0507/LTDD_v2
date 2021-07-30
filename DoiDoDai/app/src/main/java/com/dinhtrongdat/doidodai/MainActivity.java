package com.dinhtrongdat.doidodai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] units = {
            "Hải lý", "Dặm", "Kilometer", "Lý","Met", "Yard", "Foot", "Inches"
    };

    private double[][] ratio = {
            {1, 1.5077945, 1.8520000, 20.2537183, 1852.0000, 2025.37183, 6076.11549, 72913.38583},
            {0.06897624, 1, 1.6093440, 17.6000000, 1609.3440, 1760.00000, 5280.00000, 63360.00000},
            {0.53995680, 0.62137119, 1, 10.9361330, 1000.0000, 1093.61330, 3280.83990, 39370.07874},
            {0.04937365, 0.05681818, 0.0914400, 1, 91.4400, 100.00000, 300.00000, 3600.00000},
            {0.00053996, 0.00062137, 0.0010000, 0.0109361, 1.0000, 1.09361, 3.28084, 39.37008},
            {0.00049374, 0.00056818, 0.0009144, 0.0100000, 0.9144, 1.00000, 3, 36},
            {0.00016458, 0.00018939, 0.0003048, 0.0033333, 0.3048, 0.33333, 1, 12},
            {0.00001371, 0.00001578, 0.0000254, 0.0002778, 0.0254, 0.02778, 0.08333, 1}
    };

    EditText txtInput;
    Spinner spn;
    TextView[] lbResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = (EditText) findViewById(R.id.txtInput);
        spn = (Spinner) findViewById(R.id.spn);
        lbResult = new TextView[] {
                (TextView)findViewById(R.id.lbHaily),
                (TextView)findViewById(R.id.lbDam),
                (TextView)findViewById(R.id.lbKilomet),
                (TextView)findViewById(R.id.lbLy),
                (TextView)findViewById(R.id.lbMet),
                (TextView)findViewById(R.id.lbYard),
                (TextView)findViewById(R.id.lbFood),
                (TextView)findViewById(R.id.lbInches)
        };

        // Dua du lieu vao Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, units);

        // Thiet lap cach hien thi cua spiner
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        // Gan adapter vao Spinner
        spn.setAdapter(adapter);

        // Event
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                changeLenght();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        txtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                changeLenght();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    //Doi do dai
    private void changeLenght(){
        int rowIndex = spn.getSelectedItemPosition();
        if(rowIndex < 0)
            rowIndex = 0;

        String input = txtInput.getText().toString();
        if (input.isEmpty())
            input = "0";

        double number = Double.valueOf(input);

        for(int i =0; i< lbResult.length; i++){
            double temp = number * ratio[rowIndex][i];
            lbResult[i].setText(String.valueOf(temp));
        }
    }


}