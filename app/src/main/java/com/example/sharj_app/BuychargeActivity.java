package com.example.sharj_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuychargeActivity extends AppCompatActivity {
    private Button menu,BuyCharge;
    int Amount=2000;
    int Operator=0;
    CircleImageView mci,irancell,rightel;
    Button five,ten,twenty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buycharge);
        menu=findViewById(R.id.menu);
        mci=findViewById(R.id.mci);
        irancell=findViewById(R.id.irancell);
        rightel=findViewById(R.id.rightel);
        five=findViewById(R.id.five);
        ten=findViewById(R.id.ten);
        twenty=findViewById(R.id.twenty);
        BuyCharge=findViewById(R.id.BuyCharge);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
            public void openMainActivity(){
                Intent intent;
                intent = new Intent(BuychargeActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        Retrofit retrofit=new Retrofit
                .Builder()
                .baseUrl("https://topup.pec.ir/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Users users=retrofit.create(Users.class);

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amount=50000;
            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amount=100000;

            }
        });

        twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amount=200000;

            }
        });
        BuyCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mci.isPressed()){
                    Operator=0;
                }
                if(irancell.isPressed()){
                    Operator=1;
                }
                if(rightel.isPressed()){
                    Operator=2;
                }
            }
        });
    }




}