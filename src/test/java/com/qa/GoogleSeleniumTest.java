package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Admin\\Documents\\Week-6\\FirstSeleniumTest\\src\\test\\java\\resources\\chromedriver.exe"
        );
        driver = new ChromeDriver();

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void twoInputTest() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(5000);
        WebElement inputA = driver.findElement(By.id("sum1"));
        assertTrue(inputA.isDisplayed());
        inputA.sendKeys("2");
        WebElement inputB = driver.findElement(By.id("sum2"));
        assertTrue(inputB.isDisplayed());
        inputB.sendKeys("2");
        Thread.sleep(5000);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
        submit.click();
        Thread.sleep(5000);

    }

    @Test
    public void searchTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://google.com");
        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.id("q"));
        assertTrue(searchField.isDisplayed());
        searchField.sendKeys("funny cat pictures");
        Thread.sleep(5000);
        WebElement submit = driver.findElement(By.name("btnK"));
        submit.click();
        Thread.sleep(5000);
        WebElement linkToBiggerPicture = driver.findElementByLinkText("Images for funny cat");
        linkToBiggerPicture.click();
        WebElement selectedpic = driver.findElement(By.id("QiDMQ0Uiqd5jnM:"));
        selectedpic.click();
        Thread.sleep(5000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        Thread.sleep(5000);
        jse.executeScript("scroll(0, -250);");
        Thread.sleep(5000);

        driver.findElementByXPath("/html/body/div[6]/div[3]/div[3]/div[2]/div/div[2]/div[2]/div/div/div/div/div[2]/div[1]/div[7]");

    }

}
