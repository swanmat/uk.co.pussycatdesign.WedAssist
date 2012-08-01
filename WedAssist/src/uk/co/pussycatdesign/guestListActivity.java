package uk.co.pussycatdesign;

import uk.co.pussycatdesign.App.WedAssist.GuestList;
import uk.co.pussycatdesign.App.WedAssist.Activities.GuestListAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class guestListActivity extends Activity 
{
	private ListView guestView;
	private Button btnPopulate;
	
	//private ArrayAdapter<Guest> guestListAdapter;	
	protected GuestList guestList;
	private GuestListAdapter guestListAdapter = null;
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.guestlist);
		this.connectToView();
		this.subscribeToEvents();
	}
	
	private void subscribeToEvents() {
		try
		{
			btnPopulate.setOnClickListener(new OnClickListener() {
			
				public void onClick(View v) {
					btnPopulate_Click();
				}

			});
		}
		catch (NullPointerException e)
		{
			Log.w("WedAssist:guestListActivity",e.toString());
		}
		
	}
	
	private void btnPopulate_Click() {
		
		guestList.loadView();
		guestListAdapter.notifyDataSetChanged();
	}

	private void connectToView()
	{
		this.guestView = (ListView) findViewById(R.id.lvGuests);
		this.btnPopulate = (Button) findViewById(R.id.btnPopulate);
		
		guestList = new GuestList();
		guestListAdapter = new GuestListAdapter(this, R.layout.row2, guestList);
		
		View header = (View) getLayoutInflater().inflate(R.layout.guestlist_table_header, null);
		guestView.addHeaderView(header);
		guestView.setAdapter(guestListAdapter);
	}
}

