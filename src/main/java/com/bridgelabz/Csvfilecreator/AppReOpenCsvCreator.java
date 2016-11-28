package com.bridgelabz.Csvfilecreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import com.bridgelabz.model.AppReOpenModel;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.SecretFileModel;

public class AppReOpenCsvCreator {
	static String csvFilePath;

	public AppReOpenCsvCreator(SecretFileModel secretFileModelObject) {
		csvFilePath = secretFileModelObject.getCsvFilePath();
	}

	public AppReOpenCsvCreator() {

	}

	// arrayList of Unique date
	ArrayList<String> Uniquedate = new ArrayList<String>();

	// array list of unique total unique android id
	ArrayList<String> totalUniqueAndroidId = new ArrayList<String>();

	public HashSet<String> appReOpenCsvCreator(ArrayList<AppReOpenModel> appReOpenModelArrayListObject,
			GaReportInputModel gaReportInputModel) {

		// creating HashSet object to add android id
		HashSet<String> androidIdReAppOpen = new HashSet<String>();
		try {

			boolean b = false;
			File file1 = new File(csvFilePath + "GAReportappReopen.csv");
			if (file1.exists())
				file1.delete();
			
			if (!file1.exists()) 
				b = true;
			
			FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(), true);
			BufferedWriter bw1 = new BufferedWriter(fw1);
			if (b) {
				file1.createNewFile();

				bw1.append("gaid^gadiscription^AndroidId^Eventcategory^Date^");
				bw1.newLine();
			}
			for (int i = 0; i < appReOpenModelArrayListObject.size(); i++) {

				bw1.append(gaReportInputModel.getmGaID());
				bw1.append("^");

				bw1.append(gaReportInputModel.getmGaDiscription());
				bw1.append("^");

				bw1.append(appReOpenModelArrayListObject.get(i).getmAndroidId());
				// adding into androidIdReAppOpen AppReOpen
				androidIdReAppOpen.add(appReOpenModelArrayListObject.get(i).getmAndroidId());
				bw1.append("^");

				bw1.append(appReOpenModelArrayListObject.get(i).getmEventcategory());
				bw1.append("^");

				bw1.append(appReOpenModelArrayListObject.get(i).getmDate());
				bw1.append("^");

				bw1.newLine();

			}
			bw1.close();
			// HasMap of date and androidset
			HashMap<String, HashSet<String>> dateAnNdroidIdmap = new HashMap<String, HashSet<String>>();
			for (int k = 0; k < appReOpenModelArrayListObject.size(); k++) {
				// if
				// (androidIdAppOpen1.contains(allElementModelArrayListObject.get(k).getmAndroidId()))
				// {
				// assigning date
				String date = appReOpenModelArrayListObject.get(k).getmDate();

				// checking whether map contains date
				if (dateAnNdroidIdmap.containsKey(date)) {
					// HashSet for unique andoidId
					HashSet<String> androidset = dateAnNdroidIdmap.get(date);
					// adding into android set
					androidset.add(appReOpenModelArrayListObject.get(k).getmAndroidId());
					// putting into HashMap
					dateAnNdroidIdmap.put(date, androidset);
				} else {

					// assigning in android id
					String AndoidId = appReOpenModelArrayListObject.get(k).getmAndroidId();
					// HashSet of android set
					HashSet<String> androidset = new HashSet<String>();
					// adding into android set
					androidset.add(AndoidId);
					// putting into HashMap
					dateAnNdroidIdmap.put(date, androidset);

				}
			}

			/*----------------- adding into array list after fetching from hash map ------------------------------*/
			for (Entry<String, HashSet<String>> m1 : dateAnNdroidIdmap.entrySet()) {
				// adding into array list
				Uniquedate.add(m1.getKey());
				// adding into array list
				totalUniqueAndroidId.add(String.valueOf(m1.getValue().size()));
				// printing corresponding value
				//System.out.println(m1.getKey() + " " + m1.getValue().size());
			} // for csv file creation
			boolean b1 = false;
			// CSV creator for number of summary Report
			File file = new File(csvFilePath + "summaryreport.csv");
			if (!file.exists()) {
				b1 = true;
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (b1) {
				file.createNewFile();
				// appending id and ga discription
				bw.append("gaid");
				bw.append("^");
				bw.append("gadiscription");
				bw.append("^");
				// appending date in summary response
				for (int j1 = 0; j1 < Uniquedate.size(); j1++) {
					bw.append(Uniquedate.get(j1));
					bw.append("^");
				}
				bw.newLine();
			}
			if (true) {
				bw.append(gaReportInputModel.getmGaID());
				bw.append("^");
				bw.append(gaReportInputModel.getmGaDiscription());
				bw.append("^");
				// appending total values
				for (Entry<String, HashSet<String>> m1 : dateAnNdroidIdmap.entrySet()) {
					bw.append(String.valueOf(m1.getValue().size()));
					bw.append("^");
				}
				bw.newLine();
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return androidIdReAppOpen;
	}
}
