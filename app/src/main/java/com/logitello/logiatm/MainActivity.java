package com.logitello.logiatm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String data1, data2;


    private EditText editTextLogin, editTextPassword;
    private Button btnLogin, btnClose;
    private TextView btnCreateAcc, textViewLoginFailed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextLogin = findViewById(R.id.editTextLogin);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnClose = findViewById(R.id.btnClose);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateAcc = findViewById(R.id.btnCreateAcc);
        textViewLoginFailed = findViewById(R.id.textViewLoginFailed);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadPreferences();
                if(data1.equals(editTextLogin.getText().toString()) && data2.equals(editTextPassword.getText().toString())) {
                    editTextLogin.setText("");
                    editTextPassword.setText("");
                    Intent intentLoggedIn = new Intent(MainActivity.this, MyOnlineBankingActivity.class);
                    startActivity(intentLoggedIn);
                } else {
                    textViewLoginFailed.setText("Invalid credentials. Try again.");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewLoginFailed.setText("");
                        }
                    }, 3000);
                }
            }
        });

        btnCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreateAcc = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intentCreateAcc);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    private void LoadPreferences() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        data1 = sp.getString("login", "") ;
        data2 = sp.getString("password", "") ;
    }

}