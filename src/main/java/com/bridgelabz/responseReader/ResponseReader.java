package com.bridgelabz.responseReader;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.constants.ConstantData;
import com.bridgelabz.model.ResponseModel;

public class ResponseReader {

	// creating object ResponseModelinputTypeArrayList
	ArrayList<ResponseModel> responseModelArrayList = new ArrayList<ResponseModel>();

	public ResponseModel responseReader(String response) {

		ResponseModel responseModelObject = new ResponseModel();
		JSONParser parser = new JSONParser();
		try {
			// parsing and placing in Object class
			Object obj = parser.parse(response);
			// converting object into JSONObject
			JSONObject jsonObject = (JSONObject) obj;

			// covering report array into JSONArray
			JSONArray reportarray = (JSONArray) jsonObject.get(ConstantData.reports);
			
			// creating object of ArrayList of columnHeader and metricHeader
			ArrayList<String> columnHeaderArrayList = new ArrayList<String>();
			ArrayList<String> metricHeaderArrayList = new ArrayList<String>();

			// arrayList of HashMap ArrayList of dimension
			ArrayList<HashMap<String, String>> dimensionHashMapArrayList = new ArrayList<HashMap<String, String>>();

			// arrayList of HashMap ArrayList of metrics
			ArrayList<HashMap<String, String>> metricHashMapArrayList = new ArrayList<HashMap<String, String>>();


			// reading report JSONArray
			for (int j = 0; j < reportarray.size(); j++) {

				
				// getting first object and converting into JSONObject
				JSONObject obj3 = (JSONObject) reportarray.get(j);

				// making JSON object of columnHeader
				JSONObject columnHeaderObject = (JSONObject) obj3.get(ConstantData.columnHeader);

	/*--------------------------------to read metric name type from response------------------------------------*/
				JSONObject metricHeaderObject = (JSONObject) columnHeaderObject.get(ConstantData.metricHeader);

				JSONArray metricheader1 = (JSONArray) metricHeaderObject.get(ConstantData.metricHeaderEntries);

				for (int l = 0; l < metricheader1.size(); l++) {
					JSONObject metricElemnt = (JSONObject) metricheader1.get(l);
					// System.out.println(metricElemnt);

					metricHeaderArrayList.add((String) metricElemnt.get(l));

				}
				responseModelObject.setmMetricHeaderArrayList(metricHeaderArrayList);
	/*--------------------------------to read dimension name type from response------------------------------------*/

				JSONArray dimensionHeaderArrayInput = (JSONArray) columnHeaderObject.get(ConstantData.dimensions);

				for (int k = 0; k < dimensionHeaderArrayInput.size(); k++) {

					columnHeaderArrayList.add((String) dimensionHeaderArrayInput.get(k));
				}
				responseModelObject.setmColumnHeaderArrayList(columnHeaderArrayList);
/*-------------------------------------reading row data -----------------------------------------------------------------*/
				// making JSONObject of data
				JSONObject dataobject = (JSONObject) obj3.get(ConstantData.data);
				// making JSONArray of rows

				JSONArray rowarray = (JSONArray) dataobject.get(ConstantData.rows);
				
				
				if ((JSONArray) dataobject.get(ConstantData.rows) == null) {
					
					responseModelObject.setDimensionHashMapArrayList(null);
					responseModelObject.setMetricHashMapArrayList(null);
				}
				else
				{
				for (int i = 0; i < rowarray.size(); i++) {

					// creating HashMap of dimension
					HashMap<String, String> dimensionHashMap = new HashMap<String, String>();
					// creating HashMap of metric
					HashMap<String, String> metricHashMap = new HashMap<String, String>();

					// getting first object and converting into JSONObject
					JSONObject rowobject = (JSONObject) rowarray.get(i);

					// making metrics JSONArray
					JSONArray metricarray = (JSONArray) rowobject.get(ConstantData.metrics);
					// storing metric JSONArray size into temp2

					// iterating metric JSONArray
					for (int k = 0; k < metricarray.size(); k++) {
						// getting first object and converting into
						// JSONObject
						JSONObject metricobject = (JSONObject) metricarray.get(k);
						// making values JSONArray
						JSONArray valuesarray = (JSONArray) metricobject.get(ConstantData.values);

						// converting JSONArray into JSONString
						String valuestring = JSONArray.toJSONString(valuesarray);
						for (int l1 = 0; l1 < valuesarray.size(); l1++) {
							metricHashMap.put(metricHeaderArrayList.get(l1), (String) valuesarray.get(l1));
						}
						// adding into
						metricHashMapArrayList.add(metricHashMap);
						// adding into value1 ArrayList
						

					}
					//setting metric value 
					responseModelObject.setMetricHashMapArrayList(metricHashMapArrayList);

					/*-----------------------------putting element into HashMap-------------------------------------*/

					// casting into dimensions JSONArray
					JSONArray dimensionsarray = (JSONArray) rowobject.get(ConstantData.dimensions);
					// taking size of dimension array

					for (int l = 0; l < dimensionsarray.size(); l++) {
						// adding into ArrayList
						dimensionHashMap.put(columnHeaderArrayList.get(l), (String) dimensionsarray.get(l));

					}
					//adding into dimension HashMap
					dimensionHashMapArrayList.add(dimensionHashMap);

					
				}
			
				//setting value into response model class 
				responseModelObject.setDimensionHashMapArrayList(dimensionHashMapArrayList);
			}
			}
			responseModelArrayList.add(responseModelObject);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return responseModelObject;
	}
}