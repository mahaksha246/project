package com.example.fincalc1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SIPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sipactivity);

        EditText etSIPAmount = findViewById(R.id.etSIPAmount);
        EditText etSIPRate = findViewById(R.id.etSIPRate);
        EditText etSIPPeriod = findViewById(R.id.etSIPPeriod);
        Button btnCalculateSIP = findViewById(R.id.btnCalculateSIP);
        TextView tvSIPResult = findViewById(R.id.tvSIPResult);

        btnCalculateSIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountStr = etSIPAmount.getText().toString();
                String rateStr = etSIPRate.getText().toString();
                String periodStr = etSIPPeriod.getText().toString();

                if (!amountStr.isEmpty() && !rateStr.isEmpty() && !periodStr.isEmpty()) {
                    double amount = Double.parseDouble(amountStr);
                    double rate = Double.parseDouble(rateStr) / 100 / 12;
                    int period = Integer.parseInt(periodStr) * 12;

                    double sip = calculateSIP(amount, rate, period);
                    tvSIPResult.setText("SIP Value: " + sip);
                }
            }
        });
    }

    private double calculateSIP(double amount, double rate, int period) {
        return amount * (Math.pow(1 + rate, period) - 1) / rate * (1 + rate);
    }
}
