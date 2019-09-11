private boolean isElementPresent (By id ) {
    try {
        Log.info("Is present");
        driver.findElement(id);
        return true;
    } catch (org.openqa.selenium.NoSuchElementException e) {
        Log.info("Element was deleted");
        return false;
    }
}

  @Test (groups = {"Selenium", "deleteElement"})
  public void deleteElement() throws InterruptedException {
      WebElement deleteElement = driver.findElement(By.id("id"));
      deleteElement.click();
      driver.switchTo();
      Thread.sleep(500);
      pageObjectModel.deleteModalBtn().click();
      
    isElementPresent(By.id("id")); // false
  }
