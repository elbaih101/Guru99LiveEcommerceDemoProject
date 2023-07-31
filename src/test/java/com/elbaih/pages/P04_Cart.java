package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P04_Cart {


    public P04_Cart() {
        PageFactory.initElements(Hooks.driver, this);
    }


    @FindBy(css = "input[title=\"Qty\"]")
    public WebElement quantityField;

    @FindBy(css = "button[title=\"Update\"]")
    public WebElement updateButton;

    @FindBy(className = "error-msg")
    public WebElement errorMessage;
    @FindBy(css = "button[title=\"Empty Cart\"]")
    public WebElement emptyCartButton;
    @FindBy(className = "page-title")
   public WebElement cartPageTitle;
}
