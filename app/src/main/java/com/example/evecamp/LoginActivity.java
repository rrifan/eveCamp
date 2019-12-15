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
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

     EditText e1;
     EditText p1;
     Button login;
     DatabaseHelper db;
     TextView signup;
     TextView forgotPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        e1=findViewById(R.id.email1);
        p1=findViewById(R.id.password1);

        login=findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = p1.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email, password);
                if (Chkemailpass == true){
                    Intent btnLogin = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(btnLogin);
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Wrong email or Password", Toast.LENGTH_SHORT).show();
                }


            }
        });

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

    }


}
