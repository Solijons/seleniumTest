package eventTracker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by gkqrl on 7/8/19.
 */
public class Events {

    String localURL = "http://localhost:3001";

    @BeforeClass
    public void setProperty() {
        System.setProperty("webdriver.chrome.driver", "macChromeDriver//chromedriver");
    }

    @Test (groups = {"Events", "AddEvent"})
    public void AddNFEvents() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(localURL);

        System.out.println("Test Started executing");

        // Selects Nursery Field from Table
        List<WebElement> nurseryField = driver.findElements(By.cssSelector("div[class='ag-cell ag-cell-not-inline-editing ag-cell-with-height']"));
        int NFSize = nurseryField.size();
        for(int i = 0; i < NFSize; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, NFSize);
            nurseryField.get(randomIndex).click();
        }

        // Add Event
        driver.findElement(By.xpath("//button[contains(text(),'Add Event')]")).click();
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.xpath("//body/div[@id='root']/div[@class='container']/div[@class='row']/div[@class='col']/div[@class='container']/div[@class='row']/div[@class='col-sm-4']/div[@class='card']/div[@class='card-body']/span/div[1]/div[2]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@value='Planting Prep']")).click();

        // Event Date
        LocalDate localDate = LocalDate.now();
        WebElement eventDate = driver.findElement(By.xpath("//div[@class='col-sm-8']//div[1]//div[2]//form[1]//div[1]//input[1]"));
        eventDate.sendKeys(DateTimeFormatter.ofPattern("MM/dd/yyy").format(localDate));

        // Comments
        WebElement comments = driver.findElement(By.xpath("//div[@class='col-sm-8']//div[1]//div[2]//form[1]//div[2]//textarea[1]"));
        comments.sendKeys("This is my test comments");

        // Select Status
        WebElement statusValue = driver.findElement(By.xpath("//div[@class='col-sm-8']//div[1]//div[2]//form[1]//div[3]//select[1]"));
        Select statusSelectValues = new Select(statusValue);
        List <WebElement> statusValueOptions = statusSelectValues.getOptions();
        for (int i = 0; i < statusValueOptions.size(); i++) {
            System.out.println("Searching Status");
            int randomNumber = ThreadLocalRandom.current().nextInt(1, statusValueOptions.size());
            statusValueOptions.get(randomNumber).click();
            System.out.println("Clicked randomly given value and Exit \n");
            break;
        }
        Thread.sleep(1000);
        // Submit Button
        driver.findElement(By.xpath("//div[@class='col-sm-8']//div[1]//div[2]//form[1]//button[1]")).click();
        System.out.println("Test passed");

        driver.quit();
    }

    @Test (groups = {"Events", "AddEventRandom"})
    public void AddNFEWithRandomly() throws InterruptedException {
        setProperty();
        WebDriver driver = new ChromeDriver();
        driver.get(localURL);


        // Selects Nursery Field from Table
        List <WebElement> nurseryField = driver.findElements(By.cssSelector("div[class='ag-cell ag-cell-not-inline-editing ag-cell-with-height']"));
        int NFSize = nurseryField.size();
        for(int i = 0; i < NFSize; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, NFSize);
            nurseryField.get(randomIndex).click();
        }

        // Add Event
        driver.findElement(By.xpath("//button[contains(text(),'Add Event')]")).click();
        System.out.println(driver.getCurrentUrl());

        //Selects Event Types by team
        List <WebElement> teams = driver.findElements(By.cssSelector("button[class='MuiButtonBase-root-7 MuiIconButton-root-1']"));
        int teamSize = teams.size();

        for(int i = 0; i < teamSize; i ++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, teamSize);
            teams.get(randomIndex).click();
        }

        Thread.sleep(3000);

        List <WebElement> eventTypes = driver.findElements(By.cssSelector("button[class='MuiButtonBase-root-7 MuiFab-root-19 MuiFab-primary-21 MuiFab-sizeSmall-27']"));
        int eventTypeSize = eventTypes.size();

        Thread.sleep(3000);
        for (int i = 0; i < eventTypeSize; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, eventTypeSize);
            eventTypes.get(randomIndex).click();
        }
    }
}
