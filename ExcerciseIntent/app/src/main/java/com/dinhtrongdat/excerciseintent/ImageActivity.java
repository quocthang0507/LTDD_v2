package com.dinhtrongdat.excerciseintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Collections;


public class ImageActivity extends Activity {

    TableLayout tbLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        tbLayout = (TableLayout) findViewById(R.id.table_layout);

        int row = 4;
        int col = 3;

        Collections.shuffle(MainActivity.arrName);

        for(int i = 1; i<= row ; i++){
            TableRow tbRow = new TableRow(this);
            for(int j = 1; j<=col ; j++){

                ImageView imgView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(350, 350);
                imgView.setLayoutParams(layoutParams);
                int index = col * (i - 1) + j - 1;
                int idHinh = getResources().getIdentifier(MainActivity.arrName.get(index), "drawable", getPackageName());
                imgView.setImageResource(idHinh);

                tbRow.addView(imgView);

                imgView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhchon", MainActivity.arrName.get(index));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
            tbLayout.addView(tbRow);
        }

    }
}