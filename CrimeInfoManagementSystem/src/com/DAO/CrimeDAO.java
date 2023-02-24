package com.DAO;

import java.util.Date;
import java.util.List;

import com.BeenClasses.Crime;

public interface CrimeDAO {
	 public Crime getCrimeById(int id);
	    public void addCrime(Crime crime);
	    public void updateCrime(Crime crime);
	    public void deleteCrime(int id);
	    public List<Crime> getAllCrimes();
	    public List<Crime> getCrimesByDate(Date date);
	    public List<Crime> getCrimesByPlace(String place);
}
