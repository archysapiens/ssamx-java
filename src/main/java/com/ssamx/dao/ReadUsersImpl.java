package com.ssamx.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;



@Repository
public class ReadUsersImpl implements ReadUsers{

	
	private static Logger log = LoggerFactory.getLogger(ReadUsersImpl.class);
	

	
	@Override
	public File getFileFromResources(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
	}

	@Override
	public void insertUsers(File file) throws IOException {

		log.info("insertUsers");

	}

}
