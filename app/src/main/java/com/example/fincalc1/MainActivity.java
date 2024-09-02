package com.example.fincalc1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTDS = findViewById(R.id.btnTDS);
        Button btnSIP = findViewById(R.id.btnSIP);
        Button btnEMI = findViewById(R.id.btnEMI);
        Button btnLumpSum = findViewById(R.id.btnLumpSum);

        btnTDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TDSActivity.class));
            }
        });

        btnSIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SIPActivity.class));
            }
        });

        btnEMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EMIActivity.class));
            }
        });

        btnLumpSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LumpSumActivity.class));
            }
        });
    }
}
