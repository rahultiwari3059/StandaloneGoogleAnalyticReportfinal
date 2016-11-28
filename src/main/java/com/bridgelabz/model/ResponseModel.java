package com.bridgelabz.model;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseModel {

	private ArrayList<String> mColumnHeaderArrayList;
	private ArrayList<String> mMetricHeaderArrayList;
	private ArrayList<HashMap<String, String>> dimensionHashMapArrayList;
	private ArrayList<HashMap<String, String>> metricHashMapArrayList;

	// setter and getter method
	public ArrayList<HashMap<String, String>> getMetricHashMapArrayList() {
		return metricHashMapArrayList;
	}

	public void setMetricHashMapArrayList(ArrayList<HashMap<String, String>> metricHashMapArrayList) {
		this.metricHashMapArrayList = metricHashMapArrayList;
	}

	public ArrayList<String> getmColumnHeaderArrayList() {
		return mColumnHeaderArrayList;
	}

	public void setmColumnHeaderArrayList(ArrayList<String> mColumnHeaderArrayList) {
		this.mColumnHeaderArrayList = mColumnHeaderArrayList;
	}

	public ArrayList<String> getmMetricHeaderArrayList() {
		return mMetricHeaderArrayList;
	}

	public void setmMetricHeaderArrayList(ArrayList<String> mMetricHeaderArrayList) {
		this.mMetricHeaderArrayList = mMetricHeaderArrayList;
	}

	public ArrayList<HashMap<String, String>> getDimensionHashMapArrayList() {
		return dimensionHashMapArrayList;
	}

	public void setDimensionHashMapArrayList(ArrayList<HashMap<String, String>> dimensionHashMapArrayList) {
		this.dimensionHashMapArrayList = dimensionHashMapArrayList;
	}
}
