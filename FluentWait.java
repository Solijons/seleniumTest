    private void waitUntilSelectOptionsPopulated(final Select select) {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .until(new Function<WebDriver, Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return (select.getOptions().size() > 1);
                    }
                });
    }
