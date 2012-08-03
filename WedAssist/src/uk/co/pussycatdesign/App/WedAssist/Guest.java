package uk.co.pussycatdesign.App.WedAssist;

import android.content.ContentValues;
import uk.co.pussycatdesign.Data.SelfTrackingEntity;

public class Guest extends SelfTrackingEntity {
	
	protected static final String TBL_GUESTS_ID = "Id";
	protected static final String PRIMARY_KEY = "Id";
	protected static final String TBL_GUESTS_PHOTO = "Photo";
	protected static final String TBL_GUESTS_FNAME = "FName";
	protected static final String TBL_GUESTS_SNAME = "SName";
	protected static final String TBL_GUESTS_TEL = "Tel";
	protected static final String TBL_GUESTS_EMAIL = "Email";
	protected static final String TBL_GUESTS_EXTRAS = "Extras";
	protected static final String TBL_GUESTS_INVITES = "Invites";
	//protected static final String TBL_GUESTS_INVITATION = "Invitation";
	//protected static final String TBL_GUESTS_RSVP = "RSVP";
	protected static final String TBL_GUESTS_NOTES = "Notes";
	protected static final String TBL_GUESTS_ROLE = "Role";
	
	// Internal Fields
	private Role role;
	private Invites invites;
	private int extras;
	private Table table;
	private int id = -1;
	private int photo;
	private String fname;
	private String sname;
	private String tel;
	private String email;
	private String notes;
	
	@Override
	public ContentValues getValues(boolean primaryKey) {
		
		ContentValues vals = new ContentValues(10);
		
		if (primaryKey)
			vals.put(PRIMARY_KEY, id);
		
		vals.put(TBL_GUESTS_EMAIL, email);
		vals.put(TBL_GUESTS_EXTRAS, extras);
		vals.put(TBL_GUESTS_FNAME, fname);
		vals.put(TBL_GUESTS_NOTES, notes);
		vals.put(TBL_GUESTS_PHOTO, photo);
		vals.put(TBL_GUESTS_SNAME, sname);
		vals.put(TBL_GUESTS_TEL, tel);
		
		return vals;
	}
	
	@Override
	public void parseValues(ContentValues contentValues) {
		
		if (contentValues.containsKey(PRIMARY_KEY))
		{
			this.setId(contentValues.getAsInteger(PRIMARY_KEY));
		}
		if (contentValues.containsKey(TBL_GUESTS_PHOTO))
		{
			this.setPhoto(contentValues.getAsInteger(TBL_GUESTS_PHOTO));
		}
		if (contentValues.containsKey(TBL_GUESTS_FNAME))
		{
			this.setForename(contentValues.getAsString(TBL_GUESTS_FNAME));
		}
		if (contentValues.containsKey(TBL_GUESTS_SNAME))
		{
			this.setSurname(contentValues.getAsString(TBL_GUESTS_SNAME));
		}
		if (contentValues.containsKey(TBL_GUESTS_TEL))
		{
			this.setTelephone(contentValues.getAsString(TBL_GUESTS_TEL));
		}
		if (contentValues.containsKey(TBL_GUESTS_EXTRAS))
		{
			this.setExtras(contentValues.getAsInteger(TBL_GUESTS_EXTRAS));
		}
		if (contentValues.containsKey(TBL_GUESTS_NOTES))
		{
			this.setNotes(contentValues.getAsString(TBL_GUESTS_NOTES));
		}
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Constructor
	public Guest(int Id,
			int photo,
			String forename,
			String surname,
			String telephone,
			String email,
			String notes)
	{
		this.id=Id;
		this.photo = photo;
		this.fname = forename;
		this.sname = surname;
		this.tel = telephone;
		this.email = email;
		this.notes = notes;
	}
	
	public Guest(int photo,
			String forename,
			String surname,
			String telephone,
			String email,
			String notes)
	{
		this.photo = photo;
		this.fname = forename;
		this.sname = surname;
		this.tel = telephone;
		this.email = email;
		this.notes = notes;
	}
	
	
	public Guest() {
		// TODO Auto-generated constructor stub
	}

	//Public Properties
	public Role getRole()
	{
		return this.role;
	}
	
	public void setRole(Role role){
		this.role=role;
	}	
	
	public Invites getInvites(){
		return this.invites;
	}
	
	public void setInvites(Invites invites)
	{
		this.invites=invites;
	}
	
	public Table getTable()
	{
		return this.table;
	}
		
	public void setTable(Table table)
	{
		this.table=table;
	}
	
	public int getExtras()
	{
		return this.extras;
	}
	
	public void setExtras(Integer integer)
	{
		this.extras = integer;
	}
	
	public long getID()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public long getPhoto()
	{
		return this.photo;
	}
	
	public void setPhoto(int id)
	{
		this.photo=id;
	}
	
	public String getForename()
	{
		return this.fname;
	}
		
	public void setForename(String foreName){
		this.fname = foreName;
	}
	
	public void setSurname(String surname) {
		this.sname=surname;
	}
	
	public String getSurname(){
		return this.sname;
	}

	public void setTelephone(String telephone){
		this.tel=telephone;
	}
	
	public String getTelephone(){
		return this.tel;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getNotes(){
		return this.notes;
	}
	
	public void setNotes(String notes){
		 this.notes = notes;
	}
	
	@Override
	public String toString() {
		return "Guest [id=" + id + ", fname=" + fname + "]";
	}

	public void addNote(String note)
	{
		this.notes = this.notes + note;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return (int)id;
	}
}
