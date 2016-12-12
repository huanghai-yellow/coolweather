package com.example.dltqjm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.coolweather.app.R;
import com.coolweather.app.R;

public class xgcx extends ljd implements OnClickListener {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.xgcx);
    	Button b1 = (Button) findViewById(R.id.xgmm);
    	Button b2 = (Button) findViewById(R.id.cxyh);
    	b1.setOnClickListener(this);
    	b2.setOnClickListener(this);

    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.xgmm:
			Intent intent1 = new Intent(xgcx.this,xgmmjm.class);
			Intent intent22 = getIntent();
			String zz = intent22.getStringExtra("hhl");
			intent1.putExtra("hhl", zz);
			startActivity(intent1);
			activity.finishall();
			break;
		case R.id.cxyh:
			Intent intents = new Intent(xgcx.this,cxjm.class);
			startActivity(intents);
			activity.finishall();
			break;

		default:
			break;
		}
	}
}

