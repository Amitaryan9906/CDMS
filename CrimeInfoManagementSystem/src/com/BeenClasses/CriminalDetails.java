package com.BeenClasses;

public class CriminalDetails {
	  private int criminalId;
	    private String name;
	    private int age;
	    private String gender;
	    private String address;
	    private String identifyingMark;
	    private String areaOfArrest;
	    private String attachedToCrime;
	    public CriminalDetails() {}
		public CriminalDetails(int criminalId, String name, int age, String gender, String address,
				String identifyingMark, String areaOfArrest, String attachedToCrime) {
			super();
			this.criminalId = criminalId;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.address = address;
			this.identifyingMark = identifyingMark;
			this.areaOfArrest = areaOfArrest;
			this.attachedToCrime = attachedToCrime;
		}
		public int getCriminalId() {
			return criminalId;
		}
		public void setCriminalId(int criminalId) {
			this.criminalId = criminalId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getIdentifyingMark() {
			return identifyingMark;
		}
		public void setIdentifyingMark(String identifyingMark) {
			this.identifyingMark = identifyingMark;
		}
		public String getAreaOfArrest() {
			return areaOfArrest;
		}
		public void setAreaOfArrest(String areaOfArrest) {
			this.areaOfArrest = areaOfArrest;
		}
		public String getAttachedToCrime() {
			return attachedToCrime;
		}
		public void setAttachedToCrime(String attachedToCrime) {
			this.attachedToCrime = attachedToCrime;
		}
}
