package com.example.dltqjm;

import com.example.dltqjm.Dltqjm;
import com.coolweather.app.R;
import com.example.dltqjm.activity;
import com.example.dltqjm.cdjm;
import com.example.dltqjm.sql;
import com.example.dltqjm.zcjm;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;
import android.preference.PreferenceManager;

public class Dltqjm extends Activity implements OnClickListener{
	 private sql aa; 
	 SQLiteDatabase db;
	    EditText ed1;
	    EditText ed2;
	    
	    CheckBox cb;
	    SharedPreferences pf;
	    SharedPreferences.Editor ed;
	    
	    Button b1;Button b2;Button b3;
	    String name;int password;String passwords;    String names;int passwordes;String passwordss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dltqjm);
        aa = new sql(this, "fb", null, 3);
    	db = aa.getWritableDatabase();
    	//db.execSQL("insert into hl (name,password) values(?,?)",new String[]{"h","110"});
    	//db.execSQL("insert into hl (name,password) values(?,?)",new String[]{"hh","120"});
    	//db.execSQL("insert into hl (name,password) values(?,?)",new String[]{"hhh","119"});
    	db.execSQL("insert into hhl (name,password) values(?,?)",new String[]{"admin","1111"});
    	ed1 = (EditText) findViewById(R.id.editText1_dlzc);
    	ed2 = (EditText) findViewById(R.id.editText2_dlzc);
    	
    	cb = (CheckBox) findViewById(R.id.checkBox_dlzc);
    	pf=PreferenceManager.getDefaultSharedPreferences(this);
    	boolean isRemember=pf.getBoolean("checkBox_dlzc", false);
    	
    	b1 = (Button) findViewById(R.id.button1_dlzc);
    	b2 = (Button) findViewById(R.id.button2_dlzc);
    	b1.setOnClickListener(this);
    	b2.setOnClickListener(this);
    	
       if (isRemember) {
		String name=pf.getString("name", "");
		String passwords=pf.getString("passwords", "");
		ed1.setText(name);
		ed2.setText(passwords);
		cb.setChecked(true);
	}
    		
		}
    	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1_dlzc:
			//检查账号和密码正不正确
			Cursor cursor = db.rawQuery("select * from hl where name=?", new String[]{ed1.getText().toString()});
			while (cursor.moveToNext()) {
				 name = cursor.getString(cursor.getColumnIndex("name"));
				 password = cursor.getInt(cursor.getColumnIndex("password"));
				 passwords = String.valueOf(password);  
			}
			cursor.close();
			//
			Cursor cursors = db.rawQuery("select * from hhl where name=?", new String[]{ed1.getText().toString()});
			    while (cursors.moveToNext()) {
				names = cursors.getString(cursor.getColumnIndex("name"));
				passwordes = cursors.getInt(cursor.getColumnIndex("password"));
				passwordss = String.valueOf(passwordes);
			}
			   cursors.close();
			   if (ed1.getText().toString().equals(name) && ed2.getText().toString().equals(passwords)) {
					Intent intent = new Intent(Dltqjm.this,cdjm.class);
				
					
					 String ed11 = ed1.getText().toString();
					 intent.putExtra("h1", ed11);
					 
					 ed = pf.edit();
						if (cb.isChecked()) {
							ed.putBoolean("checkBox_dlzc", true);
							ed.putString("name",ed1.getText().toString());
							ed.putString("passwords", ed2.getText().toString());
						}
						else {
							ed.clear();
						}
						ed.commit();
					startActivity(intent);
//					activity.finishall();
				}else if (ed1.getText().toString().equals(names) && ed2.getText().toString().equals(passwordss)) {
			         // Intent intent22=new Intent(Dlzc.this,xwlbs.class);
					Intent intent22=new Intent(Dltqjm.this,cdjm.class);
			          String ed12 = ed1.getText().toString();
			          intent22.putExtra("hhl", ed12);
			          ed = pf.edit();
						if (cb.isChecked()) {
							ed.putBoolean("checkBox_dlzc", true);
							ed.putString("name", ed1.getText().toString());
							ed.putString("passwords",  ed2.getText().toString());
						}
						else {
							ed.clear();
						}
						ed.commit();
			          startActivity(intent22);
//					activity.finishall();
				} else {
					Toast.makeText(this, "你输入的账号有误，请重新输入", Toast.LENGTH_SHORT).show();
				} {
					//管理员				 			
					
																		
	}
			break;
        case R.id.button2_dlzc:
			  Intent intents = new Intent(Dltqjm.this,zcjm.class);
			  startActivity(intents);
			  activity.finishall();
			break;	

		default:
			break;
		}
	}
}


