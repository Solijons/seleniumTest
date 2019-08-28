 private static boolean isSortedList(ArrayList<? extends Comparable> expectedWeeks) {
        boolean isSorted = true;
        if(expectedWeeks == null || expectedWeeks.isEmpty()) {
            return false;
        }
        if(expectedWeeks.size() == 1) {
            return true;
        }
        for(int i=1; i<expectedWeeks.size();i++) {
            if(expectedWeeks.get(i).compareTo(expectedWeeks.get(i-1)) > 0 ) {
                isSorted = false;
            }
        }
        return isSorted;
}

    @Test (groups = {"Events", "sortingValidation"})
    public void sortValidation() throws InterruptedException {
        driver.get(API_URL + "/events/view?ids=");
        Thread.sleep(3000);

        String tablePath = "div.container div.row div.col div.container div.row div.col-sm-4 div.task-card.card div.task-body.card-body table.table.table-custom.table-hover tbody:nth-child(2) tr:nth-child(1) td:nth-child(1) > div.fade.alert.alert-secondary.show:nth-child(2)";
        String rowPath = "div.container div.row div.col div.container div.row div.col-sm-4 div.task-card.card div.task-body.card-body table.table.table-custom.table-hover tbody:nth-child(2) tr:nth-child(1) td:nth-child(1) div.fade.alert.alert-secondary.show:nth-child(2) > div.form-check";

        WebElement table = driver.findElement(By.cssSelector(tablePath));
        int rowCount = table.findElements(By.cssSelector(rowPath)).size();

        ArrayList actualWeeks = new ArrayList<>();
        for(int i = 0; i < rowCount; i++) {
            actualWeeks.add(Integer.parseInt(table.findElements(By.cssSelector(rowPath)).get(i).getText()));
        }
        Assert.assertTrue(isSortedList(actualWeeks));
    }
