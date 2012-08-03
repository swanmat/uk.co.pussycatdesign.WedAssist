package uk.co.pussycatdesign.Data;

import android.content.ContentValues;

public abstract class SelfTrackingEntity  
{
	private EntityState state = EntityState.UNCHANGED;

	/**
	 * @return the state
	 */
	public EntityState getState() {
		return state;
	}
	
	public abstract ContentValues getValues(boolean includeId);
	
	public abstract void parseValues(ContentValues contentValues);
	
	/**
	 * @param state the state to set
	 */
	protected void setState(EntityState state) {
		// If State is New - do not modify to other state; except Deleted.
		
		if (this.state != EntityState.NEW)
		{
			this.state = state;
		}
		else if (state == EntityState.DELETED)
		{
			this.state = state;
		}
	}
	
	public abstract int getId();
}
