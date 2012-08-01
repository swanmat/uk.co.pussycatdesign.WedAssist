package uk.co.pussycatdesign;

import android.app.Application;
import android.content.Context;

public class WedAssist extends Application 
{
	private static Context context; 
	 
    public void onCreate(){ 
        super.onCreate(); 
        WedAssist.context = getApplicationContext(); 
    } 
 
    public static Context getAppContext() 
    { 
        return WedAssist.context; 
    } 

}
