package com.example.fincalc1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LumpSumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lump_sum);

        EditText etLumpSumAmount = findViewById(R.id.etLumpSumAmount);
        EditText etLumpSumRate = findViewById(R.id.etLumpSumRate);
        EditText etLumpSumPeriod = findViewById(R.id.etLumpSumPeriod);
        Button btnCalculateLumpSum = findViewById(R.id.btnCalculateLumpSum);
        TextView tvLumpSumResult = findViewById(R.id.tvLumpSumResult);

        btnCalculateLumpSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountStr = etLumpSumAmount.getText().toString();
                String rateStr = etLumpSumRate.getText().toString();
                String periodStr = etLumpSumPeriod.getText().toString();

                if (!amountStr.isEmpty() && !rateStr.isEmpty() && !periodStr.isEmpty()) {
                    double amount = Double.parseDouble(amountStr);
                    double rate = Double.parseDouble(rateStr) / 100;
                    int period = Integer.parseInt(periodStr);

                    double futureValue = calculateLumpSum(amount, rate, period);
                    tvLumpSumResult.setText("Future Value: " + futureValue);
                }
            }
        });
    }

    private double calculateLumpSum(double amount, double rate, int period) {
        return amount * Math.pow(1 + rate, period);
    }
}
