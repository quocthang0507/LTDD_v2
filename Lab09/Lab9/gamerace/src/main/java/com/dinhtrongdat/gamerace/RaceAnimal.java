package com.dinhtrongdat.gamerace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.sax.EndElementListener;
import android.view.VerifiedInputEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class RaceAnimal extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    ImageButton btnPlay;
    int score = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_animal);

        initUI();

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);

        txtDiem.setText(String.valueOf(score));

        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int num = 5;
                Random random = new Random();

                if(skOne.getProgress() >= skOne.getMax()){
                    this.cancel();
                    Toast.makeText(RaceAnimal.this,"One Win",Toast.LENGTH_LONG).show();
                    btnPlay.setVisibility(View.VISIBLE);
                    if(cbOne.isChecked()){
                        score += 10;
                        Toast.makeText(RaceAnimal.this,"Correct",Toast.LENGTH_LONG).show();
                    }
                    else{
                        score -=10;
                        Toast.makeText(RaceAnimal.this,"Fail",Toast.LENGTH_LONG).show();
                    }
                    txtDiem.setText(String.valueOf(score));
                    EnableCheckBox();
                }
                if(skTwo.getProgress() >= skTwo.getMax()){
                    this.cancel();
                    Toast.makeText(RaceAnimal.this,"Two Win",Toast.LENGTH_LONG).show();
                    btnPlay.setVisibility(View.VISIBLE);
                    if(cbTwo.isChecked()){
                        score += 10;
                        Toast.makeText(RaceAnimal.this,"Correct",Toast.LENGTH_LONG).show();
                    }
                    else{
                        score -=10;
                        Toast.makeText(RaceAnimal.this,"Fail",Toast.LENGTH_LONG).show();
                    }
                    txtDiem.setText(String.valueOf(score));
                    EnableCheckBox();
                }
                if(skThree.getProgress() >= skThree.getMax()){
                    this.cancel();
                    Toast.makeText(RaceAnimal.this,"Three Win",Toast.LENGTH_LONG).show();
                    btnPlay.setVisibility(View.VISIBLE);
                    if(cbThree.isChecked()){
                        score += 10;
                        Toast.makeText(RaceAnimal.this,"Correct",Toast.LENGTH_LONG).show();
                    }
                    else{
                        score -=10;
                        Toast.makeText(RaceAnimal.this,"Fail",Toast.LENGTH_LONG).show();
                    }
                    txtDiem.setText(String.valueOf(score));
                    EnableCheckBox();
                }
                skOne.setProgress(skOne.getProgress()+random.nextInt(num));
                skTwo.setProgress(skTwo.getProgress()+random.nextInt(num));
                skThree.setProgress(skThree.getProgress()+random.nextInt(num));
            }

            @Override
            public void onFinish() {

            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbOne.isChecked() || cbTwo.isChecked() ||cbThree.isChecked()) {
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);

                    countDownTimer.start();
                    btnPlay.setVisibility(View.INVISIBLE);

                    DisableCheckbox();
                }
                else {
                    Toast.makeText(RaceAnimal.this,"Cược đê!!!",Toast.LENGTH_LONG).show();
                }
            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    cbTwo.setChecked(false);
                    cbOne.setChecked(false);
                }
            }
        });
    }

    private void initUI() {
        txtDiem = findViewById(R.id.txtScore);
        cbOne = findViewById(R.id.cb1);
        cbTwo = findViewById(R.id.cb2);
        cbThree = findViewById(R.id.cb3);
        skOne = findViewById(R.id.sb1);
        skTwo = findViewById(R.id.sb2);
        skThree = findViewById(R.id.sb3);
        btnPlay = findViewById(R.id.btnPlay);
    }

    private void EnableCheckBox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }

    private void DisableCheckbox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }
}