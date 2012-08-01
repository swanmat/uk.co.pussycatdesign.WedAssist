package uk.co.pussycatdesign.App.WedAssist.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GuestDetails extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		TextView tv = new TextView(this);
		
		tv.setText("Hello - this is a GuestDetail Activity");
		
		setContentView(tv);
	}	
	
}