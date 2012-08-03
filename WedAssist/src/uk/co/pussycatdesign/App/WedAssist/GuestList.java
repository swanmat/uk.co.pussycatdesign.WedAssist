package uk.co.pussycatdesign.App.WedAssist;

import android.content.ContentValues;
import uk.co.pussycatdesign.App.WedAssist.Db.GuestDataTable;
import uk.co.pussycatdesign.App.WedAssist.Db.WedAssistDb;
import uk.co.pussycatdesign.Data.DbFactory;
import uk.co.pussycatdesign.Data.DbManagedList;


public class GuestList extends DbManagedList<Guest, GuestDataTable, WedAssistDb> {
	
	private static final long serialVersionUID = 7069688655390631494L;

	public GuestList()
	{
		super(new DbFactory<GuestDataTable, WedAssistDb>(new GuestDataTable(), new WedAssistDb()));
	}

	@Override
	protected Guest parse(ContentValues item) {
		Guest thisGuest = new Guest();
		thisGuest.parseValues(item);
		return thisGuest;
	}
}