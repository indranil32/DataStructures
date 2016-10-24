package com.data.structures.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ProcessExcel {
	private static InputStream inp;
	
	
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
	
		List<String> relevantNetworks = new ArrayList<String>();
		relevantNetworks.add("FS Southeast"); 
		relevantNetworks.add("FS Sun");
		relevantNetworks.add("FS Arizona");
		relevantNetworks.add("FS Cincinnati");
		relevantNetworks.add("FS Detroit");
		relevantNetworks.add("FS Florida");
		relevantNetworks.add("FS Midwest");
		relevantNetworks.add("FS North");
		relevantNetworks.add("FS Ohio");
		relevantNetworks.add("FS San Diego");
		relevantNetworks.add("FS South");
		relevantNetworks.add("FS Southwest"); 
		relevantNetworks.add("FS West");
		relevantNetworks.add("MSG");
		relevantNetworks.add("MSG Plus");
		relevantNetworks.add("Prime Ticket"); 
		relevantNetworks.add("YES Network");
		
		String[] csvHeaders = {"internalName","description","regionCode","regionZipcodes"};
		
		StringBuffer csvOutBuff = new StringBuffer();
		CSVFormat csvFileFormat = CSVFormat.DEFAULT;
		CSVPrinter csvPrinter = new CSVPrinter(csvOutBuff, csvFileFormat);
		csvPrinter.printRecord(csvHeaders);
		int rCode = 700;
		Workbook wb = readWorkBook("C:\\Users\\indranilm\\Desktop\\aeg\\region setup\\Test.xlsx");
		//System.out.println(wb.getSheetName(1));
		for (String nw : relevantNetworks) {
			System.out.println(nw);
			List<String> nw_Region = new ArrayList<String>();
			nw_Region.add("Region "+nw);
			// zip buffer
			StringBuffer zipBuffer = new StringBuffer();
			// stateBuffer
			StringBuffer stateBuffer = new StringBuffer("This region is network "+nw+" for states ");
			Set<String> stateSet = new HashSet<String>();
			Set<String> zipSet = new HashSet<String>();
			Sheet sheet = wb.getSheet(nw);
			for (Row row : sheet) {
	        	Cell cell_zip = row.getCell(0);
	        	Cell cell_state = row.getCell(1);
	            String zipVal = getCellValue(cell_zip);
	            String stateVal = getCellValue(cell_state);
	            System.out.println(zipVal);
	            System.out.println(stateVal);
            	stateSet.add(stateVal);
	            // "03226\n03227\n03254\n03259\n03561\n03570"
	            if (zipVal.contains("-")) {
	            	String[] bounds = zipVal.split("-");
	            	int lb = Integer.parseInt(bounds[0]);
	            	System.out.println(lb);
	            	int ub = Integer.parseInt(bounds[1]);
	            	System.out.println(ub);
	            	for (int i = lb ; i <= ub; i++) {
	            		//zipBuffer.append(String.valueOf((i < 10000) ? "0"+i : i));
	            		//zipBuffer.append("\\n");
	            		zipSet.add(String.valueOf((i < 10000) ? "0"+i : i));
	            	}
	            } else {
	            	//zipBuffer.append(zipVal);
	            	//zipBuffer.append("\\n");
	            	zipSet.add(zipVal);
	            }
	            
			}
			
			for (String zip : zipSet) {
				zipBuffer.append(zip);
            	zipBuffer.append("\n");
			}
			
			for (String state : stateSet) {
				stateBuffer.append(state);
				stateBuffer.append(" ");
			}
			nw_Region.add(stateBuffer.toString());
			nw_Region.add(String.valueOf(rCode++));
			nw_Region.add(zipBuffer.toString());
			csvPrinter.printRecord(nw_Region);
		}
		String fileName = "F:\\workspace\\java-test\\src\\Test_new1.csv";
		System.out.println("csv Generated writing to: " + fileName);
		System.out.println("output: " + csvOutBuff.toString());
        List<String> op= new ArrayList<String>();op.add(csvOutBuff.toString());
        Iterable<? extends CharSequence> itr = op;
        Files.write(Paths.get(fileName), itr, Charset.forName("UTF-8"),  StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
        csvPrinter.close();
	}
	
	/*Row newRow = sheetNew.createRow(++count);
	newRow.createCell(0).setCellValue(String.valueOf((i < 10000) ? "0"+i : i));
	newRow.createCell(1).setCellValue(getCellValue(row.getCell(1)));
	newRow.createCell(2).setCellValue(getCellValue(row.getCell(2)));
	newRow.createCell(3).setCellValue(getCellValue(row.getCell(3)));
	newRow.createCell(4).setCellValue(getCellValue(row.getCell(4)));
	newRow.createCell(5).setCellValue(getCellValue(row.getCell(5)));
	newRow.createCell(6).setCellValue(getCellValue(row.getCell(6)));
	newRow.createCell(7).setCellValue(getCellValue(row.getCell(7)));*/
	private static String getCellValue(Cell cell) {
		try {
        	return cell.getStringCellValue();
        } catch (IllegalStateException i) {
        	return String.valueOf(new Double(cell.getNumericCellValue()).intValue());
        }
	}
	
	
	public static Workbook readWorkBook(String fileName) throws InvalidFormatException, IOException {
		inp = new FileInputStream(fileName);
		Workbook wb = WorkbookFactory.create(inp);
		return wb;
	}
	
	public static void writeNewSheet(Workbook wb) throws IOException {
	    FileOutputStream fileOut = new FileOutputStream("F:\\workspace\\java-test\\src\\Test_new1.xlsx",false);
	    wb.write(fileOut);
	    fileOut.close();
	    inp.close();
	}
	
	public static void writeToCsv(String filePath,String[] headers , List csvRecordList) throws IOException{
		FileWriter fileWriter=null;
		CSVPrinter csvFilePrinter=null;
		try {
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(System.lineSeparator()).withHeader(headers);
			fileWriter = new FileWriter(filePath);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
			csvFilePrinter.printRecords(csvRecordList);
		} finally {
			if(fileWriter!=null){
				fileWriter.flush();
				fileWriter.close();
			}
			
			if(csvFilePrinter!=null){
				csvFilePrinter.close();
			}
		}
		
	}
	
}
