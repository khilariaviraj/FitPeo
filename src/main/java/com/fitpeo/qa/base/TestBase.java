package com.fitpeo.qa.base;

import com.fitpeo.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;


    static {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/fitpeo/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            System.out.println("Properties file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Failed to load properties file: " + e.getMessage());
        }
    }

    @BeforeTest
    public static void initialization() {

        if (prop == null) {
            throw new IllegalStateException("Properties file not initialized.");
        }

        String browserName = prop.getProperty("browser");


        if (browserName == null || browserName.isEmpty()) {
            throw new IllegalArgumentException("Browser name not specified in properties file.");
        }

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            throw new UnsupportedOperationException("Only Chrome browser is supported currently.");
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);


        String url = prop.getProperty("url");
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL not specified in properties file.");
        }
        driver.get(url);
    }

    @AfterTest
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
