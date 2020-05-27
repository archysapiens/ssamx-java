package com.ssamx.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface InserPeriods {

	
	void insertPeriods(String operation, String fileName) throws FileNotFoundException, IOException, ParseException;
	
}
