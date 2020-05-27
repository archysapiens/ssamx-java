package com.ssamx.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface InsertFiles {
	
	void insertFiles(String operation, String fileName) throws FileNotFoundException, IOException, ParseException;
	

}
