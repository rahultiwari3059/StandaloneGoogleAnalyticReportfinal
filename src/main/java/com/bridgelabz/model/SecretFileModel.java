package com.bridgelabz.model;

public class SecretFileModel {
	public String startDate;
	public String endDate;
	public String APPLICATION_NAME;
	public String KEY_FILE_LOCATION;
	public String SERVICE_ACCOUNT_EMAIL;
	public String VIEW_ID;
	public String CsvFilePath;
	public String getCsvFilePath() {
		return CsvFilePath;
	}
	public void setCsvFilePath(String csvFilePath) {
		CsvFilePath = csvFilePath;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAPPLICATION_NAME() {
		return APPLICATION_NAME;
	}
	public void setAPPLICATION_NAME(String aPPLICATION_NAME) {
		APPLICATION_NAME = aPPLICATION_NAME;
	}
	public String getKEY_FILE_LOCATION() {
		return KEY_FILE_LOCATION;
	}
	public void setKEY_FILE_LOCATION(String kEY_FILE_LOCATION) {
		KEY_FILE_LOCATION = kEY_FILE_LOCATION;
	}
	public String getSERVICE_ACCOUNT_EMAIL() {
		return SERVICE_ACCOUNT_EMAIL;
	}
	public void setSERVICE_ACCOUNT_EMAIL(String sERVICE_ACCOUNT_EMAIL) {
		SERVICE_ACCOUNT_EMAIL = sERVICE_ACCOUNT_EMAIL;
	}
	public String getVIEW_ID() {
		return VIEW_ID;
	}
	public void setVIEW_ID(String vIEW_ID) {
		VIEW_ID = vIEW_ID;
	}
}
