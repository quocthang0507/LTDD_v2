package com.example.lab14_15.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.lab14_15.Account;

public class SQLiteHelper extends SQLiteOpenHelper {

    Context context;
    private static String DB_NAME = "account.db";
    SQLiteDatabase myDB;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
        myDB = new SQLiteDatabase();
    }

    public void openDB() throws SQLException {
        if (myDB == null)
            myDB = getWritableDatabase();
    }

    public void closeDB() {
        if (myDB != null)
            myDB.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createTable() {

        String query = "create table if not exists Account (email text PRIMARY KEY, password text)";
        myDB.execSQL(query);
    }

    public void insert(Account acc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", acc.getUser());
        contentValues.put("password", acc.getPass());

        myDB.insert("Account", null, contentValues);
    }

    public boolean login(String email, String pass) {
        String query = "select * from account where email ='" + email + "' and password='" + pass + "'";
        Cursor cursor = myDB.rawQuery(query, null);

        return (cursor.getCount() > 0) ? true : false;
    }
}
