package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P06_RegisterPage {

    public P06_RegisterPage() {PageFactory.initElements(Hooks.driver, this);}

@FindBy(id = "firstname")
  public   WebElement firstNameField;
    @FindBy(id = "lastname")
    public  WebElement lastNameField;
    @FindBy(id = "email_address")
    public  WebElement emailField;
    @FindBy(id = "password")
    public  WebElement passwordField;
    @FindBy(id = "confirmation")
    public WebElement confirmPasswordField;
    @FindBy(css = "Button[title=\"Register\"]")
    public WebElement registerButton;
    @FindBy(className = "success-msg")
  public WebElement successMsg;

    //Thank you for registering with Main Website Store.
}
