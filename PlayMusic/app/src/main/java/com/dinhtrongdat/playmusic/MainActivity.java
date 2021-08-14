package com.dinhtrongdat.playmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton btnPlay, btnNext, btnPrev;
    SeekBar seekBar;
    TextView txtTotal, txtEnd, txtName;
    ArrayList<Song> arrSong;
    MediaPlayer mediaPlayer;
    int pos = 0;
    SimpleDateFormat simpleDateFormat;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        AddSong();

        mediaPlayer = MediaPlayer.create(MainActivity.this, arrSong.get(pos).getFile());
        simpleDateFormat = new SimpleDateFormat("mm:ss");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.ic_play);
                }
                else{
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.ic_pause);
                    txtEnd.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
                    seekBar.setMax(mediaPlayer.getDuration());
                    txtName.setText(arrSong.get(pos).getTitle());
                    UpdateTime();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos++;
                if(pos > arrSong.size()-1){
                    pos = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, arrSong.get(pos).getFile());
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.ic_pause);
                txtEnd.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
                seekBar.setMax(mediaPlayer.getDuration());
                UpdateTime();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos--;
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                if (pos<0){
                    pos = arrSong.size()-1;
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, arrSong.get(pos).getFile());
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.ic_pause);
                txtEnd.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
                seekBar.setMax(mediaPlayer.getDuration());
                UpdateTime();
            }
        });


    }


    private void AnhXa(){
        btnPlay = (ImageButton) findViewById(R.id.btn_play);
        btnNext = (ImageButton) findViewById(R.id.btn_next);
        btnPrev = (ImageButton) findViewById(R.id.btn_pre);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        txtTotal = (TextView) findViewById(R.id.txt_time_total);
        txtEnd = (TextView) findViewById(R.id.txt_time_end);
        txtName = (TextView) findViewById(R.id.txt_name);
        imageView = (ImageView) findViewById(R.id.imgView);
    }

    private void AddSong(){
        arrSong = new ArrayList<>();
        arrSong.add(new Song("The Chain", R.raw.the_chain, R.drawable.the_chain));
        arrSong.add(new Song("Dreams", R.raw.dreams, R.drawable.dreams));
        arrSong.add(new Song("My First Kiss", R.raw.my_first_kiss, R.drawable.my_first_kiss));
        arrSong.add(new Song("Sanfrancisco Stress", R.raw.sanfrancisco_stress, R.drawable.sanfrancisco_stress));
        arrSong.add(new Song("Dear My Friend", R.raw.dear_my_friend, R.drawable.dear_my_friend));
    }

    private void UpdateTime(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                txtTotal.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                txtName.setText(arrSong.get(pos).getTitle());
                imageView.setImageResource(arrSong.get(pos).getImg());
                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        pos++;
                        if(pos > arrSong.size()-1){
                            pos = 0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                            mediaPlayer.release();
                        }
                        mediaPlayer = MediaPlayer.create(MainActivity.this, arrSong.get(pos).getFile());
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.ic_pause);
                        txtEnd.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
                        seekBar.setMax(mediaPlayer.getDuration());
                        UpdateTime();
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);
    }
}