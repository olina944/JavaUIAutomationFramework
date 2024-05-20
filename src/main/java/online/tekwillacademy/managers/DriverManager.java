package online.tekwillacademy.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static String webDriverType = "Chrome";
    public static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome  Driver Was initiated");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The Firefox Driver Was Initiated");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge Driver Was Initiated");
                break;
            default:
                System.out.println("The webDriverType" + webDriverType + "is not the default one");


        }

    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null){
            DriverManager.getInstance();
        }
        return driver;
    }
}