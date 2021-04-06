package resources;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(resources.Base.class.getName());
    public Properties prop = new Properties();
    public WebDriver initializeDriver() throws IOException {



        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);


        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();

        }else{
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
         return driver;

    }

    public String getScreenShotPath(String name, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sources = ts.getScreenshotAs(OutputType.FILE);
        String destFile = System.getProperty("user.dir")+"\\reports\\"+name+".png";
        FileUtils.copyFile(sources, new File(destFile));
        return destFile;

    }

}
