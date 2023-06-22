package com.example.sharj_app;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CheckbillActivity extends AppCompatActivity {
        private Button Back,Check;
        private TextView Midterm_Amount,Midterm_PaymentId,BillId,Finalterm_Amount,Finalterm_PaymentId;
        private CardView ShowCard;
    public static Retrofit retrofit;
       public EditText Phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_checkbill);
        Back=findViewById(R.id.menu);
        Check=findViewById(R.id.btncheck);
        Phone=findViewById(R.id.phone);
        ShowCard=findViewById(R.id.cardview1);
        Midterm_Amount=findViewById(R.id.Midterm_Amount);
        Midterm_PaymentId=findViewById(R.id.Midterm_PaymentId);
        BillId=findViewById(R.id.BillId);
        Finalterm_Amount=findViewById(R.id.Finalterm_Amount);
        Finalterm_PaymentId=findViewById(R.id.Finalterm_PaymentId);


        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value=Phone.getText().toString();
                String url = "http://spid3r.ir/?status&ph="+value;
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                Log.d("json respone ===", response + "");
//                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                        try {
                            String code = response.getString("code");
                            JSONObject dataObject = response.getJSONObject("data");

                            JSONObject finalTermObject = dataObject.getJSONObject("FinalTerm");
                            int amount = finalTermObject.getInt("Amount");
                            String billId = finalTermObject.getString("BillID");
                            String paymentId = finalTermObject.getString("PaymentID");
                            boolean validForPayment = finalTermObject.getBoolean("ValidForPayment");

                            JSONObject midTermObject = dataObject.getJSONObject("MidTerm");
                            int midAmount = midTermObject.getInt("Amount");
                            String midBillId = midTermObject.getString("BillID");
                            String midPaymentId = midTermObject.getString("PaymentID");
                            boolean midValidForPayment = midTermObject.getBoolean("ValidForPayment");

                            Toast.makeText(CheckbillActivity.this, amount + "rial", Toast.LENGTH_SHORT).show();
                            JSONObject inquiryObject = dataObject.getJSONObject("Inquiry");
                            //inja
                            BillId.setText(billId);
                            Finalterm_Amount.setText(amount +"");
                            Finalterm_PaymentId.setText(paymentId +" ");

                            Midterm_Amount.setText(midAmount+"");
                            Midterm_PaymentId.setText(midPaymentId+"");

                            ShowCard.setVisibility(View.VISIBLE);

                        }catch (JSONException e){
                            Log.d("e caxh  ==",e.getMessage());

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CheckbillActivity.this, "rr", Toast.LENGTH_SHORT).show();
                        Log.d("json err ===", error.getMessage() + "");

                    }
                });
                RequestQueue rozhi = Volley.newRequestQueue(CheckbillActivity.this);
                rozhi.add(request);





            }
        });




        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckbillActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(CheckbillActivity.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },2700);
    }


}