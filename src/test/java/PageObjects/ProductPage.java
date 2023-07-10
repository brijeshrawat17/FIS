package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public WebDriver driver;

	public ProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	private WebElement search;

	@FindBy(xpath = "//input[@class='button-1 search-box-button']")
	private WebElement searchbutton;

	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement Addtocartbutton;
	@FindBy(xpath = "//a//span[@class='cart-qty']")
	private WebElement cartlink;
	@FindBy(xpath = "//table[@class='cart-total']//span[text()='Sub-Total:']//parent::td//following-sibling::td//span[@class='product-price']")
	private WebElement subtotal;

	public WebElement getSubtotal() {
		return subtotal;
	}

	public List<WebElement> getProductprice() {
		return productprice;
	}

	public List<WebElement> getCartrows() {
		return cartrows;
	}

	public List<WebElement> getCartcol() {
		return cartcol;
	}

	public WebElement getUpdatecart() {
		return updatecart;
	}

	@FindBy(xpath = "//table//tbody//tr[@class='cart-item-row']")
	private List<WebElement> cartrows;

	@FindBy(xpath = "//table//tbody//tr[@class='cart-item-row']//td")
	private List<WebElement> cartcol;

	@FindBy(xpath = "//input[@name='updatecart']")
	private WebElement updatecart;
	@FindBy(xpath = "//table//tbody//tr[@class='cart-item-row']//td//input[@name='removefromcart']")
	private List<WebElement> removeproduct;

	@FindBy(xpath = "//table//tbody//tr[@class='cart-item-row']//td//span[@class='product-subtotal']")
	private List<WebElement> productprice;

	public WebElement getCartlink() {
		return cartlink;
	}

	public List<WebElement> getRemoveproduct() {
		return removeproduct;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getAddtocartbutton() {
		return Addtocartbutton;
	}

}
