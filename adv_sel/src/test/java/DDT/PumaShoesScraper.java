package DDT;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PumaShoesScraper {
    public static void main(String[] args) throws IOException {
        // Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 1: Go to Flipkart and close login popup
        driver.get("https://www.flipkart.com/");
        try {
            WebElement closeBtn = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            closeBtn.click();
        } catch (Exception ignored) {}

        // Step 2: Search for Puma Shoes
        driver.findElement(By.name("q")).sendKeys("Puma shoes");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Wait for products to load (You can use WebDriverWait if needed)
        try { Thread.sleep(5000); } catch (InterruptedException ignored) {}

        // Step 3: Extract Product Data
        List<WebElement> products = driver.findElements(By.cssSelector("div._1xHGtK"));
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Puma Shoes");

        // Create header
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Product Name");
        header.createCell(1).setCellValue("Price");
        header.createCell(2).setCellValue("Rating");

        int rowNum = 1;

        for (WebElement product : products) {
            String name = product.findElement(By.cssSelector("a.IRpwTa")).getText();
            String price = product.findElement(By.cssSelector("div._30jeq3")).getText();
            String rating = "";
            try {
                rating = product.findElement(By.cssSelector("div._3LWZlK")).getText();
            } catch (Exception e) {
                rating = "No Rating";
            }

            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(name);
            row.createCell(1).setCellValue(price);
            row.createCell(2).setCellValue(rating);
        }

        // Step 4: Write to Excel
        FileOutputStream fileOut = new FileOutputStream("PumaShoesData.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

        System.out.println("Data extracted to PumaShoesData.xlsx");

        // Cleanup
        driver.quit();
    }
}

