package com.ssamx.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InsertStates {
	
	void insertStates(String operation, String fileName) throws FileNotFoundException, IOException;

}
