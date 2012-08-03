package uk.co.pussycatdesign.App.WedAssist;

import android.content.ContentValues;
import uk.co.pussycatdesign.Data.EntityState;
import uk.co.pussycatdesign.Data.SelfTrackingEntity;

public final class Role extends SelfTrackingEntity{

	protected static final String TBL_ROLES_ID = "Id";
	protected static final String TBL_ROLES_PFK = "GuestId";
	protected static final String TBL_ROLES_ROLE = "Role";
	protected static final String TBL_ROLES_OTHER = "Info";
	
	private int id;
	private int pfk_guestId;
	private GuestRole role;
	private String otherInfo;
	
	@Override
	public void parseValues(ContentValues contentValues) {
		
		if(contentValues.containsKey(TBL_ROLES_ID))
			this.id=contentValues.getAsInteger(TBL_ROLES_ID);
		if(contentValues.containsKey(TBL_ROLES_PFK))
			this.pfk_guestId = contentValues.getAsInteger(TBL_ROLES_PFK);
		if(contentValues.containsKey(TBL_ROLES_ROLE))
			this.role = GuestRole.valueOf(contentValues.getAsString(TBL_ROLES_ROLE));
		if(contentValues.containsKey(TBL_ROLES_OTHER))
			this.otherInfo = contentValues.getAsString(TBL_ROLES_OTHER);
	}

	@Override
	public ContentValues getValues(boolean includeId) {
		
		ContentValues cv = new ContentValues(4);
		if(includeId)
			cv.put(TBL_ROLES_ID, id);
		cv.put(TBL_ROLES_PFK, pfk_guestId);
		cv.put(TBL_ROLES_ROLE, role.name());
		cv.put(TBL_ROLES_OTHER, otherInfo);
		return cv;
	}
	
	public Role(int guestId, GuestRole role, String otherInformation)
	{
		this.pfk_guestId = guestId;
		this.role = role;
		this.otherInfo = otherInformation;
		this.setState(EntityState.NEW);
	}
	
	public Role(int id, int guestId, GuestRole role, String otherInformation)
	{
		this.id = id;
		this.pfk_guestId = guestId;
		this.role = role;
		this.otherInfo = otherInformation;
		this.setState(EntityState.UNCHANGED);
	}
	
	public Role()
	{
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the pfk_guestId
	 */
	public int getGuestId() {
		return pfk_guestId;
	}

	/**
	 * @param pfk_guestId the pfk_guestId to set
	 */
	public void setGuestId(int pfk_guestId) {
		this.pfk_guestId = pfk_guestId;
		this.setState(EntityState.CHANGED);
	}

	/**
	 * @return the role
	 */
	public GuestRole getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(GuestRole role) {
		this.role = role;
		this.setState(EntityState.CHANGED);
	}

	/**
	 * @return the otherInfo
	 */
	public String getOtherInfo() {
		return otherInfo;
	}

	/**
	 * @param otherInfo the otherInfo to set
	 */
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
		this.setState(EntityState.CHANGED);
	}
}
