package com.example.dltqjm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.coolweather.app.R;

public class xgmmjm extends ljd implements OnClickListener {
	sql aa; SQLiteDatabase db;
	EditText ed1;
	EditText ed2;EditText ed3;//TextView tv1;
	String name;String names;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.xgmmjm);
    	aa = new sql(this, "fb", null, 3);
    	db = aa.getWritableDatabase();
    	ed1 = (EditText) findViewById(R.id.editText1_xgmmjm);
    	ed2 = (EditText) findViewById(R.id.editText2_xgmmjm);
    	ed3 = (EditText) findViewById(R.id.editText3_xgmmjm);
    	//tv1 = (TextView) findViewById(R.id.yzh);
    	Button b1 = (Button) findViewById(R.id.button1_xgmmjm);
    	Button b2 = (Button) findViewById(R.id.button2_xgmmjm);
    	b1.setOnClickListener(this);
    	b2.setOnClickListener(this);
    	
    	Intent intent = getIntent();
		String hl = intent.getStringExtra("hl");
		ed1.setText(hl);
		String d = ed1.getText().toString();
	    if (d.equals("")) {
			//管理员
			Intent intent1 = getIntent();
			String cc = intent1.getStringExtra("hhl");
			ed1.setText(cc);
    }
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1_xgmmjm:
			String dd = ed1.getText().toString();
			String aaa = ed2.getText().toString();
			String ss = ed3.getText().toString();
			Cursor cursor = db.rawQuery("select * from hl where name=?", new String[] { ed1.getText().toString() });
		       while (cursor.moveToNext()) {
			   name = cursor.getString(cursor.getColumnIndex("name"));}

				 Cursor cursors = db.rawQuery("select * from hhl where name=?", new String[] { ed1.getText().toString() });
			       while (cursors.moveToNext()) {
				   names = cursors.getString(cursor.getColumnIndex("name"));}
			       
			       if (aaa.equals(ss)) {
						if (dd.equals(name)) {
							db.execSQL("update hl set password=? where name=?",
									new String[] { ed2.getText().toString(),
									ed1.getText().toString() });
							Intent intent = new Intent(xgmmjm.this, Dltqjm.class);
							startActivity(intent);
							Toast.makeText(this, "你的密码已修改", Toast.LENGTH_SHORT).show();
							activity.finishall();
			}
			else if (dd.equals(names)) {
				db.execSQL("update hhl set password=? where name=?",
						new String[] { ed2.getText().toString(),
						ed1.getText().toString() });
				Intent intent = new Intent(xgmmjm.this, Dltqjm.class);
				startActivity(intent);
				Toast.makeText(this, "你的密码已修改", Toast.LENGTH_SHORT).show();
				activity.finishall();
			}
			else {
				Toast.makeText(xgmmjm.this, "你输入的账号有误，请重新输入", Toast.LENGTH_SHORT).show();
			}
		} else {
             Toast.makeText(this, "密码输入错误，请重新输入", Toast.LENGTH_SHORT).show();
		}
		
		break;
		
	case R.id.button2_xgmmjm:
		Intent intentsss = new Intent(xgmmjm.this, Dltqjm.class);
		startActivity(intentsss);
		activity.finishall();
		break;

	default:
		break;
	}
}
}
