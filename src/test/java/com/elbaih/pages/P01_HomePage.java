package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class P01_HomePage {


  public P01_HomePage(){

          PageFactory.initElements(Hooks.driver,this);

    }
   @FindBy(className ="nav-primary")
   public WebElement navPrimalList;


    @FindBy(css = "a[href=\"http://live.techpanda.org/index.php/mobile.html\"]")
  public WebElement mobilelist;

   @FindBy(className = "page-title")
   public WebElement pagetitle;


}
