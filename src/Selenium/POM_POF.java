package Selenium;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

    public class POM_POF {
        static WebDriver driver;
        public WebElement USER(WebDriver driver) {
            WebElement user = driver.findElement(By.id("searchTxt"));
            return user;
        }
        public WebElement BTN(WebDriver driver) {
            WebElement BTN = driver.findElement(By.id("Button1"));
            return BTN;}

        public WebElement ADD(WebDriver driver) {
            WebElement ADD = driver.findElement(By.className("calculator_deleteTxtcalculator_deleteTxt"));
            return ADD;}
        @FindBy(xpath = "//select[@id='serachResults']//option")
        public List<WebElement> links;


        @BeforeClass
        public static void beforeclass(){
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("http://www.netogreen.co.il/Calculators/Nutrition-Calories.aspx");
        }
        @AfterClass
        public static void afterclass(){
            driver.close();
        }
        @After
        public void after(){
            driver.navigate().refresh();
        }
        @Test
        public void test1(){
            USER(driver).sendKeys("לחם");
            BTN(driver).click();
            System.out.println(links);}
        @Test
        public void test2(){
            USER(driver).sendKeys("123");
            BTN(driver).click();
            System.out.println(links);
        }
        @Test
        public void test3()throws InterruptedException {
            USER(driver).sendKeys("לחם");
            BTN(driver).click();
            sleep(2000);
            System.out.println(links);
            for(int i=0;i<links.size();i++){
                System.out.println(links.get(i).getText());
                if (links.get(i).getText().equals("לחם זיתים")){
                    links.get(i).click();
                    ADD(driver).click();
                    System.out.println("TEST3 PASS ");
                }
            }
        }


    }


