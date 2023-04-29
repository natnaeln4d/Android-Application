package com.example.leeogezba;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FULL_NAME = "full_name";
    private static final String COLUMN_JOB = "job";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_PHOTO_URL = "photo_url";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FULL_NAME + " TEXT,"
                + COLUMN_JOB + " TEXT,"
                + COLUMN_ADDRESS + " TEXT,"
                + COLUMN_PHOTO_URL + " INTEGER"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FULL_NAME, user.getFullName());
        values.put(COLUMN_JOB, user.getJob());
        values.put(COLUMN_ADDRESS, user.getAddress());
        values.put(COLUMN_PHOTO_URL, user.getPhotoUrl());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<User> getAllUsers() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<User> userList = new ArrayList<>();


        String[] columns = {
                UserContract.UserEntry.COLUMN_ID,
                UserContract.UserEntry.COLUMN_NAME,
                UserContract.UserEntry.COLUMN_JOB,
                UserContract.UserEntry.COLUMN_ADDRESS,
                UserContract.UserEntry.COLUMN_PHOTO_URL
        };

        Cursor cursor = db.query(UserContract.UserEntry.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                null);

        while(cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_NAME));
            String job = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_JOB));
            String address = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_ADDRESS));
            int photoUrl = cursor.getInt(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_PHOTO_URL));
            String[] columnNames = cursor.getColumnNames();
            Log.d(TAG, "Column names: " + Arrays.toString(columnNames));
            User user = new User(id, name, job, address, photoUrl);
            userList.add(user);
        }

        cursor.close();
        db.close();

        return userList;
    }
    public long deleteEnter(String rowId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COLUMN_ID+ "=?",new String[]{
                rowId
        } );
    }

}
