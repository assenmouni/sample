import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Tsrtc_sampletest {
    public static String selecteddate = "5";
    public static String selectedmonth = "October";
    public static String selectedyear = "2023";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tsrtconline.in/oprs-web/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());

        if ((driver.getTitle()).equals("Online Bus Ticket Booking | TSRTC Official Website | Telangana")) {
            System.out.println("title verified");
        } else {
            System.out.println("Title not match");
        }
        WebElement fromcity = driver.findElement(By.xpath("//input[@id='fromPlaceName']"));
        fromcity.sendKeys("khammam");
        Thread.sleep(4000);
        Actions cname = new Actions(driver);
        cname.keyDown(Keys.ENTER).perform();

        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='toPlaceName']")).sendKeys("hyderab");
        Thread.sleep(2000);
        cname.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        cname.keyDown(Keys.ENTER).perform();

        WebElement datepicker = driver.findElement(By.name("txtJourneyDate"));
        datepicker.click();
        String defalutMonth = driver.findElement(By.xpath("//span[normalize-space()='August']")).getText();
        String defaultYear = driver.findElement(By.xpath(
                "//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-left']//span[@class='ui-datepicker-year'][normalize-space()='2023']"))
                .getText();

        if (defalutMonth.equals(selectedmonth) && (defaultYear.equals(selectedyear))) {
            List<WebElement> alldates = driver.findElements(By.xpath(
                    "//div[@class='ui-datepicker-group ui-datepicker-group-first']//table[@class='ui-datepicker-calendar']//td"));
            for (WebElement date : alldates) {
                if (date.getText().equals(selecteddate)) {
                    date.click();
                    return;
                }
            }
        }
        String
        currentmonth=driver.findElement(By.xpath("//span[contains(.,'September')]")).getText();
        String
        currentyear=driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'][contains(.,'2023')])[2]")).getText();

        if(currentmonth.equals(selectedmonth) && (currentyear.equals(selectedyear)))
        {
        List<WebElement> allsepdates =
        driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//table[@class='ui-datepicker-calendar']//td"));
        for(WebElement date : allsepdates)
        {
        if(date.getText().equals(selecteddate))
        {
        date.click();
        return;
        }
        }
        }
        driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
        Thread.sleep(6000);
        String reqmonth = driver.findElement(By.xpath("//span[contains(.,'October')]")).getText();
        String reqyear=driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']//span[@class='ui-datepicker-year'][normalize-space()='2023']")).getText();
        if(reqmonth.equals(selectedmonth) && (reqyear.equals(selectedyear)))
        {
            List<WebElement> octdates=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//table[@class='ui-datepicker-calendar']//td"));
            for(WebElement date : octdates)
            {
               if(date.getText().equals(selecteddate));
               Thread.sleep(4000);
               {
                date.click();
                break;
               }
                
            }
            
        }
    }
}
