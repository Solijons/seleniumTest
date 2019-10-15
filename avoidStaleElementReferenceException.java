    @Test (groups = {"ExceptionTest", "RerunTest"})
    public void RerunTest() throws InterruptedException {
      driver.get(API_URL + "/table/view?ids=");

      driver.findElement(By.id("Weeds")).click();

      int attempts = 0;
      while (attempts < 2) {
            try {
              int countTableData = pageObjectModel.Table().findElements(By.cssSelector("div.container div.row div.col div.container div.row div.col-sm-8 div.task-card.card div.task-body.card-body div table.table.table-custom.table-hover tbody tr > td:nth-child(1)")).size();
              String eventType = "";
              for (int j = 0; j < countTableData; j++) {
                    eventType = pageObjectModel.Table().findElements(By.cssSelector("div.container div.row div.col div.container div.row div.col-sm-8 div.task-card.card div.task-body.card-body div table.table.table-custom.table-hover tbody tr > td:nth-child(1)")).get(j).getText();
              }
                System.out.println("Actual: " + eventType + "Expecting: " + " Weeds");
          } catch (StaleElementReferenceException e) {
                e.getMessage();
          }
          attempts++;
      }
  }
