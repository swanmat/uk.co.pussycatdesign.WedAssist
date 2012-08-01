package uk.co.pussycatdesign.Data;

import java.util.ArrayList;

public class DbResultSet extends ArrayList<DbResult>
{
	private static final long serialVersionUID = 6997778420687352212L;
	
	private String[] dbColumns;
	
	/**
	 * @return the dbColumns
	 */
	public String[] getDbColumns()
	{
		return dbColumns;
	}

	/**
	 * @param dbColumns the dbColumns to set
	 */
	public void setDbColumns(String[] dbColumns)
	{
		this.dbColumns = dbColumns;
	}
	
	public int columnCount()
	{
		return dbColumns.length;
	}
}
