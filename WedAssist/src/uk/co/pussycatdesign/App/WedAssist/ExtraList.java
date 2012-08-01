package uk.co.pussycatdesign.App.WedAssist;

import uk.co.pussycatdesign.App.WedAssist.Db.ExtraDataTable;
import uk.co.pussycatdesign.App.WedAssist.Db.WedAssistDb;
import uk.co.pussycatdesign.Data.DbFactory;
import uk.co.pussycatdesign.Data.DbManagedList;
import uk.co.pussycatdesign.Data.DbResult;

public class ExtraList extends DbManagedList<Extra, ExtraDataTable, WedAssistDb>
{
	private static final long serialVersionUID = 6913330888186014145L;

	public ExtraList() {
		super(new DbFactory<ExtraDataTable, WedAssistDb>(new ExtraDataTable(), new WedAssistDb()));
	}
	
	public ExtraList(int guestId)
	{
		super(new DbFactory<ExtraDataTable, WedAssistDb>(new ExtraDataTable(), new WedAssistDb()));
		loadExtras(guestId);
	}

	@Override
	protected Extra parse(String[] columns, DbResult item)
	{
		Extra thisExtra = new Extra();
		thisExtra.parseValues(columns, item.getResultSet().toArray());
		return thisExtra;
	}
	
	public int loadExtras(int guestId)
	{
		String whereClause = String.format("%s=?", ExtraDataTable.getExtrasPFK());
		String whereArgs[] = {String.valueOf(guestId)};
		this.loadWhere(whereClause, whereArgs);
		return size();
	}
	
	public long removeExtras(int guestId)
	{
		String whereClause = String.format("%s=?", ExtraDataTable.getExtrasPFK());
		String whereArgs[] = {String.valueOf(guestId)};
		return this.removeWhere(whereClause, whereArgs);
	}
}
