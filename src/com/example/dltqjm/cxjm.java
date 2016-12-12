package com.example.dltqjm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.coolweather.app.R;

public class cxjm extends ljd{
	sql aa; SQLiteDatabase db;
	EditText ed1;     
	int password;String name;TextView tv1;
	@Override
        protected void onCreate(Bundle savedInstanceState) {
        	// TODO Auto-generated method stub
        	super.onCreate(savedInstanceState);
        	requestWindowFeature(Window.FEATURE_NO_TITLE);
        	setContentView(R.layout.cxjm);
        	aa = new sql(this, "fb", null, 3);
        	db = aa.getWritableDatabase();
        	ed1 = (EditText) findViewById(R.id.editText_cxjm);
        	tv1 = (TextView) findViewById(R.id.textView_cxjm);
        	Button b1 = (Button) findViewById(R.id.button1_cxjm);
        	Button b2=(Button) findViewById(R.id.button1_scyh);
        	b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				Cursor cursor= db.rawQuery("select * from hl where name=?", new String[]{ed1.getText().toString()});
				while (cursor.moveToNext()) {
					 name = cursor.getString(cursor
							.getColumnIndex("name"));
					 password = cursor.getInt(cursor
							.getColumnIndex("password"));
				}
				cursor.close();
				tv1.setText("’À∫≈:" + name + '\n' + "√‹¬Î:" + password);
				}
			});
        	b2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					db.execSQL("delete from hl where name=?", new String[]{ed1.getText().toString()});
					tv1.setText("");
				}
			});
	}
}


