package com.fitpeo.qa.util;

import com.fitpeo.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActions {
    public static WebDriver driver;

    static {
        driver = TestBase.driver;
    }

    public static void scrollIntoView(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(by));
    }

    public static void scrollIntoView(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
    }

    public static void click(By by) {
        driver.findElement(by).click();
    }

}
