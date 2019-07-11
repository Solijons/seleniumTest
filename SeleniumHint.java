// Selects by Visible test
Select statusSelectValues = new Select(driver.findElement(By.xpath("//select[@id='status']")));
statusSelectValues.selectByVisibleText("Warn");

// Clicks btn
driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

// gets selected value and validates
if(statusSelectValues.getFirstSelectedOption().getText().equalsIgnoreCase("Warn")) {
  WebElement commnetsValidation = driver.findElement(By.xpath("//div[contains(text(),'Comments are required when status is not \"Ok\"')]"));
    if (commnetsValidation.getText().equalsIgnoreCase("Comments are required when status is not \"Ok\"")) {
    System.out.println("Warn Comments Validation Passed");
    } else {
      throw new RuntimeException("No Comments found");
      driver.quit();
    }
}

//Gets value of the inputs 


String value = driver.findElement(By.id("date")).getAttribute("value");
  if(value.equalsIgnoreCase("2019-07-11")) {
    System.out.println("Date Validation passed");
  } else  {
    throw new RuntimeException("No date input found");
  }
  
// Sendskeys in date format MM/dd/yyy
LocalDate localDate = LocalDate.now();
WebElement dateInput = driver.findElement(By.xpath("//input[@id='date']"));
dateInput.sendKeys(DateTimeFormatter.ofPattern("MM/dd/yyy").format(localDate));
