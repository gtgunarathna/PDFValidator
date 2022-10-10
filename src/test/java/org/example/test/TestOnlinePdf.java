package org.example.test;

import org.apache.commons.io.FileUtils;
import org.example.helpers.PDFReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class TestOnlinePdf {

    @Test
    public void testOnlinePDF() throws IOException {

        String url = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";

        // Checking my text is available in PDF or not
        Assert.assertTrue(PDFReader.getPdfContent(url).contains("Dummy PDF file"));
    }

}
