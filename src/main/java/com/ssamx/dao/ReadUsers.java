package com.ssamx.dao;

import java.io.File;
import java.io.IOException;

public interface ReadUsers {

	
	File getFileFromResources(String fileName);
	void insertUsers(File file) throws IOException ;
}
