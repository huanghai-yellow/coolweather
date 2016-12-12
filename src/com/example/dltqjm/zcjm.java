package com.example.dltqjm;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.coolweather.app.R;

public class zcjm extends ljd implements OnClickListener {
    sql aa;SQLiteDatabase db;
    EditText ed1;EditText ed2;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.zcjm);
    	aa = new sql(this, "fb", null, 3);
    	db = aa.getWritableDatabase();
    	Button b1 = (Button) findViewById(R.id.button1_zcjm);
    	Button b2 = (Button) findViewById(R.id.button2_zcjm);
    	ed1 = (EditText) findViewById(R.id.editText1_zcjm);
        ed2 = (EditText) findViewById(R.id.editText2_zcjm);
    	b1.setOnClickListener(this);
    	b2.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1_zcjm:
			db.execSQL("insert into hl(name,password) values(?,?)",new String[]{ed1.getText().toString(),ed2.getText().toString()});
			Toast.makeText(this, "×¢²á³É¹¦", Toast.LENGTH_SHORT).show();
			Intent intents = new Intent(zcjm.this,Dltqjm.class);
			startActivity(intents);
			activity.finishall();
			break;
        case R.id.button2_zcjm:
        	Intent intent = new Intent(zcjm.this,Dltqjm.class);
			startActivity(intent);
			activity.finishall();
			break;

		default:
			break;
		}
	}
}

