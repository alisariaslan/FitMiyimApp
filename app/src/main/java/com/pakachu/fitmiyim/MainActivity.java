package com.pakachu.fitmiyim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {

    public static Double boy;
    public static Double kilo;
    public static Double bmi;
    public static Double yas;
    public static Boolean erkekmiyim = true;
    public static Boolean tugce = false;
    private InterstitialAd mInterstitialAd;


//        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
//            @Override
//            public void onAdDismissedFullScreenContent() {
//                // Called when fullscreen content is dismissed.
//                MainActivity2.cTimer.start();
//            }
//
//            @Override
//            public void onAdFailedToShowFullScreenContent(AdError adError) {
//                // Called when fullscreen content failed to show.
//            }
//
//            @Override
//            public void onAdShowedFullScreenContent() {
//                // Called when fullscreen content is shown.
//                // Make sure to set your reference to null so you don't
//                // show it a second time.
//                mInterstitialAd = null;
//            }
//        });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                Log.e("timer",""+millisUntilFinished);
            }

            public void onFinish() {
        AdRequest adRequest2 = new AdRequest.Builder().build();
        InterstitialAd.load(MainActivity.this, getResources().getString(R.string.interstatialAds), adRequest2,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(MainActivity.this);
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
            }
        }.start();



        ImageView iv_main_erkek = findViewById(R.id.iv_main_erkek);
        ImageView iv_main_kadin = findViewById(R.id.iv_main_kadin);
        ImageView iv_main_erkekbtn = findViewById(R.id.iv_main_erkekbtn);
        ImageView iv_main_kadinbtn = findViewById(R.id.iv_main_kadinbtn);


        Animation a1 = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        Animation a3 = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        Animation a4 = AnimationUtils.loadAnimation(this, R.anim.bounce);

        iv_main_erkekbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                erkekmiyim = true;
                iv_main_erkek.setImageResource(R.drawable.erkeko);
                iv_main_erkekbtn.setImageResource(android.R.drawable.checkbox_on_background);
                iv_main_kadin.setImageResource(R.drawable.kadin);
                iv_main_kadinbtn.setImageResource(android.R.drawable.checkbox_off_background);
            }
        });

        iv_main_kadinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                erkekmiyim = false;
                iv_main_erkek.setImageResource(R.drawable.erkek);
                iv_main_erkekbtn.setImageResource(android.R.drawable.checkbox_off_background);
                iv_main_kadin.setImageResource(R.drawable.kadino);
                iv_main_kadinbtn.setImageResource(android.R.drawable.checkbox_on_background);
            }
        });

        EditText et_main_yas = findViewById(R.id.et_main_yas);
        EditText et_main_boy = findViewById(R.id.et_main_boy);
        EditText et_main_kilo = findViewById(R.id.et_main_kilo);

        et_main_yas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                tugce = false;
            }
        });
        et_main_boy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                tugce = false;
            }
        });
        et_main_kilo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                tugce = false;
            }
        });

        TextView tv_main_lutfenyas = findViewById(R.id.tv_main_lutfen_yas);
        TextView tv_main_lutfenboy = findViewById(R.id.tv_main_lutfen_boy);
        TextView tv_main_lutfenkilo = findViewById(R.id.tv_main_lutfen_kilo);

//        CheckBox checkBox=findViewById(R.id.checkBox);

        Button play = findViewById(R.id.btn_main_playstore);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Pakachu&hl=tr&gl=US"));
                startActivity(openURL);
            }
        });

        Button btn_main_hesapla = findViewById(R.id.btn_main_hesapla);

        btn_main_hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_main_yas.getText().toString().matches("")) {
                    tv_main_lutfenyas.setVisibility(View.VISIBLE);
                    tv_main_lutfenyas.startAnimation(a1);
                } else {
                    tv_main_lutfenyas.setVisibility(View.GONE);
                    tv_main_lutfenyas.clearAnimation();
                }
                if (et_main_boy.getText().toString().matches("")) {
                    tv_main_lutfenboy.setVisibility(View.VISIBLE);
                    tv_main_lutfenboy.startAnimation(a1);
                } else {
                    tv_main_lutfenboy.setVisibility(View.GONE);
                    tv_main_lutfenboy.clearAnimation();
                }
                if (et_main_kilo.getText().toString().matches("")) {
                    tv_main_lutfenkilo.setVisibility(View.VISIBLE);
                    tv_main_lutfenkilo.startAnimation(a1);
                } else {
                    tv_main_lutfenkilo.setVisibility(View.GONE);
                    tv_main_lutfenkilo.clearAnimation();
                }
                if (!et_main_yas.getText().toString().matches("")) {
                    if (!et_main_boy.getText().toString().matches("")) {
                        if (!et_main_kilo.getText().toString().matches("")) {
                            yas = Double.valueOf(et_main_yas.getText().toString());
                            boy = Double.valueOf(et_main_boy.getText().toString());
                            kilo = Double.valueOf(et_main_kilo.getText().toString());
                            bmi = kilo / ((boy / 100) * (boy / 100));
//                            if(checkBox.isChecked())
//                                tugce=true;

                            startActivity(new Intent(MainActivity.this, MainActivity2.class));
                        } else btn_main_hesapla.startAnimation(a2);
                    } else btn_main_hesapla.startAnimation(a2);
                } else btn_main_hesapla.startAnimation(a2);

            }
        });

        TextView baslik = findViewById(R.id.tv_main_baslik);

//        new CountDownTimer(1000, 1000) {
//            public void onTick(long millisUntilFinished) {
//            }
//            public void onFinish() {
//                baslik.startAnimation(a3);
//            }
//        }.start();

        baslik.startAnimation(a3);
        et_main_yas.startAnimation(a3);
        et_main_boy.startAnimation(a3);
        et_main_kilo.startAnimation(a3);

        baslik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baslik.startAnimation(a4);
                askitom += 1.0;
                if (askitom % 15 == 0.0) {
                    Toast.makeText(MainActivity.this, "❤", Toast.LENGTH_SHORT).show();
                    tugce = true;
                } else
                    tugce = false;
            }
        });
    }

    private Double askitom = 0.0;


}