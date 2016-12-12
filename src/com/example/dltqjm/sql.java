package com.example.dltqjm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class sql extends SQLiteOpenHelper{
	 String sql = "create table hl(id integer primary key autoincrement,name text,password int)";
	    String sqls = "create table hhl(id integer primary key autoincrement,name text,password int)";
	    String sqles = "create table xinwen(id integer primary key autoincrement,title text,texts text)";
		public sql(Context context, String name, CursorFactory factory, int version) {
			super(context, name, factory, version);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(sql);
			db.execSQL(sqls);
			db.execSQL(sqles);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			db.execSQL("drop table if exists hl");
			db.execSQL("drop table if exists hhl");
			db.execSQL("drop table if exists xinwen");
			onCreate(db);
		}

	}

