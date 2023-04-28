package com.example.leeogezba;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    Connection con;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     dbHelper=new DBHelper(this);



        EditText userName=(EditText)findViewById(R.id.username);
        EditText name=(EditText)findViewById(R.id.name);
        EditText password=(EditText)findViewById(R.id.password);


        Button btn=(Button) findViewById(R.id.login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=userName.getText().toString();

                String nm=name.getText().toString();
                String pw=password.getText().toString();
                String unn="natty";
                boolean check=unn.equals(user);
                if(userName.getText().equals("") || name.getText().equals("") || password.getText().equals(""))
                {
                    androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle(nm);
                    builder.setMessage("fill all inputs fields please");
                    builder.show();
                }
//if(check) {
//    CharSequence text = "successful";
//    Context context = getApplicationContext();
//    int duration = Toast.LENGTH_SHORT;
//    Toast toast = Toast.makeText(context, text, duration);
//    toast.show();
//    Intent intent = new Intent(MainActivity.this, LoginPage.class);
//    startActivity(intent);
//}
//else {
//    CharSequence text = "not successful";
//    Context context = getApplicationContext();
//    int duration = Toast.LENGTH_SHORT;
//    Toast toast = Toast.makeText(context, text, duration);
//    toast.show();
//
//
//}
                Intent intent=new Intent(MainActivity.this,LoginPage.class);
                intent.putExtra("name",nm);
                intent.putExtra("email",user);
                intent.putExtra("password",pw);
                startActivity(intent);

            }
        });
    }



}