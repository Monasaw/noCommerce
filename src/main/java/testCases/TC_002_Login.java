package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {

	
	@Test(groups= {"sanity","master"})
	public void test_Login(){
		logger.info("Starting TC_002_Login");
		try {
		driver.get(rb.getString("URL"));
    	driver.manage().window().maximize();
    	logger.info("Application launched");
    	
    	HomePage hp=new HomePage(driver);
    	hp.ClickLogin();
    	
    	LoginPage lp=new LoginPage(driver);
    	lp.setemail("kajal@gmail.com");
    	Thread.sleep(1000);
    	lp.setpass("rahul123");
    	Thread.sleep(1000);
    	lp.setrem();
    	Thread.sleep(1000);
    	lp.clicklogin();
    	Thread.sleep(1000);
    	String sta=lp.confirmmsg();
    			if(sta.equals("Welcome to our store")) {
    				logger.info("Login succesfull");
    				Assert.assertTrue(true);
    			}
    			else {
    				logger.error("Login failed");
    				captureScreen(driver,"test_Login");
    				Assert.assertTrue(false);
    			}
		}
		catch(Exception e) {
			Assert.fail();
		}
    			
		
	}
	

}
