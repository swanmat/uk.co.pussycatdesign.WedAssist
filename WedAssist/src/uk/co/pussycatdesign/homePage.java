package uk.co.pussycatdesign;

import uk.co.pussycatdesign.App.WedAssist.*;
import uk.co.pussycatdesign.App.WedAssist.Db.*;
import uk.co.pussycatdesign.Data.DbFactory;
import uk.co.pussycatdesign.Data.DbManagedList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class homePage extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
        
       Button sqlOpen = (Button) findViewById(R.id.btnNew);
       Button btnGuest = (Button) findViewById(R.id.btnGuest);
       Button btnGuestList = (Button) findViewById(R.id.btn_GuestList);
       
       final TextView tvLabel = (TextView) findViewById(R.id.tv_label);
       
       
       sqlOpen.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//GuestList list = new GuestList(new DbFactory<GuestDataTable, WedAssistDb>(new GuestDataTable(), new WedAssistDb(homePage.this)));
			GuestList list = new GuestList();
			//ExtraList extras = new ExtraList(homePage.this);
			//RoleList roles = new RoleList(homePage.this);
			System.out.println("WA: Hello World...");
			if (list.loadView())
			{	
				
				String text = String.format("%s\n\n%s\n\n%s\n\n%s\n\n%s\n\n%s\n", 
						new GuestDataTable().getCreateTableSql(),
						new ExtraDataTable().getCreateTableSql(),
						new RoleDataTable().getCreateTableSql(),
						String.format("No Of Rows Set in Guest List: %s", String.valueOf(list.size()),
						String.format("No Of Rows Set in Extras List: %s", "S"),
						String.format("No Of Rows Set in Roles List: %s", "s")));
				
				tvLabel.setText(text);
			}
			else
			{
				tvLabel.setText("Cursor is currently empty...");
			}
			
		}
	});
       
       btnGuest.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			Intent openGuestMain = new Intent("uk.co.pussycatdesign.GUESTACTIVITY");
			startActivity(openGuestMain);
		}
	});
       
       btnGuestList.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			
			Intent openGuestList = new Intent("uk.co.pussycatdesign.GUESTLISTACTIVITY");
			startActivity(openGuestList);
		}
	});
      
       }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
    
    
}