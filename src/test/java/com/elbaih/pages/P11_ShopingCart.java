package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;
import java.util.List;

public class P11_ShopingCart {
   public P11_ShopingCart(){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(css = "Button[title=\"Proceed to Checkout\"]")
    public WebElement proceedtoCheckoutButton;
   @FindBy(id="country")
   public WebElement countrys;


   @FindBy(id="region_id")
   public WebElement regions;
   @FindBy(id="postcode")
    public WebElement zipCodeField;
   @FindBy(css = "Button[title=\"Estimate\"]")
    public WebElement estimateButton;
   @FindBy(id="s_method_flatrate_flatrate")
    public WebElement flatRateRadioButton;
   @FindBy(css = "Button[title=\"Update Total\"]")
    public WebElement updateTotalButton;
   @FindBy(css = "table[id=\"shopping-cart-totals-table\"] span[class=\"price\"]")
    public List<WebElement> prices;
   @FindBy(className = "success-msg")
    public WebElement succesmsg;
   @FindBy(id="coupon_code")
    public  WebElement couponeField;
   @FindBy(css = "Button[onclick=\"discountForm.submit(false)\"]")
    public WebElement applyCouponButton;
}
