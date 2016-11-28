package com.example.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper{
	public static final String CREATE_PROVINCE="createtableProvince("
			+ "idintegerprimarykeyautoincrement,"
			+ "province_nametext,"
			+ "province_codetext)";
			
			public static final String CREATE_CITY="createtableCity("
			+ "idintegerprimarykeyautoincrement,"
			+ "city_nametext,"
			+ "city_codetext,"
			+ "province_idinteger)";
			
			public static final String CREATE_COUNTY="createtableCounty("
			+ "idintegerprimarykeyautoincrement,"
			+ "county_nametext,"
			+ "county_codetext,"
			+ "city_idinteger)";
			 
			
			public CoolWeatherOpenHelper(Context context,String name,CursorFactory
			factory,int version){
			super(context,name,factory,version);
			}
			@Override
			public void onCreate(SQLiteDatabase db){
			db.execSQL(CREATE_PROVINCE);
				
			db.execSQL(CREATE_CITY);
			
			db.execSQL(CREATE_COUNTY);
			
			}
			@Override
			public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
			{
			}
			


}
