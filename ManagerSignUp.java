package com.example.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ManagerSignUp extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText confirmPassword;
    EditText name;
    Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_manager);
        final View managerSignUpView = getLayoutInflater().inflate(R.layout.sign_up_manager, null);
        email = (EditText) managerSignUpView.findViewById(R.id.editTextTextEmailAddress2);
        password = (EditText) managerSignUpView.findViewById(R.id.editTextTextPassword);
        confirmPassword = (EditText) managerSignUpView.findViewById(R.id.editTextTextPassword2);
        sign_up = (Button) managerSignUpView.findViewById(R.id.button);
        name =  (EditText) managerSignUpView.findViewById(R.id.editTextTextPassword3);
    }
}
