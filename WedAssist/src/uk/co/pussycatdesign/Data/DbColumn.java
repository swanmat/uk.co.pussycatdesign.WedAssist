package uk.co.pussycatdesign.Data;

public class DbColumn {

	private String columnName;
	private DbFieldType columnType;
	private DbFieldModifier columnModifier;
	
	public DbColumn(String columnName, DbFieldType columnType, DbFieldModifier columnModifier)
	{
		this.columnName = columnName;
		this.columnType = columnType;
		this.columnModifier = columnModifier;
	}
	
	public String getColumnName()
	{
		return this.columnName;
	}
	
	public DbFieldType getColumnType()
	{
		return this.columnType;
	}
	
	public DbFieldModifier getColumnModifier()
	{
		return this.columnModifier;
	}
	
	public String toString()
	{
		String Sql  = null;
		
		Sql = String.format("%s %s %s",this.getColumnName().trim(),
				this.getColumnType().toString().trim(), this.getColumnModifier().toString().trim());
		return Sql;
	}
}
