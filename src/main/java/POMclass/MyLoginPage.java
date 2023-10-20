package POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyLoginPage {
	public WebDriver driver;
	
	public MyLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
		@FindBy(xpath="//input[@placeholder='Username']") 
		private WebElement usertextfield;
	
       @FindBy(xpath="//input[@placeholder='Password']")
       private WebElement passwordtextfield;
       
       @FindBy(xpath="//button[text()=' Login ']")
       private WebElement Loginbutton;

	public WebElement getUsertextfield() {
		return usertextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getLoginbutton() {
		return Loginbutton;
	}

}
