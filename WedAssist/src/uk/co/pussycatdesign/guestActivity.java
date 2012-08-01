package uk.co.pussycatdesign;

import uk.co.pussycatdesign.R;
import uk.co.pussycatdesign.App.WedAssist.Guest;
import uk.co.pussycatdesign.App.WedAssist.GuestList;
import uk.co.pussycatdesign.App.WedAssist.Db.GuestDataTable;
import uk.co.pussycatdesign.App.WedAssist.Db.WedAssistDb;
import uk.co.pussycatdesign.Data.DbFactory;
import uk.co.pussycatdesign.Data.DbManagedList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class guestActivity extends Activity
{
	private EditText txtName, txtAddress, txtTelephone, txtEmail, txtNotes;
	private Spinner spnRoles;
	private TextView tvStatus;
	private Button btnAdd;
	
	private GuestList guestList;

	private void connectToView()
	{
		txtName = (EditText) findViewById(R.id.txtName);
		txtAddress = (EditText) findViewById(R.id.txtAddress);
		txtTelephone= (EditText) findViewById(R.id.txtTelephone);
		txtNotes = (EditText) findViewById(R.id.txtNotes);
		txtEmail = (EditText) findViewById(R.id.txtEmail);
		spnRoles = (Spinner) findViewById(R.id.spnRole);
		tvStatus = (TextView) findViewById(R.id.txtStatus);
		btnAdd = (Button) findViewById(R.id.btnAdd);
	}
	
	private void subscribeToHandlers()
	{
		try
		{
			btnAdd.setOnClickListener(new OnClickListener() {
			
				public void onClick(View v) {
					btnAdd_Click();
				}
			});
		}
		catch (NullPointerException e)
		{
			setMessage(e.toString());
		}
	}
	
	protected final void btnAdd_Click()  {
		
		Guest newGuest = new Guest(
				0,
				txtName.getText().toString(),
				txtName.getText().toString(),
				txtTelephone.getText().toString(),
				txtEmail.getText().toString(), 
				txtNotes.getText().toString());
		
		guestList.add(newGuest);
		getGuestCount();
	}

	private void setMessage(String message)
	{
		this.tvStatus.setText(message);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.guestmain);
		connectToView();
		subscribeToHandlers();
		//guestList = new GuestList(new DbFactory<GuestDataTable, WedAssistDb>(new GuestDataTable(), new WedAssistDb(this)));
		
		guestList = new GuestList();
		
		getGuestCount();
	}
	

	private void getGuestCount() {
		guestList.refresh();
		setMessage(String.format("%s Guest Records", String.valueOf(guestList.size())));
	}
}
