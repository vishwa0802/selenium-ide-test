package stepdefiniton;


import java.awt.List;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
public class SITStepDefinitons {

	
	private static final String JavascriptExecutor = null;
	WebDriver driver;
	private String s;
	private String CAFORN;
	
	 @Given("^User is already on Login Page$")
	public void user_is_already_on_Login_Page()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/vishwa.raicha/Desktop/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://jep.bss.jiolabs.com:9292/JEP/home");
		driver.manage().window().maximize();
		s = RandomStringUtils.randomAlphabetic(8); 

	}
	
	@When("^tile of login page is JEP$")
	public void tile_of_login_page_is_JEP() {
	    String title =driver.getTitle();
	    System.out.println(title);
	    Assert.assertEquals("Jio SSO Login", title);
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password()  {
	    driver.findElement(By.name("username")).sendKeys("Vishwa.Raicha");
	    driver.findElement(By.name("password")).sendKeys("Vish@0902");
	}

	@Then("^user clicks on login button$")
	public void user_clicks()  {
	  // WebElement loginBtn= driver.findElement(By.xpath("//*[@id='content-inner']/form/input[4]"));
	WebElement loginBtn= driver.findElement(By.xpath("//*[@id='content-inner']/form/input[5]"));
	   JavascriptExecutor js =(JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();", loginBtn);
	    
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() {
	   String title=driver.getTitle();
	   System.out.println("Home page Title ::"+title);
	   Assert.assertEquals("Jio Enterprise Dashboard KAM", title);
	    
	}
	
	
	//Create BL
	
		 @Then("^user clicks on create BL button$")
		public void user_clicks_createBL()
		{
			WebElement CreateBtn= driver.findElement(By.xpath("//*[@id='divOrderFlow']/div[1]/div[5]/div/div[3]/div[2]/a"));
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", CreateBtn);	
		}

		@Then("^user enters HQ name$")
		public void hq_name() throws InterruptedException
		{
			driver.findElement(By.name("hqName")).sendKeys("shyam");
			Thread.sleep(5000);
			//Select dropdown = new Select(driver.findElement(By.id("/html/body/ul[1]/li")));//
		
			driver.findElement(By.xpath("/html/body/ul[1]/li")).click();
			Thread.sleep(2000);
		}
		 
		
		@Then("^user enters Billing Location name$")
		public void BL_namee() throws Exception
		{
			
		//	String uuid = UUID.randomUUID().toString();
			driver.findElement(By.name("name")).sendKeys(s);
			Thread.sleep(4000);
		}
		@Then("^user selects Product Type$")
		public void product_type()
		{
			
		driver.findElement(By.xpath("/html/body/div[1]/div[9]/form[2]/div/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/select/option[3]")).click();


			
		//ILL	driver.findElement(By.xpath("/html/body/div[1]/div[8]/form[2]/div/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/select/option[7]")).click();
		//L3 MPLS  /html/body/div[1]/div[8]/form[2]/div/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/select/option[3]
		// L2 MPLS /html/body/div[1]/div[8]/form[2]/div/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/select/option[10]
		//SIP /html/body/div[1]/div[8]/form[2]/div/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/select/option[5]
		//IP Centrex /html/body/div[1]/div[8]/form[2]/div/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/select/option[9]
		// COCP /html/body/div[1]/div[8]/form[2]/div/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/select/option[6]
		// Ent WiFi /html/body/div[1]/div[8]/form[2]/div/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/select/option[11]
		//Society Centrex /html/body/div[1]/div[8]/form[2]/div/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div/select/option[2]
		
		}
		@Then("^user enters First name and Last name$")
		public void name()
		{
			driver.findElement(By.name("contactFirstName")).sendKeys("Vishwa");
			driver.findElement(By.name("contactLastName")).sendKeys("Raicha");
		}
		@Then("^user enters mobile number$")
		public void mobile_num()
		{
			driver.findElement(By.name("landline")).sendKeys("7977623155");
		}
		@Then("^user email ID$")
		public void email_id() throws Exception
		{
			driver.findElement(By.name("contactEmail")).sendKeys("vishwa.raicha@gmail.com");
		
		}
		@Then ("^user enters Department and Designation$")
		public void dept_des()
		{
			driver.findElement(By.name("contactDepartment")).sendKeys("ISO");
			driver.findElement(By.name("contactDesignation")).sendKeys("Manager");
		}
		@Then ("^user clicks on Next$")
		public void next_btn()
		{
			WebElement nextbtn= driver.findElement(By.xpath("//*[@id='main-navidation-next-to-poa']"));
			   JavascriptExecutor js =(JavascriptExecutor)driver;
			   js.executeScript("arguments[0].click();", nextbtn); 
		}
		
		@Then("^user selects POA document type$")
		public void POAdoc_type()
		{
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='poaDocType']")));  
			dropdown.selectByVisibleText("Shops and Establishment Certificate");
		}
		@Then("^user enters document number$")
		public void doc_num()
		{
			driver.findElement(By.name("poaDocNo")).sendKeys("342343432");
		}
		@Then("^user uploads POA$")
		public void upload_POA()
		{
			WebElement addFile = driver.findElement(By.xpath("//*[@id='filePoa']"));
			addFile.sendKeys("C:/Users/vishwa.raicha/Downloads/CFH0000GDG_Replica_SIP_10th.pdf");

			
		}
		
		@Then("^user selects POI document type$")
		public void POIdoc_type()
		{
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='poiDocTypeSelect']")));  
			dropdown.selectByVisibleText("Certificate of Change of Address");
		}
		@Then("^user enters POI document number$")
		public void POIdoc_number()
		{
			driver.findElement(By.name("poiDocNo")).sendKeys("56789897");
		}
		@Then("^user uploads POI$")
		public void upload_POI()
		{
			WebElement addFile = driver.findElement(By.xpath("//*[@id='filePoi']"));
			addFile.sendKeys("C:/Users/vishwa.raicha/Downloads/CFH0000GDG_Replica_SIP_10th.pdf");
			
		}
		@Then("^user selects Next$")
		public void next_button() throws Exception
		{
			WebElement nextbtn1= driver.findElement(By.xpath("//*[@id='main-navidation-next-to-address']"));
			   JavascriptExecutor js =(JavascriptExecutor)driver;
			   js.executeScript("arguments[0].click();", nextbtn1); 
			   Thread.sleep(5000);
		}
		
		@Then("^user enters pincode$")
		public void pincode() throws Exception
		{
			WebElement webElement = driver.findElement(By.xpath("//*[@id='pincode']"));
			webElement.sendKeys("400701");
			webElement.sendKeys(Keys.TAB);
			Thread.sleep(5000);
		}
		
		@Then("^user select District$")
		public void district()
		{
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='district']")));  
			dropdown.selectByVisibleText("Mumbai");
		}
		
		@Then("^user select City$")
		public void city()
		{
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='city']")));  
			dropdown.selectByVisibleText("Mumbai");
			
		}
		
		@Then("^user enters building number and name$")
		public void buildingname_num()
		{
			driver.findElement(By.name("houseFlatNo")).sendKeys("903");
			driver.findElement(By.name("bldgName")).sendKeys("Rosalie");
		}
		
		@Then("^user select Circle$")
		public void circle()
		{
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='circle']")));  
			dropdown.selectByVisibleText("MU");
			
		}
		@Then("^user clicks on GST details$")
		public void GST_details()
		{
			WebElement Gst= driver.findElement(By.xpath("/html/body/div[1]/div[9]/form[2]/div/div/div/div/div[3]/div[3]/div[2]/input"));
			   JavascriptExecutor js =(JavascriptExecutor)driver;
			   js.executeScript("arguments[0].click();", Gst);
		}

		@Then("^user uploads GST$") 
		public void upload_GST() throws Exception
		{
			WebElement addFile = driver.findElement(By.xpath("//*[@id='fileGst_Exemption_Letter']"));
			addFile.sendKeys("C:/Users/vishwa.raicha/Downloads/CFH0000GDG_Replica_SIP_10th.pdf");
			Thread.sleep(5000);
		}
		@Then("^user clicks on Submit Button$")
		public void submit_button() throws Exception
		{
			WebElement submitBL= driver.findElement(By.xpath("/html/body/div[1]/div[10]/div[1]/input[5]"));
			   JavascriptExecutor js =(JavascriptExecutor)driver;
			   js.executeScript("arguments[0].click();", submitBL);
			   Thread.sleep(2000);
		}

		@Then("^user clicks on Yes button$")
		public void Yes_button()
		{
			WebElement Yesbtn= driver.findElement(By.xpath("//*[@id='proceedBLButton']"));
			   JavascriptExecutor js =(JavascriptExecutor)driver;
			   js.executeScript("arguments[0].click();", Yesbtn);
		} 
		@Then("^user clicks on jio homepage$")
		public void jio_homepage()
		{
			WebElement homepage= driver.findElement(By.xpath("/html/body/div/div/div[12]/div/div[1]/div[2]/a"));
			   JavascriptExecutor js =(JavascriptExecutor)driver;
			   js.executeScript("arguments[0].click();", homepage); 
		}

		//End Create BL
		
		//Create AS
		@Then("^user clicks on Create AS$")
		public void Create_AS() throws Exception
		{
			
			WebElement CreateBtn1= driver.findElement(By.xpath("//*[@id='divOrderFlow']/div[1]/div[6]/div/div[3]/div[1]/a"));
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", CreateBtn1);
			Thread.sleep(3000);
		}
		@Then("^user enters BL name$")
		public void BL_name() throws Exception
		{
			driver.findElement(By.name("blName")).sendKeys(s);
			Thread.sleep(6000);
			driver.findElement(By.xpath("/html/body/ul[2]/li")).click();

		}
		
		@Then("^user enters First and Last name$")
		public void first_lastname()
		{
			driver.findElement(By.name("firstName")).sendKeys("Ram");
			driver.findElement(By.name("lastName")).sendKeys("Tanna");
		}
		@Then("^user enters Mobile number$")
		public void Mobile()
		{
			driver.findElement(By.name("mobile")).sendKeys("9920685673");
		}
		@Then("^user enters Email ID$")
		public void Email() throws InterruptedException {
			//driver.findElement(By.name("email")).sendKeys("vishwa.raicha@atertert.com");
			WebElement emailTextBx = driver.findElement(By.name("email"));
			//emailTextBx.click();
			Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(1000);  
			emailTextBx.sendKeys("sdkksdh"+ randomInt + "@fhfhqwq.com");
			Thread.sleep(3000);
		}
		@Then("^user enters Dept and designation$")
		public void dept_designation() throws Exception
		{
			driver.findElement(By.name("department")).sendKeys("HR");
			driver.findElement(By.name("designation")).sendKeys("Senior Manager");
			Thread.sleep(6000);
		}
		
		@Then("^user clicks on Next Button$")
		public void Next_button1() throws Exception
		{
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/input[1]")).click();
			Thread.sleep(2000);

		}
		
		@Then("^user selects Document Type$")
		public void documenttype()
		{
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='poiDocType']")));  
			dropdown.selectByVisibleText("Kissan Passbook having Photo");
		}
		@Then("^user enters Document number$")
		public void documentnum()
		{
			driver.findElement(By.name("poiDocNo")).sendKeys("34567");
		}
		@Then("^user uploads POI doc$")
		public void uploadPOI() throws Exception
		{
			WebElement addFile = driver.findElement(By.xpath("//*[@id='filePoi']"));
			addFile.sendKeys("C:/Users/vishwa.raicha/Downloads/CFH0000GDG_Replica_SIP_10th.pdf");
			Thread.sleep(5000);
		}
		@And("^user uploads Auth Letter$")
		public void Auth_letter() throws Exception
		{
			WebElement addFile = driver.findElement(By.xpath("//*[@id='fileAl']"));
			addFile.sendKeys("C:/Users/vishwa.raicha/Downloads/CFH0000GDG_Replica_SIP_10th.pdf");
			Thread.sleep(5000);
		}
		
		@Then("^user clicks on submit button$")
		public void submit()
		{
			driver.findElement(By.xpath("//*[@id='Submit']")).click();
		}
		
		@Then("^user clicks on dashboard$")
		public void dashboard() 
		{
			WebElement dashboard= driver.findElement(By.xpath("/html/body/div/div/div[12]/div/div[1]/div[2]/a"));
			   JavascriptExecutor js =(JavascriptExecutor)driver;
			   js.executeScript("arguments[0].click();", dashboard); 

		}
		//End AS
		
		
		//Create CAF
		
		@Then("^user clicks on Create CAF$")
		public void Create_CAF() throws Exception
		{
			driver.findElement(By.xpath("//*[@id='divOrderFlow']/div[1]/div[7]/div/div[3]/div[1]/a")).click();
			Thread.sleep(2000);
		}
		@Then("^user enters Billing name$")
		public void Billing_name() throws Exception
		{
			driver.findElement(By.name("blNameAuto")).sendKeys(s);
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/ul[2]/li[1]")).click();
			Thread.sleep(5000);
		}
		
		@Then("^user selects AS name$")
		public void AS_name() throws Exception
		{
			driver.findElement(By.xpath("/html/body/div/div[1]/form[2]/div/div/div/div[2]/div[1]/div[4]/select/option[2]")).click();
			Thread.sleep(9000);

		}
		@Then("^user selects Product$")
		public void product()
		{


		driver.findElement(By.xpath("/html/body/div/div[1]/form[2]/div/div/div/div[5]/div/div/div/div/div/div[1]/div[3]/select")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/form[2]/div/div/div/div[5]/div/div/div/div/div/div[1]/div[3]/select/option[2]")).click();



		/*	//MPLS//
			dropdown.selectByVisibleText("L3 MPLS VPN");

			//ILL

			dropdown.selectByVisibleText("ILL");

			//SIP
			dropdown.selectByVisibleText("SIP Trunk");

			//L2 MPLS
			dropdown.selectByVisibleText("L2MPLS VPN");

			//COCP
			dropdown.selectByVisibleText("FTTX Standard");

			//IP Centrex
			dropdown.selectByVisibleText("IP Centrex");

			//Enterprise WiFi
			dropdown.selectByVisibleText("ENTERPRISE WIFI");

			//Society Centrex
			dropdown.selectByVisibleText("Society Centrex");
	    */
			
		}
		@Then("^user clicks on Submit$")
		public void Submit1()
		{
			driver.findElement(By.xpath("//*[@id='printpdf']")).click();
		}

		@Then("^user copies CAF ORN$")
		public void CAF_ORN() throws Exception
		{
			CAFORN=driver.findElement(By.xpath("//*[@id='ornNo']")).getText();
			Thread.sleep(2000);
			 
		}
		@Then("^user clicks on JEP dashboard$")
		public void JEP_dashboard()
		{
			driver.findElement(By.xpath("/html/body/div/div/div[12]/div/div[1]/div[2]/a")).click();

		}
		//END CAF
		
		//Upload CAF
		@Then("^user clicks on upload CAF button$")
		public void upload_btn()
		{
			driver.findElement(By.xpath("//*[@id='divOrderFlow']/div[1]/div[7]/div/div[3]/div[3]/a")).click();
		}
		@Then("^user enters copied CAF ORN$")
		public void CAF_copy()
		{
			driver.findElement (By.xpath("//*[@id='cafnumber']")).sendKeys(CAFORN);
		}
		@Then("^user clicks on upload Button$")
		public void upload() throws Exception
		{
			driver.findElement(By.xpath("//*[@id='searchbtn']")).click();
			Thread.sleep(5000);
		}
		@Then("^user clicks on CAF Action$")
		public void CAF_Action()
		{
			driver.findElement(By.xpath("/html/body/div[1]/div/div[17]/div[2]/div/div[2]/div/div/div/div/table/thead/tr[2]/td[4]/button")).click();
		}
		@Then("^user uploads CAF document$")
		public void CAF_Documents() throws Exception
		{
			WebElement addFile = driver.findElement(By.xpath("//*[@id='caffile']"));
			addFile.sendKeys("C:/Users/vishwa.raicha/Downloads/CFH0000GDG_Replica_SIP_10th.pdf");
			Thread.sleep(2000);
		}
		
		@Then("^user clicks on Upload$")
		public void upload1_caf() throws Exception
		{
			driver.findElement(By.xpath("//*[@id='uploadcaffilebutton']")).click();
			Thread.sleep(10000);
		}

		@And("^CAF is uploaded user clicks on Ok button$")
		public void OK_btn()
		{
			driver.findElement(By.xpath("/html/body/div[1]/div/div[7]/div/div/div[3]/div/input")).click();
			
		}
		@Then("^user clicks from upload result page$")
		public void dashboard_1()
		{
			driver.findElement(By.xpath("/html/body/div[1]/div/div[9]/div/div[1]/div[2]/a")).click();
		}

		@Then("^user clicks on Create CF$")
		public void CreateCF()
		{
			driver.findElement(By.xpath("/html/body/div/div/div[18]/div[1]/div[8]/div/div[3]/div[1]/a")).click();

		}


}
