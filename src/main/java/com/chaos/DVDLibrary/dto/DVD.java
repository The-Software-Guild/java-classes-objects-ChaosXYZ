package com.chaos.DVDLibrary.dto;



public class DVD {
	private String DVDId, title, directorName, studio, MPAA, note;
	private String releaseDate; //TODO import date type
	
	public DVD(String DVDId) {
		this.DVDId = DVDId;
	}
	
	public String getID() {
		return DVDId;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getMPAA() {
		return MPAA;
	}

	public void setMPAA(String mPAA) {
		MPAA = mPAA;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}
