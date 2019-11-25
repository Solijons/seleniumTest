    LocalDate localDate = LocalDate.now();
    WebElement dateInput = driver.findElement(By.xpath("//input[@id='date']"));
    dateInput.sendKeys(DateTimeFormatter.ofPattern("MM/dd/yyy").format(localDate));

    String value = driver.findElement(By.id("date")).getAttribute("value");

    // Perquisites 
    protected String getAttrValue(final By locator) {
        String value = driver.findElement(locator).getAttribute("value");
        return value;
    }

    // Alternative way
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    LocalDate Date = LocalDate.parse(getAttrValue(By.id("date-picker-dialog")), dtf);
