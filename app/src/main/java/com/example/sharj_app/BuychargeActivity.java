package com.example.sharj_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BuychargeActivity extends AppCompatActivity {
    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buycharge);
        menu=findViewById(R.id.menu);
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
    }
}