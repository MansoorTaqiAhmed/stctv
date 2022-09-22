package subscribe_2022;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;


public class validateSubscPackg 
{

	WebDriver driver;
	
	@BeforeMethod

	public void setUp()
	{

		System.setProperty("webdriver.chrome.driver", "D:\\My Workspaces 2022\\Selenium Webdrivers\\Chrome Driver\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		
		driver.get("https://subscribe.stctv.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//*[@id=\"changeLanguageButton\"]")).click();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	}


	@Test(priority = 2, description = "TEST CASE to verify the valid homepage, Assert page title")

	public void verifyTitle()

	{
		
		String actualTitle=driver.getTitle();
		String expectedTitle="stc tv - Watch Online movies, series & live TV | Enjoy Free Trial";
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualTitle, expectedTitle, "STC Homepage >> Title >> Assertion --");
		softassert.assertAll();
	}

	

	@Test(priority = 3, description = "TEST CASE to verify the valid stc tv logo appearance")
	public void verifyLogo()

	{

	boolean flag=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div[1]/div/a[2]/img")).isDisplayed();
	
	Assert.assertTrue(flag);

	}

	@Test(priority = 1, description = "TEST CASE to assert BAHRAIN subscription package type, amount, currency and period")
	public void BahrainSubscription()

	{
	
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div/ul/li[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		SoftAssert softassert = new SoftAssert();
		
		// Assert whether BAHRAIN subscription package LITE is available 
		boolean BH_LT_flag=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]")).isDisplayed();                                          												    
		softassert.assertTrue(BH_LT_flag);
		
		// Assert the BAHRAIN >> LITE subscription amount
		String bh_lite_expectamount = "2";
		String bh_lite_actualamount = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/div[1]/span[1]")).getText();
		System.out.println("Identified BAHRAIN >> Subscription Amount: " + bh_lite_expectamount);  
		softassert.assertEquals(bh_lite_actualamount, bh_lite_expectamount, "BAHRAIN >> LITE >> AMOUNT -- Assertion --");
		
		
		// Assert the BAHRAIN >> LITE subscription currency
		String bh_lite_expectcurrency = "BHD";
		String bh_lite_actualcurrency = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/div[1]/span[2]")).getText();
		System.out.println("Identified BAHRAIN >> Subscription Curncy: " + bh_lite_actualcurrency);
		softassert.assertEquals(bh_lite_actualcurrency, bh_lite_expectcurrency, "BAHRAIN >> LITE >> CURNCY -- Assertion --");
				
		
		
		// Assert the BAHRAIN >> LITE subscription period
		String bh_lite_expectperiod = "/Month";
		String bh_lite_actualperiod = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/div[1]/span[3]")).getText();
		System.out.println("Identified BAHRAIN >> Subscription Period: " + bh_lite_actualperiod.substring(1));
		softassert.assertEquals(bh_lite_actualperiod, bh_lite_expectperiod, "BAHRAIN >> LITE >> PERIOD -- Assertion --");
		
	
		
		
		
		// Assert whether BAHRAIN subscription package CLASSIC is available 
		boolean BH_CL_flag=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]")).isDisplayed();
		softassert.assertTrue(BH_CL_flag);
		
		// Assert the BAHRAIN >> CLASSIC subscription amount
		String bh_clas_expectamount = "3";
		String bh_clas_actualamount = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/div[1]/span[1]")).getText();
		System.out.println("Identified BAHRAIN >> Subscription Amount: " + bh_clas_expectamount);
		softassert.assertEquals(bh_clas_actualamount, bh_clas_expectamount, "BAHRAIN >> LITE >> AMOUNT -- Assertion --");
		
		
		// Assert the BAHRAIN >> CLASSIC subscription currency
		String bh_clas_expectcurrency = "BHD";
		String bh_clas_actualcurrency = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/div[1]/span[2]")).getText();
		System.out.println("Identified BAHRAIN >> Subscription Curncy: " + bh_clas_actualcurrency);
		softassert.assertEquals(bh_clas_actualcurrency, bh_clas_expectcurrency, "BAHRAIN >> LITE >> CURNCY -- Assertion --");
				
		
		
		// Assert the BAHRAIN >> CLASSIC subscription period
		String bh_clas_expectperiod = "/Month";
		String bh_clas_actualperiod = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/div[1]/span[3]")).getText();
		System.out.println("Identified BAHRAIN >> Subscription Period: " + bh_clas_actualperiod.substring(1));
		softassert.assertEquals(bh_clas_actualperiod, bh_clas_expectperiod, "BAHRAIN >> LITE >> PERIOD -- Assertion --");
		
		
		

		
		// Assert whether BAHRAIN subscription package CLASSIC is available 
		boolean BH_PM_flag=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]")).isDisplayed();
		softassert.assertTrue(BH_PM_flag);
		
		// Assert the BAHRAIN >> CLASSIC subscription amount
		String bh_prem_expectamount = "6";
		String bh_prem_actualamount = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/div[1]/span[1]")).getText();
		System.out.println("Identified BAHRAIN >> Subscription Amount: " + bh_prem_expectamount);
		softassert.assertEquals(bh_prem_actualamount, bh_prem_expectamount, "BAHRAIN >> LITE >> AMOUNT -- Assertion --");
		
		
		// Assert the BAHRAIN >> CLASSIC subscription currency
		String bh_prem_expectcurrency = "BHD";
		String bh_prem_actualcurrency = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/div[1]/span[2]")).getText();
		System.out.println("Identified BAHRAIN >> Subscription Curncy: " + bh_prem_actualcurrency);
		softassert.assertEquals(bh_prem_actualcurrency, bh_prem_expectcurrency, "BAHRAIN >> LITE >> CURNCY -- Assertion --");
				
		
		
		// Assert the BAHRAIN >> CLASSIC subscription period
		String bh_prem_expectperiod = "/Month";
		String bh_prem_actualperiod = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/div[1]/span[3]")).getText();
		System.out.println("Identified BAHRAIN >> Subscription Period: " + bh_prem_actualperiod.substring(1));
		softassert.assertEquals(bh_prem_actualperiod, bh_prem_expectperiod, "BAHRAIN >> LITE >> PERIOD -- Assertion --");
		
		
		
		
		softassert.assertAll();

	}

	
	
	
	
	
	@Test(priority = 1, description = "TEST CASE to assert SAUDI ARABIA subscription package type, amount, currency and period")
	public void KSASubscription()

	{
	
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div/ul/li[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		SoftAssert softassert = new SoftAssert();
		
		// Assert whether SAUDI_ARABIA subscription package LITE is available 
		boolean KSA_LT_flag=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]")).isDisplayed();                                          												    
		softassert.assertTrue(KSA_LT_flag);
		
		// Assert the SAUDI_ARABIA >> LITE subscription amount
		String ksa_lite_expectamount = "15";
		String ksa_lite_actualamount = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/div[1]/span[1]")).getText();
		System.out.println("Identified SAUDI_ARABIA >> Subscription Amount: " + ksa_lite_expectamount);  
		softassert.assertEquals(ksa_lite_actualamount, ksa_lite_expectamount, "SAUDI_ARABIA >> LITE >> AMOUNT -- Assertion --");
		
		
		// Assert the SAUDI_ARABIA >> LITE subscription currency
		String ksa_lite_expectcurrency = "SAR";
		String ksa_lite_actualcurrency = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/div[1]/span[2]")).getText();
		System.out.println("Identified SAUDI_ARABIA >> Subscription Curncy: " + ksa_lite_actualcurrency);
		softassert.assertEquals(ksa_lite_actualcurrency, ksa_lite_expectcurrency, "SAUDI_ARABIA >> LITE >> CURNCY -- Assertion --");
				
		
		
		// Assert the SAUDI_ARABIA >> LITE subscription period
		String ksa_lite_expectperiod = "/Month";
		String ksa_lite_actualperiod = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/div[1]/span[3]")).getText();
		System.out.println("Identified SAUDI_ARABIA >> Subscription Period: " + ksa_lite_actualperiod.substring(1));
		softassert.assertEquals(ksa_lite_actualperiod, ksa_lite_expectperiod, "SAUDI_ARABIA >> LITE >> PERIOD -- Assertion --");
		
	
		
		
		
		// Assert whether SAUDI_ARABIA subscription package CLASSIC is available 
		boolean KSA_CL_flag=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]")).isDisplayed();
		softassert.assertTrue(KSA_CL_flag);
		
		// Assert the SAUDI_ARABIA >> CLASSIC subscription amount
		String ksa_clas_expectamount = "25";
		String ksa_clas_actualamount = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/div[1]/span[1]")).getText();
		System.out.println("Identified SAUDI_ARABIA >> Subscription Amount: " + ksa_clas_expectamount);
		softassert.assertEquals(ksa_clas_actualamount, ksa_clas_expectamount, "SAUDI_ARABIA >> LITE >> AMOUNT -- Assertion --");
		
		
		// Assert the SAUDI_ARABIA >> CLASSIC subscription currency
		String ksa_clas_expectcurrency = "SAR";
		String ksa_clas_actualcurrency = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/div[1]/span[2]")).getText();
		System.out.println("Identified SAUDI_ARABIA >> Subscription Curncy: " + ksa_clas_actualcurrency);
		softassert.assertEquals(ksa_clas_actualcurrency, ksa_clas_expectcurrency, "SAUDI_ARABIA >> LITE >> CURNCY -- Assertion --");
				
		
		
		// Assert the SAUDI_ARABIA >> CLASSIC subscription period
		String ksa_clas_expectperiod = "/Month";
		String ksa_clas_actualperiod = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/div[1]/span[3]")).getText();
		System.out.println("Identified SAUDI_ARABIA >> Subscription Period: " + ksa_clas_actualperiod.substring(1));
		softassert.assertEquals(ksa_clas_actualperiod, ksa_clas_expectperiod, "SAUDI_ARABIA >> LITE >> PERIOD -- Assertion --");
		
		
		

		
		// Assert whether SAUDI_ARABIA subscription package CLASSIC is available 
		boolean KSA_PM_flag=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]")).isDisplayed();
		softassert.assertTrue(KSA_PM_flag);
		
		// Assert the SAUDI_ARABIA >> CLASSIC subscription amount
		String ksa_prem_expectamount = "60";
		String ksa_prem_actualamount = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/div[1]/span[1]")).getText();
		System.out.println("Identified SAUDI_ARABIA >> Subscription Amount: " + ksa_prem_expectamount);
		softassert.assertEquals(ksa_prem_actualamount, ksa_prem_expectamount, "SAUDI_ARABIA >> LITE >> AMOUNT -- Assertion --");
		
		
		// Assert the SAUDI_ARABIA >> CLASSIC subscription currency
		String ksa_prem_expectcurrency = "SAR";
		String ksa_prem_actualcurrency = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/div[1]/span[2]")).getText();
		System.out.println("Identified SAUDI_ARABIA >> Subscription Curncy: " + ksa_prem_actualcurrency);
		softassert.assertEquals(ksa_prem_actualcurrency, ksa_prem_expectcurrency, "SAUDI_ARABIA >> LITE >> CURNCY -- Assertion --");
				
		
		
		// Assert the SAUDI_ARABIA >> CLASSIC subscription period
		String ksa_prem_expectperiod = "/Month";
		String ksa_prem_actualperiod = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/div[1]/span[3]")).getText();
		System.out.println("Identified SAUDI_ARABIA >> Subscription Period: " + ksa_prem_actualperiod.substring(1));
		softassert.assertEquals(ksa_prem_actualperiod, ksa_prem_expectperiod, "SAUDI_ARABIA >> LITE >> PERIOD -- Assertion --");
		
		
		
		
		softassert.assertAll();

	}

	
	
	

	
	
	
	
	
	@Test(priority = 1, description = "TEST CASE to assert KUWAIT subscription package type, amount, currency and period")
	public void KuwaitSubscription()

	{
	
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div/ul/li[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		SoftAssert softassert = new SoftAssert();
		
		// Assert whether KUWAIT subscription package LITE is available 
		boolean KW_LT_flag=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]")).isDisplayed();                                          												    
		softassert.assertTrue(KW_LT_flag);
		
		// Assert the KUWAIT >> LITE subscription amount
		String kw_lite_expectamount = "1.2";
		String kw_lite_actualamount = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/div[1]/span[1]")).getText();
		System.out.println("Identified KUWAIT >> Subscription Amount: " + kw_lite_expectamount);  
		softassert.assertEquals(kw_lite_actualamount, kw_lite_expectamount, "KUWAIT >> LITE >> AMOUNT -- Assertion --");
		
		
		// Assert the KUWAIT >> LITE subscription currency
		String kw_lite_expectcurrency = "KWD";
		String kw_lite_actualcurrency = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/div[1]/span[2]")).getText();
		System.out.println("Identified KUWAIT >> Subscription Curncy: " + kw_lite_actualcurrency);
		softassert.assertEquals(kw_lite_actualcurrency, kw_lite_expectcurrency, "KUWAIT >> LITE >> CURNCY -- Assertion --");
				
		
		
		// Assert the KUWAIT >> LITE subscription period
		String kw_lite_expectperiod = "/Month";
		String kw_lite_actualperiod = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[1]/div[1]/span[3]")).getText();
		System.out.println("Identified KUWAIT >> Subscription Period: " + kw_lite_actualperiod.substring(1));
		softassert.assertEquals(kw_lite_actualperiod, kw_lite_expectperiod, "KUWAIT >> LITE >> PERIOD -- Assertion --");
		
	
		
		
		
		// Assert whether KUWAIT subscription package CLASSIC is available 
		boolean KW_CL_flag=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]")).isDisplayed();
		softassert.assertTrue(KW_CL_flag);
		
		// Assert the KUWAIT >> CLASSIC subscription amount
		String kw_clas_expectamount = "2.5";
		String kw_clas_actualamount = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/div[1]/span[1]")).getText();
		System.out.println("Identified KUWAIT >> Subscription Amount: " + kw_clas_expectamount);
		softassert.assertEquals(kw_clas_actualamount, kw_clas_expectamount, "KUWAIT >> LITE >> AMOUNT -- Assertion --");
		
		
		// Assert the KUWAIT >> CLASSIC subscription currency
		String kw_clas_expectcurrency = "KWD";
		String kw_clas_actualcurrency = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/div[1]/span[2]")).getText();
		System.out.println("Identified KUWAIT >> Subscription Curncy: " + kw_clas_actualcurrency);
		softassert.assertEquals(kw_clas_actualcurrency, kw_clas_expectcurrency, "KUWAIT >> LITE >> CURNCY -- Assertion --");
				
		
		
		// Assert the KUWAIT >> CLASSIC subscription period
		String kw_clas_expectperiod = "/Month";
		String kw_clas_actualperiod = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[2]/div[1]/span[3]")).getText();
		System.out.println("Identified KUWAIT >> Subscription Period: " + kw_clas_actualperiod.substring(1));
		softassert.assertEquals(kw_clas_actualperiod, kw_clas_expectperiod, "KUWAIT >> LITE >> PERIOD -- Assertion --");
		
		
		

		
		// Assert whether KUWAIT subscription package PREMIUM is available 
		boolean KW_PM_flag=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]")).isDisplayed();
		softassert.assertTrue(KW_PM_flag);
		
		// Assert the KUWAIT >> PREMIUM subscription amount
		String kw_prem_expectamount = "4.8";
		String kw_prem_actualamount = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/div[1]/span[1]")).getText();
		System.out.println("Identified KUWAIT >> Subscription Amount: " + kw_prem_expectamount);
		softassert.assertEquals(kw_prem_actualamount, kw_prem_expectamount, "KUWAIT >> LITE >> AMOUNT -- Assertion --");
		
		
		// Assert the KUWAIT >> PREMIUM subscription currency
		String kw_prem_expectcurrency = "KWD";
		String kw_prem_actualcurrency = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/div[1]/span[2]")).getText();
		System.out.println("Identified KUWAIT >> Subscription Curncy: " + kw_prem_actualcurrency);
		softassert.assertEquals(kw_prem_actualcurrency, kw_prem_expectcurrency, "KUWAIT >> LITE >> CURNCY -- Assertion --");
				
		
		
		// Assert the KUWAIT >> PREMIUM subscription period
		String kw_prem_expectperiod = "/Month";
		String kw_prem_actualperiod = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div/section/div/div[1]/div[3]/div[1]/span[3]")).getText();
		System.out.println("Identified KUWAIT >> Subscription Period: " + kw_prem_actualperiod.substring(1));
		softassert.assertEquals(kw_prem_actualperiod, kw_prem_expectperiod, "KUWAIT >> LITE >> PERIOD -- Assertion --");
		
		
		
		
		softassert.assertAll();

	}
	
	
	

	@AfterMethod

	public void tearDown()

	{

		driver.quit();
		
	}




}