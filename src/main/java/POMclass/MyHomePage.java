package POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyHomePage 
{
public WebDriver driver;
public MyHomePage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
private WebElement dropdown;

@FindBy(xpath="//a[text()='Logout']")
private WebElement logout;
public WebElement getDropdown() {
	return dropdown;
}

public WebElement getLogout() {
	return logout;
}

}
