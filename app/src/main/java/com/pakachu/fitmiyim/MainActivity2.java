package com.pakachu.fitmiyim;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Double BMI=MainActivity.bmi;
        String BMIs = MainActivity.bmi.toString();
        if(BMIs.length()>4)
            BMIs=BMIs.substring(0,4);
        ImageView iv2 = findViewById(R.id.imageView2);
        TextView tv_main2_baslik = findViewById(R.id.tv_main2_baslik);
        tv_main2_cevap = findViewById(R.id.tv_main2_cevap);

//        Toast.makeText(this, BMI+" : "+BMIs, Toast.LENGTH_SHORT).show();

        if (BMI < 18.5) //AŞIRI ZAYIF
        {
            iv2.setImageResource(R.drawable.zayif);
            tv_main2_baslik.setText(tv_main2_baslik.getText().toString() + " -"+getString(R.string.hayir));
            tv_main2_cevap.setText(getString(R.string.bmi)+": "+BMIs+"\n\n"+getString(R.string.cevap1));

        } else if (BMI >= 18.5 && BMI <= 24.9999999) //NORMAL
        {
            iv2.setImageResource(R.drawable.normal);
            tv_main2_baslik.setText(tv_main2_baslik.getText().toString() + " -"+getString(R.string.evet));
            tv_main2_cevap.setText(getString(R.string.bmi)+": "+BMIs+"\n\n"+getString(R.string.cevap2));
        } else if (BMI >= 25 && BMI <= 30) //KİLOLU
        {
            iv2.setImageResource(R.drawable.kilolu);
            tv_main2_baslik.setText(tv_main2_baslik.getText().toString() + " -"+getString(R.string.hayir));
            tv_main2_cevap.setText(getString(R.string.bmi)+": "+BMIs+"\n\n"+getString(R.string.cevap3));
        } else if (BMI > 30) //OBEZ
        {
            iv2.setImageResource(R.drawable.obez);
            tv_main2_baslik.setText(tv_main2_baslik.getText().toString() + " -"+getString(R.string.hayir));
            tv_main2_cevap.setText(getString(R.string.bmi)+": "+BMIs+"\n\n"+getString(R.string.cevap4));
        }
        Animation forTugce = AnimationUtils.loadAnimation(this, R.anim.rotate);
        if (MainActivity.tugce) {
            iv2.setImageResource(R.drawable.sun);
            tv_main2_baslik.setText("FitMisin?" + "\n-😻!");
            tv_main2_cevap.setText("O mükemmel biri. O iyi ki var! O olmasaydı bu hayat çok sıkıcı olurdu. Umarım hayatında istediği her şey gerçekleşir. O çok seviliyor...");

            iv2.startAnimation(forTugce);

        }

        a1 = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
        a2 = AnimationUtils.loadAnimation(this, R.anim.mixed_anim);
        ImageView ivv=findViewById(R.id.imageView2);

        tv_main2_baslik.startAnimation(a1);

        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });{

        }


    }

    public static TextView tv_main2_cevap;
    public static Animation a1, a2;
//    //Declare timer
//    public static CountDownTimer cTimer = null;
//
//    //start timer function
//    public static void startTimer() {
//        cTimer = new CountDownTimer(3000, 1000) {
//            public void onTick(long millisUntilFinished) {
//            }
//
//            public void onFinish() {
//                tv_main2_cevap.startAnimation(a2);
//            }
//        };
//        cTimer.start();
//    }
//
//
//    //cancel timer
//    void cancelTimer() {
//        if (cTimer != null)
//            cTimer.cancel();
//    }
}