package com.elbaih.stepDefs;

import com.elbaih.pages.P10_CustomerPage;
import com.elbaih.pages.P13_MyOrdersPage;
import com.elbaih.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class D07_VerifyOrders {
    P10_CustomerPage customerPage=new P10_CustomerPage();
    P13_MyOrdersPage myOrdersPage=new P13_MyOrdersPage();
    SoftAssert assrt =new SoftAssert();

    @Then("verify previously created order is in recent orders and its status is {string}")
    public void verifyPreviouslyCreatedOrderIsInRecentOrdersAndItsStatusIs(String expextedStatus) {
     assrt.assertTrue(customerPage.latestOrder.isDisplayed());
     assrt.assertEquals(customerPage.latestOrder.findElement(By.className("status")).getText(),expextedStatus);
     assrt.assertAll();

    }

    @Then("user clicks on My Orders Link")
    public void userClicksOnMyOrdersLink() {
        customerPage.myOrdersLink.click();
    }

    @And("user clicks on view order link in the latest order")
    public void userClicksOnViewOrderLinkInTheLatestOrder() {
        myOrdersPage.latestOrder.findElement(By.xpath("//a[contains(text(),\"View Order\")]")).click();
    }

    @When("user clicks on print order and print from print dialouge")
    public void userClicksOnPrintOrderAndPrintFromPrintDialouge() {
        myOrdersPage.printOrderLink.click();



    }

    @Then("the order is saved as pdf")
    public void theOrderIsSavedAsPdf() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assrt.assertTrue(Utils.isFileDownloaded("src/main/resources/savedorders","order.pdf"));
   assrt.assertAll();

    }
}
