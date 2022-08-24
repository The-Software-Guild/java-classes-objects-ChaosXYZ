package com.chaos.DVDLibrary.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.chaos.DVDLibrary.dto.DVD;

public class LibraryDaoFileImpl implements LibraryDao{
	private static final String DATA_FILE = "library.txt";
	public static final String DELIMITER = ",";
	private Map<String, DVD> DVDs = new HashMap<>();
	@Override
	public DVD addDVD(String DVDId, DVD dvd) throws LibraryDaoException {
		loadLibrary();
		DVD prevDVD = DVDs.put(DVDId, dvd);
		writeLibrary();
		return prevDVD;
	}

	@Override
	public DVD displayDVD(String DVDId) throws LibraryDaoException {
		loadLibrary();
		return DVDs.get(DVDId);
	}

	@Override
	public DVD removeDVD(String DVDId) throws LibraryDaoException{
		loadLibrary();
		DVD removedDVD = DVDs.remove(DVDId);
		writeLibrary();
		return removedDVD;
	}

	@Override
	public DVD editDVD(String DVDId) throws LibraryDaoException{
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<DVD> getAllDVDs() throws LibraryDaoException{
		loadLibrary();
		return new ArrayList<DVD>(DVDs.values());
	}
	
	private DVD unmarshallDVD(String DVDText) {
		String[] DVDTokens = DVDText.split(DELIMITER);
		String DVDId = DVDTokens[0];
		DVD importDVD = new DVD(DVDId);
		importDVD.setTitle(DVDTokens[1]);
		importDVD.setMPAA(DVDTokens[2]);
		importDVD.setDirectorName(DVDTokens[3]);
		importDVD.setStudio(DVDTokens[4]);
		importDVD.setReleaseDate(DVDTokens[5]);
		importDVD.setNote(DVDTokens[6]);
		return importDVD;
	}
	
	private String marshallDVD(DVD dvd) {
		String DVDText = dvd.getID()+DELIMITER;
		DVDText += dvd.getTitle()+DELIMITER;
		DVDText += dvd.getMPAA()+DELIMITER;
		DVDText += dvd.getDirectorName()+DELIMITER;
		DVDText += dvd.getStudio()+DELIMITER;
		DVDText += dvd.getReleaseDate()+DELIMITER;
		DVDText += dvd.getNote();
		return DVDText;
	}
	
	private void loadLibrary() throws LibraryDaoException{
		Scanner scanner;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(DATA_FILE)));
		} catch (FileNotFoundException e) {
			throw new LibraryDaoException("Could not load datafile", e);
		}
		
		String currLine;
		DVD currDVD;
		while (scanner.hasNextLine()) {
			currLine = scanner.nextLine();
			currDVD = unmarshallDVD(currLine);
			DVDs.put(currDVD.getID(), currDVD);
		}
		scanner.close();
	}
	
	private void writeLibrary() throws LibraryDaoException{
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(DATA_FILE));
		} catch (IOException e) {
			throw new LibraryDaoException("Could not save data", e);
		}
		
		String currDVDText;
		List<DVD> DVDs = this.getAllDVDs();
		for (DVD dvd:DVDs) {
			currDVDText = marshallDVD(dvd);
			out.println(currDVDText);
			out.flush();
		}
		out.close();
	}
	
}
