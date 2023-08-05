package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P10_CustomerPage {

  public   P10_CustomerPage(){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(css = "div[class=\"block-content\"] a[href=\"http://live.techpanda.org/index.php/wishlist/\"]")
    public WebElement wishListLink;
  @FindBy(xpath = "//a[contains(text(),\"My Orders\")]")
    public WebElement myOrdersLink;
  @FindBy(css = "div.box-recent tr[class=\"first odd\"]")
  public WebElement latestOrder;
}
