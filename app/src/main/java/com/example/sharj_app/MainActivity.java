package com.example.sharj_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView BuyCharge, CheckBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BuyCharge = findViewById(R.id.buycharge);
        CheckBill = findViewById(R.id.bill);
//        String url = "http://spid3r.ir/?status&ph=02177902237";
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.d("json respone ===", response + "");
//                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
//                try {
//                    String code = response.getString("code");
//                    JSONObject dataObject = response.getJSONObject("data");
//
//                    JSONObject finalTermObject = dataObject.getJSONObject("FinalTerm");
//                    int amount = finalTermObject.getInt("Amount");
//                    String billId = finalTermObject.getString("BillID");
//                    String paymentId = finalTermObject.getString("PaymentID");
//                    boolean validForPayment = finalTermObject.getBoolean("ValidForPayment");
//
//                    JSONObject midTermObject = dataObject.getJSONObject("MidTerm");
//                    int midAmount = midTermObject.getInt("Amount");
//                    String midBillId = midTermObject.getString("BillID");
//                    String midPaymentId = midTermObject.getString("PaymentID");
//                    boolean midValidForPayment = midTermObject.getBoolean("ValidForPayment");
//
//                    Toast.makeText(MainActivity.this, amount + "rial", Toast.LENGTH_SHORT).show();
//                    JSONObject inquiryObject = dataObject.getJSONObject("Inquiry");
//                }catch (JSONException e){
//
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this, "rr", Toast.LENGTH_SHORT).show();
//                Log.d("json respone ===", error.getMessage() + "");
//
//            }
//        });
//        RequestQueue rozhi = Volley.newRequestQueue(this);
//        rozhi.add(request);

        CheckBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, CheckbillActivity.class);
                startActivity(intent);
            }
        });

        BuyCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, BuychargeActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View view) {

    }
}