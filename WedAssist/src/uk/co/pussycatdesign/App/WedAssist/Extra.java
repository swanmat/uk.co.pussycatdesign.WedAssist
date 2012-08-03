package uk.co.pussycatdesign.App.WedAssist;

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
	
	@Override
	public void parseValues(ContentValues contentValues) {
	
		if(contentValues.containsKey(TBL_EXTRAS_ID))
			this.id = contentValues.getAsInteger(TBL_EXTRAS_ID);
		if(contentValues.containsKey(TBL_EXTRAS_NAME))
			this.name = contentValues.getAsString(TBL_EXTRAS_NAME);
		if(contentValues.containsKey(TBL_EXTRAS_TYPE))
			this.type = ExtraType.valueOf(contentValues.getAsString(TBL_EXTRAS_TYPE));
		if(contentValues.containsKey(TBL_EXTRAS_PFK))
			this.pfk_GuestId = contentValues.getAsInteger(TBL_EXTRAS_PFK);
	}
	
	@Override
	public ContentValues getValues(boolean includeId) {
		
		ContentValues cv = new ContentValues(4);
		
		if (includeId)
			cv.put(TBL_EXTRAS_ID, this.id);
		cv.put(TBL_EXTRAS_NAME, this.name);
		cv.put(TBL_EXTRAS_TYPE, this.type.name());
		cv.put(TBL_EXTRAS_PFK, this.pfk_GuestId);
		
		return cv;		
	}

	public Extra() {
		// TODO Auto-generated constructor stub
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
}
