// Package of Object repositories

public class NameOfTheClass {
  WebDriver driver;
  // Constructor
  public NameOfTheClass(Webdriver driver) {
     // driver
     this.driver = driver
     // For page object factory
     pageFactory.initElements(driver, this);
  }
  
  By username = By.xpath("//div[@id='username']");
  
  public WebElement LoginId() {
    return driver.findElement(username);
  }
  
  // By Page Factory
  public WebElement LoginId() {
    return username;
  }
}


// Package for Test cases
 public class NameOfTheClassForTestCases {
     WebDriver driver = new ChromeDriver();
     driver.get(API_URL);
     
     // New instance of class
     NameOfTheClass objects = new NameOfTheClass(driver);
     objects.LoginId().sendkeys('Login');
 }
 
 
 // Anotation
 @FindBy(xpath="//*[@id='login']")
 WebElement username;
