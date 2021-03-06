package uk.co.pussycatdesign.App.WedAssist.Db;

import uk.co.pussycatdesign.Data.DbColumn;
import uk.co.pussycatdesign.Data.DbFieldModifier;
import uk.co.pussycatdesign.Data.DbFieldType;
import uk.co.pussycatdesign.Data.DbTable;

 public class ExtraDataTable extends DbTable {

	// Database Fields
	
	private static final String TBL_EXTRAS = "ExtraList";
	protected static final String TBL_EXTRAS_ID = "Id";
	protected static final String TBL_EXTRAS_NAME = "Name";
	protected static final String TBL_EXTRAS_TYPE = "Type";
	protected static final String TBL_EXTRAS_PFK = "GuestId";
	
	
	//Database Columns
	protected static final DbColumn COL_ID = new DbColumn(TBL_EXTRAS_ID, DbFieldType.INT, 
			DbFieldModifier.PRIMARY_KEY);
	
	protected static final DbColumn COL_NAME = new DbColumn(TBL_EXTRAS_NAME, DbFieldType.STRING, 
			DbFieldModifier.NOT_NULL);
	
	protected static final DbColumn COL_TYPE = new DbColumn(TBL_EXTRAS_TYPE, DbFieldType.STRING, 
			DbFieldModifier.NOT_NULL);
	
	protected static final DbColumn COL_PFK = new DbColumn(TBL_EXTRAS_PFK, DbFieldType.INT, 
			DbFieldModifier.NOT_NULL);
	

	public ExtraDataTable() {
		super(TBL_EXTRAS, 
				TBL_EXTRAS_TRIGGER,
				TBL_EXTRAS_VIEW, 
				TBL_EXTRAS_ID);
		
		super.addFieldValue(COL_ID);
		super.addFieldValue(COL_NAME);
		super.addFieldValue(COL_TYPE);
		super.addFieldValue(COL_PFK);
	}
	
	//Database View
	private static final String TBL_EXTRAS_VIEW = "extraView";
		
	//Database Trigger
	private static final String TBL_EXTRAS_TRIGGER = "extraTrigger";
	

	@Override
	public String getCreateTriggerSql() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String getExtrasPFK()
	{
		return TBL_EXTRAS_PFK;
	}

	@Override
	public String getCreateViewSql() {
		// TODO Auto-generated method stub
		return null;
	}
}
