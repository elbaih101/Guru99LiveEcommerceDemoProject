package com.elbaih.stepDefs;

import com.elbaih.pages.P02_MobileList;
import com.elbaih.pages.P03_DetailsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.atomic.AtomicReference;

public class D02_VerifyCost {
    P02_MobileList mobileList = new P02_MobileList();
    P03_DetailsPage detailsPage = new P03_DetailsPage();
    String listPriceText;
    String detailPriceText;
    SoftAssert assrt = new SoftAssert();
    AtomicReference<WebElement> temp = new AtomicReference<>(null);

    @Then("get the cost of the {string} mobilephone")
    public void getTheCostOfTheMobilephone(String arg0) {

        mobileList.mobilelist.forEach(WebElement -> temp.set(WebElement.findElement(By.xpath("//*/a[@title=\"Sony Xperia\"]/..//following-sibling::*"))));
        if (temp != null)
            listPriceText = temp.get().getText();

    }

    @When("user clicks on the {string} mobilephone")
    public void userClicksOnTheMobilephone(String arg0) {
        mobileList.mobilelist.forEach(WebElement -> temp.set(WebElement.findElement(By.xpath("//*/a[@title=\"Sony Xperia\"]"))));
        if (temp != null)
            temp.get().click();

    }

    @Then("compare the price from the detail page with the list page")
    public void compareThePriceFromTheDetailPageWithTheListPage() {
        detailPriceText = detailsPage.detailPagePrice.getText();
        assrt.assertEquals(listPriceText, detailPriceText);
        assrt.assertAll();
    }


}
