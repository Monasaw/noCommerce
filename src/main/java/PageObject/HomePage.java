package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkregister;
	
	@FindBy(xpath="//a[normalize-space()='Log in']")
	WebElement linklogin;
	
	public void ClickRegister() {
		linkregister.click();
	}
	public void ClickLogin() {
		linklogin.click();
	}

}
