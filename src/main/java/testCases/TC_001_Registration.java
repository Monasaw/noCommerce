package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.RegistrationPage;
import testBase.BaseClass;

public class TC_001_Registration extends BaseClass {
	
	    @Test(groups= {"regression","master"})
	    public void test_Registration() throws InterruptedException {
	    	try {
	    	driver.get(rb.getString("URL"));
	    	driver.manage().window().maximize();
	    	logger.info("Application launched");
	    	
	    	HomePage hp=new HomePage(driver);
	    	hp.ClickRegister();
	    	logger.info("Click in Register");
	    	RegistrationPage rp=new RegistrationPage(driver);
	    	rp.setgender();
	    	rp.setfirstname("Nemma");
	    	rp.setlastname("Tiwari");
	    	rp.setemail(randomestring()+"@gmail.com");
	    	Thread.sleep(1000);
	    	rp.setcompanyname("Medibuddy");
	    	rp.setpassword("N12345");
	    	rp.setcnfpassword("N12345");
	    	rp.clickregis();
	    	String status=rp.msgcnf();
	    	
	    	if(status.equals("Your registration completed")) {
	    		logger.info("Successfully register");
	    		Assert.assertTrue(true);
	    		
	    	}
	    	else {
	    		logger.error("Register failed");
	    		
	    		captureScreen(driver,"test_Registration");
	    		Assert.assertTrue(false);
	    		
	    	}
	    	}
	    	catch(Exception e) {
	    		logger.error("test case faild");
				Assert.fail();
	    	}
	    	logger.info("Finished TC_001_Registration");
	    }
	    
	    
	    
	    
	    
	   
		
		

	}


