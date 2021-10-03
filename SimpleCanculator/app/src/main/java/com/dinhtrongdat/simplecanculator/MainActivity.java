package com.dinhtrongdat.simplecanculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText result, out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (EditText) findViewById(R.id.txtResult);
        result.setShowSoftInputOnFocus(false);
        out = (EditText) findViewById(R.id.txtOut);

    }
    private void updateTxt(String str){
        String oldStr = result.getText().toString();
        int Posision = result.getSelectionStart();
        String left = oldStr.substring(0, Posision);
        String right = oldStr.substring(Posision);

        result.setText(String.format("%s%s%s", left, str, right));
        result.setSelection(Posision +1);
    }

    public void btnZero(View view){
        updateTxt("0");
    }

    public void btnOne(View view){
        updateTxt("1");
    }

    public void btnTwo(View view){
        updateTxt("2");
    }

    public   void btnThree(View view){
        updateTxt("3");
    }

    public void btnFore(View view){
        updateTxt("4");
    }

    public void btnFive(View view){
        updateTxt("5");
    }

    public void btnSix(View view){
        updateTxt("6");
    }

    public void btnSeven(View view){
        updateTxt("7");
    }

    public void btnEight(View view){
        updateTxt("8");
    }

    public void btnNine(View view){
        updateTxt("9");
    }

    public void btnClear(View view){
        result.setText("");
    }

    public void btnPare(View view){

    }

    public void btnHead(View view){
        updateTxt("^");
    }

    public void btnDev(View view){
        updateTxt("/");
    }

    public void btnMul(View view){
        updateTxt("*");
    }

    public void btnSub(View view){
        updateTxt("-");
    }

    public void btnPlus(View view){
        updateTxt("+");
    }

    public void btnEqual(View view){
        int Position = result.getSelectionStart();
        String input = result.getText().toString();
        if(input.isEmpty())
            result.setText("0");
        else if(input.split("\\*").length == 2){
            String number[] = input.split("\\*");
            try{
               double rs = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
               out.setText(rs +"");
            }
            catch (Exception e){

            }
        }
        else if(input.split("/").length == 2){
            String number[] = input.split("/");
            try{
                double rs = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                out.setText(rs +"");

            }
            catch (Exception e){

            }
        }
        else if(input.split("\\^").length == 2){
            String number[] = input.split("\\^");
            try{
                double rs = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                out.setText(rs +"");
            }
            catch (Exception e){

            }
        }
        else if(input.split("\\+").length == 2){
            String number[] = input.split("\\+");
            try{
                double rs = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                out.setText(rs +"");
            }
            catch (Exception e){

            }
        }
        else if(input.split("-").length == 2){
            String number[] = input.split("-");
            try{
                double rs = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                out.setText(rs +"");
            }
            catch (Exception e){
            }
        }
    }

    public void btnDot(View view){
        updateTxt(".");
    }

    public void btnDelete(View view){
        int Posision = result.getSelectionStart();
        int len = result.getText().length();
        if(Posision != 0 && len != 0){
            SpannableStringBuilder select = (SpannableStringBuilder) result.getText();
            select.replace(Posision - 1, Posision, "");
            result.setText(select);
            result.setSelection(Posision - 1);
        }
    }
}