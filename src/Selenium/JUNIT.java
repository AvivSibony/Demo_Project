package Selenium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Thread.sleep;

public class JUNIT {
    static WebDriver driver;
    static WebElement element;
    static double shufer = 0.0;
    static double quick = 0.0;
    static Robot robot;
    static double rami_levi = 0.0;

    @BeforeClass
    public static void BeforeClass() {
        //driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void AfterClass() {
        driver.close();
    }

    @Test
    public void shufersal() throws InterruptedException {
        driver.get("https://www.shufersal.co.il/online/he/");
        driver.findElement(By.xpath("//input[@name='text']")).sendKeys("שניצל תירס טבעול");
        sleep(4000);
        List<WebElement> price_shufer = driver.findElements(By.xpath("//span[@class='number']"));
        shufer = Double.parseDouble(price_shufer.get(0).getText());
    }

    @Test
    public void Rami() throws InterruptedException {
        driver.get("https://www.rami-levy.co.il/he/online/market");
        driver.findElement(By.id("destination")).sendKeys("שניצל תירס טבעול");
        sleep(2000);
        driver.findElement(By.xpath("//div[@id='srch-item-1']")).click();
        List<WebElement> prices = driver.findElements(By.xpath("//span/span"));
        String prices_rami = prices.get(0).getText().replace("₪", "");
        rami_levi = Double.parseDouble(prices_rami);

    }

    @Test
    public void QUICK() throws InterruptedException {
        driver.get("https://quik.co.il/");
        driver.findElement(By.className("searchInput_KC6")).sendKeys("שניצל תירס טבעול");
        sleep(2000);
        List<WebElement> p_q = driver.findElements(By.xpath("//div//strong"));
        List<WebElement> p_q1 = driver.findElements(By.xpath("//div//small"));
        String final_p = p_q.get(0).getText();
        String final_p1 = p_q1.get(1).getText();
        double f_p = Double.parseDouble(final_p);
        double f_p1 = Double.parseDouble(final_p1);
        quick = f_p + (f_p1 / 100);

    }

    @Test
    public void copmere_prices() throws InterruptedException {
        double max = 0.0;
        double min = 0.0;
        System.out.println("Shufersal price = "+shufer);
        System.out.println("Rami Levi price = "+rami_levi);
        System.out.println("Quick price = "+quick);
        List<Double> list = new ArrayList<>();
        list.add(shufer);
        list.add(quick);
        list.add(rami_levi);
        for (int i=0;i<list.size();i++) {
            if(list.get(i)>max)
            {
                max= list.get(i);
            }
            else {
                min = list.get(i);
            }
        }
        System.out.println("Maximum Price - "+max);
        System.out.println("Minimum Price - "+min);

    }
}


