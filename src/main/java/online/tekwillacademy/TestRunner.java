package online.tekwillacademy;

import javafx.scene.control.Tab;
import online.tekwillacademy.managers.DataGeneratorManager;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.ScrollManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.sql.SQLOutput;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        String currentTabName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The current url is" + driver.getCurrentUrl());
        System.out.println("The current url is" + driver.getTitle());

        WebElement userDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        userDropDownIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Register']"));
        registerOption.click();

        System.out.println("The current url is" + driver.getCurrentUrl());
        System.out.println("The current url is" + driver.getTitle());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(DataGeneratorManager.getRandomName());

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Burlaka");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String randomEmail = DataGeneratorManager.getRandomEmail();
        emailInput.sendKeys(randomEmail);

        WebElement password = driver.findElement(By.id("input-password"));
        String randomPassword = DataGeneratorManager.getRandomPassword(5,15);
        password.sendKeys(randomPassword);

        WebElement privacyToggle = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        ScrollManager.ScrollElement(privacyToggle);
        privacyToggle.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        Thread.sleep(5000);
        driver.quit();

    }
}