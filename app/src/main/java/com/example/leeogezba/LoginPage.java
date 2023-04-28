package com.example.leeogezba;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {


    EditText email , password;
    Button btnSubmit;
    TextView createAcc;
    DBHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Bundle bundle=getIntent().getExtras();
        String user=bundle.getString("email");
        String nm=bundle.getString("name");
        String pass=bundle.getString("password");
        androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
        builder.setCancelable(true);
        builder.setTitle(nm);
        builder.setMessage("welcome "+user+"\n"
                +"this app helps you to find a user");
        builder.show();

        email=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnSubmit = findViewById(R.id.btnSubmit_login);
        dbHelper = new DBHelper(this);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailCheck = email.getText().toString();
                String passCheck = password.getText().toString();
//                Cursor cursor = dbHelper.getData(emailCheck, passCheck);
                if(emailCheck.equals(user)&&passCheck.equals(pass)){
                    Intent intent=new Intent(LoginPage.this,MainActivity2.class);
                    startActivity(intent);

                }
                else {
                    androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
                    builder.setCancelable(true);
                    builder.setTitle("Login error");
                    builder.setMessage("wrong email or password sign up again");
                    builder.show();

                }

//                if (cursor.getCount() == 1) {
//                    Toast.makeText(LoginPage.this, "No entries Exists", Toast.LENGTH_LONG).show();
//                }
//                if(cursor.moveToFirst()) {
//
//                    String name = cursor.getString(cursor.getColumnIndex("name"));
//                    String email = cursor.getString(cursor.getColumnIndex("email"));
//                    String username = cursor.getString(cursor.getColumnIndex("username"));
//                    String password = cursor.getString(cursor.getColumnIndex("password"));
//                }

//                if (loginCheck(cursor, emailCheck, passCheck)) {
//                    Intent intent = new Intent(LoginPage.this, MainActivity.class);
//                    intent.putExtra("email", emailCheck);
//                
//                    startActivity(intent);
//                } else {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
//                    builder.setCancelable(true);
//                    builder.setTitle("Wrong Credential");
//                    builder.setMessage("Wrong Credential");
//                    builder.show();
//                }

            }
        });
        createAcc=findViewById(R.id.createAcc);
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public static boolean loginCheck(Cursor cursor, String emailCheck, String passCheck) {
        while (cursor.moveToNext()){
            if (cursor.getString(0).equals(emailCheck)) {
                if (cursor.getString(2).equals(passCheck)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}