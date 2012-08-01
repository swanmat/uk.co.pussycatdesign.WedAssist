package uk.co.pussycatdesign.Data;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.ListIterator;

import android.util.Log;

public abstract class DbTable {  //NB TODO: Make Generic Static DB Table class with this as static internal class?

	private List<DbColumn> values;
	
	private String TABLE_NAME, 
				PRIMARY_KEY,
				TRIGGER_NAME = null,
				VIEW_NAME = null;
	
	public DbTable(String tableName, String triggerName,
			String viewName, String primaryKey)
	{
		this.TABLE_NAME = tableName;
		this.PRIMARY_KEY = primaryKey;
		this.TRIGGER_NAME = triggerName;
		this.VIEW_NAME = viewName;
		this.values = new ArrayList<DbColumn>();
	}
	
	public abstract String getCreateTriggerSql();
	
	public abstract String getCreateViewSql();
	
	public String[] getDropSql()
	{
		String[] Sql = {"DROP TABLE IF EXISTS " + this.TABLE_NAME + ";",
				" DROP VIEW IF EXISTS " + this.VIEW_NAME + ";",
				" DROP TRIGGER IF EXISTS " + this.TRIGGER_NAME + ";"};
		
		return Sql;
	}
	
	public List<DbColumn> getTableDescriptor() //throw exception here: no values in list
	{
		return this.values;
	}
	
	public Hashtable<String, Object> getTableSchema()
	{
		int columnCount = values.size();
		
		Hashtable<String, Object> schema = new Hashtable<String, Object>(columnCount);
		
		ListIterator<DbColumn> list = values.listIterator(0);
		
		while(list.hasNext())
		{
			DbColumn currentColumn = list.next();
			schema.put(currentColumn.getColumnName(), currentColumn);
		}
		
		return schema;
	}
	
	public String getPrimaryKey()
	{
		return this.PRIMARY_KEY;
	}
	
	public String getTableName()
	{
		return this.TABLE_NAME;
	}
	
	public String getTriggerName()
	{
		return this.TRIGGER_NAME;
	}
	
	public String getViewName()
	{
		return this.VIEW_NAME;
	}
	
	public String getCreateTableSql()
	{
		String Sql = String.format("CREATE TABLE %s (", this.TABLE_NAME);
				
		for (int i = 0; i <= values.size()-1; i++) 
		{
			if (i < values.size()-1)
			{
				Sql = Sql + String.format ("%s, ", values.get(i));
			}
			else
			{
				Sql = Sql + String.format ("%s); ", values.get(i));
			}
		}
		return Sql;
	}
	
	public ArrayList<String> getTableColumns(boolean omitId)
	{
		ArrayList<String> result = new ArrayList<String>();
		
		for (int i = 0; i <= values.size()-1; i++) 
		{
			DbColumn thisColumn = values.get(i);
			if (!(omitId && thisColumn.getColumnModifier() == DbFieldModifier.PRIMARY_KEY))
			{
				result.add(thisColumn.getColumnName());
			}
		}
		return result;
	}
	
	protected void addFieldValue(DbColumn value)
	{
		this.values.add(value);
	}
	
	public String toString() // Display Table Descriptor
	{
		return null;
	}
}
