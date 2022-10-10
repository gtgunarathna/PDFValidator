package org.example.helpers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class PDFReader {

    public static String getPdfContent(String url) throws IOException {
        URL pdfUrl = new URL(url);
        InputStream inputStream = pdfUrl.openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        PDDocument pdfDocument = PDDocument.load(bufferedInputStream);
        String documentContent = new PDFTextStripper().getText(pdfDocument);
        pdfDocument.close();

        return documentContent;
    }

    public static int getTotalPageCount(String url) throws IOException {
        URL pdfUrl = new URL(url);
        InputStream inputStream = pdfUrl.openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        PDDocument pdfDocument = PDDocument.load(bufferedInputStream);
        int count = pdfDocument.getNumberOfPages();
        pdfDocument.close();

        System.out.println("The total number of pages " + count);
        return count;
    }
}
