package Assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import objectRepositoryUtility.CreateNewProductPage;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.ProductInfoPage;
import objectRepositoryUtility.ProductsPage;

public class Products extends BaseClass {

	@Test
	public void products() throws Throwable{
		
		int rnum = jlib.getRandomNumber();
		  
		String prodname = elib.getDataFromExcel("opportunities", 4, 2) +rnum;
		 String quantity = elib.getDataFromExcel("opportunities", 4, 3);
		   
		  //products
		  
		  HomePage hp = new HomePage(driver);
		  hp.getProductsLink().click();
		  
		  ProductsPage p= new ProductsPage(driver);
		  p.getNewProductsbtn().click();
		  
		  CreateNewProductPage cpp= new CreateNewProductPage(driver);
				  cpp.getproductNameTxt().sendKeys(prodname);
		  
		  Actions act = new Actions(driver);
		  act.scrollByAmount(0, 800).perform();
		  
		  WebElement ele = cpp.getHandlerDD();
		  ele.click();
		  wlib.select(ele, 3);
		  
		  cpp.getQuantityTxt().sendKeys(quantity);
	 WebElement upload =cpp.getUploadbtn();
	 upload.sendKeys("C:\\Users\\heman\\OneDrive\\Desktop\\advSel\\testData.xlsx");
	 
	 cpp.getTxtBox().sendKeys("product is updated ");

	 cpp.getSaveBtn().click();
	  
	  //verify opp
	 ProductInfoPage pip = new ProductInfoPage(driver);
	 String actualprodName = pip.getProductinfoConfirm().getText();
		if(actualprodName.contains(prodname)) {
			System.out.println(prodname + " product is created == pass");
		}
		else{
			System.out.println(prodname + " product is not created == fail");
		}			 
	}

}
