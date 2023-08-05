package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P09_LoginPage {

   public P09_LoginPage(){
       PageFactory.initElements(Hooks.driver,this);
   }

   @FindBy(id = "email")
public WebElement emaiField;
   @FindBy(id="pass")
    public WebElement passField;
   @FindBy(id="send2")
    public WebElement loginButton;
}
