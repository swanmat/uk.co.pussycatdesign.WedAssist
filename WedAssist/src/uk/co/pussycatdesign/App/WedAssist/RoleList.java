/* 25/06/2012
 * RoleList - Matt Swain 
 * PussyCatDesign Copyright 2012
 * 
 */

package uk.co.pussycatdesign.App.WedAssist;

import uk.co.pussycatdesign.App.WedAssist.Db.RoleDataTable;
import uk.co.pussycatdesign.App.WedAssist.Db.WedAssistDb;
import uk.co.pussycatdesign.Data.DbFactory;
import uk.co.pussycatdesign.Data.DbManagedList;
import uk.co.pussycatdesign.Data.DbResult;
import uk.co.pussycatdesign.Data.DbResultSet;

public class RoleList extends DbManagedList<Role, RoleDataTable, WedAssistDb>{

	public RoleList(DbFactory<RoleDataTable, WedAssistDb> factory) {
		super(factory);
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1118159611287347533L;


	@Override
	protected Role parse(String[] columns, DbResult item) {
		// TODO Auto-generated method stub
		return null;
	}

}
