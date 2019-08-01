public class actionsDoubleClick {
    
    String API_URL;
    WebDriver driver;

    // Constuctor
    public actionsDoubleClick () {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        try (InputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            Properties property = new Properties();
            property.load(fis);
            API_URL = property.getProperty("API_URL");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


  @BeforeMethod
    private void runWebDriver() {
        driver = new ChromeDriver();
        driver.get(API_URL);
  }        

        
        Actions actions = new Actions(driver);
        WebElement type = driver.findElement(By.xpath("//div[contains(text(),'ZY')]"));
        actions.doubleClick(type).perform();
        
        
  @AfterMethod
    public void cleanUp() {
      driver.quit();
  }

}
