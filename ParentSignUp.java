package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ParentSignUp extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText confirmPassword;
    Button sign_up;
    EditText name;
    Connection connection;
    Statement statement;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_parent);
        //final View parentSignUpView = getLayoutInflater().inflate(R.layout.sign_up_parent, null);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        confirmPassword = (EditText) findViewById(R.id.editTextTextPassword2);
        sign_up = (Button) findViewById(R.id.button);
        name =  (EditText) findViewById(R.id.editTextTextPassword3);
        status = (TextView) findViewById(R.id.status);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ParentSignUp.registerUser().execute("");
            }
        });

    }

    public class registerUser extends AsyncTask<String, String, String>{

        String z ="";
        Boolean isSuccess = false;

        public registerUser() {
            super();
        }

        @Override
        protected void onPreExecute() {
            status.setText("Sending Data to Database");
        }

        @Override
        protected void onPostExecute(String s) {
            status.setText("Registration Successful");
            name.setText("");
            email.setText("");
            password.setText("");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                connection = connection_class(ConnectionClass.user_name.toString(), ConnectionClass.password.toString(),
                        ConnectionClass.database.toString(), ConnectionClass.ip.toString());
                if (connection == null) {
                    z = "Check Internet Connection";
                }
                else {
                    String sql = "INSERT INTO Register (name,email,password) VALUES ('"+name.getText()+"','"+email.getText()
                            +"','"+password.getText();
                    statement = connection.createStatement();
                    statement.executeUpdate(sql);
                }
            }
            catch (Exception e) {
                isSuccess = false;
                z = e.getMessage();
            }
            return null;
        }
    }

    @SuppressLint("NewApi")
    public Connection connection_class (String user, String password, String database, String server) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connetion = null;
        String connectionUrl = null;
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionUrl = "jdbc:jtds:sqlserver://" + server+"/" + database + ";user=" + user + ";password=" + password + ";";
            connection = DriverManager.getConnection(connectionUrl);
        }catch (Exception e){
            Log.e("SQL Connection Error : ", e.getMessage());
        }

        return connection;

    }
}
