package uk.co.pussycatdesign.App.WedAssist.Db;
import uk.co.pussycatdesign.WedAssist;
import uk.co.pussycatdesign.Data.DbTable;
import uk.co.pussycatdesign.Interfaces.DataContext;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class WedAssistDb implements DataContext 
{
	
	// Guest Table
	private static final String DB_NAME = "WedAssistDb" ;
	private static final int SCHEMA_VERSION = 4 ;
	
	private DbHelper dbHelper;
	private final Context context;
	private SQLiteDatabase wedAssistDB;
	
	public WedAssistDb()
	{
		this.context = WedAssist.getAppContext();
	}
	
	/* (non-Javadoc)
	 * @see uk.co.pussycatdesign.WedAssist.DataContext#open()
	 */
	public DataContext open()
	{
		dbHelper = new DbHelper(context);
		wedAssistDB = dbHelper.getWritableDatabase();
		return this;
	}
	
	/* (non-Javadoc)
	 * @see uk.co.pussycatdesign.WedAssist.DataContext#close()
	 */
	public void close()
	{
		dbHelper.close();
	}
	
	/* (non-Javadoc)
	 * @see uk.co.pussycatdesign.WedAssist.DataContext#insert(java.lang.String, android.content.ContentValues)
	 */
	public long insert(String tableName, ContentValues values)
	{
		try
		{
			open();
			long result = wedAssistDB.insert(tableName, null, values);
			close();
			return result;
		}
		catch(Exception e)
		{
			System.out.println(String.format("WA: %s", e.toString()));
			return -1;
		}
	}
	
	/* (non-Javadoc)
	 * @see uk.co.pussycatdesign.WedAssist.DataContext#delete(java.lang.String, java.lang.String, java.lang.String[])
	 */
	public long delete(String tableName, String whereClause, String[] whereArgs)
	{
		try
		{
			return wedAssistDB.delete(tableName, whereClause, whereArgs);
		}
		catch(Exception e)
		{
			return -1;
		}
	}
	
	/* (non-Javadoc)
	 * @see uk.co.pussycatdesign.WedAssist.DataContext#update(java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[])
	 */
	public long update(String tableName, ContentValues values, String whereClause, String[] whereArgs)
	{
		try
		{
			return wedAssistDB.update(tableName, values, whereClause, whereArgs);
		}
		catch(Exception e)
		{
			return -1;
		}
	}
	
	public Cursor query(String table, String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having, String orderBy)
	{
		try
		{
			open();
			
			Cursor result = wedAssistDB.query(table, columns, selection, 
					selectionArgs, groupBy, having, orderBy);
			//close();
			return result;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public void query(String sql)
	{
		try
		{
			wedAssistDB.execSQL(sql);
		}
		catch (Exception e){}
	}
	
	public Cursor rawQuery(String sql, String[] selectionArgs)
	{
		Cursor rs = null;
		try
		{
			 rs = wedAssistDB.rawQuery(sql, selectionArgs);
			 Log.w("WedAssist:DataContext", String.format("Raw Query Executed Successfully and returned %s Items.",
					 String.valueOf(rs.getCount())));
		}
		catch(Exception e)
		{
			Log.w("WedAssist:DataContext", e.toString());
		}
		
		return rs;
	}
	
	
	private static class DbHelper extends SQLiteOpenHelper
	{
		public DbHelper(Context context){
			super(context, DB_NAME, null, SCHEMA_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			
			Log.w("WedAssist:DbHelper", "Creating new WedAssistDb Database");
			//Initialise Descriptors
			DbTable GuestDataTable = new GuestDataTable();
			DbTable extraDataTable = new ExtraDataTable();
			DbTable roleDataTable = new RoleDataTable();
			//Create Tables
			db.execSQL(GuestDataTable.getCreateTableSql());
			db.execSQL(GuestDataTable.getCreateViewSql());
			
			db.execSQL(extraDataTable.getCreateTableSql());
			db.execSQL(roleDataTable.getCreateTableSql());
			//Create Triggers
			
			//Create Views
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			DbTable GuestDataTable = new GuestDataTable();
			DbTable extraDataTable = new ExtraDataTable(); 
			DbTable roleDataTable = new RoleDataTable();
			
			//Drop Tables
			executeCompoundDrop(GuestDataTable.getDropSql(),db);
			executeCompoundDrop(extraDataTable.getDropSql(),db);
			executeCompoundDrop(roleDataTable.getDropSql(),db);
			
			Log.w("WedAssist:DbHelper", 
					String.format("Upgrading Database from version %s, to version %s", 
							String.valueOf(oldVersion), String.valueOf(newVersion)));
			onCreate(db);
		}
		
		private void executeCompoundDrop(String[] dropSql, SQLiteDatabase db)
		{
			for (int i=0; i < dropSql.length; i++)
			{
				db.execSQL(dropSql[i]);
			}
		}
	}
}
