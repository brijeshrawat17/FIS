package Test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.ProductPage;

public class Demowebshop extends BaseClass {

	HomePage homepage;
	ProductPage productpage;
	WebDriverWait wait;

	@Test(groups = { "SmokeTest" })
	@Parameters({ "product1", "product2" })

	public void Login(String product1, String product2) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		homepage = new HomePage(driver);

		homepage.getLoginlink().click();
		homepage.getEmail().sendKeys("brijeshrawat@test.com");
		homepage.getPassword().sendKeys("brijesh123");
		homepage.getLoginbutton().click();

		productpage = new ProductPage(driver);
		if (productpage.getCartlink().getText().equals("(0)")) {

			addProduct(product1, product2);
		} else {
			deleteproduct();
			addProduct(product1, product2);

		}

	}

	public void addProduct(String product1, String product2) {
		productpage.getSearch().sendKeys(product1);
		productpage.getSearchbutton().click();
		productpage.getAddtocartbutton().click();
		wait.until(ExpectedConditions.visibilityOf(productpage.getAddtocartbutton()));

		productpage.getSearch().sendKeys(product2);
		productpage.getSearchbutton().click();
		wait.until(ExpectedConditions.visibilityOf(productpage.getAddtocartbutton()));
		productpage.getAddtocartbutton().click();
		productpage.getCartlink().click();

		Double product1price = Double.parseDouble(productpage.getProductprice().get(0).getText());
		System.out.println(Double.parseDouble(productpage.getProductprice().get(0).getText()));
		Double product2price = Double.parseDouble(productpage.getProductprice().get(1).getText());
		System.out.println(productpage.getProductprice().get(1).getText());
		double finalprice = product1price + product2price;

		System.out.println(Double.parseDouble(productpage.getSubtotal().getText()));
		Assert.assertEquals(finalprice, Double.parseDouble(productpage.getSubtotal().getText()));

	}

	public void deleteproduct() {

		productpage.getCartlink().click();

		int rowssize = productpage.getCartrows().size();

		for (int i = 0; i < rowssize; i++) {
			productpage.getRemoveproduct().get(i).click();
			;

		}
		productpage.getUpdatecart().click();
	}

}
