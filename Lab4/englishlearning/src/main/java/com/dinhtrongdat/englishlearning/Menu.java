package com.dinhtrongdat.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    private static final int[] ID_DRAWABLES = {R.drawable.ecentials, R.drawable.traveling, R.drawable.medical, R.drawable.hotel, R.drawable.restaurant,
    R.drawable.bar, R.drawable.store, R.drawable.work, R.drawable.time, R.drawable.education, R.drawable.entertainment};

    private static final int[] ID_TEXTS = {R.string.txt_mess, R.string.txt_flight, R.string.txt_hospital,
            R.string.txt_hotel, R.string.txt_restaurant, R.string.txt_coctail,
            R.string.txt_store, R.string.txt_work, R.string.txt_time, R.string.txt_education, R.string.txt_movie};
    public static ArrayList<String> arrWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initUI();
    }

    private void initUI(){
        LinearLayout lnMain = findViewById(R.id.ln_main);
        lnMain.removeAllViews();
        for(int i=0; i<ID_DRAWABLES.length; i++){
            View v = LayoutInflater.from(this).inflate(R.layout.item_topic, null);
            ImageView ivTopic = v.findViewById(R.id.iv_topic);
            TextView tvTopic = v.findViewById(R.id.tv_topic);
            ivTopic.setImageResource(ID_DRAWABLES[i]);
            tvTopic.setText(ID_TEXTS[i]);

            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            );
            v.setLayoutParams(param);
            lnMain.addView(v);
            tvTopic.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
//        startActivity(new Intent(Menu.this, act_word.class));
        TextView tv = (TextView) view;
        if(tv.getText().toString().compareTo("Essentials") == 0){
            String[] word = getResources().getStringArray(R.array.Essentials);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(tv.getText().toString().compareTo("Traveling") == 0){
            String[] word = getResources().getStringArray(R.array.Traveling);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(tv.getText().toString().compareTo("Medical") == 0){
            String[] word = getResources().getStringArray(R.array.Medical);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(tv.getText().toString().compareTo("Hotel") == 0){
            String[] word = getResources().getStringArray(R.array.Hotel);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(tv.getText().toString().compareTo("Restaurant") == 0){
            String[] word = getResources().getStringArray(R.array.Restaurant);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(tv.getText().toString().compareTo("Bar") == 0){
            String[] word = getResources().getStringArray(R.array.Bar);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(tv.getText().toString().compareTo("Store") == 0){
            String[] word = getResources().getStringArray(R.array.Store);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(tv.getText().toString().compareTo("Work") == 0){
            String[] word = getResources().getStringArray(R.array.Work);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(tv.getText().toString().compareTo("Time") == 0){
            String[] word = getResources().getStringArray(R.array.Time);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(tv.getText().toString().compareTo("Education") == 0){
            String[] word = getResources().getStringArray(R.array.Education);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else if(tv.getText().toString().compareTo("Entertainment") == 0){
            String[] word = getResources().getStringArray(R.array.Entertainment);
            arrWord = new ArrayList<>(Arrays.asList(word));
            Intent intent = new Intent(Menu.this, act_word.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arr_word", arrWord);
            intent.putExtras(bundle);

            startActivity(intent);
        }

    }
}