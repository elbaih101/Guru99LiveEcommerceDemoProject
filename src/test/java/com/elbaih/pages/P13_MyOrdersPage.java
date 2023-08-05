package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P13_MyOrdersPage {
 public    P13_MyOrdersPage(){
     PageFactory.initElements(Hooks.driver,this);
 }



    @FindBy(xpath = "//tr[@class=\"first odd\"]")
    public WebElement latestOrder;
 @FindBy(xpath = "//a[contains(text(),\"Print Order\")]")
    public WebElement printOrderLink;
}
