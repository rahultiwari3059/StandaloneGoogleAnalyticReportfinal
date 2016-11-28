package com.bridgelabz.responseElementReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import com.bridgelabz.Csvfilecreator.AllElementCSvFileCreator;
import com.bridgelabz.Csvfilecreator.AppOpenCsvCreator;
import com.bridgelabz.Csvfilecreator.AppReOpenCsvCreator;
import com.bridgelabz.constants.ConstantData;
import com.bridgelabz.model.AllElementModels;
import com.bridgelabz.model.AppOpenModel;
import com.bridgelabz.model.AppReOpenModel;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.ResponseModel;

public class ResponseElementReader {

	// creating object of dimensionHashMapArrayList to store
	// dimensionHashMapArrayList
	ArrayList<HashMap<String, String>> dimensionHashMapArrayList = new ArrayList<HashMap<String, String>>();

	// creating object of AppOpenCsvCreator class
	AppOpenCsvCreator appOpenCsvCreatorObject = new AppOpenCsvCreator();
	// creating object of AppReOpenCsvCreator
	AppReOpenCsvCreator appReOpenCsvCreatorObject = new AppReOpenCsvCreator();
	// creating object of AllElementCSvFileCreator class
	AllElementCSvFileCreator allElementCSvFileCreatorObject = new AllElementCSvFileCreator();
	//hash set for app open android id 
	HashSet<String> androidIdAppOpen;
	//hash set for app Reopen android id 
	HashSet<String> androidIdReAppOpen;

	public void responseElementReader(ResponseModel responseModelObject, GaReportInputModel gaReportInputModel) {
		try {
			// creating object of ArrayListAppOpenModel
			ArrayList<AppOpenModel> appOpenModelArrayListObject = new ArrayList<AppOpenModel>();
			// creating object of ArrayListReAppOpenModel
			ArrayList<AppReOpenModel> appReOpenModelArrayListObject = new ArrayList<AppReOpenModel>();
			// creating object of AllElementArrayList
			ArrayList<AllElementModels> allElementModelArrayListObject = new ArrayList<AllElementModels>();
			boolean appOpenFlag = false;
			boolean appReOpenFlag = false;
			boolean allElementFlag = false;
			boolean allElementFlag1 = false;
			// assigning to dimensionHashMapArrayList
			dimensionHashMapArrayList = responseModelObject.getDimensionHashMapArrayList();
			/*-----------------------if response object have null value------------------------*/
			if (dimensionHashMapArrayList.equals(ConstantData.isNull)) {
				AllElementModels allElementModelsObject = new AllElementModels();
				allElementModelsObject.setmDate("");
				allElementModelsObject.setmAndroidId(" ");
			} else {
				for (int i = 0; i < dimensionHashMapArrayList.size(); i++) {
					// creating object of AppOpenModel
					AppOpenModel appOpenModelObject = new AppOpenModel();
					// creating object of AppReOpenModel
					AppReOpenModel appReOpenModelObject = new AppReOpenModel();
					// creating object of AllElementModel
					AllElementModels allElementModelsObject = new AllElementModels();

					// iterating element of hashmapArrayList
					for (Entry<String, String> m1 : dimensionHashMapArrayList.get(i).entrySet()) {

						/*----------------------------------for appOpen-----------------------------------------------------*/
						if (gaReportInputModel.getmGaID().equals(ConstantData.one)) {

							appReOpenFlag = true;
							allElementFlag = true;
							appOpenModelObject.setmGaId(gaReportInputModel.getmGaID());

							appOpenModelObject.setmGadiscription(gaReportInputModel.getmGaDiscription());

							if (m1.getKey().equals(ConstantData.date)) {
								appOpenModelObject.setmDate(m1.getValue());

							}
							if (m1.getKey().equals(ConstantData.dimension1)) {
								appOpenModelObject.setmAndroidId(m1.getValue());

							}
							if (m1.getKey().equals(ConstantData.eventCategory)) {
								appOpenModelObject.setmEventcategory(m1.getValue());

							}

						}
						/*----------------------------------for appReOpen------------------------------------------------*/

						if (gaReportInputModel.getmGaID().equals(ConstantData.two)) {
							appOpenFlag = true;
							allElementFlag1 = true;
							appReOpenModelObject.setmGaId(gaReportInputModel.getmGaID());

							appReOpenModelObject.setmGadiscription(gaReportInputModel.getmGaDiscription());

							if (m1.getKey().equals(ConstantData.date)) {
								appReOpenModelObject.setmDate(m1.getValue());

							}
							if (m1.getKey().equals(ConstantData.dimension1)) {
								appReOpenModelObject.setmAndroidId(m1.getValue());

							}
							if (m1.getKey().equals(ConstantData.eventCategory)) {
								appReOpenModelObject.setmEventcategory(m1.getValue());

							}

						}
						/*-------------if other than App open and ReOpen------*/
						if (!gaReportInputModel.getmGaID().equals(ConstantData.one) && !gaReportInputModel.getmGaID().equals(ConstantData.two)) {

							allElementModelsObject.setmGaid(gaReportInputModel.getmGaID());

							allElementModelsObject.setmGadiscription(gaReportInputModel.getmGaDiscription());

							if (m1.getKey().equals(ConstantData.date)) {
								allElementModelsObject.setmDate(m1.getValue());
								// System.out.println("date"+allElementModelsObject.getmDate());
							}
							if (m1.getKey().equals(ConstantData.dimension1)) {
								allElementModelsObject.setmAndroidId(m1.getValue());
								// System.out.println("androidid"+m1.getValue());
							}
							// System.out.println(allElementModelsObject.toString());
						}

					}
					if (!appOpenFlag)
						appOpenModelArrayListObject.add(appOpenModelObject);
					if (!appReOpenFlag)
						appReOpenModelArrayListObject.add(appReOpenModelObject);
					if (!allElementFlag && !allElementFlag1)
						allElementModelArrayListObject.add(allElementModelsObject);
				}
			}
			// System.out.println(allElementModelArrayListObject.toString());
			// method to create appOpen CSvfile
			if (gaReportInputModel.getmGaID().equals(ConstantData.one)) {
				androidIdAppOpen = appOpenCsvCreatorObject.appOpenCsvCreator(appOpenModelArrayListObject,
						gaReportInputModel);
			}
			// method to create appOpen CSvfile
			if (gaReportInputModel.getmGaID().equals(ConstantData.one)) {
				androidIdReAppOpen = appReOpenCsvCreatorObject.appReOpenCsvCreator(appReOpenModelArrayListObject,
						gaReportInputModel);

			}
			// method to create all other than AppOpen and Reopen
			if (!gaReportInputModel.getmGaID().equals(ConstantData.one) && !gaReportInputModel.getmGaID().equals(ConstantData.two)) {
				allElementCSvFileCreatorObject.allElementCSvFileCreator(allElementModelArrayListObject,
						gaReportInputModel, androidIdAppOpen, androidIdReAppOpen);
			}

		} catch (Exception e) {
			
			System.out.println("there is 0 rows in response");
			//e.printStackTrace();

		}
	}

}
