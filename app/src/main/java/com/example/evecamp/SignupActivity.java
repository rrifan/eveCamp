package com.example.evecamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText email;
    EditText password1;
    EditText password2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = new DatabaseHelper( this);
        email=(EditText)findViewById(R.id.input_email);
        password1=(EditText)findViewById(R.id.input_password);
        password2=(EditText)findViewById(R.id.input_password2);
        btn=(Button)findViewById(R.id.btn_signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 =email.getText().toString();
                String s2 =password1.getText().toString();
                String s3 =password2.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }else{
                    if(s2.equals(s3)){
                        Boolean chkemail = db.chkemail(s1);
                        if(chkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successfuly",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public void signIn(View view) {
        Intent signIn= new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(signIn);
    }
}
