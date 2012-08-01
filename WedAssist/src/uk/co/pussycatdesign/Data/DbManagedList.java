package uk.co.pussycatdesign.Data;

import java.util.ArrayList;
import java.util.ListIterator;

import android.content.Context;
import uk.co.pussycatdesign.App.WedAssist.Guest;
import uk.co.pussycatdesign.App.WedAssist.Db.GuestDataTable;
import uk.co.pussycatdesign.App.WedAssist.Db.WedAssistDb;
import uk.co.pussycatdesign.Interfaces.DataContext;

public abstract class DbManagedList<E extends SelfTrackingEntity,
		T extends DbTable, D extends DataContext> extends ArrayList<E>
{

	private static final long serialVersionUID = 6081997360864094951L;
	
	private DbFactory<T, D> factory = null;

	public DbManagedList(DbFactory<T, D> factory) 
	{
		this.factory = factory;
	}
	
	protected int parseResult(DbResultSet resultSet)
	{
		String columnNames[] = resultSet.getDbColumns();
		int addCount = 0;
	
		for (int index = 0; index < resultSet.size(); index ++)
		{
			DbResult result = resultSet.get(index);
			this.add(index, parse(columnNames, result));
			addCount ++;
		}
		return addCount;
	}
	
	protected abstract E parse (String[] columns, DbResult item);
	
	public boolean loadView()
	{
		DbResultSet res = factory.loadView();
		
		if (!(res == null))
		{
			parseResult(res);
			
			return true;
		}
		return false;
	}
	
	public boolean loadList()
	{
		DbResultSet res = factory.loadList();
		
		if (!(res == null))
		{
			parseResult(res);
			
			return true;
		}
		return false;
	}
	
	@Override
	public boolean add(E object) {
		
		if(factory.addItem(object.getValues(false)) != -1)
		{
			return super.add(object);
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean remove(Object object) {
		if(factory.removeItem(((SelfTrackingEntity) object).getId())!=1)
		{
			return super.remove(object);
		}
		else
		{
			return false;
		}	
	} // Maybe the other one here.
	
	public long removeWhere(String whereClause, String[] whereArgs)
	{
		return factory.removeWhere(whereClause, whereArgs);
	}
	
	public int loadWhere(String whereClause, String[] whereArgs)
	{
		return search(null, whereClause, whereArgs, null, null, null);
	}
	
	public int search(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
	{
		DbResultSet res = factory.query(columns, selection, selectionArgs, groupBy, having, orderBy);
				
		if (!(res == null))
		{
			parseResult(res);
			
			return this.size();
		}
		return 0;
	}
	
	public void refresh()
	{
		this.clear();
		loadList();
	}
		
}

