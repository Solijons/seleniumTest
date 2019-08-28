    // @Test (groups = {"Dashboard", "timelinePattern"})
    public void timelinePattern() {
        String pattern = "^\\d{2} [JFMASOND][a-z]{2} 20\\d{2}$";
        Pattern r = Pattern.compile(pattern);

        WebElement date = driver.findElement(By.cssSelector(this.timeLineDates));
        String line = date.getText().trim();
        Matcher m = r.matcher(line);
        Assert.assertTrue(m.find());
    }
