package com.acme.database;

import java.util.List;

import com.acme.model.Starter;

public interface StarterDAO {
	/**
	 * Gets a Starter
	 * 
	 * @return Starter
	 * @author Nicholas Keam
	 * @since 11/5/2012
	 */
	List<Starter> getStarters();
	
}

