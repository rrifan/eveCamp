package com.example.evecamp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private TextView signup;
    private TextView forgotPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email=findViewById(R.id.input_email);
        password=findViewById(R.id.input_password);
        login=findViewById(R.id.btn_login);
        signup=findViewById(R.id.sign_up);
        forgotPass=findViewById(R.id.forgot_password);
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotPass = new Intent(LoginActivity.this,ForgotPassword.class);
                startActivity(forgotPass);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signUp);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent btnLogin= new Intent(LoginActivity.this,MainActivity.class);
                startActivity(btnLogin);
            }
        });
    }


}
