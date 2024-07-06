package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import java.lang.Thread;

public class SpiceJetE2E {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/karthiknedunchezhiyan/Downloads/chromedriver-mac-x64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // code starts here ->

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.spicejet.com/");

        // Select Round Trip
        driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();

        // From field
        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input")).sendKeys("MAA");

        // To field
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//input")).sendKeys("delhi");

        // Depature and Return field
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-testid='undefined-month-July-2024']//div[@data-testid='undefined-calendar-day-25']")).click();
        driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']//*[name()='svg']")).click();
        // Thread.sleep(1000);
        // driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']//*[name()='svg']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-testid='undefined-month-September-2024']//div[@data-testid='undefined-calendar-day-13']")).click();

        // passenger
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();

        // Increment adult count
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();

        // close passenger count
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();

        // search
        driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
    }
}
