package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P05_ComparePage {
 public final String xperiaNameXpath="//*//h2[@class=\"product-name\"]/a[@title=\"Sony Xperia\"]";
   public final String galaxyNameXpath="//*//h2[@class=\"product-name\"]/a[@title=\"Samsung Galaxy\"]";
   public P05_ComparePage(){PageFactory.initElements(Hooks.driver,this);}


    @FindBy(id = "product_comparison")
   public WebElement compareTable;
}
