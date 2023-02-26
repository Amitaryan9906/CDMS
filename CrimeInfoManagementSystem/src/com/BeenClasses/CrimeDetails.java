package com.BeenClasses;


public class CrimeDetails {
	 private int crimeId;
	    private String date;
	    private String place;
	    private String description;
	    private String victims;
	    private String details;
	    private String suspected;
	    private String status;
	    private String police_Station_name;
	    private String area;
	    
	    public CrimeDetails() {}
	        public CrimeDetails(int crimeId, String date, String place, String description, String victims, String details,
				String suspected, String status, String police_station_name,String area) {
			super();
			this.crimeId = crimeId;
			this.date = date;
			this.place = place;
			this.description = description;
			this.victims = victims;
			this.details = details;
			this.suspected = suspected;
			this.status = status;
			this.police_Station_name=police_station_name;
			this.area=area;
		}
		
		public String getArea() {
				return area;
			}
			public void setArea(String area) {
				this.area = area;
			}
		public String getPolice_Station_name() {
				return police_Station_name;
			}
			public void setPolice_Station_name(String police_Station_name) {
				this.police_Station_name = police_Station_name;
			}
		public int getCrimeId() {
			return crimeId;
		}
		public void setCrimeId(int crimeId) {
			this.crimeId = crimeId;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getPlace() {
			return place;
		}
		public void setPlace(String place) {
			this.place = place;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getVictims() {
			return victims;
		}
		public void setVictims(String victims) {
			this.victims = victims;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		public String getSuspected() {
			return suspected;
		}
		public void setSuspected(String suspected) {
			this.suspected = suspected;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
}
