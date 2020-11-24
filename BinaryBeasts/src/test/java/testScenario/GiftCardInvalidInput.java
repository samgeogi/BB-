package testScenario;
/* Class  : GiftCard_Invalid Data
 * Author : Anjana Rajeevan
 * Date   : 23-11-2020
 * ID     : 875286
 */


import java.io.FileReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.google.gson.JsonObject;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExcelReadWrite;
import userDefinedLibraries.ScreenShot;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;  
import org.json.simple.parser.JSONParser;


public class GiftCardInvalidInput extends DriverSetup {
	public static JSONObject jsonObject;
	public static JSONArray pathArray;
	public static String path;
	public static WebDriver driver;
	 public static ExtentTest test;
	 public static Logger logger;
	 private static ExtentReports extent;
	 public static String errorMessage_customeremail;
	 public static String errorMessage_recipentsemail;
	 public static String errormessage_Phone;
	 @Parameters("browser")
		@BeforeClass
		// Driver Configuration
		public void driverConfiguration(String browser) {
			driver = DriverSetup.driverInstantiation(browser);
		}
	 @BeforeTest
public void testcase_getPathFile(){
	 //String dataFilePath = "src//test//java//testObjectRepository";
	     
		//String dataFilePath = "src//test//java//testObjectRepository";
	     
	    try {
	        //FileReader reader = new FileReader(dataFilePath + "giftcardPath.json");  
	    	 FileReader reader = new FileReader("C:\\Users\\AMMU\\git\\BB-\\BinaryBeasts\\src\\test\\java\\testObjectRepository\\giftcardPath.json");   
	        JSONParser jsonParser = new JSONParser();
	         jsonObject = (JSONObject) jsonParser.parse(reader);
	        
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	   
	}
	 @Test(priority=1)
	 public void testcase_readExcelData(){
		
				try {
					ExcelReadWrite.readExcel();
				} catch (Exception e) {
					e.printStackTrace();
				} 
	 }
	@Test(priority=2)
	void testcase_clickGiftCards() 
	{
		try{
			
			path=(String)jsonObject.get("giftcard");
		driver.findElement(By.xpath(path)).click();
		//status for Extent report
		/*extent = new ExtentReports("extend Reports htmlfile", true);
		ExtentTest test = extent.startTest("GiftCard", "Invalid Input");
		if(driver.getTitle().equals("Gift Card - Buy Gift Cards & Vouchers Online for Wedding, Birthday | Urban Ladder"))
		{//pass status
				test.log(LogStatus.PASS, "Navigated to Gift Cards page");
		}
		else
		{//fail status
			test.log(LogStatus.FAIL, "Navigation to Gift Cards failed failed");
		}*/
		//scrolling the page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		 jse.executeScript("window.scrollBy(0,600)");
		 Thread.sleep(2000);
		 ScreenShot.screenShot(driver);
		 
	        //logger.info("Navigated to gift cards page");
		}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	@Test(priority=3)
	public void testcase_selectGiftCards(){
		try{
			path=(String)jsonObject.get("category");
			WebElement element=driver.findElement(By.xpath(path));
		element.click();
		
		/*if(element.getText().equals("Gift something memorable to help them celebrate great memories!"))
			{
     			test.log(LogStatus.PASS, "Occassion selected as birthday/anniversary");
			}
			else
			{
				test.log(LogStatus.FAIL, "Occassion not selected as birthday/anniversary");
			}
		 logger.info("Occassion selected as Birthday/Anniversary");*/
	} catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	@Test(priority=4)
	public void testcase_customiseGiftCard(){
		try{
			path=(String)jsonObject.get("amount"); 
			WebElement amt=driver.findElement(By.xpath(path));//extracting the xpath to select the amount
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		   String amount=ExcelReadWrite.amount;
		   amt.sendKeys(amount);
			
			 //status for extent report
			/* if(amt.getText().equals(amount))
				{
				 //pass status
	  			test.log(LogStatus.PASS, "Amount selected as Rs "+amount );
				}
				else
				{
					//fail status
					test.log(LogStatus.FAIL,"Amount not selected as Rs "+amount);
				}
			 
			 logger.info("Amount set to Rs "+amount );*/
			 //selecting the desired month and year to deliver the card
			 String monthPath=(String)jsonObject.get("month");
			WebElement monthelement=driver.findElement(By.xpath(monthPath));
			 Select month = new Select(driver.findElement(By.xpath(monthPath)));
			month.selectByVisibleText(ExcelReadWrite.monthAndYear);
			 
			 //status for extent report
			/* if(monthelement.getText().equals(ExcelReadWrite.monthAndYear))
				{
				 //pass status
	  			test.log(LogStatus.PASS, "Month and Year selected as "+ ExcelReadWrite.monthAndYear);
				}
				else
				{
					//fail status
					test.log(LogStatus.FAIL, "Month and Year not selected as "+ExcelReadWrite.monthAndYear);
				}
			 
			 logger.info("Month and Year set to "+ExcelReadWrite.monthAndYear);*/
			 //selecting the desired date to deliver the card
				String datePath=(String)jsonObject.get("date");
				WebElement dateelement=driver.findElement(By.xpath(datePath)); 
				Select date = new Select(driver.findElement(By.xpath(datePath)));
				 date.selectByVisibleText(ExcelReadWrite.date);
				//status for extent report
				 /*if(dateelement.getText().equals(ExcelReadWrite.date))
					{
					 //pass status
		  			test.log(LogStatus.PASS, "Date selected as "+ ExcelReadWrite.date);
					}
					else
					{
						//fail status
						test.log(LogStatus.FAIL, "Date not selected as "+ExcelReadWrite.date);
					}
				 
				 logger.info("Date set to "+ExcelReadWrite.date);*/
			 //selecting the next option to proceed to the mext step
				 String nextPath=(String)jsonObject.get("next");
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 WebElement nxt=driver.findElement(By.xpath("//*[contains(text(),'Next')]"));
			     nxt.click();
			//status for extent report
			/*if(nxt.getText().equals("NEXT"))
				{
				//pass status
	 			test.log(LogStatus.PASS, "Proceeded to the next step for recipient's and sender's details");
				}
				else
				{
					//fail status
					test.log(LogStatus.FAIL, "Not proceeded to the next step for recipient's and sender's details");
				}*/
	} catch(Exception e)
		{
		e.printStackTrace();
		}	
	}
	@Test(priority=5)
	public void testcase_FillDetails(){
		try{
			 System.out.println("Form details are: ");
			 //filling the receipient's details
			 //filling the form starting from recepient's name
			 String recipentsname=(String)jsonObject.get("recipientsname");
			 WebElement name1=driver.findElement(By.name(recipentsname));
			 name1.sendKeys(ExcelReadWrite.recipents_name);//recepient's name
			String strName1 = driver.findElement(By.name(recipentsname)).getAttribute("value");
			 System.out.println("Receipient name :"+strName1);//printing recepient's name
			
			 //status for extent report
			 /*if(strName1.equals(ExcelReadWrite.recipents_name))
				{//pass status
				test.log(LogStatus.PASS, "Recipient's name entered");
				}
				else
				{//fail status
					test.log(LogStatus.FAIL, "Recipient's name not entered");
				}*/
			  //Recipent's Email
			 String recipentsemail=(String)jsonObject.get("recipientsemail");
			 WebElement email1=driver.findElement(By.name(recipentsemail));
			 email1.sendKeys(ExcelReadWrite.recipents_email);//filling recepient's email id
			 String strEmail1 = email1.getAttribute("value");
			 System.out.println("Receipient's email :"+strEmail1);//printing recepient's email id
			 //status for extent report
			/* if(strEmail1.equals(ExcelReadWrite.recipents_email))
				{//pass status
				test.log(LogStatus.PASS, "Recipient's email id entered");
				}
				else
				{//fail status
					test.log(LogStatus.FAIL, "Recipient's email id not entered");
				}*/
			 
			 //Sender's details
			//filling sender's name
			 String sendersname=(String)jsonObject.get("yourname");
			 WebElement name2=driver.findElement(By.name(sendersname));
			 name2.sendKeys(ExcelReadWrite.customer_name);
			 String strName2 =name2.getAttribute("value");
			 System.out.println("Sender's name :"+strName2);//printing sender's name
			 //status for extent report
			/* if(strName2.equals(ExcelReadWrite.customer_name))
				{//pass status
				test.log(LogStatus.PASS, "Sender's name entered");
				}
				else
				{//fail status
					test.log(LogStatus.FAIL, "Sender's name not entered");
				}*/
			 
			 
			//filling sender's email id
			 String sendersemail=(String)jsonObject.get("youremail");
			 //String strEmail2 = driver.findElement(By.xpath(pb.get_Custemail(
			 WebElement email2=driver.findElement(By.name(sendersemail));
			 email2.sendKeys(ExcelReadWrite.customer_email);
			 String strEmail2=email2.getAttribute("value");
			 System.out.println("Sender's email :"+strEmail2);//printing sender's email id
			 //status for extent report
			 /*if(strEmail2.equals(ExcelReadWrite.customer_email))
				{//pass status
				test.log(LogStatus.PASS, "Sender's email entered");
				}
				else
				{//fail status
					test.log(LogStatus.FAIL, "Sender's email not entered");
				}*/
			 
			 
			//filling sender's mobile number
			 String phone=(String)jsonObject.get("phone");
			 WebElement mobile=driver.findElement(By.name(phone));
			 mobile.sendKeys(ExcelReadWrite.customer_phonenumber);
			 String strmob = mobile.getAttribute("value");
			 System.out.println("Mobile number :"+strmob);//printing sender's mobile number
			 //status for extent report
			/* if(strmob.equals(ExcelReadWrite.customer_phonenumber))
				{//pass status
				test.log(LogStatus.PASS, "mobile number entered");
				}
				else
				{//fail status
					test.log(LogStatus.FAIL, "Mobile number not entered");
				}*/
			 
			 
			//filing the message to be delivered
			/* WebElement message=driver.findElement(By.xpath(pb.get_Msg()));
			 message.sendKeys("Happy Birthday!");
			 String strmsg = driver.findElement(By.xpath(pb.get_Msg())).getAttribute("value");
			 System.out.println("Message :"+strmsg);//printing the message to be delivered
			 //status for extent report
			 if(strmsg.equals("Happy Birthday!"))
				{//pass status
				test.log(LogStatus.PASS, "Message written successfully");
				}
				else
				{//fail status
					test.log(LogStatus.FAIL, "Message not written");
				}
			
			 logger.info("Details of the form are filled");*/
			 
			 ScreenShot.screenShot(driver);//screenshot the the filled form
			 //confirmation
			String confirm=(String)jsonObject.get("confirm");
			 WebElement confirmation=driver.findElement(By.xpath(confirm));
			 confirmation.click();
			 //status for extent report
			 /*if(confirmation.getText().equals("CONFIRM"))
				{//pass status
				test.log(LogStatus.PASS, "Confirmation of form fill up successful");
				}
				else
				{//fail status
					test.log(LogStatus.FAIL, "Confirmation of form fill up not successful");
				}*/
			 
			 Thread.sleep(2000);
			 String proceedToPayment=(String)jsonObject.get("proceedtopayment");
			 WebElement payment=driver.findElement(By.xpath(proceedToPayment));
			 payment.click();
			 
			 /*if(payment.getText().equals("PROCEED TO PAYMENT"))
				{
				test.log(LogStatus.PASS, "No Error: Payment Successful");
				}
				else
				{
					test.log(LogStatus.FAIL, "Error: Payment unsuccessful");
				}*/
			 
			 ScreenShot.screenShot(driver); //screenshot the the error message 
		}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	@Test(priority=6)
	public static void errorMessage(){
		try{	
			errorMessage_customeremail=driver.findElement(By.xpath((String)jsonObject.get("customeremailinavalid"))).getText();
		  errorMessage_recipentsemail=driver.findElement(By.xpath((String)jsonObject.get("recipentsemailinvalid"))).getText();
		 errormessage_Phone=driver.findElement(By.xpath((String)jsonObject.get("phoneinvalid"))).getText();	
			//status for extent report
			/*if(errorMessage_customeremail.equals("Customer email is invalid"))
			{//pass status
			test.log(LogStatus.PASS, "Error message captured");
			}
			else
			{//fail status
				test.log(LogStatus.FAIL, "No error message captured");
			}*/
			//printing the error message
			System.out.println("Error Message :"+errorMessage_customeremail);
			System.out.println("Error Message :"+errorMessage_recipentsemail);
			System.out.println("Error Message :"+errormessage_Phone);
			// extent.endTest(test);
			//extent.flush();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=7)
	public static void write_ErrorMessage(){
		try{
			ExcelReadWrite.writeexcel(errorMessage_customeremail,errorMessage_recipentsemail,errormessage_Phone);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

