package com.bridgelabz.inputReader;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.Csvfilecreator.AllElementCSvFileCreator;
import com.bridgelabz.Csvfilecreator.AppOpenCsvCreator;
import com.bridgelabz.Csvfilecreator.AppReOpenCsvCreator;
import com.bridgelabz.Csvfilecreator.SummaryReportCsvFilecreator;
import com.bridgelabz.constants.ConstantData;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.SecretFileModel;
import com.bridgelabz.responseFetcher.GaReportResponseFetcher;
import com.bridgelabz.responseFetcher.InitializeAnalyticsReporting;

public class GaReprtInfoArrayList {

	// ArrayList of model class
	ArrayList<GaReportInputModel> GaReportInputModelArrayList = new ArrayList<GaReportInputModel>();

	// method for reading JsonFile
	public ArrayList<GaReportInputModel> readInputJsonFile(String jsonfilepath) {

		try {
			// creating object of SecretFileModel to set data from JSON data
			SecretFileModel secretFileModelObject = new SecretFileModel();

			JSONParser parser = new JSONParser();
			// parsing and casting to Object
			Object obj = parser.parse(new FileReader(jsonfilepath));
			// casting object into JSONObject
			JSONObject jsonObject = (JSONObject) obj;

			// setting value in secretFileModelObject
			secretFileModelObject.setStartDate((String) jsonObject.get(ConstantData.startDate));

			secretFileModelObject.setEndDate((String) jsonObject.get(ConstantData.endDate));

			secretFileModelObject.setAPPLICATION_NAME((String) jsonObject.get(ConstantData.APPLICATION_NAME));

			secretFileModelObject.setKEY_FILE_LOCATION((String) jsonObject.get(ConstantData.KEY_FILE_LOCATION));

			secretFileModelObject.setSERVICE_ACCOUNT_EMAIL((String) jsonObject.get(ConstantData.SERVICE_ACCOUNT_EMAIL));

			secretFileModelObject.setVIEW_ID((String) jsonObject.get(ConstantData.VIEW_ID));

			secretFileModelObject.setCsvFilePath((String) jsonObject.get(ConstantData.CSVFilePath));

			// passing secretFileModelObject to constructor to set all secret
			// credential

			InitializeAnalyticsReporting initializeAnalyticsReportingObject = new InitializeAnalyticsReporting(
					secretFileModelObject);

			AllElementCSvFileCreator allElementCSvFileCreatorObject = new AllElementCSvFileCreator(
					secretFileModelObject);

			AppOpenCsvCreator appOpenCsvCreatorObject = new AppOpenCsvCreator(secretFileModelObject);

			AppReOpenCsvCreator appReOpenCsvCreatorObject = new AppReOpenCsvCreator(secretFileModelObject);

			SummaryReportCsvFilecreator summaryReportCsvFilecreatorObject = new SummaryReportCsvFilecreator(
					secretFileModelObject);

			GaReportResponseFetcher gaReportResponseFetcherObject = new GaReportResponseFetcher(secretFileModelObject);
			// casting into jsonArray
			JSONArray gaReportInfoArray = (JSONArray) jsonObject.get(ConstantData.GAReportInfo);

			// reading one by one object
			for (int i = 0; i < gaReportInfoArray.size(); i++) {
				GaReportInputModel gaReportInputModelObject = new GaReportInputModel();

				// initializing all value

				ArrayList<String> metricArraList = new ArrayList<String>();
				ArrayList<String> dimensionArraList = new ArrayList<String>();
				ArrayList<String> dimensionFilterArraList = new ArrayList<String>();

				JSONObject gaReportInfoObject = (JSONObject) gaReportInfoArray.get(i);

				metricArraList.clear();
				dimensionArraList.clear();
				dimensionFilterArraList.clear();

				// setting gaid into model class

				gaReportInputModelObject.setmGaID((String) gaReportInfoObject.get(ConstantData.GAID));

				// setting in model class

				gaReportInputModelObject.setmGaDiscription((String) gaReportInfoObject.get(ConstantData.GAdiscription));

				// making metric array
				JSONArray metricJSONArray = (JSONArray) gaReportInfoObject.get(ConstantData.metric);
				// reading the metric array
				for (int k = 0; k < metricJSONArray.size(); k++) {
					// adding into metric ArrayList
					metricArraList.add((String) metricJSONArray.get(k));
				}
				// setting metric in model class
				gaReportInputModelObject.setmMetricArraList(metricArraList);

				// making dimension JSONArray
				JSONArray dimensionsJSONArray = (JSONArray) gaReportInfoObject.get(ConstantData.dimension);
				// reading the dimension array
				for (int j = 0; j < dimensionsJSONArray.size(); j++) {
					dimensionArraList.add((String) dimensionsJSONArray.get(j));
				}
				// setting dimension in model class
				gaReportInputModelObject.setmDimensionArraList(dimensionArraList);

				// Casting DimensionFilter into JSONArray
				JSONArray dimensionFilterJSONArray = (JSONArray) gaReportInfoObject.get(ConstantData.dimensionfilter);

				for (int l = 0; l < dimensionFilterJSONArray.size(); l++) {
					// adding into DimensionFilter ArrayList
					dimensionFilterArraList.add((String) dimensionFilterJSONArray.get(l));
				}
				// setting dimension filter in model class
				gaReportInputModelObject.setmDimensionFilterArraList(dimensionFilterArraList);

				GaReportInputModelArrayList.add(gaReportInputModelObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// returning the ArrayList of report info
		return GaReportInputModelArrayList;
	}

}