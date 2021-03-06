package uk.co.pussycatdesign.Data;

import java.util.ArrayList;
import android.content.*;

public class DbResult extends Object {
	
	private ArrayList<Object> resultSet;
	
	ContentValues rSet = null;
	
	public DbResult()
	{
		this.resultSet = new ArrayList<Object>();
	}
	
	public void addElement(Object value)
	{
		resultSet.add(value);
	}
	
	public void setContent(ContentValues contentValues)
	{
		this.rSet = contentValues;
	}
	
	public ContentValues getContentValues()
	{
		return rSet;
	}
	
	public Object[] toArray()
	{
		return this.resultSet.toArray();
	}
	
	public ArrayList<Object> getResultSet()
	{
		return this.resultSet;
	}
	
	public int countColumns()
	{
		return resultSet.size();
	}
	
	public String getString()
	{
		String res = null;
		
		for (int i =0; i <= countColumns() -1; i++)
		{
			res = res + String.format("%s ", resultSet.get(i).toString());
		}
		return String.format("%s Columns returned. Values: %s ", String.valueOf(countColumns()), res);
	}
	
	public String toString()
	{
		String res = ""; 
		for (int i =0; i <= countColumns() -1; i++)
		{
			res = res + String.format("%s; ", resultSet.get(i).toString());
		}
		return res;
	}
}
