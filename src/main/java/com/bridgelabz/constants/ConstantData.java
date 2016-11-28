package com.bridgelabz.constants;

public interface ConstantData {

	static final String one = "1";
	static final String two = "2";
	static final String isNull = "null";
	static final char csvDelimiter = '^';
	//file path for android id operations
	static final String resultsFilepath = "/home/bridgeit/Music/SpringWeb/";
	
	//constants for input json file
	static final String startDate = "startDate";
	static final String endDate = "endDate";
	static final String APPLICATION_NAME = "APPLICATION_NAME";
	static final String KEY_FILE_LOCATION = "KEY_FILE_LOCATION";
	static final String SERVICE_ACCOUNT_EMAIL = "SERVICE_ACCOUNT_EMAIL";
	static final String VIEW_ID = "VIEW_ID";
	static final String CSVFilePath = "CSVFilePath";
	
	static final String GAReportInfo = "GAReportInfo";
	static final String GAID = "GAID";
	static final String GAdiscription ="GAdiscription";
	static final String metric = "metric";
	static final String dimension = "dimension";
	static final String dimensionfilter = "dimensionfilter";
	
	//constants for reading response json
	static final String reports = "reports";
	static final String columnHeader = "columnHeader";
	static final String metricHeader = "metricHeader";
	static final String metricHeaderEntries = "metricHeaderEntries";
	static final String name = "name";
	static final String dimensions = "dimensions";
	static final String data = "data";
	static final String rows = "rows";
	static final String metrics = "metrics";
	static final String values = "values";
	
	static final String date = "ga:date";
	static final String dimension1 = "ga:dimension1";
	static final String eventCategory = "ga:eventCategory";
	static final String dimension8 = "ga:dimension8";
	
	//operators constants for dimention filters in input json
	static final String operatorEXACT = "EXACT";
	static final String operatorPARTIAL = "PARTIAL";
	static final String operatorAND = "AND";
	
}
