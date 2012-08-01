package uk.co.pussycatdesign.App.WedAssist;

import java.util.ArrayList;

import android.content.ContentValues;

import uk.co.pussycatdesign.Data.EntityState;
import uk.co.pussycatdesign.Data.SelfTrackingEntity;

public class Extra extends SelfTrackingEntity {
	
	private int id;
	private ExtraType type;
	private String name;
	private int pfk_GuestId;
	
	protected static final String TBL_EXTRAS_ID = "Id";
	protected static final String TBL_EXTRAS_NAME = "Name";
	protected static final String TBL_EXTRAS_TYPE = "Type";
	protected static final String TBL_EXTRAS_PFK = "GuestId";
	
	public Extra(String Name, ExtraType Type, int GuestId)
	{
		this.name = Name;
		this.type = Type;
		this.pfk_GuestId = GuestId;
		this.setState(EntityState.NEW);
	}
	
	public Extra(int Id, String Name, ExtraType Type, int GuestId)
	{
		this.id = Id;
		this.name = Name;
		this.type = Type;
		this.pfk_GuestId = GuestId;
		this.setState(EntityState.UNCHANGED);
	}
	

	public Extra() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> getValues(boolean includeId) {
		ArrayList<String> values = new ArrayList<String>();
		if (includeId)
		{
			values.add(String.valueOf(this.id));
		}
		values.add(this.name);
		values.add(this.type.name());
		values.add(String.valueOf(this.pfk_GuestId));
		
		return values;
	}

	@Override
	public void parseValues(String[] columns, Object[] values) {
		for (int column = 0; column < columns.length; column ++)
		{
			String columnName = columns[column];
			Object columnValue = values[column];
			
				if(columnName.compareTo(TBL_EXTRAS_ID) == 0)
				{
					Integer iVal = (Integer) columnValue;
					this.setId(iVal.intValue());
				}
				else if (columnName.compareTo(TBL_EXTRAS_NAME) == 0)
				{
					this.setName((String) columnValue);
				}
				else if (columnName.compareTo(TBL_EXTRAS_TYPE) == 0)
				{
					this.setType(ExtraType.valueOf((String)columnValue));
				}
				else if (columnName.compareTo(TBL_EXTRAS_PFK) == 0)
				{
					Integer iVal =(Integer) columnValue;
					this.setGuestId(iVal.intValue());
				}
		}
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;
		this.setState(EntityState.UNCHANGED);
	}

	/**
	 * @return the type
	 */
	public ExtraType getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(ExtraType type) {
		this.type = type;
		this.setState(EntityState.CHANGED);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
		this.setState(EntityState.CHANGED);
	}
	
	/**
	 * @return the pfk_GuestId
	 */
	public int getGuestId() {
		return pfk_GuestId;
	}
	
	/**
	 * @param pfk_GuestId the pfk_GuestId to set
	 */
	public void setGuestId(int pfk_GuestId) {
		this.pfk_GuestId = pfk_GuestId;
		this.setState(EntityState.CHANGED);
	}

	@Override
	public void parseValues(ContentValues contentValues) {
		// TODO Auto-generated method stub
		
	}

}
