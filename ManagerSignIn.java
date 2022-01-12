package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ManagerSignIn extends AppCompatActivity {
    EditText email;
    EditText password;
    Button sign_in;
    Button sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_manager);
        final View managerSignInView = getLayoutInflater().inflate(R.layout.sign_in_manager, null);
        email = (EditText) managerSignInView.findViewById(R.id.editTextTextEmailAddress2);
        password = (EditText) managerSignInView.findViewById(R.id.editTextTextPassword);
        sign_in = (Button) managerSignInView.findViewById(R.id.button2);
        sign_up = (Button) managerSignInView.findViewById(R.id.button);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button:
                        Intent intent = new Intent(ManagerSignIn.this, ManagerSignUp.class);
                        startActivity(intent);
                }
            }
        });
    }


}
