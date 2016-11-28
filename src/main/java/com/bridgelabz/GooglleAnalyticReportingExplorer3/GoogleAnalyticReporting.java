package com.bridgelabz.GooglleAnalyticReportingExplorer3;

import java.util.ArrayList;

import com.bridgelabz.inputReader.GaReprtInfoArrayList;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.ResponseModel;
import com.bridgelabz.responseElementReader.ResponseElementReader;
import com.bridgelabz.responseFetcher.GaReportResponseFetcher;

public class GoogleAnalyticReporting {

	public static void main(String[] args) {
		try {

			// taking JSON file path
			String jsonfilepath = args[0];

			
			 //creating object of ResponseModel
			 ResponseModel responseModelObject= new ResponseModel();
			 
			// creating object of ResponseElementReader
			ResponseElementReader ResponseElementReader = new ResponseElementReader();

			// creating object of GaReportResponseFetcher
			GaReportResponseFetcher gaReportResponseFetcherObject = new GaReportResponseFetcher();

			// creating object GaReprtInfoArrayList class
			GaReprtInfoArrayList GaReprtInfoArrayListObject = new GaReprtInfoArrayList();

			// passing JSONpath and getting ArrayList of GaInputInfoModel class
			ArrayList<GaReportInputModel> gaReportInputInfoArrayList = GaReprtInfoArrayListObject
					.readInputJsonFile(jsonfilepath);

			for (int i = 0; i < gaReportInputInfoArrayList.size(); i++) {

				// making ArrayList of responseModel after passing one by one
				// gaReportInputInfoArrayList

				responseModelObject = gaReportResponseFetcherObject
						.getResponse(gaReportInputInfoArrayList.get(i));

				ResponseElementReader.responseElementReader(responseModelObject,
						gaReportInputInfoArrayList.get(i));

			}
			
			System.out.println("all reports are created");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}