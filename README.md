# Kids-Manager

Anadroid application.
Stop at sql server problem. port = 1433
 public static String ip= "192.168.1.7:1433"; // SQL Server IP Address
    public static String user_name ="KidsManager"; // SQL Server User name
    public static String password = "2232"; // SQL Server Password
    public static String database = "KidsManager"; // SQL Server Database




package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public static String ip= "192.168.1.7:1433"; // SQL Server IP Address
    public static String user_name ="dani"; // SQL Server User name
    public static String password = "1234"; // SQL Server Password
    public static String database = "tests"; // SQL Server Database

    /*Connection con;

    @SuppressLint("NewApi")
    public Connection conclass() {
        String ip = "192.168.1.7", port = "1433", db = "KidsManager", username = "DESKTOP-1QIGJNA\\SQLSERVER", password = "Dbhtk100";
        StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(a);
        String connectURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + db + ";user=" + username + ";"+"password=" + password + ";";
            con = DriverManager.getConnection(connectURL);
        } catch (Exception e) {
            Log.e("Error :", e.getMessage());
        }
        return con;
    }*/


}


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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParentSignUp extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText confirmPassword;
    Button sign_up;
    EditText name;
    Connection connection1;
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
                /*status = (TextView) findViewById(R.id.status);
                ConnectionClass c = new ConnectionClass();
                connection = c.conclass();
                /*if (c != null) {
                    try{
                        String sqlstatement = "SELECT name FROM Register";
                        Statement smt = connection.createStatement();
                        ResultSet set = smt.executeQuery(sqlstatement);
                        while (set.next()) {
                            status.setText(set.getString(2));
                        }
                        connection.close();

                    } catch (Exception e) {
                        Log.e("Error: ", e.getMessage());
                    }
                }*/
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
            //status.setText("Registration Successful");
            name.setText("");
            email.setText("");
            password.setText("");
            confirmPassword.setText("");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                connection1 = connection_class(ConnectionClass.user_name.toString(), ConnectionClass.password.toString(),
                        ConnectionClass.database.toString(), ConnectionClass.ip.toString());
                if (connection1 == null) {
                    z = "Check Internet Connection";

                }
                else {
                    String sql = "INSERT INTO test (name,password, email) VALUES ('d', 'd', 'd')";
                    statement = connection1.createStatement();
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
        Connection connection = null;
        String connectionUrl = null;
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String url = "jdbc:jtds:sqlserver://192.168.1.7:1433;databasename=tests;integratedSecurity=true;";
            String userName = "DESKTOP-1QIGJNA\\dr100";
            String pw = "Dbhtk100";
            connectionUrl = "jdbc:jtds:sqlserver://" + server + "/" + database + ";user=" + user + ";"+"password=" + password + ";";
            connection = DriverManager.getConnection(connectionUrl);
            //connection = DriverManager.getConnection(url, userName, pw);
        }catch (Exception e){
            Log.e("SQL Connection Error : ", e.getMessage());
            status.setText(e.getMessage());
        }

        return connection;

    }
}
