package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TopDealsScrap {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/karthiknedunchezhiyan/Downloads/chromedriver-mac-x64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // code starts here ->

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        int totalPages = 4;
        // 0   1   2   3   4   5   6   7   8
        // td1 td2 td3 td4 td5 td6 td7 td8 td9 .......
        for(int j = 1; j <= totalPages; j++)
        {
            List<WebElement> tdList = driver.findElements(By.xpath("//tr//td"));

            for (int i = 0; i < tdList.size(); i+=3)
            {
                String productName = tdList.get(i).getText();
                String actualPrice = tdList.get(i+1).getText();
                String discountedPrice = tdList.get(i+2).getText();

                System.out.printf("%s - %s - %s\n", 
                productName, actualPrice, discountedPrice);
            }

            if (j != totalPages)
            {
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        }

        // driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']//*[name()='svg']")).click();

        driver.findElement(By.xpath("//button[@class='react-date-picker__clear-button react-date-picker__button']")).click();

        driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']")).click();

        driver.findElement(By.xpath("//abbr[@aria-label='14 July 2024']")).click();
    }
}
