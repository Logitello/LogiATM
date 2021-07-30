package com.logitello.logiatm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyOnlineBankingActivity extends AppCompatActivity {

    private TextView textViewMoney;
    private Button buttonWithdraw, buttonDeposit, buttonMakePayment, buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_online_banking);

        Intent intent = getIntent();


        textViewMoney = findViewById(R.id.textViewMoney);

        buttonWithdraw = findViewById(R.id.buttonWithdraw);
        buttonDeposit = findViewById(R.id.buttonDeposit);
        buttonMakePayment = findViewById(R.id.buttonMakePayment);
        buttonLogout = findViewById(R.id.buttonLogout);
        

        // TODO: set textViewMoney changes



        buttonWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWithdraw = new Intent(MyOnlineBankingActivity.this, WithdrawActivity.class);
                startActivity(intentWithdraw);
            }
        });

        buttonDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDeposit = new Intent(MyOnlineBankingActivity.this, DepositActivity.class);
                startActivity(intentDeposit);
            }
        });

        buttonMakePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMakePayment = new Intent(MyOnlineBankingActivity.this, MakePaymentActivity.class);
                startActivity(intentMakePayment);
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}