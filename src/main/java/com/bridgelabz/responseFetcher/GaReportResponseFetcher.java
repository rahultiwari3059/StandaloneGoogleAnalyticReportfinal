package com.bridgelabz.responseFetcher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.ResponseModel;
import com.bridgelabz.model.SecretFileModel;
import com.bridgelabz.responseReader.ResponseReader;
import com.google.api.services.analyticsreporting.v4.AnalyticsReporting;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;

public class GaReportResponseFetcher {
	/* Get actual class name to be printed on */
	static Logger log = Logger.getLogger(GaReportResponseFetcher.class.getName());
	
	static String csvFilePath;

	// creating object of InitializeAnalyticsReporting
	InitializeAnalyticsReporting initializeAnalyticsReportingObject = InitializeAnalyticsReporting.getInstance();

	// creating object of ResponseReader
	ResponseReader responseReaderObject = new ResponseReader();

	/*-------------------------method to get the response model ArrayList------------------------------------*/
	// to get csvfilepath

	public GaReportResponseFetcher(SecretFileModel secretFileModelObject) {
		csvFilePath = secretFileModelObject.getCsvFilePath();
	}

	public GaReportResponseFetcher() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponseModel getResponse(GaReportInputModel gaReportInputModel) {
		ArrayList<ReportRequest> requests = new ArrayList<ReportRequest>();
		// creating object of ResponseModel
		ResponseModel responseModelObject = new ResponseModel();
		GetReportsResponse response = null;
		// calling initializeAnalyticsReporting method of
		// InitializeAnalyticsReporting class to initialize all credential
		try {
			AnalyticsReporting service = initializeAnalyticsReportingObject.initializeAnalyticsReporting();
			//getting nextToken so that we can get all rows 
			String nextToken= "0" ;
			 int i=0;
			while (nextToken!=null) {
				
				// calling getReport method to get response
				 response = initializeAnalyticsReportingObject.getReport(service, gaReportInputModel, nextToken,requests);
				// taking nextToken from response 
				 nextToken = response.getReports().get(i).getNextPageToken();
				 // printing next token 
				// System.out.println(nextToken);
				 i++;
			}

			File file1 = new File(csvFilePath + "log4j.txt");
			if (!file1.exists())
				file1.createNewFile();
			// getting nextToken so that we can get all rows

			/*-----------------method to write the response into the text file-------------------------*/
			File file = new File(csvFilePath + gaReportInputModel.getmGaDiscription() + ".txt");
			if (file.exists())
				file.delete();

			if (!file.exists())
				file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			// printing the response
			//System.out.println(response);

			// assigning response into variable response JSON of
			// GetReportsResponse type

			GetReportsResponse responsejson = response;

			bw.write(responsejson.toString());
			log.debug(responsejson.toString());
			
			bw.close();
			// reading response and placing it to responseModelArrayList
			responseModelObject = responseReaderObject.responseReader(responsejson.toString());
		} catch (Exception e) {
			e.printStackTrace();

		}

		return responseModelObject;
	}
}
