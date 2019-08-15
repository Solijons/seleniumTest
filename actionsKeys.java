Actions action = new Actions(driver);
Thread.sleep(3000);
dateInput.click();
dateInput.sendKeys(Keys.DELETE);
dateInput.sendKeys(Keys.ARROW_LEFT);
dateInput.sendKeys(Keys.DELETE);
dateInput.sendKeys(Keys.ARROW_LEFT);
dateInput.sendKeys(Keys.DELETE);
action.build().perform();
