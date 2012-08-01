package uk.co.pussycatdesign.Data;

public enum DbFieldType {
	
	BLOB
	{
		public String toString()
		{
			return "BLOB" ;
		}
	},
	
	BOOLEAN
	{
		public String toString()
		{
			return "BOOLEAN" ;
		}
	},
	
	DOUBLE
	{
		public String toString()
		{
			return "DOUBLE" ;
		}
	},
	
	FLOAT
	{
		public String toString()
		{
			return "FLOAT" ;
		}
	},
	
	INT
	{
		public String toString()
		{
			return "INTEGER" ;
		}
	},
	
	LONG
	{
		public String toString()
		{
			return "LONG" ;
		}
	},
	
	SHORT
	{
		public String toString()
		{
			return "INTEGER" ;
		}
	},
	
	STRING
	{
		public String toString()
		{
			return "TEXT" ;
		}
	},
	
	DATE_TIME
	{
		public String toString()
		{
			return "DATETIME" ;
		}
	},
	
	DATE
	{
		public String toString()
		{
			return "DATE" ;
		}
	}
	;
}
