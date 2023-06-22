package com.example.sharj_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuychargeActivity extends AppCompatActivity {
     Button menu,BuyCharge;
    int Amount=2000;
    int Operator=2;
    CircleImageView mci,irancell,rightel;
    Button five,ten,twenty;
    EditText PhoneNumber;
    String phonenumber;

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
        PhoneNumber = findViewById(R.id.PhoneNumber);
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
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amount=50000;
                if(five.isPressed()) {
                    five.setBackground(getDrawable(R.drawable.circleclicked));
                    twenty.setBackground(getDrawable(R.drawable.circle));
                    ten.setBackground(getDrawable(R.drawable.circle));
                }
            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amount=100000;
                if(ten.isPressed()) {
                    ten.setBackground(getDrawable(R.drawable.circleclicked));
                    five.setBackground(getDrawable(R.drawable.circle));
                    twenty.setBackground(getDrawable(R.drawable.circle));
                }

            }
        });

        twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amount=200000;
                if(twenty.isPressed()) {
                    twenty.setBackground(getDrawable(R.drawable.circleclicked));
                    five.setBackground(getDrawable(R.drawable.circle));
                    ten.setBackground(getDrawable(R.drawable.circle));
                }
            }
        });
        mci.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Operator=1;
                    mci.setBorderColor(R.color.darkpurple);
                mci.setBorderOverlay(true);

            }
        });
        irancell.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Operator=2;
                irancell.setBorderOverlay(true);
                irancell.setBorderColor(R.color.darkpurple);

            }
        });
        rightel.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Operator=3;
                rightel.setBorderOverlay(true);
                rightel.setBorderColor(R.color.darkpurple);

            }
        });


        BuyCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = PhoneNumber.getText().toString();

                String url = "http://spid3r.ir/?charge&ph=" + phonenumber + "&op=" + Operator + "&am=" + Amount;
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {//put a log in here///
                            Log.d("respon ====", response + "");
                            String url = response.getString("url");
                            Uri webpage = Uri.parse(url);
                            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);


                            if (intent.resolveActivity(getPackageManager()) != null) {
                                startActivity(intent);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("err ===", error.getMessage() + ""); //run kon test bgir

                    }
                });

                RequestQueue rozhi = Volley.newRequestQueue(BuychargeActivity.this);
                rozhi.add(request);

                if (PhoneNumber.getText().toString().length()==0) {
                    Toast.makeText(BuychargeActivity.this, "لطفا شماره تلفن خود را وارد نمایید", Toast.LENGTH_SHORT).show();
                }

            }
        });





    }




}