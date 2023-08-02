package com.elbaih.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

    /**
     *
     * @param driver WebDriver
     * @param by  the method to find element
     * @return returns the WebElement
     */

    public static WebElement retryingFind(WebDriver driver, By by) {
        WebElement element = null;
        int attempts = 0;
        while(attempts < 2) {
            try {
             element= driver.findElement(by);

                break;
            } catch(StaleElementReferenceException ignored) {
            }
            attempts++;
        }
        return element;
    }

    /**
     *
     * @param base BAse webElement to find through ut
     * @param by the method to find element
     * @return returns the WebElement
     */
    public static WebElement retryingFind(WebElement base,By by) {
        WebElement element = null;
        int attempts = 0;
        while(attempts < 2) {
            try {
                element= base.findElement(by);

                break;
            } catch(StaleElementReferenceException ignored) {
            }
            attempts++;
        }
        return element;
    }
}
