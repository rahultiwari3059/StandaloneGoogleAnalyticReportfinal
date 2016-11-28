package com.bridgelabz.Csvfilecreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import com.bridgelabz.model.AllElementModels;
import com.bridgelabz.model.GaReportInputModel;
import com.bridgelabz.model.SecretFileModel;

public class SummaryReportCsvFilecreator {

	static String csvFilePath;

	// arrayList of Unique date
	ArrayList<String> Uniquedate = new ArrayList<String>();

	// array list of unique total unique android id
	ArrayList<String> totalUniqueAndroidId = new ArrayList<String>();

	public SummaryReportCsvFilecreator(SecretFileModel secretFileModelObject) {
		csvFilePath = secretFileModelObject.getCsvFilePath();
	}

	public SummaryReportCsvFilecreator() {

	}

	public void summaryReportCsvFilecreator(ArrayList<AllElementModels> allElementModelArrayListObject,
			GaReportInputModel gaReportInputModel, HashSet<String> androidIdAppOpen1) {
		try {
			// HasMap of date and androidset
			HashMap<String, HashSet<String>> dateAnNdroidIdmap = new HashMap<String, HashSet<String>>();
			// System.out.println(androidIdAppOpen1.size());
			for (int k = 0; k < allElementModelArrayListObject.size(); k++) {
				// if
				// (androidIdAppOpen1.contains(allElementModelArrayListObject.get(k).getmAndroidId()))
				// {
				// assigning date
				String date = allElementModelArrayListObject.get(k).getmDate();

				// checking whether map contains date
				if (dateAnNdroidIdmap.containsKey(date)) {
					// HashSet for unique andoidId
					HashSet<String> androidset = dateAnNdroidIdmap.get(date);
					// adding into android set
					androidset.add(allElementModelArrayListObject.get(k).getmAndroidId());
					// putting into HashMap
					dateAnNdroidIdmap.put(date, androidset);
				} else {

					// assigning in android id
					String AndoidId = allElementModelArrayListObject.get(k).getmAndroidId();
					// HashSet of android set
					HashSet<String> androidset = new HashSet<String>();
					// adding into android set
					androidset.add(AndoidId);
					// putting into HashMap
					dateAnNdroidIdmap.put(date, androidset);

				}
			}
			// }
			/*----------------- adding into array list after fetching from hash map ------------------------------*/
			for (Entry<String, HashSet<String>> m1 : dateAnNdroidIdmap.entrySet()) {
				// adding into array list
				Uniquedate.add(m1.getKey());
				// adding into array list
				totalUniqueAndroidId.add(String.valueOf(m1.getValue().size()));
				// printing corresponding value
				//System.out.println(m1.getKey() + " " + m1.getValue().size());
			}
			/*-------------------------- for creating summary report CSv------------------------------------------ */
			// for csv file creation
			boolean b = false;
			// CSV creator for number of summary Report
			File file = new File(csvFilePath + "summaryreport.csv");
			/*if (file.exists())
				file.delete();*/

			if (!file.exists())
				b = true;

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (b) {
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
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

}
