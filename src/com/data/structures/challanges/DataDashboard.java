package com.data.structures.challanges;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class DataDashboard {

	private static final String delimiter = "-|,|\\(";
	private static final String STOPPER_WORD = "NOT PROVIDED";
	private static final String numnericRegex = "^[0-9]+$";
	
	public static void main(String[] args) throws IOException {
		Reader in = new FileReader("pay4cfef84.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader("Id","name",
				"job_title","base_pay","overtime_pay","other_pay","benefits").withSkipHeaderRecord().parse(in);
		List<employee_salaries> eList = new ArrayList<employee_salaries>();
		for (CSVRecord record : records) {
			eList.add(new employee_salaries(
					Long.parseLong(	processInput("Id", record)), 
					record.get("name"), 
					record.get("job_title"), 
					Double.parseDouble(processInput("base_pay", record)),
					Double.parseDouble(processInput("overtime_pay", record)), 
					Double.parseDouble(processInput("other_pay", record)),
					Double.parseDouble(processInput("benefits", record))));
		
		}
		Map<String, Integer> jobTitleCounts = new HashMap<String, Integer>();
		BigDecimal avgSalary = new BigDecimal(0);
		String mostCommonJobTitle = "";
		int max = 0;
		for (employee_salaries e : eList){
			String tmp = e.job_title;
			if (tmp != null && !tmp.isEmpty() && !tmp.equalsIgnoreCase(STOPPER_WORD)) {
				tmp = e.job_title.trim().toUpperCase().split(delimiter)[0].trim();
				tmp = changeJobLevelToNumeric(tmp).trim();
				Integer i = jobTitleCounts.get(tmp);
				if (i != null) {
					i = i+1;
					jobTitleCounts.put(tmp, i);
					if (max <= i.intValue()) {
						mostCommonJobTitle = tmp;
						max = i;
					}
				} else {
					jobTitleCounts.put(tmp, 1);
					mostCommonJobTitle = tmp;
					max = 1;
				}
				//System.out.println(mostCommonJobTitle);
			}
			//System.out.println(e.base_pay+e.benefits+e.other_pay+e.other_pay);
			avgSalary = avgSalary.add(new BigDecimal( e.base_pay+e.benefits+e.other_pay+e.other_pay));
		}
		avgSalary = avgSalary.divide(new BigDecimal(eList.size()), 2);
		//System.out.println(jobTitleCounts);
		System.out.println("Avg salary : " + avgSalary.doubleValue());
		System.out.println("Most Common Job Title : " +mostCommonJobTitle);
	}
	
	
	private static String changeJobLevelToNumeric(String tmp) {
		StringTokenizer tokens = new StringTokenizer(tmp);
		String last = "";
		int lastTokenNum = tokens.countTokens();
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		while(tokens.hasMoreTokens()) {
			last = tokens.nextToken();
			if (checkNumerin(last.trim()) && count == lastTokenNum) {
				switch(last.trim().toUpperCase()) {
					case "I": last = "1"; break;
					case "II": last = "2" ; break;
					case "III":	last = "3" ; break;
					case "IV": last = "4" ; break;
					case "V": last = "5" ; break;
					case "VI": last = "6" ; break;
					case "VII": last = "7" ; break;
					case "VIII": last = "8" ; break;
					case "IX": last = "9" ; break;
					case "X": last = "10" ; break;
					default : System.out.println("Wow!!");	last = "99" ; break;
				}
			}
			buffer.append(last);
			buffer.append(" ");
		}
		//System.out.println(buffer.toString());
		return buffer.toString(); 
	}


	private static boolean checkNumerin(String last) {
		if (last.matches(numnericRegex))
			return true;
		else  
			return false;
	}


	private static String processInput(String name, CSVRecord record) {
		String tmp = record.get(name);
		if (tmp == null || tmp.isEmpty()) 
			tmp = "0";
		try {
			Double.parseDouble(tmp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			tmp = "0";
		}
		return tmp;
	}

}

class employee_salaries {
	public long id;
	public String name;
	public String job_title; 
	public double base_pay;
	public double overtime_pay;
	public double other_pay;
	public double benefits;
	
	public employee_salaries(long id, String name, String job_title, double base_pay, double overtime_pay, double other_pay, double benefits) {
		this.id = id;
		this.name = name;
		this.job_title = job_title;
		this.base_pay = base_pay;
		this.overtime_pay = overtime_pay;
		this.other_pay = other_pay;
		this.benefits = benefits;
	}
	
}
