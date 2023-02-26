package com.DAO;

import java.util.List;

import com.BeenClasses.CriminalDetails;

public interface CriminalDao {
	boolean login(String username, String password);
	 public void addCriminal(CriminalDetails criminalDetails);
	    public CriminalDetails searchCriminal(int criminalId);
	    public void updateCriminal(int criminalId, CriminalDetails criminalDetails);
	    public List<CriminalDetails> getAllCriminals();
	    List<CriminalDetails> getCriminalsByArea(String area);
	    List<CriminalDetails> getCriminalsByPoliceStation(String policeStation);
}
