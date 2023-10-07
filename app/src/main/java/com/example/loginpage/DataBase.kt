package com.example.loginpage

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DataBase(val context : Context, val factory : SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context,"app",factory,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, password TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUsers(user : User){
        val values = ContentValues()
        values.put("name",user.name)
        values.put("login",user.login)
        values.put("password",user.login)

        val db = this.writableDatabase
        db.insert("users",null,values)
        db.close()
    }

    fun getUser(login : String, password : String) : Boolean {
        val db = this.readableDatabase

        val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND  password = '$password'",null)

        return result.moveToFirst()
    }

}