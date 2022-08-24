package com.chaos.DVDLibrary.ui;

import java.util.List;

import com.chaos.DVDLibrary.dto.DVD;

public class LibraryView {
	private UserIO io;
	
	public LibraryView(UserIO io) {
		this.io = io;
	}
	
	public int getUserSelection() {
		io.print("MAIN MENU");
		io.print("1. Add DVD");
		io.print("2. Remove DVD");
		io.print("3. Edit DVD");
		io.print("4. List DVD");
		io.print("5. Display DVD");
		io.print("6. Exit");
		return io.readInt("Enter Choice: ", 1, 6);
	}
	
	public DVD getDVDInfo() {
		String DVDid = io.readString("Please enter DVD Id: ");
		String title = io.readString("Please enter DVD Title: ");
		String mpaa = io.readString("Please enter DVD MPAA Rating: ");
		String directorName = io.readString("Please enter DVD Director's Name: ");
		String Studio = io.readString("Please enter the Studio: ");
		String releaseDate = io.readString("Please enter release date: ");
		String note = io.readString("Enter any notes: ");
		DVD newDVD = new DVD(DVDid);
		newDVD.setTitle(title);
		newDVD.setMPAA(mpaa);
		newDVD.setDirectorName(directorName);
		newDVD.setStudio(Studio);
		newDVD.setReleaseDate(releaseDate);
		newDVD.setNote(note);
		return newDVD;
	}
	
	public void listAllDVDs(List<DVD> DVDList) {
		io.print("=== Display All DVDs ===");
		for (DVD currDVD:DVDList) {
			String info = String.format("#%s: %s MPAA: %s",
					currDVD.getID(),
					currDVD.getTitle(),
					currDVD.getMPAA());
			io.print(info);
		}
		io.readString("Please hit enter to continue.");
	}
	
	public void displayDVD(DVD dvd) {
		if (dvd != null) {
			String info = String.format("#%s: %s MPAA: %s\nDirector: %s\nStudio: %s\nRelease Date: %s\nNotes: %s",
					dvd.getID(),
					dvd.getTitle(),
					dvd.getMPAA(),
					dvd.getDirectorName(),
					dvd.getStudio(),
					dvd.getReleaseDate(),
					dvd.getNote());
			io.print(info);	
		}else {
			io.print("Not found!");
		}
		io.readString("Please hit enter to continue.");
	}
	
	public void editPrompt() {
		io.print("Enter new details..");
	}
	
	public int editConfirmation() {
		return io.readInt("Would you like to confirm this edit?\n1. Yes\n2. No\nEnter Choice: ", 1, 2);
	}
	
	public void displayRemoveResult(DVD dvd) {
	    if(dvd != null){
	      io.print("DVD successfully removed.");
	    }else{
	      io.print("No such DVD.");
	    }
	    io.readString("Please hit enter to continue.");
	}
	
	public String getUserIDInput() {
		return io.readString("Enter ID: ");
	}
	
	
	public void displayDVDBanner() {
		io.print("===VIEW DVD===");
	}
	public void addDVDBanner() {
		io.print("===ADD DVD===");
	}
	public void removeDVDBanner() {
		io.print("===REMOVE DVD===");
	}
	public void editDVDBanner() {
		io.print("===EDIT DVD===");
	}
	public void successBanner() {
		io.print("===Success===");
	}
	
	public void unknownCommand() {
		io.print("UNKNOWN COMMAND");
	}
	public void exitMessage() {
		io.print("Goodbye..");
	}

}
