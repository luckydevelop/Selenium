package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Help
{

    WebDriver driver;

    public Help(WebDriver driver)
    {
        this.driver = driver;
    }

    public  void makeScreenShot(String folderName, String fileName)
    {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("D:" + File.separator + "logs" + File.separator + folderName + File.separator + fileName + ".png");
        System.out.println(destFile);
        try
        {
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getClassName(String name)
    {
        int dotIndex = name.indexOf('.');
        int usdIndex = name.indexOf('$');
        String res = name.substring(dotIndex + 1, usdIndex - 1);
        return res;
    }


}
