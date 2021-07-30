package com.logitello.logiatm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class CreateAccountActivity extends AppCompatActivity {
    private TextView textViewNewName, textViewNewPassword, textViewNewConfirmPass, textViewNewFailed;
    private EditText editTextNewName, editTextNewPassword, editTextNewConfirmPass;
    private Button buttonConfirmCreateAccount, buttonBackCreateAccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Intent intent = getIntent();

        textViewNewName = findViewById(R.id.textViewNewName);
        textViewNewPassword = findViewById(R.id.textViewNewPassword);
        textViewNewConfirmPass = findViewById(R.id.textViewNewConfirmPass);
        textViewNewFailed = findViewById(R.id.textViewNewFailed);

        editTextNewName = findViewById(R.id.editTextNewName);
        editTextNewPassword = findViewById(R.id.editTextNewPassword);
        editTextNewConfirmPass = findViewById(R.id.editTextNewConfirmPass);

        buttonConfirmCreateAccount = findViewById(R.id.buttonConfirmCreateAcc);
        buttonBackCreateAccount = findViewById(R.id.buttonBackCreateAcc);

        editTextNewName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    textViewNewName.setText("Maximum of 10 characters");
                } else {
                    textViewNewName.setText("");
                }
            }
        });

        editTextNewPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    textViewNewPassword.setText("Maximum of 10 characters");
                } else {
                    textViewNewPassword.setText("");
                }
            }
        });

        editTextNewConfirmPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    textViewNewConfirmPass.setText("Maximum of 10 characters");
                } else {
                    textViewNewConfirmPass.setText("");
                }
            }
        });

        buttonConfirmCreateAccount.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {

                if(editTextNewName.getText().length() == 0 || editTextNewPassword.length() == 0 || editTextNewConfirmPass.length() == 0) {
                        textViewNewFailed.setText("All fields are required!");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                textViewNewFailed.setText("");
                            }
                        }, 3000);
                } else {
                    SavePreferences("login", editTextNewName.getText().toString());
                    SavePreferences("password", editTextNewPassword.getText().toString());
                    Toast.makeText(CreateAccountActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                }
            }
        });



        buttonBackCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void SavePreferences(String key, String value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor Ed = sp.edit();
        Ed.putString(key, value);
        Ed.commit();
    }
}