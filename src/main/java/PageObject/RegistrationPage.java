package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='gender-female']")
	WebElement btnfemale;
	
	@FindBy(name="FirstName")
	WebElement txtfname;
	
	@FindBy(name="LastName")
	WebElement txtlname;
	
	@FindBy(name="Email")
	WebElement txtemail;
	
	@FindBy(name="Company")
	WebElement txtcompanyname;
	
	@FindBy(name="Password")
	WebElement txtpass;
	
	@FindBy(name="ConfirmPassword")
	WebElement txtcnfpass;
	
	@FindBy(name="register-button")
	WebElement btnregister;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement msgConfirmation;
	
	public void setgender()
	{
		btnfemale.click();
	}
	public void setfirstname(String fname) {
		txtfname.sendKeys(fname);
	}
	public void setlastname(String lname) {
		txtlname.sendKeys(lname);
	}
	public void setemail(String email) {
		txtemail.sendKeys(email);
	}
	public void setcompanyname(String companyname) {
		txtcompanyname.sendKeys(companyname);
	}
	public void setpassword(String password) {
		txtpass.sendKeys(password);
	}

	public void setcnfpassword(String cnfpassword) {
		txtcnfpass.sendKeys(cnfpassword);
	}
	public void clickregis() {
		btnregister.click();
	}
	public String msgcnf() {
		try {
			return(msgConfirmation.getText());
			}
			catch(Exception e) {
				return(e.getMessage());
			}
			}
	}

