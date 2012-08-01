package uk.co.pussycatdesign.App.WedAssist;

import java.util.ArrayList;

import android.content.ContentValues;

import uk.co.pussycatdesign.Data.EntityState;
import uk.co.pussycatdesign.Data.SelfTrackingEntity;

public class Role extends SelfTrackingEntity{
	
	private int id;
	private int pfk_guestId;
	private GuestRole role;
	private String otherInfo;
	
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

	@Override
	public ArrayList<String> getValues(boolean includeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void parseValues(String[] columns, Object[] values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parseValues(ContentValues contentValues) {
		// TODO Auto-generated method stub
		
	}
}
