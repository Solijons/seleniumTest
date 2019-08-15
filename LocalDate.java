    LocalDate localDate = LocalDate.now();
    WebElement dateInput = driver.findElement(By.xpath("//input[@id='date']"));
    dateInput.sendKeys(DateTimeFormatter.ofPattern("MM/dd/yyy").format(localDate));

    String value = driver.findElement(By.id("date")).getAttribute("value");
