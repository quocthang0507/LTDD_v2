package deso1.dinhtrongdat.zodiacapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import deso1.dinhtrongdat.zodiacapp.model.Zodiac;

public class DetailActivity extends AppCompatActivity {
    TextView txtTitle, txtDate, txtDetail;
    ImageView imgDetail;
    Zodiac zodiac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initUI();
    }

    private void initUI() {

        txtTitle = findViewById(R.id.txt_detail_title);
        txtDate = findViewById(R.id.txt_detail_date);
        txtDetail = findViewById(R.id.txt_detail);
        imgDetail = findViewById(R.id.imgDetail);

        zodiac = (Zodiac) getIntent().getExtras().get("data");
        txtTitle.setText(zodiac.getTitle());
        txtDate.setText(zodiac.getDate());
        txtDetail.setText(zodiac.getDetail());
        imgDetail.setImageResource(zodiac.getImg());

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this, HomeActivity.class));
            }
        });
    }
}