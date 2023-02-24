package com.BeenClasses;

import java.util.Date;
import java.util.List;

public class Crime {
	  private int id;
	    private Date date;
	    private String place;
	    private String description;
	    private String victims;
	    private String details;
	    private List<String> suspects;
	    private boolean solved;
	    
	    
	    public Crime() {}
		public Crime(int id, Date date, String place, String description, String victims, String details,
				List<String> suspects, boolean solved) {
			super();
			this.id = id;
			this.date = date;
			this.place = place;
			this.description = description;
			this.victims = victims;
			this.details = details;
			this.suspects = suspects;
			this.solved = solved;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
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
		public List<String> getSuspects() {
			return suspects;
		}
		public void setSuspects(List<String> suspects) {
			this.suspects = suspects;
		}
		public boolean isSolved() {
			return solved;
		}
		public void setSolved(boolean solved) {
			this.solved = solved;
		}
}
