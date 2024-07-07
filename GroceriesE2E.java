package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import java.lang.Thread;
import java.util.List;

public class GroceriesE2E {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/karthiknedunchezhiyan/Downloads/chromedriver-mac-x64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // code starts here ->
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        
        String addToCartItems[] = {"Cucumber", "Carrot"};
        int addToCartTimes[] = {2, 3};

        List<WebElement> productNameList = driver.findElements(By.xpath("//h4[@class='product-name']"));
        List<WebElement> addToCartList = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));


        for (int i = 0; i < addToCartItems.length; i++)
        {
            String addToCart = addToCartItems[i];
            int times = addToCartTimes[i];

            for (int j = 0 ; j < productNameList.size(); j++)
            {
                if (productNameList.get(j).getText().contains(addToCart) == true)
                {
                    for (int k = 0; k < times; k++)
                    {
                        addToCartList.get(j).click();
                    }
                    break;
                }
            }
        }

        // Click on Add to Cart
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

        // Click on Proceed to Checkout
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        // Add promo code and apply
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[text()='Apply']")).click();

        // Place the order
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(1000);

        // Select country
        WebElement staticDropdown = driver.findElement(By.xpath("//select"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("India");

        // Agree terms and condition
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        // Final proceed
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    }
}
