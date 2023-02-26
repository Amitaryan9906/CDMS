package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.BeenClasses.CriminalDetails;
import com.Utility.DBUtils;

public class CriminalImpl implements CriminalDao{

	
	
	@Override
	public void addCriminal(CriminalDetails criminalDetails) {
		String sql = "INSERT INTO Criminal (name, age, gender, address, identifying_mark, area_of_arrest, attached_to_crime) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBUtils.provideConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, criminalDetails.getName());
			stmt.setInt(2, criminalDetails.getAge());
			stmt.setString(3, criminalDetails.getGender());
			stmt.setString(4, criminalDetails.getAddress());
			stmt.setString(5, criminalDetails.getIdentifyingMark());
			stmt.setString(6, criminalDetails.getAreaOfArrest());
			stmt.setString(7, criminalDetails.getAttachedToCrime());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error adding criminal: " + e.getMessage());
		}
		
	}

	@Override
	public CriminalDetails searchCriminal(int criminalId) {
		String sql = "SELECT * FROM Criminal WHERE criminal_id = ?";
		try (Connection conn = DBUtils.provideConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, criminalId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String identifyingMark = rs.getString("identifying_mark");
				String areaOfCrime = rs.getString("area_of_arrest");
				String attachedCrime = rs.getString("attached_to_crime");
				return new CriminalDetails(criminalId, name, age, gender, address, identifyingMark, areaOfCrime, attachedCrime);
			} else {
				System.out.println("No criminal found with ID " + criminalId);
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Error searching criminal: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void updateCriminal(int criminalId, CriminalDetails criminalDetails) {
		String sql = "UPDATE Criminal SET name = ?, age = ?, gender = ?, address = ?, identifying_mark = ?, area_of_arrest = ?, attached_to_crime = ? WHERE criminal_id = ?";
		try (Connection conn = DBUtils.provideConnection();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, criminalDetails.getName());
			stmt.setInt(2, criminalDetails.getAge());
			stmt.setString(3, criminalDetails.getGender());
			stmt.setString(4, criminalDetails.getAddress());
			stmt.setString(5, criminalDetails.getIdentifyingMark());
			stmt.setString(6, criminalDetails.getAreaOfArrest());
			stmt.setString(7, criminalDetails.getAttachedToCrime());
			stmt.setInt(8, criminalId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error updating criminal: " + e.getMessage());
		}
	}

	@Override
	public List<CriminalDetails> getAllCriminals() {
		List<CriminalDetails> criminals = new ArrayList<>();
	    String sql = "SELECT * FROM criminal";
	    try (Connection conn = DBUtils.provideConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	        	        int criminalId=rs.getInt("crime_id");
	            		String name = rs.getString("name");
	    				int age = rs.getInt("age");
	    				String gender = rs.getString("gender");
	    				String address = rs.getString("address");
	    				String identifyingMark = rs.getString("identifying_mark");
	    				String areaOfCrime = rs.getString("area_of_arrest");
	    				String attachedCrime = rs.getString("attached_to_crime");
	            
	            criminals.add(new CriminalDetails(criminalId, name, age, gender, address, identifyingMark, areaOfCrime, attachedCrime));
	        }
	    } catch (SQLException e) {
	        System.out.println("Error getting all criminals: " + e.getMessage());
	    }
	    return criminals;	}

	@Override
	public boolean login(String username, String password) {
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (Connection conn = DBUtils.provideConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return true; // user found, return true
            }
        } catch (SQLException e) {
            System.out.println("Error logging in: " + e.getMessage());
        }
        return false; // user not found, return false
	}

	@Override
	public List<CriminalDetails> getCriminalsByArea(String area) {
	    List<CriminalDetails> criminals = new ArrayList<>();
	    String sql = "SELECT * FROM criminal WHERE area=?";

	    try (Connection conn = DBUtils.provideConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, area);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	        	 int criminalId=rs.getInt("crime_id");
         		String name = rs.getString("name");
 				int age = rs.getInt("age");
 				String gender = rs.getString("gender");
 				String address = rs.getString("address");
 				String identifyingMark = rs.getString("identifying_mark");
 				String areaOfCrime = rs.getString("area_of_arrest");
 				String attachedCrime = rs.getString("attached_to_crime");
         
         criminals.add(new CriminalDetails(criminalId, name, age, gender, address, identifyingMark, areaOfCrime, attachedCrime));
	        }
	    } catch (SQLException e) {
	        System.out.println("Error getting criminals by area: " + e.getMessage());
	    }

	    return criminals;
	}

	@Override
	public List<CriminalDetails> getCriminalsByPoliceStation(String policeStation) {
	    List<CriminalDetails> criminals = new ArrayList<>();
	    String sql = "SELECT * FROM criminal WHERE police_station=?";

	    try (Connection conn = DBUtils.provideConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, policeStation);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	        	 int criminalId=rs.getInt("crime_id");
         		String name = rs.getString("name");
 				int age = rs.getInt("age");
 				String gender = rs.getString("gender");
 				String address = rs.getString("address");
 				String identifyingMark = rs.getString("identifying_mark");
 				String areaOfCrime = rs.getString("area_of_arrest");
 				String attachedCrime = rs.getString("attached_to_crime");
         
         criminals.add(new CriminalDetails(criminalId, name, age, gender, address, identifyingMark, areaOfCrime, attachedCrime));
	        }
	    } catch (SQLException e) {
	        System.out.println("Error getting criminals by police station: " + e.getMessage());
	    }

	    return criminals;
	}


	}


