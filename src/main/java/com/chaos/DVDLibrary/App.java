package com.chaos.DVDLibrary;

import com.chaos.DVDLibrary.controller.LibraryController;
import com.chaos.DVDLibrary.dao.LibraryDao;
import com.chaos.DVDLibrary.dao.LibraryDaoException;
import com.chaos.DVDLibrary.dao.LibraryDaoFileImpl;
import com.chaos.DVDLibrary.ui.LibraryView;
import com.chaos.DVDLibrary.ui.UserIO;
import com.chaos.DVDLibrary.ui.UserIOConsoleImpl;

public class App 
{
	public static void main(String[] args) throws LibraryDaoException {
	    UserIO myIo = new UserIOConsoleImpl();
	    LibraryView myView = new LibraryView(myIo);
	    LibraryDao myDao = new LibraryDaoFileImpl();
	    LibraryController controller = new LibraryController(myDao, myView);
	    controller.run();
	}
}
