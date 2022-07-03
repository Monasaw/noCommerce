package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="Email")
	WebElement txtemail;
	
	@FindBy(name="Password")
	WebElement txtpass;
	
	@FindBy(name="RememberMe")
	WebElement chkrem;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement btnlogin;
	
	@FindBy(xpath="//h2[normalize-space()='Welcome to our store']")
	WebElement cnfmsg;
	
	public void setemail(String email) {
		txtemail.sendKeys(email);
	}
	public void setpass(String pass) {
		txtpass.sendKeys(pass);
	}
	public void setrem()
	{
		chkrem.click();
	}
	public void clicklogin() {
		btnlogin.click();
	}
	public String confirmmsg() {
		try {
		return(cnfmsg.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	

}
