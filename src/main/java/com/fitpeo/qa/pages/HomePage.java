package com.fitpeo.qa.pages;

import com.fitpeo.qa.base.TestBase;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.fitpeo.qa.util.SeleniumActions.click;
import static com.fitpeo.qa.util.SeleniumActions.scrollIntoView;

public class HomePage extends TestBase {

    private static final By revenueCalculator = By.xpath("//div[contains(text(),'Revenue Calculator')]");
    private static final By sliderBar = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 inter css-k0m0w']");
    private static final By sliderBarValue = By.xpath("//span[@class='MuiSlider-rail css-3ndvyc']");


    @Test(priority = 1)
    public static void navigateToHomePage() {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);

    }

    @Test(priority = 2)
    public static void navigateToRevenueCalculatorPage() {
        click(revenueCalculator);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);

    }

    @Test(priority = 3)
    public static void scrollToSliderBar() {
        scrollIntoView(sliderBar);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);

    }

    @Test(priority = 4)
    public static void adjustTheSlider() {
        try {
            WebElement sliderHandle = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh')]"));

            Actions actions = new Actions(driver);
            actions.clickAndHold(sliderHandle)
                    .moveByOffset(94, 0) // Move 50 pixels to the right
                    .release()
                    .perform();

            // Optional: Add a delay to observe the result
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public static void clearTextField() {
        WebElement textBox = driver.findElement(By.xpath("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall css-129j43u']/input"));
        WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']")); // Replace with the actual locator
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", textBox);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        js.executeScript("arguments[0].value = '';", textBox);
        // Value to set
        int desiredValue = 560;
        js.executeScript("arguments[0].value = arguments[1];", textBox, desiredValue);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

    }


    @Test(priority = 6)
    public static void selectCheckbox() {
        WebElement checkbox_99091 = driver.findElement(By.xpath("//div[@class='MuiBox-root css-rfiegf']//div[1]//label[1]//span[1]//input[1]"));
        WebElement checkbox_99453 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]"));
        WebElement checkbox_99454 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]"));
        WebElement checkbox_99474 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        scrollIntoView(checkbox_99091);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        js.executeScript("arguments[0].click();", checkbox_99091);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        js.executeScript("arguments[0].click();", checkbox_99453);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        js.executeScript("arguments[0].click();", checkbox_99454);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

        scrollIntoView(checkbox_99474);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        js.executeScript("arguments[0].click();", checkbox_99474);

    }

    @Test(priority = 7)
    public static void validateTotal() {
        WebElement totalElement = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19'])[3]"));
        String totalText = totalElement.getAttribute("textContent");
        System.out.println("Total value: " + totalText);
    }
}





