package userDefinedLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import userDefinedLibraries.DriverSetup;

public class ExcelReadWrite {
	public static File src;
	//public static String exfilepath = "C:\\Users\\AMMU\\Desktop\\anjana\\WorkSpace\\BinaryBeasts\\src\\test\\java\\dataTable\\DataTable.xlsx";
	//public static String exfilepath = "anjana\\WorkSpace\\BinaryBeasts\\src\\test\\java\\dataTable\\DataTable.xlsx";
	public static String exfilepath = "C:\\Users\\AMMU\\git\\BB-\\BinaryBeasts\\src\\test\\java\\dataTable\\DataTable.xlsx";
	public static FileInputStream fileip;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String val1;
	public static int row;
	public static XSSFCell cell;
	public static XSSFRow Row;
	public static String amount;
	public static String monthAndYear;
	public static String date;
	public static String recipents_name;
	public static String customer_name;
	public static String recipents_email;
	public static String customer_email;
	public static String customer_phonenumber;
	
	
	// Read the excel data and store into variables
	public static int readExcel() {
		try {
			src = new File(exfilepath);
			// Create an object of FileInputStream class to read data from excel
			fileip = new FileInputStream(src);
			// Create Workbook instance holding reference to ".xlsx" file
			workbook = new XSSFWorkbook(fileip);
			// Get desired sheet from workbook
			sheet = workbook.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				if (i == 1) {
					// Getting value from excel and Storing it to variables
					amount = String.valueOf(sheet.getRow(i).getCell(0)
							.getNumericCellValue());
					System.out.println("Excel Value for amount text box:"
							+ amount);
					monthAndYear = sheet.getRow(i).getCell(1).getStringCellValue();
					System.out.println("Month and Year from excel:" + monthAndYear);
					date = String.valueOf((int)(sheet.getRow(i).getCell(2).getNumericCellValue()));
					System.out.println("date from excel:" + date);
					recipents_name = sheet.getRow(i).getCell(3).getStringCellValue();
					System.out
							.println("Recipent's name from excel:" +recipents_name );
					customer_name = sheet.getRow(i).getCell(4).getStringCellValue();
					System.out
					.println("customer name from excel:" +customer_name);
					recipents_email = sheet.getRow(i).getCell(5).getStringCellValue();
					System.out
							.println("Recipent's email from excel:" +recipents_email );
					customer_email = sheet.getRow(i).getCell(6).getStringCellValue();
					System.out
							.println("Customer email id from excel:" +customer_email );
					customer_phonenumber = String.valueOf(sheet.getRow(i).getCell(7).getNumericCellValue());
					System.out
							.println("Customer's Phone Number from excel:" +customer_phonenumber );
					
					
					
					row = i;
					break;

				}

			}
		} catch (FileNotFoundException f) {
			f.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return row;

	}

	// Write the output into excel sheet
	public static void writeexcel(String errorMessage_customeremail,String errorMessage_recipentsemail,String errormessage_Phone) {
		try {
			 File file = new File("C:\\Users\\AMMU\\git\\BB-\\BinaryBeasts\\src\\test\\java\\OutPut.xlsx");
			// Create an object of FileInputStream class to read data from excel
			 FileInputStream fileip1 = new FileInputStream(file);
			// Create Workbook instance holding reference to ".xlsx" file
			 XSSFWorkbook workbook1 = new XSSFWorkbook(fileip1);
			// Get desired sheet from workbook
			 XSSFSheet sheet1 = workbook1.getSheet("GiftCard_InvalidInput");
			// Create an object of FileOutputStream class to create write data
			// in excel file
			if (!DriverSetup.browsertype.equalsIgnoreCase("Edge")) {
				
				 XSSFCell cell1= sheet1.createRow(1).createCell(0);
				 XSSFCell cell2= sheet1.createRow(2).createCell(0);
				 XSSFCell cell3= sheet1.createRow(3).createCell(0);
				 
				 cell1.setCellValue(errorMessage_customeremail);
				 cell2.setCellValue(errorMessage_recipentsemail);
				 cell3.setCellValue(errormessage_Phone);
				}
			else
			{
				 XSSFCell cell1= sheet.createRow(5).createCell(0);
				 XSSFCell cell2= sheet.createRow(6).createCell(0);
				 XSSFCell cell3= sheet.createRow(7).createCell(0);
				 
				 cell1.setCellValue(errorMessage_customeremail);
				 cell2.setCellValue(errorMessage_recipentsemail);
				 cell3.setCellValue(errormessage_Phone);	
			}
				
			fileop = new FileOutputStream(new File("C:\\Users\\AMMU\\git\\BB-\\BinaryBeasts\\src\\test\\java\\OutPut.xlsx"));
			// write data in the excel file
			workbook1.write(fileop);
			// close output stream
			fileop.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
