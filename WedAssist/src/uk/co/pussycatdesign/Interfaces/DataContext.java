package uk.co.pussycatdesign.Interfaces;

import android.content.ContentValues;
import android.database.Cursor;

public interface DataContext {

    abstract DataContext open();

    abstract void close();

    abstract long insert(String tableName, ContentValues values);

    abstract long delete(String tableName, String whereClause,
			String[] whereArgs);

    abstract long update(String tableName, ContentValues values,
			String whereClause, String[] whereArgs);
    
    abstract Cursor query(String table, String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having, String orderBy);
    
    abstract Cursor rawQuery(String sql, String[] selectionArgs);
    
    abstract void query(String sql);
  
 }