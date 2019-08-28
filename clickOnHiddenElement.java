JavascriptExecutor js = (JavascriptExecutor)driver;
String hiddenButton = "return document.getElementById(\"auto-fix\").click();";
js.executeScript(hiddenButton);
