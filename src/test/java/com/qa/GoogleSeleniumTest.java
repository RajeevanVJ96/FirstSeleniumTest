package com.qa;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;
    static ExtentTest test;
    static ExtentReports extent;

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
    public void sliderTest() throws InterruptedException {
        extent = new ExtentReports("C:\\Users\\Admin\\Documents\\Week-6\\Test Reports\\slider.html", true);
        test = extent.startTest("Testing Slide");
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
        Actions drag = new Actions(driver);
        WebElement slide = driver.findElement(By.xpath("//*[@id=\"slider1\"]/div/input"));
        drag.dragAndDropBy(slide, 100, 0).perform();
        WebElement smth = driver.findElement(By.id("range"));
        String value = smth.getText();
        if (value.equals("75")){
            test.log(LogStatus.PASS, "slid the slider" );
        }else{
            test.log(LogStatus.FAIL, "Didnt slide" );
        }
        extent.endTest(test);
        extent.flush();


    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        extent = new ExtentReports("C:\\Users\\Admin\\Documents\\Week-6\\Test Reports", true);
        test = extent.startTest("Testing Drag and Drop");
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        test.log(LogStatus.INFO, "Browser started..");
        Thread.sleep(5000);
        Actions drag = new Actions(driver);
        WebElement src = driver.findElementByXPath("//*[@id=\"todrag\"]/span[1]");
        WebElement target = driver.findElementByXPath("//*[@id=\"mydropzone\"]");
        test.log(LogStatus.INFO, "About to drag and drop..");
        drag.clickAndHold(src).moveToElement(target).release(target).perform();
        Thread.sleep(5000);
        test.log(LogStatus.FAIL, "Didnt drag and drop" );
        Thread.sleep(5000);

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
    public void checkboxTest() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(5000);
        WebElement chk1 = driver.findElementById("check1");
        assertTrue(chk1.isDisplayed());
        chk1.click();
        Thread.sleep(5000);
        chk1.click();
        Thread.sleep(5000);
        WebElement radio1 = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input");
        assertTrue(radio1.isDisplayed());
        radio1.click();
        WebElement radio2 = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input");
        assertTrue(radio2.isDisplayed());
        radio2.click();
        WebElement radio3 = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input");
        assertTrue(radio3.isDisplayed());
        radio3.click();
        WebElement radio4 = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input");
        assertTrue(radio4.isDisplayed());
        radio4.click();
        Thread.sleep(5000);
        WebElement submit = driver.findElementById("check1");
        assertTrue(submit.isDisplayed());
        submit.click();
        Thread.sleep(5000);

    }

    @Test
    public void selectAndMultiListTest() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        Thread.sleep(2000);
        Select slist = new Select(driver.findElement(By.id("select-demo")));
        slist.selectByVisibleText("Wednesday");
        Thread.sleep(2000);
        Select mlist = new Select(driver.findElement(By.id("multi-select")));
        mlist.selectByVisibleText("California");
        mlist.selectByIndex(1);
        Thread.sleep(2000);
        WebElement firstSel = driver.findElement(By.id("printMe"));
        assertTrue(firstSel.isDisplayed());
        firstSel.click();
        Thread.sleep(2000);
        WebElement allSel = driver.findElement(By.id("printAll"));
        assertTrue(allSel.isDisplayed());
        allSel.click();
        Thread.sleep(2000);

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
