package org.acharyaprashant.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShot {
	
	public static void TakeScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Take a screenshot
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Generate a timestamp for the filename
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String timestamp = dateFormat.format(new Date());
            
         // Specify the destination path with the screenshot filename
            String filename = screenshotName + "-" + timestamp + ".png";
            
            FileUtils.copyFile(source, new File("./Screenshots/"+filename));

            
            //Path destinationPath = Path.of("path/to/save/" + filename);

            // Copy the screenshot file to the destination path
           // Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

            //System.out.println("Screenshot saved to: " + destinationPath.toAbsolutePath());
            
        } catch (Exception e) {
            System.out.println("Failed to save the screenshot: " + e.getMessage());
        }
    }
	
	
	
	

}
