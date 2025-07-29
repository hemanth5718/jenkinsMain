package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	WebDriver driver;
	  public CreateNewProductPage(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productNameTxt;
	
	@FindBy(xpath="//select[@name='assigned_user_id']")
	private WebElement HandlerDD;
	
	@FindBy(id ="qty_per_unit")
	private WebElement quantityTxt;
	
	@FindBy(id ="my_file_element")
	private WebElement uploadbtn;
	
	@FindBy(xpath ="//textarea[@class='detailedViewTextBox']")
	private WebElement txtBox;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;
	
	
	
	
	
	public WebElement getProductNameTxt() {
		return productNameTxt;
	}

	public WebElement getHandlerDD() {
		return HandlerDD;
	}

	public WebElement getQuantityTxt() {
		return quantityTxt;
	}
	public WebElement getUploadbtn() {
		return uploadbtn;
	}
	public WebElement getTxtBox() {
		return txtBox;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getproductNameTxt() {
		return productNameTxt;
	}

}
