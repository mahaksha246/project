package com.example.fincalc1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TDSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdsactivity);

        EditText etIncome = findViewById(R.id.etIncome);
        Button btnCalculateTDS = findViewById(R.id.btnCalculateTDS);
        TextView tvTDSResult = findViewById(R.id.tvTDSResult);

        btnCalculateTDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String incomeStr = etIncome.getText().toString();
                if (!incomeStr.isEmpty()) {
                    double income = Double.parseDouble(incomeStr);
                    double tds = calculateTDS(income);
                    tvTDSResult.setText("TDS: " + tds);
                }
            }
        });
    }

    private double calculateTDS(double income) {
        // Simplified TDS calculation logic
        return income * 0.1; // Example: 10% TDS
    }
}
