package eventTracker;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Dashboard {

	// write your code here
    @BeforeClass
        public void setProperty() {
        System.setProperty("webdriver.chrome.driver", "macChromeDriver//chromedriver");
    }


    @Test (groups = {"Dashboard", "NFTable"})
    public void NFTable() {
        setProperty();
        System.out.println("Prints All the Value of Nursery Field Table");
        WebDriver driver = new ChromeDriver();
        String localURL = "http://localhost:3001/";
        driver.get(localURL);

        // Nursery Field Table Header
        System.out.println("Test started executing");
        System.out.println("Find Nursery Field Table Header");
        WebElement nurseryFieldHeadersValues = driver.findElement(By.xpath("//div[@class='ag-header-viewport']"));
        System.out.println("Found and printing");
        System.out.println(nurseryFieldHeadersValues.getText());


        // Nursery Field Table Body
        System.out.println("Find Nursery Field Table Body");
        WebElement nurseryFieldBodyValues = driver.findElement(By.xpath("//div[@class='ag-body-viewport ag-layout-normal ag-row-no-animation']"));
        // Uncomment if you want to print table in your console
        //System.out.println("Found and printing");
        //System.out.println(driver.findElement(By.xpath("//div[@class='ag-body-viewport ag-layout-normal ag-row-no-animation']")).getText());

        System.out.println(nurseryFieldBodyValues.getText());
        System.out.println("Found Values");
        System.out.println("Test Passed");
        driver.quit();

    }

    @Test (groups = {"Dashboard", "TimeLineValues"})
    public void timeLineValue() {
        setProperty();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3001/");

        System.out.println("Test started executing");
        System.out.println("Searching for timeline feeds");
        driver.findElement(By.xpath("//div[@class='time-line-ctnr']")).getText();
        System.out.println("Found");
        System.out.println("Test passed");
        driver.quit();
    }

    @Test (groups = {"Dashboard", "NFModal"})
    public void CreateNFInsertedValue() throws InterruptedException {
        setProperty();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3001/");

        // Create Nursery Field Test
        System.out.print("Started testing Create Nursery Field \n");
        driver.findElement(By.xpath("//button[contains(text(),'Create Nursery Field')]")).click();
        System.out.println("Clicked button and switched to modal \n");
        driver.switchTo();
        Thread.sleep(3000);


        // Field Location
        System.out.println("Searching for field Location");
        WebElement fieldLocation = driver.findElement(By.id("location"));
        Select fieldLocationSelect = new Select(fieldLocation);
        List<WebElement> fieldLocationOptions = fieldLocationSelect.getOptions();
        System.out.println("Found and looping through field location");
        for (int i = 0; i < fieldLocationOptions.size(); i++) {
            if (fieldLocationOptions.get(i).getText().equalsIgnoreCase("OPEN FIELD")) {
                fieldLocationOptions.get(i).click();
                System.out.println("Clicked by given value and Exit  \n");
                break;
            }
        }

        // Field Year
        System.out.println("Searching for field Year");
        WebElement fieldYear = driver.findElement(By.xpath("//div[@class='form-row']//div[1]//select[1]"));
        Select fieldYearSelect = new Select(fieldYear);
        List <WebElement> fieldYearOptions = fieldYearSelect.getOptions();
        for(int i = 0; i < fieldYearOptions.size(); i++) {
            if (fieldYearOptions.get(i).getText().equalsIgnoreCase("2019")) {
                System.out.println("Found and looping through field year");
                fieldYearOptions.get(i).click();
                System.out.println("Clicked by given value and Exit \n");
                break;
            }
        }

        // Field Week
        System.out.println("Searching for field Week");
        WebElement fieldWeek = driver.findElement(By.xpath("//div[@class='form-group']//div[2]//select[1]"));
        Select fieldWeekSelect = new Select(fieldWeek);
        List <WebElement> fieldWeekOptions = fieldWeekSelect.getOptions();
        for(int i = 0; i < fieldWeekOptions.size(); i ++) {
            if(fieldWeekOptions.get(i).getText().equalsIgnoreCase("20")) {
                System.out.println("Found and looping through field week");
                fieldWeekOptions.get(i).click();
                System.out.println("Clicked by given value and Exit \n");
                break;
            }
        }

        // Field

        System.out.println("Searching for field");
        WebElement field = driver.findElement(By.id("field"));
        Select fieldSelect = new Select(field);
        List<WebElement> fieldOptions = fieldSelect.getOptions();
        for(int i = 0; i < fieldOptions.size(); i ++) {
            if(fieldOptions.get(i).getText().equalsIgnoreCase("19OH20A3-4S3")) {
                System.out.println("Found and looping through field");
                fieldOptions.get(i).click();
                System.out.println("Clicked by given value and Exit \n");
                break;
            }
        }

        // Nursery Type
        System.out.println("Searching for Nursery Field");
        WebElement nurseryField = driver.findElement(By.id("type"));
        Select nurseryFieldSelect = new Select(nurseryField);
        List <WebElement> nurseryFieldOptions = nurseryFieldSelect.getOptions();
        for(int i = 0; i < nurseryFieldOptions.size(); i ++) {
            if(nurseryFieldOptions.get(i).getText().equalsIgnoreCase("pa")) {
                System.out.println("Found and looping through Nursery Type");
                nurseryFieldOptions.get(i).click();
                System.out.println("Clicked by given value and Exit \n");
                break;
            }
        }

        // Field Size (SREs)
        System.out.println("Inserting Field Size");
        WebElement fieldSize = driver.findElement(By.id("size"));
        fieldSize.clear();
        fieldSize.sendKeys("5000");
        System.out.println("Inserted Field Size");

        // Forcasted Date
        System.out.println("Inserting Local Date");
        LocalDate localDate = LocalDate.now();
        WebElement forcastedDate = driver.findElement(By.id("forecastDate"));
        forcastedDate.sendKeys(DateTimeFormatter.ofPattern("MM/dd/yyy").format(localDate));
        System.out.println("Inserted Local Date");
        //VCR ID

        System.out.println("Inserting VCR ID");
        WebElement vcrId = driver.findElement(By.xpath("//div[8]//input[1]"));
        vcrId.clear();
        vcrId.sendKeys("25");
        System.out.println("Inserted VCR ID");

        // Save
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        System.out.println("Test Passed");

        driver.quit();
    }

    @Test (groups = {"Dashboard", "NFModal"})
    public void NFModalValidation() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3001/");

        // Create Nursery Field Test
        System.out.print("Started testing Create Nursery Field \n");
        driver.findElement(By.xpath("//button[contains(text(),'Create Nursery Field')]")).click();
        System.out.println("Clicked button and switched to modal \n");
        driver.switchTo();
        Thread.sleep(1000);
        // Save
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        Thread.sleep(2000);

        //Field
        WebElement fieldInvalid = driver.findElement(By.xpath("//div[contains(text(),'Please select a field.')]"));
        if(fieldInvalid.getText().equalsIgnoreCase("Please select a field.")) {
            System.out.println("Field Validation passed");
        } else {
            System.out.println("Field Validation failed");
        }

        // Nursery Type
        WebElement nurseryFieldInvalid = driver.findElement(By.xpath("//div[contains(text(),'Please select a nursery type.')]"));
        if(nurseryFieldInvalid.getText().equalsIgnoreCase("Please select a nursery type.")) {
            System.out.println("Nursery Type Validation passed");
        } else {
            System.out.println("Nursery Type Validation failed");
        }

        // Field Size
        WebElement fieldSize = driver.findElement(By.xpath("//div[contains(text(),'Please input nursery size.')]"));
        if(fieldSize.getText().equalsIgnoreCase("Please input nursery size.")) {
            System.out.println("Size Validation passed");
        } else {
            System.out.println("Size Validation failed");
        }

        // Forecasted Date
        WebElement forecastedDate = driver.findElement(By.xpath("//div[contains(text(),'Please select a forecasted planting date.')]"));
        if(forecastedDate.getText().equalsIgnoreCase("Please select a forecasted planting date.")) {
            System.out.println("Forecasted Date Validation passed");
        } else {
            System.out.println("Forecasted Date Validation failed");
        }

        WebElement vcrId = driver.findElement(By.xpath("//div[contains(text(),'Please provide a valid VCR ID')]"));
        if(vcrId.getText().equalsIgnoreCase("Please provide a valid VCR ID")) {
            System.out.println("VCR ID Validation passed");
        } else {
            System.out.println("VCR ID Validation failed");
        }
    }

}
