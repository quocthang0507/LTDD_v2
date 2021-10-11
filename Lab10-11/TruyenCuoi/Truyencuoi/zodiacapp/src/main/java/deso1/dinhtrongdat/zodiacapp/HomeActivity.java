package deso1.dinhtrongdat.zodiacapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import deso1.dinhtrongdat.zodiacapp.model.Zodiac;

public class HomeActivity extends AppCompatActivity {
    ImageView imgCurrent;
    TextView txtTitle, txtDate, txtDes;
    Button btnSeeMore;
    Zodiac zodiac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
    }

    private void initUI() {
        imgCurrent = findViewById(R.id.img_current);
        txtTitle = findViewById(R.id.txt_title);;
        txtDate = findViewById(R.id.txt_date);
        txtDes = findViewById(R.id.txt_description);

        btnSeeMore = findViewById(R.id.btnSeeMore);

        btnSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", zodiac);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        findViewById(R.id.img_aries).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("aries");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_aquarius).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("aquarius");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_cancer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("cancer");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_capricon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("capricon");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_gemini).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("gemini");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_leo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("leo");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_libra).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("libra");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_pisces).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("pisces");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_sagitarius).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("sagitarius");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_scopio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("scopio");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_taurus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("taurus");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
        findViewById(R.id.img_virgo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zodiac = readZodiac("virgo");
                imgCurrent.setImageResource(zodiac.getImg());
                txtTitle.setText(zodiac.getTitle());
                txtDate.setText(zodiac.getDate());
                txtDes.setText(zodiac.getDescrip());
            }
        });
    }
    private Zodiac readZodiac(String fileName){
        String mTitle = null, mDate = null, mDescription = null, mDetail= null;
        int img = getResources().getIdentifier(fileName,"drawable", getPackageName());
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(
              new InputStreamReader(this.getAssets().open("zodiac/"+fileName+".txt"),"UTF-8"));
            String line ="";
            while ((line=reader.readLine())!=null){
                String[] data = line.split("\\*");
                mTitle = data[0];
                mDate = data[1];
                mDescription = data[2];
                mDetail = data[3];
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Zodiac(mTitle,mDescription,mDate,mDetail,img);
    }
}