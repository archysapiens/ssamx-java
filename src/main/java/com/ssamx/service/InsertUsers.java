package com.ssamx.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InsertUsers {
	
	void insertaUsers(String operation, String fileName) throws FileNotFoundException, IOException;

}
