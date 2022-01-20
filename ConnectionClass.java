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


}
