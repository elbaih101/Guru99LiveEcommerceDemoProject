package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_DetailsPage {


  public   P03_DetailsPage(){PageFactory.initElements(Hooks.driver,this);}


    @FindBy(id = "product-price-1")
   public WebElement detailPagePrice;
}
