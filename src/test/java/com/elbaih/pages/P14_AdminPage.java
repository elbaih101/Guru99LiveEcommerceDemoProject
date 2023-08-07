package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class P14_AdminPage {


   public P14_AdminPage(){
        PageFactory.initElements(Hooks.driver,this);
    }


    @FindBy(id="username")
    public WebElement usernameField;
   @FindBy(id="login")
    public WebElement passwordField;
   @FindBy(className ="form-button")
    public WebElement loginButton;
   @FindBy(css = "a[title=\"close\"]")
    public WebElement popUpCloseButton;
   @FindBy(xpath = "//span[contains(text(),\"Sales\")]/../../ul//span[contains(text(),\"Orders\")]/..")
    public WebElement ordersLink;
   @FindBy(xpath = "//span[contains(text(),\"Sales\")]/..")
    public WebElement salesLink;
   @FindBy(id="sales_order_grid_export")
    public WebElement exportTypeList;
   @FindBy(css = "Button[title=\"Export\"]")
    public WebElement exportButton;
}
