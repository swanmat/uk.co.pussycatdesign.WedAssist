package uk.co.pussycatdesign.Data;

public enum DbFieldModifier {

	NOT_NULL{
		public String toString()
		{
			return "NOT NULL";
		}
	},
	
	PRIMARY_KEY
	{
		public String toString()
		{
			return "PRIMARY KEY ASC AUTOINCREMENT";
		}
	},
	
	NONE
	{
		public String toString()
		{
			return "";
		}
	};
}
