package uk.co.pussycatdesign.App.WedAssist.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class GuestNotes extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		TextView tv = new TextView(this);
		
		tv.setText("Hello - this is a GuestNote Activity");
		
		setContentView(tv);
	}	
	
}
