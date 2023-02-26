package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeenClasses.CrimeDetails;
import com.Utility.DBUtils;

public class CrimeDaoImpl implements CrimeDao {

	    
	   
	    
	    @Override
	    public void addCrime(CrimeDetails crimeDetails) {
	        String sql = "INSERT INTO crime (date, place, description, victims, details, suspected, status, polic_station_name,area) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try (Connection conn = DBUtils.provideConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1,  crimeDetails.getDate());
	            pstmt.setString(2, crimeDetails.getPlace());
	            pstmt.setString(3, crimeDetails.getDescription());
	            pstmt.setString(4, crimeDetails.getVictims());
	            pstmt.setString(5, crimeDetails.getDetails());
	            pstmt.setString(6, crimeDetails.getSuspected());
	            pstmt.setString(7, crimeDetails.getStatus());
	            pstmt.setString(8, crimeDetails.getPolice_Station_name());
	            pstmt.setString(9, crimeDetails.getArea());
	            
	            pstmt.executeUpdate();
	            System.out.println("Crime added successfully.");
	        } catch (SQLException e) {
	            System.out.println("Error adding crime: " + e.getMessage());
	        }
	    }

	    @Override
	    public CrimeDetails searchCrime(int crimeId) {
	    	 String sql = "SELECT * FROM crime WHERE id=?";
				try (Connection conn = DBUtils.provideConnection();
	              PreparedStatement pstmt = conn.prepareStatement(sql)) {
	             
	             pstmt.setInt(1, crimeId);
	             
	             ResultSet rs = pstmt.executeQuery();
	             if (rs.next()) {
	            	 
	            	 
	            	int Id= rs.getInt("id");
	              String date=   rs.getString("date");
	              String place=  rs.getString("place");
	              String disc=   rs.getString("description");
	              String victim=   rs.getString("victims");
	              String details=   rs.getString("details");
	              String suspect=    rs.getString("suspected");
	              String status=  rs.getString("status");
	              String ps=rs.getString("police_station_name");
	              String area=rs.getString("area");
	                 CrimeDetails crimeDetails = new CrimeDetails(Id,date,place,disc,victim,details,suspect,status,ps,area);
	                 
	                 return crimeDetails;
	             }
	         } catch (SQLException e) {
	             System.out.println("Error searching crime: " + e.getMessage());
	         }	            
	      return null;
	    }

	    @Override
	    public void updateCrime(int crimeId, CrimeDetails crimeDetails) {
	        String sql = "UPDATE crime SET date=?, place=?, description=?, victims=?, details=?, suspected=?, status=? WHERE id=?";
			try (Connection conn = DBUtils.provideConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1,  crimeDetails.getDate());
	            pstmt.setString(2, crimeDetails.getPlace());
	            pstmt.setString(3, crimeDetails.getDescription());
	            pstmt.setString(4, crimeDetails.getVictims());
	            pstmt.setString(5, crimeDetails.getDetails());
	            pstmt.setString(6, crimeDetails.getSuspected());
	            pstmt.setString(7, crimeDetails.getStatus());
	            pstmt.setInt(8, crimeId);
	            
	            pstmt.executeUpdate();
	            System.out.println("Crime updated successfully.");
	        } catch (SQLException e) {
	            System.out.println("Error updating crime: " + e.getMessage());
	        }
	    }

		@Override
		public List<CrimeDetails> getCrimesByArea(String area) {
			List<CrimeDetails> crimesList = new ArrayList<>();
			String sql = "SELECT * FROM crime WHERE area=?";
			
			try (Connection conn = DBUtils.provideConnection();
			        PreparedStatement pstmt = conn.prepareStatement(sql)) {
			    pstmt.setString(1, area);
			    ResultSet rs = pstmt.executeQuery();

			    while (rs.next()) {
			    	 
			    	int id= rs.getInt("id");
	                String date= rs.getString("date");
	               String place=  rs.getString("place");
	               String desc=  rs.getString("description");
	               String victim=  rs.getString("victims");
	               String details=  rs.getString("details");
	               String suspect=  rs.getString("suspected");
	               String status=  rs.getString("status");
	                String ps= rs.getString("police_station");
	                CrimeDetails crime = new CrimeDetails( id, date, place,desc, victim,details,
	        				suspect, status,ps,area);
	                
	                crimesList.add(crime);
			    }
			} catch (SQLException e) {
			    System.out.println("Error retrieving crimes by area: " + e.getMessage());
			}

			return crimesList;

			
		}

		@Override
		public List<CrimeDetails> getCrimesByPoliceStation(String policeStation) {
			List<CrimeDetails> crimesList = new ArrayList<>();
			String sql = "SELECT * FROM crime WHERE police_station=?";

			try (Connection conn = DBUtils.provideConnection();
			        PreparedStatement pstmt = conn.prepareStatement(sql)) {
			    pstmt.setString(1, policeStation);
			    ResultSet rs = pstmt.executeQuery();

			    while (rs.next()) {
			    	int id= rs.getInt("id");
		            String date= rs.getString("date");
		            String place=  rs.getString("place");
		            String desc=  rs.getString("description");
		            String victim=  rs.getString("victims");
		            String details=  rs.getString("details");
		            String suspect=  rs.getString("suspected");
		            String status=  rs.getString("status");
		            String area= rs.getString("area");
		            CrimeDetails crime = new CrimeDetails( id, date, place,desc, victim,details,
		    				suspect, status,policeStation,area);
		            
		            crimesList.add(crime);
			    }
			} catch (SQLException e) {
			    System.out.println("Error retrieving crimes by police station: " + e.getMessage());
			}

			return crimesList;
		}

		@Override
		public int getNumberOfSolvedCrimes() {
			int count = 0;
			String sql = "SELECT COUNT(*) FROM crime WHERE status='Solved'";

			try (Connection conn = DBUtils.provideConnection();
			        PreparedStatement pstmt = conn.prepareStatement(sql)) {
			    ResultSet rs = pstmt.executeQuery();

			    if (rs.next()) {
			        count = rs.getInt(1);
			    }
			} catch (SQLException e) {
			    System.out.println("Error retrieving number of solved crimes: " + e.getMessage());
			}

			return count;
		}

		@Override
		public int getNumberOfUnsolvedCrimes() {
			int count = 0;
			String sql = "SELECT COUNT(*) FROM crime WHERE status='Unsolved'";

			try (Connection conn = DBUtils.provideConnection();
			        PreparedStatement pstmt = conn.prepareStatement(sql)) {
			    ResultSet rs = pstmt.executeQuery();

			    if (rs.next()) {
			        count = rs.getInt(1);
			    }
			} catch (SQLException e) {
			    System.out.println("Error retrieving number of unsolved crimes: " + e.getMessage());
			}

			return count;
		}

		@Override
		public int getNumberOfCrimesRecordedInCurrentMonth() {
			int count = 0;
			String sql = "SELECT COUNT(*) FROM crime WHERE MONTH(date) = MONTH(CURDATE()) AND YEAR(date) = YEAR(CURDATE())";

			try (Connection conn = DBUtils.provideConnection();
			        PreparedStatement pstmt = conn.prepareStatement(sql)) {
			    ResultSet rs = pstmt.executeQuery();

			    if (rs.next()) {
			        count = rs.getInt(1);
			    }
			} catch (SQLException e) {
			    System.out.println("Error retrieving number of crimes recorded in current month: " + e.getMessage());
			}

			return count;
		}

	}

	