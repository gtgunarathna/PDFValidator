package org.example.helpers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class GetDriver {
    public static ChromeDriver getChromeDriver(String fileDownloadDirectory) {

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();

        // Forcing Google Chrome to download PDF files instead of view
        prefs.put("plugins.always_open_pdf_externally", true);

        // Forcing Google Chrome to download files to specific location
        prefs.put("download.default_directory", fileDownloadDirectory);

        options.addArguments("--test-type");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }
}
