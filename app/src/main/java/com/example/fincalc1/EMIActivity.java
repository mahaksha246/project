package com.example.fincalc1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emiactivity);

        EditText etLoanAmount = findViewById(R.id.etLoanAmount);
        EditText etInterestRate = findViewById(R.id.etInterestRate);
        EditText etLoanPeriod = findViewById(R.id.etLoanPeriod);
        Button btnCalculateEMI = findViewById(R.id.btnCalculateEMI);
        TextView tvEMIResult = findViewById(R.id.tvEMIResult);

        btnCalculateEMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountStr = etLoanAmount.getText().toString();
                String rateStr = etInterestRate.getText().toString();
                String periodStr = etLoanPeriod.getText().toString();

                if (!amountStr.isEmpty() && !rateStr.isEmpty() && !periodStr.isEmpty()) {
                    double amount = Double.parseDouble(amountStr);
                    double rate = Double.parseDouble(rateStr) / 100 / 12;
                    int period = Integer.parseInt(periodStr) * 12;

                    double emi = calculateEMI(amount, rate, period);
                    tvEMIResult.setText("EMI: " + emi);
                }
            }
        });
    }

    private double calculateEMI(double amount, double rate, int period) {
        return (amount * rate * Math.pow(1 + rate, period)) / (Math.pow(1 + rate, period) - 1);
    }
}
