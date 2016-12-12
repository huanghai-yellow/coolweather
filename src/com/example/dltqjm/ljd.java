package com.example.dltqjm;

import android.app.Activity;
import android.os.Bundle;

public class ljd extends Activity {
	  @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	// TODO Auto-generated method stub
	    	super.onCreate(savedInstanceState);
	    	activity.addactivity(this);
	    }
	       @Override
	    protected void onDestroy() {
	    	// TODO Auto-generated method stub
	    	super.onDestroy();
	    	activity.removeActivity(this);
	    }
	}

