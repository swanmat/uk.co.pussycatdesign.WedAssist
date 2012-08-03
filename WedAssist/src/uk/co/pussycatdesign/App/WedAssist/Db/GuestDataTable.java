package uk.co.pussycatdesign.App.WedAssist.Db;

import uk.co.pussycatdesign.Data.*;

public class GuestDataTable extends DbTable {

	//Database Fields
	protected static final String TBL_GUESTS_ID = "Id";
	protected static final String PRIMARY_KEY = "Id";
	protected static final String TBL_GUESTS_PHOTO = "Photo";
	protected static final String TBL_GUESTS_FNAME = "FName";
	protected static final String TBL_GUESTS_SNAME = "SName";
	protected static final String TBL_GUESTS_TEL = "Tel";
	protected static final String TBL_GUESTS_EMAIL = "Email";
	protected static final String TBL_GUESTS_EXTRAS = "Extras";
	protected static final String TBL_GUESTS_INVITES = "Invites";
	//protected static final String TBL_GUESTS_INVITATION = "Invitation";
	//protected static final String TBL_GUESTS_RSVP = "RSVP";
	protected static final String TBL_GUESTS_NOTES = "Notes";
	protected static final String TBL_GUESTS_ROLE = "Role";
	
	// Database Table Name
	private static final String TBL_GUESTS = "GuestList";
		
	//Database Views
	private static final String TBL_GUESTS_VIEW = "guestView";
	private static final String TBL_GUESTS_VIEW_SQL = 
			"CREATE VIEW " + TBL_GUESTS_VIEW +
			" AS " +
			"SELECT " + TBL_GUESTS_ID + ", " + TBL_GUESTS_PHOTO + ", "
			+ TBL_GUESTS_FNAME +", "+ TBL_GUESTS_TEL +" FROM " +
			TBL_GUESTS;
		
	//Database Triggers
	private static final String TBL_GUESTS_TRIGGER = "guestTrigger";
	
	public GuestDataTable() {
		super(TBL_GUESTS, TBL_GUESTS_TRIGGER, TBL_GUESTS_VIEW, PRIMARY_KEY);
		populate();
	}

	private void populate()
	{
		this.addFieldValue(new DbColumn(TBL_GUESTS_ID, DbFieldType.INT, DbFieldModifier.PRIMARY_KEY));
		this.addFieldValue(new DbColumn(TBL_GUESTS_PHOTO, DbFieldType.INT, DbFieldModifier.NONE));
		this.addFieldValue(new DbColumn(TBL_GUESTS_FNAME, DbFieldType.STRING, DbFieldModifier.NOT_NULL));
		this.addFieldValue(new DbColumn(TBL_GUESTS_SNAME, DbFieldType.STRING, DbFieldModifier.NOT_NULL ));
		this.addFieldValue(new DbColumn(TBL_GUESTS_TEL, DbFieldType.STRING, DbFieldModifier.NOT_NULL));
		this.addFieldValue(new DbColumn(TBL_GUESTS_EMAIL, DbFieldType.STRING, DbFieldModifier.NOT_NULL));
		this.addFieldValue(new DbColumn(TBL_GUESTS_NOTES, DbFieldType.STRING, DbFieldModifier.NOT_NULL));
		this.addFieldValue(new DbColumn(TBL_GUESTS_EXTRAS, DbFieldType.INT, DbFieldModifier.NOT_NULL));
	}

	@Override
	public String getCreateTriggerSql() {
		return null;
	}

	@Override
	public String getCreateViewSql() {
		return TBL_GUESTS_VIEW_SQL;
	}
}
