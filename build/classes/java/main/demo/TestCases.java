package demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();
        searchBox.sendKeys("amazon");
        searchBox.sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();
        Thread.sleep(3000);
        Boolean isDisplayed = driver.findElement(By.xpath("//h3[text()='Amazon.in']")).isDisplayed();
        System.out.println("end Test case: testCase02, amazon.in displayed status is: " +  isDisplayed);
    }

    //Automate count of hyperlinks on bookmyshow
     public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        int countLinks = driver.findElements(By.xpath("//a")).size();
        System.out.println("count of hyperlinks in bookmyshow is: " + countLinks);
        
        System.out.println("end Test case: testCase02");
    }

    //Automate_image_urls
    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> imageList = new ArrayList<>();
        imageList = driver.findElements(By.xpath("//*[contains(@class,'style__WidgetContainerBody-sc-lnhrs7-4 YeNog')]/div/a/div/div/div/img"));
        int countImages = imageList.size();
        System.out.println("count of images in bookmyshow recommendations is: " + countImages);
        for (int i=0; i<countImages;i++) {
             System.out.println("image url is: " + imageList.get(i).getAttribute("src"));
        }
        System.out.println("count of images in bookmyshow recommendations is: " + countImages);
        
        System.out.println("end Test case: testCase03");
    }


}
