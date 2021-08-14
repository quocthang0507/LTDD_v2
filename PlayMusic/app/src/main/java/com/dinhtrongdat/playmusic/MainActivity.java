package com.dinhtrongdat.playmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton btnPlay, btnNext, btnPrev;
    SeekBar seekBar;
    TextView txtTotal, txtEnd, txtName;
    ArrayList<Song> arrSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        AddSong();

    }

    private void AnhXa(){
        btnPlay = (ImageButton) findViewById(R.id.btn_play);
        btnNext = (ImageButton) findViewById(R.id.btn_next);
        btnPrev = (ImageButton) findViewById(R.id.btn_pre);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        txtTotal = (TextView) findViewById(R.id.txt_time_total);
        txtEnd = (TextView) findViewById(R.id.txt_time_end);
        txtName = (TextView) findViewById(R.id.txt_name);
    }

    private void AddSong(){
        arrSong = new ArrayList<>();
        arrSong.add(new Song("The Chain", R.drawable.the_chain));
        arrSong.add(new Song("Dreams", R.drawable.dreams));
        arrSong.add(new Song("My First Kiss", R.drawable.my_first_kiss));
        arrSong.add(new Song("Sanfrancisco Stress", R.drawable.sanfrancisco_stress));
        arrSong.add(new Song("Dear My Friend", R.drawable.dear_my_friend));
    }
}