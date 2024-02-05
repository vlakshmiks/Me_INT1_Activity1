package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

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

    //Automate_nested frames text
    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        //driver.switchTo().frame("frameset-middle");
        driver.switchTo().frame("frame-left");
        WebElement textElement = driver.findElement(By.xpath("//html/body"));
        System.out.println("text in the left frame is: " + textElement.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        textElement = driver.findElement(By.xpath("//html/body"));
        System.out.println("text in the middle frame is: " + textElement.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        textElement = driver.findElement(By.xpath("//html/body"));
        System.out.println("text in the right frame is: " + textElement.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        textElement = driver.findElement(By.xpath("//html/body"));
        System.out.println("text in the botton frame is: " + textElement.getText());
        driver.switchTo().parentFrame();


        
        System.out.println("end Test case: testCase04");
    }

    //Automate_window_handle
    public  void testCase05() throws InterruptedException{
        System.out.println("Start Test case: testCase05");
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        Thread.sleep(5000);
        driver.switchTo().frame("iframeResult");
        WebElement tryIt = driver.findElement(By.xpath("//button[text()='Try it']"));
        //WebElement tryIt = driver.findElement(By.xpath("//html/body/button"));
        String parentWindowHandle = driver.getWindowHandle();
        tryIt.click();
        Set<String> windows = driver.getWindowHandles(); 
        System.out.println(windows); 
        
        for (String window : windows) 
        { 
            if (window.equalsIgnoreCase(parentWindowHandle)) {

            } else {
                driver.switchTo().window(window);
                break;
            }
        }
        System.out.println("url of the child window is: " + driver.getCurrentUrl());
        System.out.println("title of the child window is: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(parentWindowHandle);
        System.out.println("end Test case: testCase05");
    }

    //Automate_IMDB_ratings
    public  void testCase06() throws InterruptedException{
        System.out.println("Start Test case: testCase06");
        driver.get("https://www.imdb.com/chart/top/");
        Thread.sleep(5000);
        WebElement highestRated = driver.findElement(By.xpath("(//h3)[2]"));
        System.out.println("Hightest rated movie is: " + highestRated.getText());
        List<WebElement> moviesCount = driver.findElements(By.xpath("(//ul[@role='presentation'])[1]/li"));
        System.out.println("Movies count is: " + moviesCount.size());
        System.out.println("end Test case: testCase06");
    }


}
