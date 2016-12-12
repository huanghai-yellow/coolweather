package com.example.dltqjm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.coolweather.app.R;
import com.coolweather.app.activity.ChooseAreaActivity;
public class cdjm extends Activity implements OnClickListener {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.cdjm);
	Button b1=(Button)findViewById(R.id.button1_yhgl);
	Button b2=(Button)findViewById(R.id.button1_xwgl);
	b1.setOnClickListener(this);
	b2.setOnClickListener(this);
}

@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	switch (arg0.getId()) {
	case R.id.button1_yhgl:
		Intent intent = new Intent(cdjm.this,xgcx.class);
		startActivity(intent);
		activity.finishall();
		break;
	case R.id.button1_xwgl:
		Intent intent1 = new Intent(cdjm.this,ChooseAreaActivity.class);
		startActivity(intent1);
		activity.finishall();
		break;
	default:
		break;
	}
}
}
