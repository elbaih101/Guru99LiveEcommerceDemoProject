package com.elbaih.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

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
    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }
}
