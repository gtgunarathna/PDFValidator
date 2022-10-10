# Sample codes for PDF validation
In this sample code, I have added to test to validate
1. an online PDF
2. already downloaded PDF using Apache PDF box.

And the bonus gifts are
1. Downloading a file to the desired location
```
    public static ChromeDriver getChromeDriver(String fileDownloadDirectory) {

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();

        // Forcing Google Chrome to download files to specific location
        prefs.put("download.default_directory", fileDownloadDirectory);

        options.addArguments("--test-type");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }

```
2. Force downloading PDF files

```
    public static ChromeDriver getChromeDriver() {

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();

        // Forcing Google Chrome to download PDF files instead of view
        prefs.put("plugins.always_open_pdf_externally", true);

        options.addArguments("--test-type");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }
```

## Run the test
You can test using this command
```
mvn clean install
```