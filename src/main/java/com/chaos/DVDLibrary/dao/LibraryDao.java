package com.chaos.DVDLibrary.dao;

import java.util.List;

import com.chaos.DVDLibrary.dto.DVD;

public interface LibraryDao {
	DVD addDVD(String DVDId, DVD dvd) throws LibraryDaoException;
	DVD displayDVD(String DVDId) throws LibraryDaoException;
	DVD removeDVD(String DVDId) throws LibraryDaoException;
	DVD editDVD(String DVDId) throws LibraryDaoException;
	List<DVD> getAllDVDs() throws LibraryDaoException;
}
