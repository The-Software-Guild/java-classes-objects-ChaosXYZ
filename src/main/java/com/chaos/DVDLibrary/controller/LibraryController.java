package com.chaos.DVDLibrary.controller;

import java.util.List;

import com.chaos.DVDLibrary.dao.LibraryDao;
import com.chaos.DVDLibrary.dao.LibraryDaoException;
import com.chaos.DVDLibrary.dto.DVD;
import com.chaos.DVDLibrary.ui.LibraryView;


public class LibraryController {

	private LibraryView view;
	private LibraryDao dao;
	
	public LibraryController(LibraryDao dao, LibraryView view) {
		this.dao = dao;
		this.view = view;
	}
	
	public void run() throws LibraryDaoException {
		boolean keepGoing = true;
		int userSelection = 0;
		
		while (keepGoing){
			
			userSelection = displayMenu();
			
			switch (userSelection) {
				case 1:
					addDVD();
					break;
				case 2:
					removeDVD();
					break;
				case 3:
					editDVD();
					break;
				case 4:
					listDVDs();
					break;
				case 5:
					displayDVD();
					break;
				case 6:
					keepGoing = false;
					break;
				case 7:
					view.unknownCommand();
			}
		}
		view.exitMessage();
	}
	
	private int displayMenu() {
		return view.getUserSelection();
	}
	
	private void addDVD() throws LibraryDaoException{
		view.addDVDBanner();
		DVD newDVD = view.getDVDInfo();
		dao.addDVD(newDVD.getID(), newDVD);
		view.successBanner();
	}
	
	private void removeDVD() throws LibraryDaoException{
		view.removeDVDBanner();
		String DVDid = view.getUserIDInput();
		DVD dvd = dao.removeDVD(DVDid);
		view.displayRemoveResult(dvd);
	}
	
	private void editDVD() throws LibraryDaoException{
		view.editDVDBanner();
		String DVDid = view.getUserIDInput();
		view.editPrompt();
		DVD newDVD = view.getDVDInfo();
		int confirmEdit = view.editConfirmation();
		if (confirmEdit == 1) {
			dao.removeDVD(DVDid);
			dao.addDVD(newDVD.getID(), newDVD);
		}
		
	}
	
	private void listDVDs() throws LibraryDaoException{
		List<DVD> DVDlist = dao.getAllDVDs();
		view.listAllDVDs(DVDlist);
	}
	
	private void displayDVD() throws LibraryDaoException{
		view.displayDVDBanner();
		String DVDid = view.getUserIDInput();
		DVD dvd = dao.displayDVD(DVDid);
		view.displayDVD(dvd);
		
	}
}
