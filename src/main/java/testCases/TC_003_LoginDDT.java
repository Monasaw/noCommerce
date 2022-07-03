package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT extends BaseClass  {
	@Test(dataProvider="LoginData")
	public void test_LoginDDT(String uname,String pass,String exp) {
		logger.info("TC_003_LoginDDT started");
		try {
		driver.get(rb.getString("URL"));
		driver.manage().window().maximize();
		HomePage hp=new HomePage(driver);
		hp.ClickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(uname);
		lp.setpass(pass);
		lp.setrem();
		lp.clicklogin();
		String sta=lp.confirmmsg();
		if(exp.equals("valid")) {
			if(sta.equals("Welcome to our store")) {
				logger.info("Login Successfull");
				MyAccountPage mp=new MyAccountPage(driver);
				mp.Clicklogout();
				Assert.assertTrue(true);
						
			}
			else {
				logger.error("Login failed");
				Assert.assertTrue(false);
			}
				
		}
		if(exp.equals("Invalid")) {
			if(sta.equals("Welcome to our store")) {
				MyAccountPage mp=new MyAccountPage(driver);
				mp.Clicklogout();
				Assert.assertTrue(false);
			}
			else {
				logger.error("Login failed");
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_003_LoginDDT ");

	}
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Data_noCommerce.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;
	}

}
