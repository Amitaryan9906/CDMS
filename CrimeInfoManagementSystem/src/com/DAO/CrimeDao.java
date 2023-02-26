package com.DAO;

import java.util.List;

import com.BeenClasses.CrimeDetails;

public interface CrimeDao {
	 public void addCrime(CrimeDetails crimeDetails);
	    public CrimeDetails searchCrime(int crimeId);
	    public void updateCrime(int crimeId, CrimeDetails crimeDetails);
	    List<CrimeDetails> getCrimesByArea(String area);
	    List<CrimeDetails> getCrimesByPoliceStation(String policeStation);
	    int getNumberOfSolvedCrimes();
	    int getNumberOfUnsolvedCrimes();
	    int getNumberOfCrimesRecordedInCurrentMonth();
}
