package org.example.test;

import org.apache.commons.io.FileUtils;
import org.example.helpers.GetDriver;
import org.example.helpers.PDFReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class TestDownloadedPdf {
    WebDriver driver;
    String fileDownloadDirectory = System.getProperty("user.dir").concat("\\FileDownload");

    @Test
    public void testDownloadedPDF() throws IOException {

        // Getting the PDF downloaded to desired location
        driver = GetDriver.getChromeDriver(fileDownloadDirectory);
        driver.get("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
        testWait();


        // This is the important part, you have to point to the PDF as a URL
        // String url ="file:///C:/Users/admin/Downloads/dummy.pdf";

        String url = "file:///" + fileDownloadDirectory.replace('\\', '/') + "/dummy.pdf";

        // Passing my PDF file as a URL to get PDF content method
        String pDFContent = PDFReader.getPdfContent(url);

        // Checking my text is available in PDF or not
        Assert.assertTrue(pDFContent.contains("Dummy PDF file"));
    }

    @BeforeClass
    public void beforeClassMethod() throws IOException {
        // Cleaning directory before starting the test
        try {
            FileUtils.cleanDirectory(new File(fileDownloadDirectory));

        } catch (IllegalArgumentException exception) {
        }
    }

    @AfterClass
    public void afterClassMethod() throws IOException {
        driver.quit();
    }

    private void testWait() {
        // Very dirty fix :) waiting for download completes
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
