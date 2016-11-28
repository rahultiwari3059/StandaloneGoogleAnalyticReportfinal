package com.bridgelabz.model;

import java.util.ArrayList;

public class GaReportInputModel {
	public String mGaID;
	public String mGaDiscription;
	public ArrayList <String> mMetricArraList ;
	public ArrayList <String> mDimensionArraList ;
	public ArrayList <String> mDimensionFilterArraList ;
	public String startDate;
	public String endDate;
	public String APPLICATION_NAME;
	public String KEY_FILE_LOCATION;
	public String SERVICE_ACCOUNT_EMAIL;
	public String VIEW_ID;
	// setter and getter method
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEnddate() {
		return endDate;
	}
	public void setEnddate(String enddate) {
		this.endDate = enddate;
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
	public void setmGaID(String mGaID) {
		this.mGaID = mGaID;
	}
	public void setmGaDiscription(String mGaDiscription) {
		this.mGaDiscription = mGaDiscription;
	}
	public void setmMetricArraList(ArrayList<String> mMetricArraList) {
		this.mMetricArraList = mMetricArraList;
	}
	public void setmDimensionArraList(ArrayList<String> mDimensionArraList) {
		this.mDimensionArraList = mDimensionArraList;
	}
	public void setmDimensionFilterArraList(ArrayList<String> mDimensionFilterArraList) {
		this.mDimensionFilterArraList = mDimensionFilterArraList;
	}
	public String getmGaID() {
		return mGaID;
	}
	public String getmGaDiscription() {
		return mGaDiscription;
	}
	public ArrayList<String> getmMetricArraList() {
		return mMetricArraList;
	}
	public ArrayList<String> getmDimensionArraList() {
		return mDimensionArraList;
	}
	
	public ArrayList<String> getmDimensionFilterArraList() {
		return mDimensionFilterArraList;
	}
	
	
	
	
}
