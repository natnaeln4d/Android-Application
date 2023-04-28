package com.example.leeogezba;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLCon {
    Connection con;
    @SuppressLint("NewApi")
    public Connection connect(){
//        String ip = "172.1.2.2", port = "1433", db = "mytestdb", username = "sa", password = "yourpass";
        StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(a);



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/java_tuto";
            String usernam="natnaeln4d";
            String pwd="natty@123";
            con = (Connection) DriverManager.getConnection(url, usernam, pwd);

        } catch (Exception e) {
            Log.e("Error :", e.getMessage());
        }
        return con;
    }
}
