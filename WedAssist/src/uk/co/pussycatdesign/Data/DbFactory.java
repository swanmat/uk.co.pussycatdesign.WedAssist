package uk.co.pussycatdesign.Data;

import java.util.Hashtable;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import uk.co.pussycatdesign.Interfaces.DataContext;

public class DbFactory<T extends DbTable, D extends DataContext>
{
		
	private T referenceItem;
	private D dataContext;
	private Hashtable<String, Object> tableSchema;
	
	public DbFactory(T ref, D db)
	{
		this.referenceItem = ref;
		this.dataContext = db;
		//this.tableDescriptor = referenceItem.getTableDescriptor();
		this.tableSchema = referenceItem.getTableSchema();
	}
	
	public DbResultSet query(String[] columns, String selection, String[] selectionArgs,
			String groupBy, String having, String orderBy)
	{
		Cursor res = null;
		String tableName = referenceItem.getTableName();
		
		res = dataContext.open().query(tableName, columns, selection,
				selectionArgs, groupBy, having, orderBy);
		
		if (res != null)
		{
			DbResultSet rSet = new DbResultSet();
			
			rSet = loadResults(res);
			
			Log.w("WedAssist:DbFactory", String.format
					("%s successfully loaded into result set", "Custom Query"));
			
			res.close();
			
			return rSet;
		}
		else
		{
			Log.w("WedAssist:DbFactory", String.format("WedAssistDb:DbFactory,",
					String.format("Loading of  %s Failed. SQL Error.", "Custom Query")));
		}
		
		return null;
	}

	public DbResultSet loadView()
	{
		if (!(referenceItem.getViewName() == null))
		{
			String sql = "SELECT * FROM " + referenceItem.getViewName();
			Cursor res = null;
			DbResultSet rSet = null;
			
			res = dataContext.open().rawQuery(sql, null);
				
			if (res != null)
			{
				rSet = loadResults(res);
				
				Log.w("WedAssist:DbFactory", String.format
						("%s successfully loaded into result set", referenceItem.getViewName()));
				
				res.close();
				
				return rSet;
			}
			else
			{
				Log.w("WedAssist:DbFactory", String.format("WedAssistDb:DbFactory,",
						String.format("Loading of View %s Failed. SQL Error.", referenceItem.getViewName())));
			}
		}
		else
		{
			Log.w("WedAssist:DbFactory", String.format("No View Defined for context: %s. *.* Loaded",
					referenceItem.getTableName()));
			return loadList();
		}
		
		return null;
	}
	
	public DbResultSet loadList() // Returns all values based on Generic Type.GetTableColumns
	{
		if (!(tableSchema.isEmpty()))
		{
			DbResultSet rSet = null;
			
			Cursor results = dataContext.open().query(referenceItem.getTableName(), null,
					null, null, null, null, null);
			
			rSet = loadResults(results);
			
			results.close();
			
			return rSet;
		}
		else
		{
			return null;
		}
	}
	
	private DbResultSet loadResults(Cursor results) {
		DbResultSet res = new DbResultSet();
		
		res.setDbColumns(results.getColumnNames());
		
		while (results.moveToNext())
		{
			//int rowIndex = results.getPosition();
			DbResult thisRecord = getResult(results); //getDbResult(results);
			res.add(thisRecord);
			Log.w("WedAssist:DbFactory" ,thisRecord.getString());
		}
		
		return res;
	}

	public DbResult get(int index)
	{
		String selection = String.format("%s=?", referenceItem.getPrimaryKey());
		String selectionArgs[] = {String.valueOf(index)};
		
		return getResult(dataContext.open().query(this.referenceItem.getTableName(),
				null, selection, selectionArgs, null, null, null));
	}
	
	private DbResult getResult(Cursor resultSet)
	{
		DbResult singleton = new DbResult();
		
		String[] columns = resultSet.getColumnNames();
		
		ContentValues result = new ContentValues(columns.length);
		
		for (int i=0; i < columns.length; i++)
		{
			DbColumn currentColumn = (DbColumn) this.tableSchema.get(columns[i]);
			loadContentValues(currentColumn, resultSet, result);
		}
		
		singleton.setContent(result);
		
		return singleton;
	}
	
	private ContentValues loadContentValues(DbColumn current, Cursor resultSet, ContentValues contentValues)
	{
		String key = current.getColumnName();
		int columnIndex = resultSet.getColumnIndex(key);
		
		switch (current.getColumnType())
		{
			case BLOB:
				 contentValues.put(key, resultSet.getBlob(columnIndex));
				 break;
			case BOOLEAN:
				 contentValues.put(key, resultSet.getInt(columnIndex)>0);
				 break;
			case DOUBLE:
				 contentValues.put(key, resultSet.getDouble(columnIndex));
				 break;
			case FLOAT:
				 contentValues.put(key, resultSet.getFloat(columnIndex));
				 break;
			case INT:
				 contentValues.put(key, resultSet.getInt(columnIndex));
				 break;
			case LONG:
				 contentValues.put(key, resultSet.getLong(columnIndex));
				 break;
			case SHORT:
				 contentValues.put(key, resultSet.getShort(columnIndex));
				 break;
			case STRING:
				 contentValues.put(key, resultSet.getString(columnIndex));
				 break;
			default:
				contentValues.putNull(key);
				break;
		}
		return contentValues;
	}

	public long addItem(ContentValues item) throws UnsupportedOperationException
	{
		if (item != null)
		{
			try
			{
				long result = dataContext.open().insert(referenceItem.getTableName(), item);
				dataContext.close();
				return result;
			}
			catch(Exception e)
			{
				throw new UnsupportedOperationException(e.toString());
			}
		}
		else
		{
			return -1 ;
			
		}
	}
	
	public long removeItem(int id) throws UnsupportedOperationException
	{
		try
		{
			long result = dataContext.open().delete(this.referenceItem.getTableName(), 
					this.referenceItem.getPrimaryKey()+"=?", new String[] {String.valueOf(id)});
			dataContext.close();
			
			Log.w("WedAssist:DbFactory.RemoveItem", String.format("Query Completed Successfully: %s item(s) removed.",
					String.valueOf(result)));
			
			return result;
		}
		catch(UnsupportedOperationException e)
		{
			throw new UnsupportedOperationException(e.toString());
		}
	}
	
	public long removeWhere(String whereClause, String[] whereArgs ) throws UnsupportedOperationException
	{
		try
		{
			long result = dataContext.open().delete(this.referenceItem.getTableName(), 
					whereClause, whereArgs);
			
			Log.w("WedAssist:DbFactory.RemoveWhere", String.format("Query Completed Successfully: %s item(s) removed.",
					String.valueOf(result)));
			
			dataContext.close();
			return result;
		}
		catch(UnsupportedOperationException e)
		{
			throw new UnsupportedOperationException(e.toString());
		}
	}
}
