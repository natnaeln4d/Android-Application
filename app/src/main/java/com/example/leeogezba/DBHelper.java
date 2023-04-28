package com.example.leeogezba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table creation statement for usersDetails
    private static final String CREATE_TABLE_USERS_DETAILS =
            "CREATE TABLE usersDetails (id INTEGER PRIMARY KEY AUTOINCREMENT, userID TEXT, password TEXT)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS_DETAILS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }
    public Boolean register(String email,String name,String password){
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues values = new ContentValues();
        values.put("userID",email);
        values.put("password",password);



//      values.put(KEY_PH_NO,user.getPhoneNumber());
        long result= db.insert("usersDetails",null,values);
        if (result == -1){
            return false;
        }else {
            return true;
        }


  }
//  User user(int id){
////      SQLiteDatabase db = this.getReadableDatabase();
////      Cursor cursor=db.query(TABLE_USER, new String[] { KEY_ID,
////                      KEY_EMAIL, KEY_PASSWORD }, KEY_ID + "=?",
////              new String[] { String.valueOf(id) }, null, null, null, null);
////      if (cursor != null)
////          cursor.moveToFirst();
////
////      User user=new User(Integer.parseInt(cursor.getString(0)),
////              cursor.getString(1), cursor.getString(2));
////      return user;
//  }
public Cursor getData(String username, String password) {
    SQLiteDatabase db = this.getWritableDatabase();
    String query = "SELECT * FROM usersDetails"  + " WHERE userID = ? AND password = ?";
    String[] selectionArgs = {username, password};
    Cursor cursor = db.rawQuery(query, selectionArgs);
    return cursor;
}



}
