/* 25/06/2012
 * RoleList - Matt Swain 
 * PussyCatDesign Copyright 2012
 * 
 */

package uk.co.pussycatdesign.App.WedAssist;

import android.content.ContentValues;
import uk.co.pussycatdesign.App.WedAssist.Db.RoleDataTable;
import uk.co.pussycatdesign.App.WedAssist.Db.WedAssistDb;
import uk.co.pussycatdesign.Data.DbFactory;
import uk.co.pussycatdesign.Data.DbManagedList;

public class RoleList extends DbManagedList<Role, RoleDataTable, WedAssistDb>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1118159611287347533L;

	public RoleList(DbFactory<RoleDataTable, WedAssistDb> factory) {
		super(factory);
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	protected Role parse(ContentValues item) {
		Role role = new Role();
		role.parseValues(item);
		return role;
	}
}
