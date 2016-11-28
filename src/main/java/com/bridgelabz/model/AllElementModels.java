package com.bridgelabz.model;

public class AllElementModels {
	private String mGaid;
	private String mGadiscription;
	@Override
	public String toString() {
		return "AllElementModels [mGaid=" + mGaid + ", mGadiscription=" + mGadiscription + ", mAndroidId=" + mAndroidId
				+ ", mDate=" + mDate + "]";
	}
	private String mAndroidId;
	private String mDate;
	public String getmGaid() {
		return mGaid;
	}
	public void setmGaid(String mGaid) {
		this.mGaid = mGaid;
	}
	public String getmGadiscription() {
		return mGadiscription;
	}
	public void setmGadiscription(String mGadiscription) {
		this.mGadiscription = mGadiscription;
	}
	public String getmAndroidId() {
		return mAndroidId;
	}
	public void setmAndroidId(String mAndroidId) {
		this.mAndroidId = mAndroidId;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	

}
