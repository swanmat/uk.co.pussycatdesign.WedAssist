package uk.co.pussycatdesign.App.WedAssist.Db;


import uk.co.pussycatdesign.Data.DbColumn;
import uk.co.pussycatdesign.Data.DbFieldModifier;
import uk.co.pussycatdesign.Data.DbFieldType;
import uk.co.pussycatdesign.Data.DbTable;

public class RoleDataTable extends DbTable {

	// Database Fields
	protected static final String TBL_ROLES = "RoleList";
	protected static final String TBL_ROLES_ID = "Id";
	protected static final String TBL_ROLES_PFK = "GuestId";
	protected static final String TBL_ROLES_ROLE = "Role";
	protected static final String TBL_ROLES_OTHER = "Info";
	
	// Database Columns
	protected static final DbColumn COL_ID = new DbColumn(TBL_ROLES_ID, 
			DbFieldType.INT, DbFieldModifier.PRIMARY_KEY);
	
	protected static final DbColumn COL_PFK = new DbColumn(TBL_ROLES_PFK, 
			DbFieldType.INT, DbFieldModifier.NOT_NULL);
	
	protected static final DbColumn COL_ROLE = new DbColumn(TBL_ROLES_ROLE, 
			DbFieldType.INT, DbFieldModifier.NOT_NULL);
	
	protected static final DbColumn COL_OTHER = new DbColumn(TBL_ROLES_OTHER, 
			DbFieldType.STRING, DbFieldModifier.NONE);
	
	public RoleDataTable() {
		super(TBL_ROLES,
				TBL_ROLES_TRIGGER,
				TBL_ROLES_VIEW,
				TBL_ROLES_ID);
		
		super.addFieldValue(COL_ID);
		super.addFieldValue(COL_PFK);
		super.addFieldValue(COL_ROLE);
		super.addFieldValue(COL_OTHER);
	}

	//Database Views
	private static final String TBL_ROLES_VIEW = "roleView";

	//Database Triggers
	private static final String TBL_ROLES_TRIGGER = "roleTrigger";

	@Override
	public String getCreateTriggerSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCreateViewSql() {
		// TODO Auto-generated method stub
		return null;
	}
}
